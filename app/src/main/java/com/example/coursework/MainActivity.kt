package com.example.coursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.PopupWindow


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aboutButton=findViewById<Button>(R.id.about)
        val newgameButton=findViewById<Button>(R.id.newgame)

        aboutPage(aboutButton)

        newGamePage(newgameButton)






            // If API level 23 or higher then execute the code


    }

    private fun newGamePage(newgameButton: Button) {
        newgameButton.setOnClickListener {
            intent= Intent(this,NewGame_Activity::class.java)
            startActivity(intent)

        }
    }

    fun aboutPage(aboutButton: Button){
       val window= PopupWindow(this)
       val view=layoutInflater.inflate(R.layout.about_popup,null)
       window.contentView=view

       aboutButton.setOnClickListener{
           val dialog=about()
           dialog.show(supportFragmentManager,"About Dialog")

       }

    }
}
