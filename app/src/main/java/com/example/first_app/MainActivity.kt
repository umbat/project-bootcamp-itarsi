package com.example.first_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

        ivFoto.load(R.drawable.foto) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }
        tvNama.text = "Sekolah Tinggi Meteorologi Klimatologi dan Geofisika"
        tvLokasi.text = "Tangerang Selatan"
        tvDesc.text =
            "Sekolah Tinggi Meteorologi Klimatologi dan Geofisika (STMKG) adalah Perguruan Tinggi Kedinasan di lingkungan Badan Meteorologi, Klimatologi, dan Geofisika (BMKG), yang mempersiapkan kader tenaga ahli tingkat madya, guna mendukung tugas Badan Meteorologi, Klimatologi, dan Geofisika sebagai lembaga acuan utama di Indonesia dalam memberikan informasi meteorologi, klimatologi, geofisika, dan kualitas udara, yang secara teknis akademik, pembinaannya dilakukan oleh Menteri Pendidikan Nasional dan secara teknis operasional dilakukan oleh Kepala Badan Meteorologi, Klimatologi, dan Geofisika."

        btnAction.setOnClickListener {
            val namaPengguna = etNama.text.toString()
            if (namaPengguna.isNotEmpty()) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra(SecondActivity.EXTRA_NAME, namaPengguna)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Nama harus diisi!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}