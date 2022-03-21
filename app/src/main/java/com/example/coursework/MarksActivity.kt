package com.example.coursework

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.RatingBar
import kotlin.math.roundToInt


class MarksActivity : AppCompatActivity() {

    val TAG = "MyActivity"


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marks)
        supportActionBar?.hide() //hide action bar

        var marks=0

        //get values from the intent
        val correctAns = intent.getStringExtra("CORRECT_ANS")
        val incorrectAns = intent.getStringExtra("INCORRECT_ANS")

        //set total
        var total =
            Integer.parseInt(correctAns.toString()) + Integer.parseInt(incorrectAns.toString())
        //set percentage of total
         if(total!=0){
             marks =
                 (((Integer.parseInt(correctAns.toString()).toDouble()) / total) * 100).roundToInt()
         }
        else{
            marks=0
        }

        //create text viewes
        var correct =
            findViewById<TextView>(R.id.correct_text).apply { text = correctAns.toString() }
        var incorrect =
            findViewById<TextView>(R.id.incorrect_text).apply { text = incorrectAns.toString() }
        var marksText = findViewById<TextView>(R.id.marks).apply { text = ("$marks%") }
        //creates buttons
        val newGameButton = findViewById<Button>(R.id.play_button)
        val homeButton = findViewById<Button>(R.id.home_button)
        //creates a rating bar
        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        //set step sizes of rating bar
        ratingBar.stepSize = 0.5f
        // set rating bar
        when {
            marks < 1 -> {
                ratingBar.rating = 0F
            }
            marks < 10 -> {
                ratingBar.rating = 0.5f
            }
            marks < 25 -> {
                ratingBar.rating = 1f
            }
            marks < 35 -> {
                ratingBar.rating = 1.5f
            }
            marks < 50 -> {
                ratingBar.rating = 2f
            }
            marks < 65 -> {
                ratingBar.rating = 2.5f
            }
            marks < 75 -> {
                ratingBar.rating = 3f
            }
            marks < 85 -> {
                ratingBar.rating = 3.5f
            }
            marks < 90 -> {
                ratingBar.rating = 4f
            }
            marks < 95 -> {
                ratingBar.rating = 4.5f
            }
            marks > 90 -> {
                ratingBar.rating = 5f
            }
        }

        //set new game button
        newGameButton.setOnClickListener {
            //creates new intent
            intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
        homeButton.setOnClickListener {
            //creates new intent
            intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        Log.i(TAG, "On Resume")
        super.onResume()

    }

    override fun onPause() {
        Log.i(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.i(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy")
        super.onDestroy()

    }


}