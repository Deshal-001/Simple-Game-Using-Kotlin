package com.example.coursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

class HomeActivity : AppCompatActivity() {

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val progressbar= findViewById<ProgressBar>(R.id.progressBar)
        setProgressbar(progressbar)



    }

    override fun onStop() {
        Toast.makeText(applicationContext, "onStop", Toast.LENGTH_SHORT).show()
        finish()

        super.onStop()
    }

   fun setProgressbar(progressbar:ProgressBar){
       progressbar.visibility = View.VISIBLE
      var i=progressbar.progress


       Thread(Runnable {
           // this loop will run until the value of i becomes 99
           while (i < 100) {
               if(i==99){
                   intent= Intent(this,MenuActivity::class.java)
                   startActivity(intent)

               }
               i += 1
               // Update the progress bar and display the current value
               handler.post(Runnable {
                   progressbar.progress = i
                   // setting current progress to the textview

               })
               try {
                   Thread.sleep(100)
               } catch (e: InterruptedException) {
                   e.printStackTrace()
               }
           }

           // setting the visibility of the progressbar to invisible
           // or you can use View.GONE instead of invisible
           // View.GONE will remove the progressbar
           progressbar.visibility = View.INVISIBLE


       }).start()






   }
}