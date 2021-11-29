package com.example.first_app

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "About"

        val aboutImages = findViewById<ImageView>(R.id.iv_about_image)
        val aboutName = findViewById<TextView>(R.id.tv_about_nama)
        val aboutKet = findViewById<TextView>(R.id.tv_about_ket)
        val aboutDesc = findViewById<TextView>(R.id.tv_about_desc)

        aboutImages.load(R.drawable.my_photo) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }
        aboutName.text = "Muhammad Farhan Pratama"
        aboutKet.text = "Shinobi Konoha"
        aboutDesc.text = "Lahir di Magelang dan hidup sebagai shinobi Konoha"
    }
}