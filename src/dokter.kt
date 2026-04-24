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

// ── KELAS PASIEN ─────────────────────────────────────────────
class Pasien(
    val idPasien: String,
    val nama: String,
    val tanggalLahir: String,
    val email: String,
    password: String
) {
    private var password: String = password

    private val daftarAntrian = mutableListOf<Antrian>()
    private var counterAntrian = 0

    fun ubahPassword(passwordLama: String, passwordBaru: String) {
        if (passwordLama != this.password) {
            println("  [ERROR] Password lama salah untuk pasien $nama!")
            return
        }
        if (passwordBaru.length < 6) {
            println("  [ERROR] Password baru minimal 6 karakter!")
            return
        }
        this.password = passwordBaru
        println("  [OK] Password pasien $nama berhasil diubah.")
    }

    fun daftarBerobat(dokter: Dokter, tanggal: String): Antrian? {
        if (dokter.kuotaHarian <= 0) {
            println("  [ERROR] Pendaftaran GAGAL: Kuota dr. ${dokter.nama} penuh!")
            return null
        }

        val berhasil = dokter.kurangiKuota()
        if (!berhasil) return null

        counterAntrian++
        val idAntrian = "ANT-${idPasien}-${counterAntrian.toString().padStart(3, '0')}"
        val nomorAntrian = daftarAntrian.size + 1

        val antrian = Antrian(
            idAntrian,
            nomorAntrian,
            tanggal,
            idPasien,
            dokter.idDokter
        )

        daftarAntrian.add(antrian)

        println("  [OK] $nama berhasil daftar ke dr. ${dokter.nama}. No. Antrian: $nomorAntrian")
        return antrian
    }

    fun lihatAntrian(): Int = daftarAntrian.size

    fun info() {
        println("  Pasien[$idPasien] $nama | Lahir: $tanggalLahir | Email: $email | Total Antrian: ${lihatAntrian()}")
    }
}
