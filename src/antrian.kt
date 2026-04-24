// ── KELAS ANTRIAN ────────────────────────────────────────────
class Antrian(
    val idAntrian: String,
    val nomorAntrian: Int,
    val tanggal: String,
    idPasien: String,
    idDokter: String
) {
    var status: String = "MENUNGGU"
        private set

    val infoPasien: String = idPasien
    val infoDokter: String = idDokter

    fun getNomor(): Int = nomorAntrian

    fun setStatus(statusBaru: String) {
        val statusValid = listOf("MENUNGGU", "DIPANGGIL", "SELESAI", "BATAL")
        if (statusBaru.uppercase() !in statusValid) {
            println("  [ERROR] Status '$statusBaru' tidak valid! " +
                    "Pilihan: ${statusValid.joinToString(", ")}")
            return
        }

        if (status == "SELESAI" || status == "BATAL") {
            println("  [ERROR] Antrian #$nomorAntrian sudah '$status', tidak dapat diubah!")
            return
        }

        val lama = status
        status = statusBaru.uppercase()
        println("  [OK] Status antrian #$nomorAntrian: $lama → $status")
    }

    fun info() {
        println("  Antrian[$idAntrian] No.$nomorAntrian | " +
                "Tgl: $tanggal | Status: $status | " +
                "Pasien: $infoPasien | Dokter: $infoDokter")
    }
}