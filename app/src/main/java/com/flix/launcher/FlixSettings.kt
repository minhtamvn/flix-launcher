package com.flix.launcher

import android.content.Context

/**
 * Every user-facing option in Flix Launcher. Each one is a list of choices stored by id;
 * on/off switches are just two-choice options. The settings screen lists
 * each one with its icon and search words.
 */
object FlixSettings {
    class Option(
        val key: String,
        val title: String,
        val choices: List<Pair<String, String>>, // id to label
        val default: String,
        val summary: String? = null,
    ) {
        fun label(id: String) = choices.firstOrNull { it.first == id }?.second ?: id
    }

    private fun toggle(key: String, title: String, default: Boolean = true, summary: String? = null) =
        Option(key, title, listOf("on" to "Bật", "off" to "Tắt"), if (default) "on" else "off", summary)

    // Look
    val THEME = Option("theme", "Giao diện",
        listOf("cinema" to "Rạp phim", "glass" to "Kính mờ", "midnight" to "Nửa đêm", "minimal" to "Tối giản"), "cinema",
        summary = "Màu sắc và kiểu dáng của màn hình chính")

    // What the Home button lands on
    val HOME_FOCUS = Option("home_focus", "Nút Home mở tại",
        listOf("apps" to "Ứng dụng của bạn", "watching" to "Nội dung đang xem dở"), "apps",
        summary = "Bắt đầu tại hàng ứng dụng hoặc Xem tiếp bộ phim gần nhất")

    // Icons
    val ICON_SHAPE = Option("icon_shape", "Hình dạng biểu tượng",
        listOf("circle" to "Hình tròn", "squircle" to "Vuông bo góc", "rounded" to "Chữ nhật bo góc", "banner" to "Biểu ngữ ngang"), "circle",
        summary = "Cách hiển thị các ô ứng dụng")
    val ICON_SIZE = Option("icon_size", "Kích thước biểu tượng", listOf("small" to "Nhỏ", "medium" to "Vừa", "large" to "Lớn"), "medium")
    val LABELS = Option("labels", "Tên ứng dụng", listOf("always" to "Luôn hiện", "focus" to "Khi chọn", "never" to "Ẩn"), "always")
    val GLOW = toggle("glow", "Hiệu ứng phát sáng", summary = "Ứng dụng được chọn sẽ phát sáng theo màu riêng")
    val MOTION = Option("motion", "Hiệu ứng chuyển động", listOf("spring" to "Độ nảy", "smooth" to "Mượt mà", "none" to "Tắt"), "spring")

    // Clock & widgets
    val CLOCK_STYLE = Option("clock_style", "Kiểu đồng hồ", listOf("duo" to "Hai tông màu", "thin" to "Nét mảnh", "bold" to "Nét đậm"), "duo")
    val CLOCK_FORMAT = Option("clock_format", "Định dạng giờ", listOf("system" to "Hệ thống", "12" to "12 giờ", "24" to "24 giờ"), "system")
    val GREETING = toggle("greeting", "Lời chào")
    val DATE = toggle("date", "Ngày tháng")
    val SUN_ARC = toggle("sun_arc", "Vòng cung bình minh & hoàng hôn")
    val WEATHER = toggle("weather", "Thời tiết", summary = "Thẻ thời tiết ở góc trên bên phải")
    val FORECAST = toggle("forecast", "Dự báo 3 ngày")
    val UNITS = Option("units", "Đơn vị nhiệt độ", listOf("c" to "Độ C", "f" to "Độ F"), "c")

    // Wallpaper
    val WALLPAPER = Option("wallpaper", "Hình nền", listOf(
        "nature" to "Ảnh thiên nhiên", "cities" to "Ảnh thành phố",
        "video" to "Tất cả video trên không", "v_nature" to "Video phong cảnh", "v_sea" to "Video đại dương",
        "v_city" to "Video thành phố", "v_space" to "Trái đất từ không gian", "v_art" to "Video nghệ thuật màu sắc",
        "gradient" to "Tối giản đơn sắc"), "nature",
        summary = "Ảnh Bing mới mỗi phút hoặc video trên không từ Apple TV và Fire TV")
    val SHUFFLE = toggle("shuffle", "Xáo trộn hình nền")
    val DIM = Option("dim", "Độ tối hình nền", listOf("low" to "Nhẹ", "medium" to "Vừa", "high" to "Mạnh"), "medium")
    val SCENE_NAME = toggle("scene_name", "Tên địa danh")

