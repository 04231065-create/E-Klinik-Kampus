// ── KELAS DOKTER ─────────────────────────────────────────────
class Dokter(
    val idDokter: String,
    val nama: String,
    val spesialisasi: String,
    kuotaAwal: Int
) {
    var kuotaHarian: Int = kuotaAwal
        private set

    private val batasMinKuota = 0
    private val batasMaksKuota = 20

    fun setKuota(kuota: Int) {
        if (kuota < batasMinKuota || kuota > batasMaksKuota) {
            println("  [ERROR] Kuota harus antara $batasMinKuota–$batasMaksKuota. Input: $kuota")
            return
        }
        kuotaHarian = kuota
        println("  [OK] Kuota dr. $nama diperbarui menjadi $kuotaHarian")
    }

    fun kurangiKuota(): Boolean {
        if (kuotaHarian <= 0) {
            println("  [ERROR] Kuota dr. $nama HABIS! Tidak bisa menerima pasien baru.")
            return false
        }
        kuotaHarian--
        println("  [OK] Kuota dr. $nama berkurang. Sisa: $kuotaHarian")
        return true
    }

    fun info() {
        println("  Dokter[$idDokter] dr. $nama | $spesialisasi | Kuota tersisa: $kuotaHarian")
    }
}