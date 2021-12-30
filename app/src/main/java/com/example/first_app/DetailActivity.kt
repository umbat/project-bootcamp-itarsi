package com.example.first_app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import coil.load
import org.w3c.dom.Text

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PRODI = "EXTRA_PRODI"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Details"

        val ivDetailImage = findViewById<ImageView>(R.id.iv_detail_image)
        val tvDetailNama = findViewById<TextView>(R.id.tv_detail_nama)
        val tvDetailDesc = findViewById<TextView>(R.id.tv_detail_desc)
        val tvDetailTitel = findViewById<TextView>(R.id.tv_titel)
        val ivFotoPimpinan = findViewById<ImageView>(R.id.iv_pimpinan)
        val tvNamaPimpinan = findViewById<TextView>(R.id.tv_nama_pimpinan)
        val btnLink = findViewById<Button>(R.id.btn_link)

        val prodi = intent.getParcelableExtra<Prodi>(EXTRA_PRODI)

        prodi?.let { prodi ->
            ivDetailImage.load(prodi.logoprodi) {
                crossfade(true)
            }
            ivFotoPimpinan.load(prodi.fotopimpinan) {
                crossfade(true)
            }
            tvDetailNama.text = prodi.nama
            tvDetailDesc.text = prodi.desc
            tvDetailTitel.text = prodi.titelpimpinan
            tvNamaPimpinan.text = prodi.namapimpinan

            btnLink.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse(prodi.link))
                startActivity(intent)
            }
            supportActionBar?.title = prodi.nama
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_favorite -> {
                Toast.makeText(this, "Anda menyukai halaman ini", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
            R.id.menu_help -> {
                val intent = Intent(this, HelpActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}