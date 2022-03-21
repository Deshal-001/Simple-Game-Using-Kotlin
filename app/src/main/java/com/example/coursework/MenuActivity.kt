package com.example.coursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        supportActionBar?.hide()  //hide action bar

        val aboutButton = findViewById<Button>(R.id.about)
        val newgameButton = findViewById<Button>(R.id.newgame)

        val logo=findViewById<ImageView>(R.id.logo)
        logo.setOnClickListener {
            logoAnimation(logo)
        }

        aboutPage(aboutButton)
        newGamePage(newgameButton)
    }
    private fun newGamePage(newgameButton: Button) {
        newgameButton.setOnClickListener {
            intent = Intent(this, GameActivity::class.java)
            startActivity(intent)

        }
    }

    fun aboutPage(aboutButton: Button) {
        val window = PopupWindow(this)

        val view = layoutInflater.inflate(R.layout.about_popup, null)
        window.contentView = view

        aboutButton.setOnClickListener {
            val popUpWindow = about()
            popUpWindow.show(supportFragmentManager, "About PopUp")

        }


    }
    private fun logoAnimation(logoView: ImageView) {
        logoView.animate().apply {
            //set duration
            duration = 550
            //set rotaion
            rotationYBy(360f)

        }.start()
    }
}