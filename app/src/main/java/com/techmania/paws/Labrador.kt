package com.techmania.paws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Labrador : AppCompatActivity() {
    lateinit var intro : TextView
    lateinit var phyChar : TextView
    lateinit var phyCharInfo : TextView
    lateinit var health : TextView
    lateinit var healthInfo : TextView
    lateinit var care : TextView
    lateinit var careInfo : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_labrador)
        binding()
        intro.text = getString(R.string.lab_intro)
        phyChar.text = getString(R.string.physical_char)
        phyCharInfo.text = getString(R.string.lab_phy_char)
        health.text = getString(R.string.health)
        healthInfo.text = getString(R.string.lab_health)
        care.text = getString(R.string.care)
        careInfo.text = getString(R.string.lab_care)
    }
    fun binding(){
        intro = findViewById(R.id.intro_lab)
        phyChar = findViewById(R.id.phyHeadingLab)
        phyCharInfo  = findViewById(R.id.phyLab)
        health = findViewById(R.id.healthLab)
        healthInfo = findViewById(R.id.healthInfoLab)
        care = findViewById(R.id.careHeadingLab)
        careInfo = findViewById(R.id.careLab)
    }
}