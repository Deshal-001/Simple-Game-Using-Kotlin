package com.example.coursework

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MarksActivity : AppCompatActivity() {

    val TAG = "MyActivity"


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marks)

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