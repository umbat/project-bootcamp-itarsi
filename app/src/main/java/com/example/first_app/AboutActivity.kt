package com.example.first_app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.title = "About"

        val aboutImages = findViewById<ImageView>(R.id.iv_about_image)
        val aboutName = findViewById<TextView>(R.id.tv_about_nama)
        val aboutKet = findViewById<TextView>(R.id.tv_about_ket)
        val aboutDesc = findViewById<TextView>(R.id.tv_about_desc)
        val aboutInsta = findViewById<Button>(R.id.instagram)
        val aboutGithub = findViewById<Button>(R.id.github)

        aboutImages.load(R.drawable.my_photo) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }
        aboutName.text = "Muhammad Farhan Pratama"
        aboutKet.text = "Taruna Instrumentasi MKG"
        aboutDesc.text = "Lahir pada 8 Juni 2000 di Magelang. Bercita-cita menjadi fullstack developer walaupun laptopnya medioker dan ilmunya masih sangat minim"
        aboutInsta.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://www.instagram.com/farhannpratama/"))
            startActivity(intent)
        }
        aboutGithub.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://github.com/umbat"))
            startActivity(intent)
        }
    }
}