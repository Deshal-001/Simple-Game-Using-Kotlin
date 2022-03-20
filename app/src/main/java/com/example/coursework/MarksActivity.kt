package com.example.coursework

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast

class MarksActivity : AppCompatActivity() {

    val TAG = "MyActivity"


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marks)
        supportActionBar?.hide()  //hide action bar

         val correctAns=intent.getStringExtra("CORRECT_ANS")
         val incorrect_ans=intent.getStringExtra("INCORRECT_ANS")

        var total=Integer.parseInt(correctAns.toString())+Integer.parseInt(incorrect_ans.toString())

        var marks=Math.round(((Integer.parseInt(correctAns.toString()).toDouble())/total)* 100)
        Toast.makeText(this,Integer.parseInt(correctAns.toString()).toString(),Toast.LENGTH_SHORT).show()


        var correct=findViewById<TextView>(R.id.correct_text).apply { text=correctAns.toString() }
        var incorrect=findViewById<TextView>(R.id.incorrect_text).apply { text=incorrect_ans.toString() }
        var marksText=findViewById<TextView>(R.id.marks).apply { text=("$marks%")}

        val new_gamebutton=findViewById<Button>(R.id.play_button)
        val home_button=findViewById<Button>(R.id.home_button)

        val ratingBar=findViewById<RatingBar>(R.id.ratingBar)
        ratingBar.stepSize=1f

        when {
            marks<1->{
                ratingBar.rating= 0F
            }
            marks<10->{
                ratingBar.rating=0.5f
            }
            marks<25 -> {
                ratingBar.rating=1f
            }
            marks<35 -> {
                ratingBar.rating=1.5f
            }
            marks<50 -> {
                ratingBar.rating=2f
            }
            marks<65 -> {
                ratingBar.rating=2.5f
            }
            marks<75 -> {
                ratingBar.rating=3f
            }
            marks<85 -> {
                ratingBar.rating=3.5f
            }
            marks<90 -> {
                ratingBar.rating=4f
            }
            marks<95 -> {
                ratingBar.rating=4.5f
            }
            marks>90 -> {
                ratingBar.rating=5f
            }
        }


        new_gamebutton.setOnClickListener {
            intent=Intent(this,GameActivity::class.java)
            startActivity(intent)
        }
        home_button.setOnClickListener {
            intent=Intent(this,MenuActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        Toast.makeText(applicationContext, "On Resume", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "On Resume")
        super.onResume()

    }

    override fun onPause() {
        Toast.makeText(applicationContext, "onPause", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Toast.makeText(applicationContext, "onStop", Toast.LENGTH_SHORT).show()

        Log.i(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Toast.makeText(applicationContext, "onDestroy", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onDestroy")
        super.onDestroy()

    }


}