class Dokter(
    val idDokter: String,
    val nama: String,
    val spesialis: String,
    kuotaAwal: Int
) {
    // Kriteria: Variabel sensitif tidak boleh diubah sembarangan dari luar [cite: 41]
    var kuotaHarian: Int = kuotaAwal
        private set // Hanya bisa diubah oleh fungsi di dalam kelas ini

    // "Jalur Resmi" untuk memodifikasi kuota [cite: 43]
    fun kurangiKuota(): Boolean {
        return if (kuotaHarian > 0) {
            kuotaHarian--
            true
        } else {
            false
        }
    }
}