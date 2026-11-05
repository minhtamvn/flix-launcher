package com.flix.launcher

import android.app.Activity
import android.app.AlertDialog
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.Settings

/**
 * Where the Home button goes, and the right way to point it at Flix on this TV.
 *
 * Plain Android TV follows the default home app, so choosing Flix there is enough. Google TV
 * ignores the default and needs [HomeKeyService]. Some TVs (Android 13+, apps installed from an
 * APK) refuse to start that service: it is switched on in Settings but never runs.
 */
object HomeButton {
    enum class State { SERVICE, DEFAULT_HOME, BLOCKED, OFF }

    private const val GOOGLE_TV_HOME = "com.google.android.apps.tv.launcherx"

    /** The fix shown to people whose TV blocks the service; needs a computer once. */
    const val UNBLOCK_COMMAND = "adb shell appops set com.flix.launcher ACCESS_RESTRICTED_SETTINGS allow"
    const val DEFAULT_COMMAND = "adb shell cmd package set-home-activity com.flix.launcher/.MainActivity"

    fun state(context: Context): State = when {
        HomeKeyService.running -> State.SERVICE
        isDefaultHome(context) && !isGoogleTv(context) -> State.DEFAULT_HOME
        serviceSwitchedOn(context) -> State.BLOCKED
        else -> State.OFF
    }

    fun works(context: Context) = state(context).let { it == State.SERVICE || it == State.DEFAULT_HOME }

    /** Google TV sends Home to its own screen whatever the default is. */
    fun isGoogleTv(context: Context) = runCatching { context.packageManager.getPackageInfo(GOOGLE_TV_HOME, 0); true }.getOrDefault(false)

    fun isDefaultHome(context: Context): Boolean = runCatching {
        context.packageManager.resolveActivity(Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME), PackageManager.MATCH_DEFAULT_ONLY)
            ?.activityInfo?.packageName == context.packageName
    }.getOrDefault(false)

    private fun serviceSwitchedOn(context: Context): Boolean {
        val me = ComponentName(context, HomeKeyService::class.java)
        return Settings.Secure.getString(context.contentResolver, Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES).orEmpty()
            .split(':').any { ComponentName.unflattenFromString(it) == me }
    }

    /** One line for Settings and bug reports. */
    fun describe(context: Context): String = when (state(context)) {
        State.SERVICE -> "Đang hoạt động: Phím Home của Flix đang bật"
        State.DEFAULT_HOME -> "Đang hoạt động: Flix là ứng dụng trang chủ mặc định"
        State.BLOCKED -> "Bị chặn: Android không thể khởi chạy phím Home của Flix"
        State.OFF -> if (isGoogleTv(context)) "Chưa thiết lập: Nút Home mở Google TV" else "Chưa thiết lập: Nút Home mở ứng dụng khác"
    }

    /** Opens the screen that fixes it: the home app picker on plain Android TV, otherwise Accessibility. */
    fun fix(activity: Activity) {
        when {
            state(activity) == State.BLOCKED -> showBlockedHelp(activity)
            !isGoogleTv(activity) -> chooseDefault(activity)
            else -> openAccessibility(activity)
        }
    }

    fun openAccessibility(activity: Activity) {
        runCatching { activity.startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)) }
    }

    /**
     * The system's home app setting where the TV has one; otherwise pressing Home through the
     * chooser, which asks which app to use when no default is set. If neither shows a choice
     * (another app is already the default), the help explains the one adb command.
     */
    fun chooseDefault(activity: Activity) {
        val settings = Intent(Settings.ACTION_HOME_SETTINGS)
        if (settings.resolveActivity(activity.packageManager) != null && runCatching { activity.startActivity(settings) }.isSuccess) return
        AlertDialog.Builder(activity, android.R.style.Theme_DeviceDefault_Dialog_Alert)
            .setTitle("Đặt Flix làm ứng dụng trang chủ")
            .setMessage("TV này không có mục cài đặt ứng dụng trang chủ. Hãy nhấn phím Home ngay bây giờ: nếu TV hỏi dùng ứng dụng nào, hãy chọn Flix Launcher và chọn Luôn luôn.\n\n" +
                "Nếu TV không hỏi, hãy chạy lệnh sau một lần từ máy tính trong cùng mạng:\n\n$DEFAULT_COMMAND\n\n" +
                "Hoặc bật phím Home của Flix trong phần Trợ năng.")
            .setPositiveButton("Mở Trợ năng") { _, _ -> openAccessibility(activity) }
            .setNegativeButton("Đóng", null)
            .show()
    }

    fun showBlockedHelp(activity: Activity) {
        val dialog = AlertDialog.Builder(activity, android.R.style.Theme_DeviceDefault_Dialog_Alert)
            .setTitle("Android đang chặn phím Home")
            .setMessage("Flix Launcher đã được bật trong Trợ năng, nhưng TV này chưa khởi chạy được. Android có thể áp dụng hạn chế này đối với ứng dụng cài từ file APK ngoài.\n\n" +
                "Để cho phép, hãy chạy lệnh sau một lần từ máy tính trong cùng mạng, sau đó tắt đi và bật lại Flix Launcher trong Trợ năng:\n\n$UNBLOCK_COMMAND" +
                if (!isGoogleTv(activity)) "\n\nHoặc bỏ qua bước này: chiếc TV này có thể trực tiếp đặt Flix làm ứng dụng trang chủ mặc định." else "")
            .setNegativeButton("Đóng", null)
        if (!isGoogleTv(activity)) dialog.setPositiveButton("Đặt Flix làm màn hình chính") { _, _ -> chooseDefault(activity) }
        else dialog.setPositiveButton("Mở Trợ năng") { _, _ -> openAccessibility(activity) }
        dialog.show()
    }
}
