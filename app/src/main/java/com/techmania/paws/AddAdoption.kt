package com.techmania.paws

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AddAdoption : AppCompatActivity() {
    lateinit var breed : TextView
    lateinit var home : TextView
    lateinit var donate : TextView
    lateinit var adoptions : TextView
    lateinit var addName : TextInputEditText
    lateinit var addBreed : TextInputEditText
    lateinit var addAge : TextInputEditText
    lateinit var addGender : TextInputEditText
    lateinit var addPlace : TextInputEditText
    lateinit var addContact : TextInputEditText
    lateinit var add : Button
    val db = Firebase.firestore
    val ref = db.collection("Adoption Dogs")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_adoption)
        binding()
        breed.setOnClickListener {
            startActivity(Intent(this@AddAdoption,Breed::class.java))
        }
        donate.setOnClickListener {
            startActivity(Intent(this@AddAdoption,Donate::class.java))
        }
        adoptions.setOnClickListener {
            startActivity(Intent(this@AddAdoption,Adoptions::class.java))
        }
        home.setOnClickListener {
            startActivity(Intent(this@AddAdoption,HomePage::class.java))
        }
        add.setOnClickListener {
            saveAdoption()
        }
    }
    fun binding(){
        addName = findViewById(R.id.addName)
        addBreed = findViewById(R.id.addBreed)
        addAge = findViewById(R.id.addAge)
        addGender = findViewById(R.id.addGender)
        addPlace = findViewById(R.id.addPlace)
        addContact = findViewById(R.id.addContact)
        add = findViewById(R.id.addAdoption)
        breed = findViewById(R.id.breeds)
        home = findViewById(R.id.homeText)
        donate = findViewById(R.id.donate)
        adoptions = findViewById(R.id.adoptions)
    }
    fun saveAdoption(){
        val name = addName.text.toString()
        val breed = addBreed.text.toString()
        val age = addAge.text.toString()
        val gender = addGender.text.toString()
        val place = addPlace.text.toString()
        val contact = addContact.text.toString()
        val addAdoption = DogDatabase(name,breed,age,gender,place,contact)
        ref.document(breed)
            .set(addAdoption)
            .addOnSuccessListener {
                Toast.makeText(applicationContext, "Successfully added adoption!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { it ->
                Toast.makeText(applicationContext, it.message.toString(), Toast.LENGTH_SHORT).show()
            }
    }
}