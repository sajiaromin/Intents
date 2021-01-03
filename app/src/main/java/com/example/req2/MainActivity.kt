package com.example.req2

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginbut = findViewById<Button>(R.id.button)
        val reg = findViewById<TextView>(R.id.textView)
        val prof = findViewById<Button>(R.id.changeN)
        val REQUEST_CODE = 200


        loginbut.setOnClickListener{
                val intent = Intent(this, loginn::class.java)
                startActivity(intent)
            }
        reg.setOnClickListener{
            Toast.makeText(this@MainActivity, "Unable to Register, no internet connection. Try again later", Toast.LENGTH_SHORT).show()
        }


        fun capturePhoto() {

            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, REQUEST_CODE)
        }
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null){
                //imageView.setImageBitmap(data.extras.get("data") as Bitmap)
            }
        }
    }

}