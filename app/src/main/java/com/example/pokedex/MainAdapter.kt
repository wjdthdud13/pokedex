package com.example.pokedex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class MainAdapter(private val myDataset: ArrayList<PokeData>, private val width: Int) :
    RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.main_item_view, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val textView = holder.view.findViewById<TextView>(R.id.item_view)
        textView.text = myDataset[position].name

        val imageView = holder.view.findViewById<ImageView>(R.id.image_view)
        imageView.layoutParams = ConstraintLayout.LayoutParams(this.width, this.width)

        Glide.with(holder.view.context)
            .load("https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png").into(imageView)
    }

    override fun getItemCount() = myDataset.size
}