    // Behaviour
    val IDLE = Option("idle", "Chuyển sang phong cảnh sau",
        listOf("off" to "Không bao giờ", "30" to "30 giây", "60" to "1 phút", "120" to "2 phút", "300" to "5 phút"), "60")
    val ALL_APPS = toggle("all_apps", "Hàng tất cả ứng dụng", default = false)
    val ALL_APPS_TILE = toggle("all_apps_tile", "Ô tất cả ứng dụng", summary = "Một ô ở cuối mục yêu thích để mở tất cả ứng dụng")

    // Movies & shows
    val SUGGESTIONS = toggle("suggestions", "Hàng phim & chương trình", summary = "Các hàng từ addon của bạn; nhấn OK để mở trong Nuvio")
    val BILLBOARD = toggle("billboard", "Băng chuyền nổi bật", summary = "Áp phích xoay lớn phía trên các hàng")
    val CONTINUE_WATCHING = toggle("continue_watching", "Tiếp tục xem", summary = "Từ tài khoản Nuvio của bạn")
    val GENRE = Option("genre", "Lọc theo thể loại", listOf("all" to "Tất cả thể loại", "Action" to "Hành động", "Comedy" to "Hài hước", "Drama" to "Chính kịch",
        "Thriller" to "Giật gân", "Horror" to "Kinh dị", "Romance" to "Lãng mạn", "Sci-Fi" to "Khoa học viễn tưởng", "Animation" to "Hoạt hình",
        "Crime" to "Tội phạm", "Family" to "Gia đình"), "all", summary = "Chỉ áp dụng cho các hàng có hỗ trợ addon")
    val RATING_BADGE = toggle("rating_badge", "Huy hiệu đánh giá trên áp phích", summary = "Tắt nếu áp phích từ addon đã có sẵn điểm")
    val TYPE_TABS = toggle("type_tabs", "Tab Phim lẻ và Phim bộ", summary = "Màn hình chính đã hiển thị cả hai")
    val POSTER_SIZE = Option("poster_size", "Kích thước áp phích", listOf("small" to "Nhỏ", "medium" to "Vừa", "large" to "Lớn"), "medium")
    val BACKDROP = toggle("backdrop", "Xem trước ảnh nền", summary = "Hiển thị ảnh nền của tựa phim đang chọn phía sau các hàng")
    val TOP_TEN = Option("top_ten_from", "Hàng Top 10",
        listOf("mine" to "Từ hàng đầu tiên", "world" to "Toàn cầu (chủ yếu tiếng Anh)", "off" to "Tắt"), "mine",
        summary = "Hàng được đánh số của 10 bộ phim phổ biến nhất")
    val TRAILERS = toggle("trailers", "Phát trailer", summary = "Tự động phát trailer khi dừng chọn áp phích")
    val TRAILER_DELAY = Option("trailer_delay", "Trailer phát sau",
        listOf("1" to "1 giây", "2" to "2 giây", "3" to "3 giây", "5" to "5 giây", "8" to "8 giây"), "2",
        summary = "Thời gian dừng ở áp phích trước khi trailer bắt đầu phát")
    val TRAILER_SOUND = toggle("trailer_sound_v2", "Âm thanh trailer", summary = "Tắt để phát trailer ở chế độ im lặng")


    private fun prefs(context: Context) = context.getSharedPreferences("flix_settings", Context.MODE_PRIVATE)

    fun get(context: Context, option: Option): String =
        prefs(context).getString(option.key, null)?.takeIf { id -> option.choices.any { it.first == id } } ?: option.default

    fun isOn(context: Context, option: Option) = get(context, option) == "on"

    fun set(context: Context, option: Option, id: String) {
        val p = prefs(context)
        p.edit().putString(option.key, id).putInt(KEY_REVISION, p.getInt(KEY_REVISION, 0) + 1).apply()
    }

    /** The city typed for the weather, or "" to locate the TV from its internet connection. */
    fun weatherCity(context: Context): String = prefs(context).getString("weather_city", null).orEmpty()

    fun setWeatherCity(context: Context, city: String) {
        val p = prefs(context)
        p.edit().putString("weather_city", city.trim()).putInt(KEY_REVISION, p.getInt(KEY_REVISION, 0) + 1).apply()
    }

    /** Bumped on every change, so the home screen knows when to re-apply. */
    fun revision(context: Context) = prefs(context).getInt(KEY_REVISION, 0)

    private const val KEY_REVISION = "revision"
}
