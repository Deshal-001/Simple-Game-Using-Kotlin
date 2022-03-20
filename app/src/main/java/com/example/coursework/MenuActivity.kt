package com.example.coursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.PopupWindow

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        supportActionBar?.hide()  //hide action bar

        val aboutButton = findViewById<Button>(R.id.about)
        val newgameButton = findViewById<Button>(R.id.newgame)

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
}