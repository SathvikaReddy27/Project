package com.techmania.paws

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Donate : AppCompatActivity() {
    lateinit var breed : TextView
    lateinit var home : TextView
    lateinit var donate : TextView
    lateinit var adoptions : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donate)
        binding()
        breed.setOnClickListener {
            startActivity(Intent(this@Donate,Breed::class.java))
        }
        home.setOnClickListener {
            startActivity(Intent(this@Donate,HomePage::class.java))
        }
        adoptions.setOnClickListener {
            startActivity(Intent(this@Donate,Adoptions::class.java))
        }
    }
    fun binding(){
        breed = findViewById(R.id.breeds)
        home = findViewById(R.id.homeText)
        donate = findViewById(R.id.donate)
        adoptions = findViewById(R.id.adoptions)
    }
}