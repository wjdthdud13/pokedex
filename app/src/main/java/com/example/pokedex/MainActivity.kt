package com.example.pokedex

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.lang.String.format
import java.nio.charset.Charset
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val width = applicationContext.resources.displayMetrics.widthPixels / 3

        val pokemon = findViewById<RecyclerView>(R.id.pokemon_recycler_view)

        pokemon.setHasFixedSize(true)

        pokemon.layoutManager = GridLayoutManager(this, 3)
        val data = jsonParsing(getJsonString())
        pokemon.adapter = MainAdapter(data, width)

    }

    private fun getJsonString(): String {
        var json = ""
        try {
            val inputStream: InputStream = assets.open("pokedex.json")
            val fileSize: Int = inputStream.available()
            val buffer = ByteArray(fileSize)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return json
    }

    private fun jsonParsing(json: String): ArrayList<PokeData>{
        val pokeDataArray = arrayListOf<PokeData>()
        try {
            val jsonObject = JSONObject(json)
            val pokedexArray = jsonObject.getJSONArray("pokedex")
            for (i in 0 until pokedexArray.length()) {
                val pokeObject = pokedexArray.getJSONObject(i)
                val number = pokeObject.getString("number")
                val name = pokeObject.getString("name")
                val pokeData = PokeData(number, name)
                pokeDataArray.add(pokeData)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return pokeDataArray
    }

}
