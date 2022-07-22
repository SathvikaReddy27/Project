package com.techmania.paws

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class AdoptionAdapter(val dogList : ArrayList<DogDatabase>
) : RecyclerView.Adapter<AdoptionAdapter.AdoptionViewHolder>() {
    class AdoptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var dogName : TextView = itemView.findViewById(R.id.dogName)
        var dogBreed : TextView = itemView.findViewById(R.id.dogBreed)
        var dogAge : TextView = itemView.findViewById(R.id.dogAge)
        var dogGender : TextView = itemView.findViewById(R.id.dogGender)
        var place : TextView = itemView.findViewById(R.id.place)
        var contact : TextView = itemView.findViewById(R.id.contact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdoptionViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.adoption_card,parent,false)
        return AdoptionViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdoptionViewHolder, position: Int) {
        val dog : DogDatabase = dogList[position]
        holder.dogName.text = dog.Name
        holder.dogBreed.text = dog.Breed
        holder.dogAge.text = dog.Age
        holder.dogGender.text = dog.Gender
        holder.place.text = dog.Place
        holder.contact.text = dog.Contact
        holder.contact.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + Uri.encode(holder.contact.text.toString())))
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dogList.size
    }
}