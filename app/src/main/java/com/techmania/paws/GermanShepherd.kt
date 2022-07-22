package com.techmania.paws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class GermanShepherd : AppCompatActivity() {
    lateinit var intro : TextView
    lateinit var phyChar : TextView
    lateinit var phyCharInfo : TextView
    lateinit var health : TextView
    lateinit var healthInfo : TextView
    lateinit var care : TextView
    lateinit var careInfo : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_german_shepherd)
        binding()
        intro.text = getString(R.string.german_intro)
        phyChar.text = getString(R.string.physical_char)
        phyCharInfo.text = getString(R.string.german_phy_char)
        health.text = getString(R.string.health)
        healthInfo.text = getString(R.string.german_health)
        care.text = getString(R.string.care)
        careInfo.text = getString(R.string.german_care)
    }
    fun binding(){
        intro = findViewById(R.id.intro_german)
        phyChar = findViewById(R.id.phyHeadingGerman)
        phyCharInfo  = findViewById(R.id.phyGerman)
        health = findViewById(R.id.healthGerman)
        healthInfo = findViewById(R.id.healthInfoGerman)
        care = findViewById(R.id.careHeadingGerman)
        careInfo = findViewById(R.id.careGerman)
    }
}