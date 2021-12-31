package com.example.first_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import coil.load
import coil.transform.CircleCropTransformation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivFoto = findViewById<ImageView>(R.id.iv_foto)
        val tvNama = findViewById<TextView>(R.id.tv_nama)
        val tvLokasi = findViewById<TextView>(R.id.tv_lokasi)
        val tvDesc = findViewById<TextView>(R.id.tv_desc)
        val btnAction = findViewById<Button>(R.id.sebuah_button)
        val etNama = findViewById<EditText>(R.id.et_nama)

        ivFoto.load(R.drawable.stmkg) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }
        tvNama.text = "Sekolah Tinggi Meteorologi Klimatologi dan Geofisika"
        tvLokasi.text = "Tangerang Selatan"
        tvDesc.text =
            "Aplikasi ini merupakan pintu bagi masyarakat umum yang belum mengetahui seluk-beluk tentang STMKG. Selamat menjelajah!"

        btnAction.setOnClickListener {
            val namaPengguna = etNama.text.toString()
            if (namaPengguna.isNotEmpty()) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra(SecondActivity.EXTRA_NAME, namaPengguna)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Nama harus diisi",Toast.LENGTH_SHORT).show()
            }
        }
    }
}