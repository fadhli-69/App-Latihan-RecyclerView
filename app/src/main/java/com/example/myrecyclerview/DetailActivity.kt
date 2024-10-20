package com.example.myrecyclerview

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Menghubungkan view dengan kode menggunakan findViewById
        val tvDetailName: TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription: TextView = findViewById(R.id.tv_detail_description)
        val ivDetailPhoto: ImageView = findViewById(R.id.iv_detail_photo)

        // Menerima data dari intent
        val dataHero = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_HERO, Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>(EXTRA_HERO)
        }

        // Menampilkan data pada view
        dataHero?.let {
            ivDetailPhoto.setImageResource(it.photo)
            tvDetailName.text = it.name
            tvDetailDescription.text = it.description
        }
    }
}