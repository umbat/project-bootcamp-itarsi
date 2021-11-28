package com.example.first_app

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
        supportActionBar?.title = "Help Page"

        val helpLogo = findViewById<ImageView>(R.id.iv_help_logo)
        val helpVersion = findViewById<TextView>(R.id.tv_help_version)

        helpLogo.load(R.drawable.foto) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }
        helpVersion.text = "STMKG App version 1.0.0"
    }
}