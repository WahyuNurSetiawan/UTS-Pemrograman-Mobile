package com.example.utspemrogramanmobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView: ImageView = findViewById(R.id.imageView2)
        val buttonCall: Button = findViewById(R.id.buttonCall)
        val buttonSMS: Button = findViewById(R.id.buttonSMS)

        val movie = intent.getStringExtra("movie")!!
        val phoneNumber = getPhoneNumber(movie)

        val posterImageView: ImageView = findViewById(R.id.imageView2)

        when (movie) {
            "The Super Mario Bros. Movie (2023)" -> posterImageView.setImageResource(R.drawable.poster_mario)
            "Guardians of the Galaxy Vol. 3 (2023)" -> posterImageView.setImageResource(R.drawable.poster_guardians)
            "Ant-Man and the Wasp: Quantumania (2023)" -> posterImageView.setImageResource(R.drawable.poster_antman)
            else -> posterImageView.setImageResource(R.drawable.default_poster)
        }



        imageView.setOnClickListener {
            searchMovie(movie)
        }

        buttonCall.setOnClickListener {
            dialPhoneNumber(phoneNumber)
        }

        buttonSMS.setOnClickListener {
            sendSMS(movie)
        }
    }

    private fun getPhoneNumber(movie: String): String {
        return when (movie) {
            "The Super Mario Bros. Movie (2023)" -> "087839997075"
            "Guardians of the Galaxy Vol. 3 (2023)" -> "087839997077"
            "Ant-Man and the Wasp: Quantumania (2023)" -> "087839997079"
            else -> ""
        }
    }

    private fun searchMovie(movie: String) {
        val query = movie.replace(" ", "+")
        val url = "https://www.google.com/search?q=$query"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
        startActivity(intent)
    }

    private fun sendSMS(movie: String) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT, movie)
        startActivity(intent)
    }
}



