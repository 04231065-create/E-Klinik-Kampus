class Antrian(val tanggal: String) {
    private val daftarPasien = mutableListOf<Pasien>()
    
    // Nomor antrian bertambah secara otomatis, tidak bisa di-reset dari luar [cite: 41]
    var nomorAntrianSaatIni: Int = 0
        private set

    // Fungsi pendaftaran dengan validasi ketat (If-Else) [cite: 44]
    fun prosesPendaftaran(pasien: Pasien, dokter: Dokter) {
        println("=== Memproses Pendaftaran: ${pasien.nama} ===")
        
        // Aturan Bisnis: Pasien hanya bisa mendaftar jika Kuota Dokter > 0 
        if (dokter.kuotaHarian > 0) {
            dokter.kurangiKuota() // Kuota dokter berkurang 
            nomorAntrianSaatIni++ // Nomor antrian bertambah 
            daftarPasien.add(pasien)
            
            println("Status: BERHASIL.")
            println("No. Antrian Anda: $nomorAntrianSaatIni")
            println("Sisa Kuota dr. ${dokter.nama}: ${dokter.kuotaHarian}\n")
        } else {
            // Simulasi GAGAL: Memunculkan print error [cite: 47]
            println("Status: GAGAL! Maaf, kuota dr. ${dokter.nama} sudah habis.\n")
        }
    }
}