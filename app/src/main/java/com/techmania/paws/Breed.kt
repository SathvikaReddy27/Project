package com.techmania.paws

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Breed : AppCompatActivity(), onClickListener {
    lateinit var recyclerView : RecyclerView
    lateinit var breed : TextView
    lateinit var home : TextView
    lateinit var donate : TextView
    lateinit var adoptions : TextView
    var imagesList = ArrayList<Int>()
    var breedNameList = ArrayList<String>()
    var lifespanList = ArrayList<String>()
    lateinit var adapter : BreedAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breed)
        binding()
        home.setOnClickListener {
            startActivity(Intent(this@Breed,HomePage::class.java))
        }
        donate.setOnClickListener {
            startActivity(Intent(this@Breed,Donate::class.java))
        }
        adoptions.setOnClickListener {
            startActivity(Intent(this@Breed,Adoptions::class.java))
        }
        recyclerView.layoutManager = GridLayoutManager(this,2)
        addImages()
        addBreedNames()
        addlifespan()
        adapter = BreedAdapter(imagesList,breedNameList,lifespanList,this,this@Breed)
        recyclerView.adapter = adapter
    }
    fun binding(){
        recyclerView = findViewById(R.id.recyclerView)
        breed = findViewById(R.id.breeds)
        home = findViewById(R.id.homeText)
        donate = findViewById(R.id.donate)
        adoptions = findViewById(R.id.adoptions)
    }
    fun addImages(){
        imagesList.add(R.drawable.golden)
        imagesList.add(R.drawable.lab)
        imagesList.add(R.drawable.german_shepherd)
        imagesList.add(R.drawable.pom)
        imagesList.add(R.drawable.pug)
        imagesList.add(R.drawable.husky)
        imagesList.add(R.drawable.samoyed)
        imagesList.add(R.drawable.st_bernard)
    }
    fun addBreedNames(){
        breedNameList.add("Golden Retriever")
        breedNameList.add("Labrador")
        breedNameList.add("German Shepherd")
        breedNameList.add("Pomeranian")
        breedNameList.add("Pug")
        breedNameList.add("Siberian Husky")
        breedNameList.add("Samoyed")
        breedNameList.add("St Bernard")
    }
    fun addlifespan(){
        lifespanList.add("10-12 Years")
        lifespanList.add("10-12 Years")
        lifespanList.add("9-13 Years")
        lifespanList.add("12-16 Years")
        lifespanList.add("12-15 Years")
        lifespanList.add("12-15 Years")
        lifespanList.add("12-14 Years")
        lifespanList.add("8-10 Years")
    }

    override fun onItemClicked(position: Int) {
        when(position){
            0 -> startActivity(Intent(this@Breed,GoldenRetriever::class.java))
            1 -> startActivity(Intent(this@Breed,Labrador::class.java))
            2 -> startActivity(Intent(this@Breed,GermanShepherd::class.java))
            3 -> startActivity(Intent(this@Breed,Pomeranian::class.java))
        }
    }
}