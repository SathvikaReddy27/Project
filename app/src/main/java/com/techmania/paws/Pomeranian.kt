package com.techmania.paws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Pomeranian : AppCompatActivity() {
    lateinit var intro : TextView
    lateinit var phyChar : TextView
    lateinit var phyCharInfo : TextView
    lateinit var health : TextView
    lateinit var healthInfo : TextView
    lateinit var care : TextView
    lateinit var careInfo : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pomeranian)
        binding()
        intro.text = getString(R.string.pom_intro)
        phyChar.text = getString(R.string.physical_char)
        phyCharInfo.text = getString(R.string.pom_phy_char)
        health.text = getString(R.string.health)
        healthInfo.text = getString(R.string.pom_health)
        care.text = getString(R.string.care)
        careInfo.text = getString(R.string.pom_care)
    }
    fun binding(){
        intro = findViewById(R.id.intro_pom)
        phyChar = findViewById(R.id.phyHeadingPom)
        phyCharInfo  = findViewById(R.id.phyPom)
        health = findViewById(R.id.healthPom)
        healthInfo = findViewById(R.id.healthInfoPom)
        care = findViewById(R.id.careHeadingPom)
        careInfo = findViewById(R.id.carePom)
    }
}