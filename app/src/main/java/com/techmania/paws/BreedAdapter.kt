package com.techmania.paws

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BreedAdapter(
    var imagesList: ArrayList<Int>,
    var breedNameList: ArrayList<String>,
    var lifespanList: ArrayList<String>,
    val onClickListener: onClickListener,
    var context: Context
) : RecyclerView.Adapter<BreedAdapter.BreedViewHolder>(){
    class BreedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var dogImage : ImageView = itemView.findViewById(R.id.dogImageView)
        var breedNameText : TextView = itemView.findViewById(R.id.name)
        var lifespanText : TextView = itemView.findViewById(R.id.lifespan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.breed_design,parent,false)
        return BreedViewHolder(view)
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        holder.breedNameText.text = breedNameList.get(position)
        holder.lifespanText.text = lifespanList.get(position)
        holder.dogImage.setImageResource(imagesList.get(position))
        holder.itemView.setOnClickListener{
            onClickListener.onItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return breedNameList.size
    }
}