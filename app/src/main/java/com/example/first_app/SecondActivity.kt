package com.example.first_app

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.title = "Hello World"

        val dataProdi = listOf<Prodi>(
            Prodi(
                "Meteorologi",
                "Bidang Meteorologi umumnya berkaitan dengan fenomena di atmosfer dari aspek dinamis, fisis, komputasi meterologi, hingga oseanografi",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fstmkg.ac.id%2F&psig=AOvVaw0kjvuFMDhdC5b46VxrZTEY&ust=1638111598096000&source=images&cd=vfe&ved=2ahUKEwiHnMOw57j0AhVGtUsFHXP-CXgQjRx6BAgAEAk",
                "https://meteorologi.stmkg.ac.id/"
            ),
            Prodi(
                "Klimatologi",
                "Klimatologi merupakan ilmu yang mempelajari kualitas udara dan keadaan iklim",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fstmkg.ac.id%2F&psig=AOvVaw3TdHFfCspdNZL5oAKm8RXf&ust=1638111702945000&source=images&cd=vfe&ved=2ahUKEwio3cLi57j0AhWaR2wGHY2YBu0QjRx6BAgAEAk",
                "https://klimatologi.stmkg.ac.id/"
            ),
            Prodi(
                "Geofisika",
                "Geofisika mempelajari ilmu yang menerapkan prinsip-prinsip fisika untuk mengetahui dan memecahkan masalah yang berhubungan dengan bumi",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fstmkg.ac.id%2F&psig=AOvVaw3TdHFfCspdNZL5oAKm8RXf&ust=1638111702945000&source=images&cd=vfe&ved=0CAkQjRxqFwoTCLjdgfnnuPQCFQAAAAAdAAAAABAE",
                "https://geofisika.stmkg.ac.id/"
            ),
            Prodi(
                "Instrumentasi",
                "Instrumentasi MKG menyiapkan teknisi BMKG yang handal dalam pengoperasian alat, kalibrasi, elektronika, perancangan dan rekayasa sistem, jaringan, dan lain-lain",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fstmkg.ac.id%2F&psig=AOvVaw0kjvuFMDhdC5b46VxrZTEY&ust=1638111598096000&source=images&cd=vfe&ved=0CAkQjRxqFwoTCPibvY_ouPQCFQAAAAAdAAAAABAD",
                "https://instrumentasi.stmkg.ac.id/"
            ),
        )

        val rv = findViewById<RecyclerView>(R.id.rv_prodi)
        val adapter = ProdiAdapter(dataProdi) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_PRODI, it)
            startActivity(intent)
        }

        rv.layoutManager = LinearLayoutManager(this)
        rv.setHasFixedSize(true)
        rv.adapter = adapter
    }
}
