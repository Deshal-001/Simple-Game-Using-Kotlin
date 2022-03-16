package com.example.coursework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.widget.Button

class Marks_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marks)

        val marks=intent.getStringExtra("EXTRA_MESSAGE")
        var total=findViewById<TextView>(R.id.marks_text).apply { text=marks.toString() }

        val new_gamebutton=findViewById<Button>(R.id.play_button)
        val home_button=findViewById<Button>(R.id.home_button)

        new_gamebutton.setOnClickListener {
            intent=Intent(this,NewGame_Activity::class.java)
            startActivity(intent)

        }
        home_button.setOnClickListener {
            intent=Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

    }
}