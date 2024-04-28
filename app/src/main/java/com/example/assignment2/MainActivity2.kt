package com.example.assignment2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {

    private var petHunger = 150
    private var petHealth = 120
    private var petClean = 200

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Get the button and text views
        val btnFeed = findViewById<Button>(R.id.btnFeed)
        val btnClean = findViewById<Button>(R.id.btnClean)
        val btnHappy = findViewById<Button>(R.id.btnHappy)
        val txtHunger = findViewById<EditText>(R.id.petHunger)
        val txtClean = findViewById<EditText>(R.id.petClean)
        val txtHappy = findViewById<EditText>(R.id.petHappy)
        val petImage = findViewById<ImageView>(R.id.petImage)

        // set the initial text value
        txtHunger.setText(petHunger.toString())
        txtClean.setText(petClean.toString())
        txtHappy.setText(petHealth.toString())

        // Handle button click
        btnFeed.setOnClickListener{
            petHunger -= 20
            petHealth += 20
            petHunger += 15

            txtHunger.setText(petHunger.toString())
            animateImageChange(petImage, R.drawable.img)
        }

        btnClean.setOnClickListener{
          petClean += 20
          petHealth +=20

            txtClean.setText(petClean.toString())
            animateImageChange(petImage, R.drawable.img_2)
        }

        btnHappy.setOnClickListener{
            petHealth += 20
            petHunger += 15
            petClean -15
            txtHappy.setText(petHealth.toString())
            animateImageChange(petImage, R.drawable.img_3)

        }
    }

    private fun animateImageChange(imageView: ImageView, newImageResource: Int) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 500
        animation.fillAfter = true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)
    }
}