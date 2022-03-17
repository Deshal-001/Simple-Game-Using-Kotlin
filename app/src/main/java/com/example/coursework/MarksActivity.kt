package com.example.coursework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MarksActivity : AppCompatActivity() {

    val TAG = "MyActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marks)

        val marks=intent.getStringExtra("EXTRA_MESSAGE")
        var total=findViewById<TextView>(R.id.marks_text).apply { text=marks.toString() }

        val new_gamebutton=findViewById<Button>(R.id.play_button)
        val home_button=findViewById<Button>(R.id.home_button)

        new_gamebutton.setOnClickListener {
            intent=Intent(this,GameActivity::class.java)
            startActivity(intent)

        }
        home_button.setOnClickListener {
            intent=Intent(this,MainActivity::class.java)
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
        finish()
        Log.i(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Toast.makeText(applicationContext, "onDestroy", Toast.LENGTH_SHORT).show()
        Log.i(TAG, "onDestroy")

        super.onDestroy()

    }
}