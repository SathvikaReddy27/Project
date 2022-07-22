package com.techmania.paws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class GoldenRetriever : AppCompatActivity() {
    lateinit var intro : TextView
    lateinit var phyChar : TextView
    lateinit var phyCharInfo : TextView
    lateinit var health : TextView
    lateinit var healthInfo : TextView
    lateinit var care : TextView
    lateinit var careInfo : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_golden_retriever)
        binding()
        intro.text = getString(R.string.golden_intro)
        phyChar.text = getString(R.string.physical_char)
        phyCharInfo.text = getString(R.string.golden_phy)
        health.text = getString(R.string.health)
        healthInfo.text = getString(R.string.golden_health)
        care.text = getString(R.string.care)
        careInfo.text = getString(R.string.golden_care)
    }
    fun binding(){
        intro = findViewById(R.id.intro_golden)
        phyChar = findViewById(R.id.phyHeadingGolden)
        phyCharInfo  = findViewById(R.id.phyGolden)
        health = findViewById(R.id.healthGolden)
        healthInfo = findViewById(R.id.healthInfoGolden)
        care = findViewById(R.id.careHeadingGolden)
        careInfo = findViewById(R.id.careGolden)
    }
}