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
import coil.transform.CircleCropTransformation

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PRODI = "EXTRA_PRODI"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val ivDetailImage = findViewById<ImageView>(R.id.iv_detail_image)
        val tvDetailNama = findViewById<TextView>(R.id.tv_detail_nama)
        val tvDetailDesc = findViewById<TextView>(R.id.tv_detail_desc)
        val btnLink = findViewById<Button>(R.id.btn_link)

        val prodi = intent.getParcelableExtra<Prodi>(EXTRA_PRODI)

        prodi?.let { prodi ->
            ivDetailImage.load(prodi.foto) {
                crossfade(true)
                transformations(CircleCropTransformation())
            }
            tvDetailNama.text = prodi.nama
            tvDetailDesc.text = prodi.desc

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
                Toast.makeText(this, "Anda menyukai prodi ini", Toast.LENGTH_SHORT)
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