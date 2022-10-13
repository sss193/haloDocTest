package com.vicky.halodoctest.persentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.vicky.halodoctest.R

class Fullscreen : AppCompatActivity() {
    companion object{
       const val IMAGE_URL = "image_url"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen)
        val imgFullScreen: ImageView = findViewById(R.id.imgFullScreen)
        val imageUrl = intent.getStringExtra(IMAGE_URL)

        Picasso
            .get()
            .load(imageUrl)
            .noFade()
            .into(imgFullScreen);
    }
}