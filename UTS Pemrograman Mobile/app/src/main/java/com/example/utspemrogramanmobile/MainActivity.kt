package com.example.utspemrogramanmobile

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val movieList = arrayOf(
        "The Super Mario Bros. Movie (2023)",
        "Guardians of the Galaxy Vol. 3 (2023)",
        "Ant-Man and the Wasp: Quantumania (2023)"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, movieList)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedMovie = movieList[position]
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("movie", selectedMovie)
            startActivity(intent)
        }
    }
}
