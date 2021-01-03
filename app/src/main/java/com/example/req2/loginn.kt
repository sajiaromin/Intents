package com.example.req2

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import java.util.jar.Manifest

class loginn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginn)

        var intent = intent
        val prof = findViewById<Button>(R.id.changeN)
        val exit = findViewById<Button>(R.id.exit)
        val icon = findViewById<Button>(R.id.changePic)
        val openg = findViewById<Button>(R.id.gallery)
        val wall = findViewById<Button>(R.id.wall)
        val REQUEST_CODE = 100

        wall.setOnClickListener{
            Toast.makeText(this@loginn, "The intent failed; No wall account linked.", Toast.LENGTH_SHORT).show()
        }
        openg.setOnClickListener{
            Toast.makeText(this@loginn, "The intent failed due to external storage conflict", Toast.LENGTH_SHORT).show()
        }
        exit.setOnClickListener{
            finish();
            System.exit(0)
        }
        prof.setOnClickListener {
            val intent = Intent(this, editProf::class.java)
            startActivity(intent)
        }
        icon.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED
                ) {
                    val permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    requestPermissions(permissions, PERMISSION_CODE)
                } else {
                    pickImageFromGallery()
                }
            } else {
                pickImageFromGallery()
            }
        }
    }

    private fun pickImageFromGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_PICK_CODE)
    }

    companion object {
        private val IMAGE_PICK_CODE = 1000
        private val PERMISSION_CODE = 1001

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray

    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            PERMISSION_CODE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickImageFromGallery()
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            val imageView2 = findViewById<ImageView>(R.id.imageView2)
            imageView2.setImageURI(data?.data)
        }
    }
}



