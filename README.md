<p align="center">
  <img src="docs/hero.png" alt="Flix Launcher Tiếng Việt - Launcher tùy biến cho Android TV" width="100%">
</p>

<h1 align="center">Flix Launcher (Bản Tiếng Việt)</h1>

<p align="center">
  <b>Trình khởi chạy (launcher) Android TV không quảng cáo, tối ưu cho trải nghiệm xem phim.</b><br>
  Nhấn Home để mở phim chỉ với 1 click: tập phim đang xem dở, phim đề xuất hấp dẫn và toàn bộ ứng dụng xem phim của bạn.<br>
  Hỗ trợ mượt mà trên Sony BRAVIA, TCL, Hisense, Xiaomi Mi Box, Chromecast with Google TV, NVIDIA Shield và các thiết bị Android TV khác.
</p>

<p align="center">
  <a href="https://github.com/minhtamvn/flix-launcher/releases/latest"><b>Tải file APK (Releases)</b></a> ·
  <a href="https://github.com/minhtamvn/flix-launcher/tree/vi"><b>Mã nguồn (Nhánh Tiếng Việt)</b></a> ·
  <a href="https://github.com/HatriGt/flix-launcher"><b>Dự án gốc (HatriGt)</b></a>
</p>

<p align="center">
  <a href="https://github.com/minhtamvn/flix-launcher/releases/latest"><img alt="Bản phát hành" src="https://img.shields.io/github/v/release/minhtamvn/flix-launcher?style=flat-square&color=E50914"></a>
  <img alt="Android TV 9+" src="https://img.shields.io/badge/Android%20TV-9%2B-3DDC84?style=flat-square&logo=android&logoColor=white">
  <img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-plain%20Views-7F52FF?style=flat-square&logo=kotlin&logoColor=white">
  <img alt="Dung lượng APK" src="https://img.shields.io/badge/Dung%20lượng%20APK-~2%20MB-141414?style=flat-square">
  <img alt="Ngôn ngữ" src="https://img.shields.io/badge/Ngôn%20ngữ-Tiếng%20Việt%20(100%25)-E50914?style=flat-square">
  <a href="LICENSE"><img alt="License" src="https://img.shields.io/github/license/HatriGt/flix-launcher?style=flat-square&color=141414"></a>
</p>

<p align="center">
  <a href="#giới-thiệu-về-bản-việt-hóa">Giới thiệu</a> ·
  <a href="#hình-ảnh-giao-diện">Giao diện</a> ·
  <a href="#tính-năng-nổi-bật">Tính năng</a> ·
  <a href="#hướng-dẫn-cài-đặt">Cài đặt</a> ·
  <a href="#cài-làm-màn-hình-chính-nút-home">Cài nút Home</a> ·
  <a href="#cài-đặt-tùy-chỉnh">Tùy chỉnh</a> ·
  <a href="#biên-dịch-từ-mã-nguồn">Build APK</a> ·
  <a href="#câu-hỏi-thường-gặp">FAQ</a>
</p>

---

## Giới thiệu về bản Việt hóa

Đây là bản fork của **Flix Launcher** được Việt hóa toàn diện 100% giao diện sang tiếng Việt tự nhiên và trực quan (từ màn hình chính, thanh điều hướng, cài đặt, trình quản lý hàng phim, cho đến giao diện thiết lập và Live TV).

* **Siêu nhẹ và mượt mà:** File cài đặt APK Release chỉ nặng khoảng **~2 MB**, sử dụng thuần Kotlin Views (không dùng Jetpack Compose hay layout XML cồng kềnh), chiếm chỉ ~54 MB RAM trên TV 2 GB nhờ cơ chế GPU layer và tải artwork theo nhu cầu.
* **Không quảng cáo:** Loại bỏ hoàn toàn banner quảng cáo và ứng dụng rác của Google TV.
* **Tích hợp sâu với Nuvio & Stremio Addons:** Tự động lấy danh sách phim hot, Top 10, tiếp tục xem dở và phát trailer nền sống động.
* **Tab Truyền hình trực tiếp (Live TV):** Đọc danh sách kênh Nuvio+IPTV qua Setup Sync, phát xem trước trực tiếp ở nền và hỗ trợ ẩn kênh nhanh chóng.

---

## Hình ảnh giao diện

<p align="center">
  <img src="docs/home.webp" alt="Màn hình chính Flix Launcher" width="100%">
</p>

<p align="center">
  <img src="docs/shows.webp" alt="Tab Phim bộ" width="49%">
  <img src="docs/tv.webp" alt="Tab Truyền hình TV với Nuvio+IPTV" width="49%">
</p>

<p align="center">
  <img src="docs/setup.webp" alt="Thiết lập lần đầu" width="49%">
  <img src="docs/settings.webp" alt="Màn hình Cài đặt Flix Launcher" width="49%">
</p>

<p align="center"><sub>Giao diện hiển thị trên Sony BRAVIA (Android TV 14, 2 GB RAM). Màn hình chính, Phim bộ, Kênh TV (với Nuvio+IPTV), thiết lập và cài đặt.</sub></p>

---

## Tính năng nổi bật

