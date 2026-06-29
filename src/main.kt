// ── MAIN FUNCTION ─────────────────────────────────────────────
fun main() {
    val sep = "=".repeat(60)

    println(sep)
    println("       SIMULASI SISTEM E-KLINIK KAMPUS")
    println(sep)

    val dokterA = Dokter("D001", "MUSTAIN", "Umum", 2)
    val dokterB = Dokter("D002", "CLEMENT", "Gigi", 0)

    val pasien1 = Pasien("P001", "RADJA JASMIN", "2005-04-10", "radja@email.com", "pass123")
    val pasien2 = Pasien("P002", "FERY KURNIAWAN", "2003-07-22", "fery@email.com", "abc123")
    val pasien3 = Pasien("P003", "ADITYA RAHARJA", "2005-01-15", "raharja@email.com", "xyz999")

    dokterA.info()
    dokterB.info()
    pasien1.info()

    
    println("\n$sep")
    println("  SIMULASI GAGAL")
    println(sep)

    pasien2.daftarBerobat(dokterB, "2025-01-15")
    pasien1.ubahPassword("wrongpass", "newpass999")
    pasien1.ubahPassword("pass123", "abc")
    dokterA.setKuota(25)

    val dummyAntrian = Antrian("ANT-DUMMY", 99, "2025-01-15", "P099", "D001")
    dummyAntrian.setStatus("UNKNOWN_STATUS")
    dummyAntrian.setStatus("SELESAI")
    dummyAntrian.setStatus("MENUNGGU")

    println("\n$sep")
    println("  SIMULASI SUKSES")
    println(sep)

    val antrian1 = pasien1.daftarBerobat(dokterA, "2025-01-15")
    val antrian2 = pasien2.daftarBerobat(dokterA, "2025-01-15")

    pasien3.daftarBerobat(dokterA, "2025-01-15")

    antrian1?.setStatus("DIPANGGIL")
    antrian1?.setStatus("SELESAI")

    pasien1.ubahPassword("pass123", "newSecure99")

    dokterB.setKuota(10)

    println("\n$sep")
    println("  SIMULASI SELESAI")
    println(sep)
}