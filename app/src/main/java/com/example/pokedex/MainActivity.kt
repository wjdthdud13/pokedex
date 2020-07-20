package com.example.pokedex

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.String.format
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val width = applicationContext.resources.displayMetrics.widthPixels / 3

        val pokemon = findViewById<RecyclerView>(R.id.pokemon_recycler_view)

        val dataset = arrayOfNulls<String>(100)

        pokemon.setHasFixedSize(true)

        pokemon.layoutManager = GridLayoutManager(this, 3)

        var i = 0
        while (i < 100) {
            dataset[i] = format(Locale.ENGLISH, "Data_0%d", i)
            i++
        }
        pokemon.adapter = MainAdapter(dataset, width)

    }
}