<table>
<tr>
<td width="50%" valign="top">

### 🏠 Màn hình chính
- **Hàng ứng dụng yêu thích** tự sắp xếp vị trí theo ý muốn
- **Lưới tất cả ứng dụng** tích hợp ngay màn hình chính, mở tức thì không cần đợi
- **Hiệu ứng phát sáng (glow)** theo tông màu của từng biểu tượng ứng dụng
- Tùy chỉnh kích thước, hình dạng icon (tròn, vuông bo góc, chữ nhật) và hiệu ứng phóng to
- Nhấn phím Home luôn mở Flix Launcher ngay cả trên Google TV

</td>
<td width="50%" valign="top">

### 🎬 Phim & Chương trình
- **Banner nổi bật (Billboard)** giới thiệu các tựa phim/chương trình chất lượng cao
- **Hàng phim từ bất kỳ Addon Stremio nào**; mặc định dùng Cinemeta
- **Top 10 phim hôm nay** và bộ lọc theo thể loại
- **Tiếp tục xem** liên kết tài khoản Nuvio với thanh tiến trình % đã xem
- **Trailer phát nền** phía sau tựa phim được chọn (hỗ trợ bật/tắt tiếng, chỉnh độ trễ)
- Nhấn OK để mở xem phim ngay qua [Nuvio](https://nuvio.tv)

</td>
</tr>
<tr>
<td valign="top">

### 📺 Truyền hình trực tiếp (Live TV)
- **Tab TV riêng biệt** với các kênh Nuvio+IPTV của bạn: Kênh đã xem gần đây xếp trước, sau đó là các nhóm kênh được chọn
- Mỗi kênh hiển thị logo và chương trình đang phát, kèm thanh thời gian và chương trình tiếp theo
- Dừng lại ở một kênh để phát trực tiếp toàn màn hình phía sau trang, như trailer phim; nhấn OK để xem trong Nuvio+IPTV
- Nhấn giữ OK để ẩn kênh. Đọc thông qua Đồng bộ thiết lập của Nuvio+IPTV với tài khoản Nuvio sẵn có

### 🌄 Hình nền sống động
- **Hơn 270 video cảnh quay trên không** (Apple TV, Amazon Fire TV): phong cảnh thiên nhiên, đại dương, thành phố, vũ trụ và nghệ thuật
- **Hình nền ảnh chụp Bing** độ phân giải cao thay đổi mỗi phút
- Stream trực tiếp khi hiển thị, không lưu vào bộ nhớ trong gây đầy dung lượng TV
- Tự động chuyển sang chế độ bảo vệ màn hình (screensaver) phong cảnh khi TV không hoạt động

</td>
<td valign="top">

### ⏰ Tiện ích & Thông tin
- Đồng hồ 3 phong cách hiển thị, định dạng 12h hoặc 24h
- Lời chào theo buổi, ngày tháng, đồ thị bình minh/hoàng hôn
- Thời tiết và dự báo 3 ngày bằng tiếng Việt (tìm kiếm thành phố thông minh qua Open-Meteo & wttr.in)
- **Cài đặt tìm kiếm nhanh**: gõ "trailer", "đồng hồ", "âm thanh" để đến thẳng mục cài đặt
- Quản lý thêm bớt hàng phim từ điện thoại qua mạng Wi-Fi nội bộ bằng mã QR

</td>
</tr>
</table>

---

## Hướng dẫn cài đặt

1. Tải file `FlixLauncher-vi.apk` từ mục [Releases](https://github.com/minhtamvn/flix-launcher/releases) của repo.
2. Cài đặt lên Android TV bằng ứng dụng chuyển file (Downloader, Send Files to TV, USB) hoặc qua lệnh **ADB**:

   ```bash
   adb connect <dia-chi-ip-tv>:5555
   adb install FlixLauncher-vi.apk
   ```

**Yêu cầu hệ thống:** Thiết bị chạy Android TV 9.0 (API 28) trở lên. Ứng dụng xem phim [Nuvio](https://nuvio.tv) là tùy chọn (chỉ cần nếu bạn muốn phát trực tiếp nội dung hoặc đồng bộ hàng Tiếp tục xem).

---

## Cài làm màn hình chính (Nút Home)

Mặc định Google TV luôn bắt nút Home trỏ về launcher của hãng. Flix Launcher tích hợp sẵn một dịch vụ trợ năng nhẹ chỉ lắng nghe phím Home để mở Flix:

1. Trên TV, vào **Cài đặt → Trợ năng (Accessibility) → Flix Launcher** và gạt bật dịch vụ.
2. *(Khuyên dùng)* Cấp quyền cho Flix Launcher tự động bật lại dịch vụ này sau mỗi lần TV cập nhật hoặc khởi động lại:

   ```bash
   adb shell pm grant com.flix.launcher android.permission.WRITE_SECURE_SETTINGS
   ```

Như vậy là xong: mỗi khi bấm nút Home trên điều khiển, Flix Launcher sẽ xuất hiện ngay lập tức.

---

## Cài đặt tùy chỉnh

Nhấn biểu tượng bánh răng ở góc phải thanh trên cùng để vào màn hình Cài đặt:

| Danh mục | Nội dung có thể tùy chỉnh |
|---|---|
| **Màn hình chính** | Hình dạng & kích thước biểu tượng, nhãn tên ứng dụng, vệt màu phát sáng, hiệu ứng chuyển động, thẻ Tất cả ứng dụng |
| **Phim & chương trình** | Tài khoản Nuvio, danh sách addon & sắp xếp hàng phim, carousel nổi bật, Tiếp tục xem, Top 10, thể loại, phát trailer, kích thước áp phích, khôi phục tựa phim đã ẩn |
| **Đồng hồ & thời tiết** | Kiểu dáng và định dạng giờ, lời chào, ngày tháng, cung mặt trời, thời tiết, tìm kiếm thành phố, đơn vị đo nhiệt độ |
| **Hình nền** | Ảnh chụp Bing, video trên không theo từng chủ đề hoặc tối giản đơn sắc; xáo trộn ngẫu nhiên, độ sáng tối màn hình, thời gian chờ bảo vệ màn hình |
| **Giới thiệu** | Sao lưu và khôi phục toàn bộ cài đặt, ứng dụng yêu thích và hàng phim |

---

## Biên dịch từ mã nguồn

Dự án có thể biên dịch dễ dàng trên máy tính hoặc trực tiếp ngay trong Termux trên Android:

```bash
git clone https://github.com/minhtamvn/flix-launcher.git
cd flix-launcher
git checkout vi
./gradlew assembleRelease
# File APK xuất ra tại: app/build/outputs/apk/release/app-release.apk
```

**Yêu cầu môi trường:** JDK 17 hoặc 21 và Android SDK (compile SDK 35). Bản build Release được tối ưu hóa và làm gọn mã nguồn bằng R8 ProGuard cùng Baseline Profile giúp khởi động siêu nhanh.

---

## Câu hỏi thường gặp

<details>
<summary><b>Flix Launcher có thu thập dữ liệu cá nhân không?</b></summary>

Hoàn toàn không. Ứng dụng không có mã theo dõi, phân tích người dùng hay quảng cáo. Ứng dụng chỉ kết nối trực tiếp đến các dịch vụ cần hiển thị: Addon Stremio của bạn, Cinemeta, Nuvio (nếu bạn đăng nhập), wttr.in để lấy thời tiết, danh sách video phong cảnh trên GitHub và YouTube để phát trailer.
</details>

<details>
<summary><b>Nhấn phím OK trên tựa phim sẽ mở ứng dụng gì?</b></summary>

Nhấn OK trên một bộ phim lẻ sẽ chuyển thẳng vào danh sách luồng phát của Nuvio. Với phim bộ sẽ mở trang chi tiết để bạn chọn tập; nếu tập phim nằm ở hàng Tiếp tục xem thì sẽ vào thẳng luồng phát của tập đó.
</details>

<details>
<summary><b>Video hình nền có làm tốn dung lượng bộ nhớ TV không?</b></summary>

Không. Các video này được truyền phát (stream) trực tiếp khi hiển thị và không bao giờ lưu trữ trong máy. Ứng dụng chỉ lưu danh sách liên kết nhẹ và được làm mới hàng tuần.
</details>

<details>
<summary><b>Làm sao để sao lưu cài đặt sang TV khác?</b></summary>

Vào **Cài đặt → Giới thiệu → Sao lưu cài đặt**. Bản sao lưu sẽ được lưu tại `Android/data/com.flix.launcher/files/backups` và `Download/FlixLauncher`. Trên TV mới, chỉ cần sao chép file sao lưu vào đúng thư mục này và chọn **Khôi phục bản sao lưu**.
</details>

<details>
<summary><b>Làm thế nào để gỡ bỏ hoặc quay lại launcher gốc của TV?</b></summary>

Tắt dịch vụ trợ năng của Flix trong **Cài đặt → Trợ năng**, hoặc gỡ cài đặt ứng dụng Flix Launcher như một ứng dụng thông thường.
</details>

---

## Lời cảm ơn & Nguồn tham khảo

- Dự án gốc: [HatriGt/flix-launcher](https://github.com/HatriGt/flix-launcher)
- [Aerial Views](https://github.com/theothernt/AerialViews) danh sách video cảnh quay trên không công khai
- [Cinemeta](https://v3-cinemeta.strem.io) và giao thức Addon của Stremio
- [npanuhin/Bing-Wallpaper-Archive](https://github.com/npanuhin/Bing-Wallpaper-Archive) kho lưu trữ ảnh chất lượng cao của Bing
- [wttr.in](https://wttr.in) cung cấp dữ liệu dự báo thời tiết

Flix Launcher không liên kết với Netflix, Google, Stremio hay Nuvio. Hình ảnh áp phích phim, trailer và hình nền thuộc bản quyền của chủ sở hữu tương ứng.

## Giấy phép (License)

Dự án được phân phối dưới giấy phép [MIT](LICENSE) © HatriGt. Bản Việt hóa được duy trì tại [minhtamvn/flix-launcher](https://github.com/minhtamvn/flix-launcher).
