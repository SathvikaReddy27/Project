package com.techmania.paws

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomePage : AppCompatActivity() {
    lateinit var breed : TextView
    lateinit var home : TextView
    lateinit var donate : TextView
    lateinit var adoptions : TextView
    lateinit var instagram : TextView
    lateinit var twitter : TextView
    lateinit var facebook : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
        binding()
        breed.setOnClickListener {
            startActivity(Intent(this@HomePage,Breed::class.java))
        }
        donate.setOnClickListener {
            startActivity(Intent(this@HomePage,Donate::class.java))
        }
        adoptions.setOnClickListener {
            startActivity(Intent(this@HomePage,Adoptions::class.java))
        }
        instagram.setOnClickListener {
            val uri = Uri.parse("http://instagram.com/_u/dogs__paws__")
            val insta = Intent(Intent.ACTION_VIEW, uri)
            insta.setPackage("com.instagram.android")
            try{
                startActivity(insta)
            }catch (e : ActivityNotFoundException){
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://instagram.com/_u/dogs__paws__")))
            }
        }
    }
    fun binding(){
        breed = findViewById(R.id.breeds)
        home = findViewById(R.id.homeText)
        donate = findViewById(R.id.donate)
        adoptions = findViewById(R.id.adoptions)
        instagram = findViewById(R.id.insta)
        twitter = findViewById(R.id.twitter)
        facebook = findViewById(R.id.facebook)
    }
}