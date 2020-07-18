package com.example.pokedex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainAdapter(private val myDataset: Array<String?>) :
    RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        //        // create a new view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_item_view, parent, false)
        // set the view's size, margins, paddings and layout parameters

        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val textView = holder.view.findViewById<TextView>(R.id.item_view)
        textView.text =  myDataset[position]

        val imageView = holder.view.findViewById<ImageView>(R.id.image_view)
        Glide.with(holder.view.context).load("https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png").into(imageView)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size
}