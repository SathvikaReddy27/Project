package com.techmania.paws

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Adoptions : AppCompatActivity() {

    lateinit var breed : TextView
    lateinit var home : TextView
    lateinit var donate : TextView
    lateinit var adoptions : TextView
    lateinit var recyclerV : RecyclerView
    lateinit var adoptionArrayList : ArrayList<DogDatabase>
    lateinit var adoptionAdapter : AdoptionAdapter
    lateinit var data : FirebaseFirestore
    lateinit var add : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adoptions)
        binding()
        breed.setOnClickListener {
            startActivity(Intent(this@Adoptions,Breed::class.java))
        }
        donate.setOnClickListener {
            startActivity(Intent(this@Adoptions,Donate::class.java))
        }
        home.setOnClickListener {
            startActivity(Intent(this@Adoptions,HomePage::class.java))
        }
        add.setOnClickListener {
            startActivity(Intent(this@Adoptions,AddAdoption::class.java))
        }

        recyclerV = findViewById(R.id.recyclerV)
        recyclerV.layoutManager = LinearLayoutManager(this)
        adoptionArrayList = arrayListOf()
        adoptionAdapter = AdoptionAdapter(adoptionArrayList)
        recyclerV.adapter = adoptionAdapter
    }

    override fun onStart() {
        super.onStart()
        getAdoptions()
    }
    fun binding(){
        add = findViewById(R.id.textView5)
        breed = findViewById(R.id.breeds)
        home = findViewById(R.id.homeText)
        donate = findViewById(R.id.donate)
        adoptions = findViewById(R.id.adoptions)
    }

    fun getAdoptions(){
        data = FirebaseFirestore.getInstance()
        data.collection("Adoption Dogs").addSnapshotListener(object : EventListener<QuerySnapshot>{
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if(error!=null){
                    Log.e("Firebase error",error.message.toString())
                    return
                }
                for(dc : DocumentChange in value?.documentChanges!!){
                    if(dc.type == DocumentChange.Type.ADDED){
                        adoptionArrayList.add(dc.document.toObject(DogDatabase::class.java))
                    }
                }
                adoptionAdapter.notifyDataSetChanged()
            }

        })
    }
}