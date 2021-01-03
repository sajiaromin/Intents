package com.example.req2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class editProf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_prof)

        val save = findViewById<Button>(R.id.savebut)
        var intent = intent

        save.setOnClickListener{
            val intent = Intent(this, loginn::class.java)
            startActivity(intent)
        }
    }
}