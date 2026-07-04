class Dokter(val nama: String, kuotaAwal: Int) {
    // Menerapkan Data Hiding & Private Set untuk keamanan [1, 2]
    var kuotaHarian: Int = kuotaAwal
        private set(value) {
            // Logika validasi: kuota tidak boleh minus [2]
            if (value >= 0) {
                field = value
            } else {
                println("Error: Kuota dokter $nama tidak boleh negatif!")
            }
        }

    // "Jalur Resmi" untuk memodifikasi data melalui fungsi public [1]
    fun kurangiKuota(): Boolean {
        return if (kuotaHarian > 0) {
            kuotaHarian--
            true
        } else {
            println("Pendaftaran Gagal: Kuota dokter $nama sudah habis.")
            false
        }
    }
}

class Pasien(val nama: String, val noRekamMedis: String)

fun main() {
    val dokter = Dokter("dr. Andi", 1) // Simulasi kuota hanya 1
    val pasien1 = Pasien("Budi", "RM001")
    val pasien2 = Pasien("Siti", "RM002")

    // --- Simulasi SUKSES --- [1]
    println("--- Pendaftaran 1 ---")
    if (dokter.kurangiKuota()) {
        println("Pasien ${pasien1.nama} berhasil mendaftar ke ${dokter.nama}.")
        println("Sisa kuota: ${dokter.kuotaHarian}")
    }

    // --- Simulasi GAGAL --- [1]
    // Aktor mencoba mendaftar saat kuota sudah habis
    println("\n--- Pendaftaran 2 ---")
    if (dokter.kurangiKuota()) {
        println("Pasien ${pasien2.nama} berhasil mendaftar.")
    }
    
    // Mencoba mengubah kuota secara langsung akan menyebabkan error compile
    // dokter.kuotaHarian = 10 // Error: Cannot assign to 'kuotaHarian': the setter is private [2]
}