fun main() {
    // Persiapan Objek
    val dokter1 = Dokter("D01", "Himawan", "Umum", 1) // Kuota cuma 1 untuk tes
    val antrianKlinik = Antrian("24 April 2026")

    val p1 = Pasien("P01", "Budi", "Batuk")
    val p2 = Pasien("P02", "Siti", "Sakit Gigi")

    // 1. Simulasi SUKSES [cite: 48]
    antrianKlinik.prosesPendaftaran(p1, dokter1)

    // 2. Simulasi GAGAL (Karena kuota sudah 0) [cite: 46, 47]
    antrianKlinik.prosesPendaftaran(p2, dokter1)
}