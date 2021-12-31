package com.example.first_app

object ProdiData {
    private val prodiNames = arrayOf (
        "STMKG",
        "BMKG",
        "Meteorologi",
        "Klimatologi",
        "Geofisika",
        "Instrumentasi",
        "Resimen Taruna"
    )

    private val prodiDetails = arrayOf (
        "Sekolah Tinggi Meteorologi Klimatologi dan Geofisika (STMKG) adalah Perguruan Tinggi Kedinasan di lingkungan Badan Meteorologi, Klimatologi, dan Geofisika (BMKG), yang mempersiapkan kader tenaga ahli tingkat madya, guna mendukung tugas Badan Meteorologi, Klimatologi, dan Geofisika sebagai lembaga acuan utama di Indonesia dalam memberikan informasi meteorologi, klimatologi, geofisika, dan kualitas udara, yang secara teknis akademik, pembinaannya dilakukan oleh Menteri Pendidikan Nasional dan secara teknis operasional dilakukan oleh Kepala Badan Meteorologi, Klimatologi, dan Geofisika.",
        "Badan Meteorologi, Klimatologi, dan Geofisika (disingkat BMKG), sebelumnya bernama Badan Meteorologi dan Geofisika (disingkat BMG) adalah Lembaga Pemerintah Nonkementerian Indonesia yang mempunyai tugas melaksanakan tugas pemerintahan di bidang meteorologi, klimatologi, dan geofisika.",
        "Bidang Meteorologi umumnya berkaitan dengan fenomena di atmosfer dari aspek dinamis, fisis, komputasi meterologi, hingga oseanografi",
        "Klimatologi merupakan ilmu yang mempelajari kualitas udara dan keadaan iklim",
        "Geofisika mempelajari ilmu yang menerapkan prinsip-prinsip fisika untuk mengetahui dan memecahkan masalah yang berhubungan dengan bumi",
        "Instrumentasi MKG menyiapkan teknisi BMKG yang handal dalam pengoperasian alat, kalibrasi, elektronika, perancangan dan rekayasa sistem, jaringan, dan lain-lain",
        "Resimen Taruna Sekolah Tinggi Meteorologi, Klimatologi, dan Geofisika adalah sebuah wadah untuk taruna dan taruni STMKG untuk mengembangkan bakat dan minat di lingkungan kampus"
    )

    private val prodiTitel = arrayOf (
        "Kepala",
        "Ketua",
        "Kaprodi",
        "Kaprodi",
        "Kaprodi",
        "Kaprodi",
        "Komandan"
    )

    private val prodiNamaPemimpin = arrayOf (
        "Dr. I Nyoman Sukanta S.Si., MT",
        "Prof. Ir. Dwikorita Karnawati, M.Sc. Ph.D",
        "Ahmad Fadlan, SST, M.Si.",
        "Ervan Ferdiansyah, M.Si.",
        "Dr. Wandono, M.Si",
        "Hapsoro Agung Nugroho, M.T",
        "Ahmadi Musa"
    )

    private val prodiLogo = intArrayOf (
        R.drawable.stmkg,
        R.drawable.bmkg,
        R.drawable.meteo,
        R.drawable.klimat,
        R.drawable.geof,
        R.drawable.ins,
        R.drawable.resimen
    )

    private val prodiFotoPimpinan = intArrayOf (
        R.drawable.i_nyoman_sukanta,
        R.drawable.dwikorita_karnawati,
        R.drawable.icon,
        R.drawable.icon,
        R.drawable.icon,
        R.drawable.icon,
        R.drawable.ahmadi_musa
    )

    private val prodiLink = arrayOf (
        "https://stmkg.ac.id/",
        "https://bmkg.go.id/",
        "https://meteorologi.stmkg.ac.id/",
        "https://klimatologi.stmkg.ac.id/",
        "https://geofisika.stmkg.ac.id/",
        "https://instrumentasi.stmkg.ac.id/",
        "https://www.instagram.com/resimen.stmkg/"
    )
    val listData: ArrayList<Prodi>
    get() {
        val list = arrayListOf<Prodi>()
        for (position in prodiNames.indices){
            val prodi = Prodi()
            prodi.nama = prodiNames[position]
            prodi.desc = prodiDetails[position]
            prodi.logoprodi = prodiLogo[position]
            prodi.titelpimpinan = prodiTitel[position]
            prodi.fotopimpinan = prodiFotoPimpinan[position]
            prodi.namapimpinan = prodiNamaPemimpin[position]
            prodi.link = prodiLink[position]
            list.add(prodi)
        }
        return list
    }
}