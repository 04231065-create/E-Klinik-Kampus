# UTS PBO - E-Klinik Kampus (Pendaftaran Berobat)
Repositori ini merupakan hasil pengerjaan Ujian Tengah Semester (UTS) mata kuliah Pemrograman Berorientasi Objek (PBO). Proyek ini difokuskan pada pemodelan sistem dan implementasi kode berbasis Object-Oriented Programming (OOP) menggunakan bahasa Kotlin.

## Deskripsi Proyek
Sistem **E-Klinik Kampus** adalah simulasi pendaftaran berobat yang dirancang untuk memastikan keamanan data dan logika bisnis melalui penerapan enkapsulasi ketat. Proyek ini mengevaluasi aspek Analisis SDLC/UML, Kerapian Kolaborasi Git, dan Keamanan Logika Kode.

### Entitas Sistem
Sistem ini terdiri dari tiga Class utama:
- Pasien
- Dokter
- Antrian

### Aturan Bisnis (Business Rules)
Logika program dibangun dengan mematuhi aturan bisnis berikut:
- Pasien hanya bisa mendaftar jika Kuota Harian Dokter > 0.
- Setelah mendaftar, nomor antrian pasien bertambah dan kuota dokter berkurang.

### Fitur & Keamanan Kode
- Data Hiding: Variabel sensitif (seperti kuota dokter) diproteksi dan tidak boleh diakses atau diubah secara langsung menggunakan operator = dari luar Class.
- Custom Setter & Validasi: Modifikasi data hanya bisa dilakukan melalui "Jalur Resmi" (fungsi public) yang telah dilengkapi dengan validasi If-Else secara ketat.
- Simulasi Transaksi: Terdapat fungsi simulasi di dalam main() yang menguji dua skenario utama:
- - Simulasi SUKSES: Pasien melakukan pendaftaran yang sah, sistem memprosesnya, serta atribut antrian dan kuota ter-update dengan benar.
- - Simulasi GAGAL: Aktor mencoba melanggar aturan (misalnya mendaftar saat kuota dokter penuh), dan sistem akan menolak serta memunculkan print error.Teknologi yang DigunakanBahasa Pemrograman: Kotlin Version Control: Git & GitHub Pemodelan: UML (Use Case & Class Diagram) 