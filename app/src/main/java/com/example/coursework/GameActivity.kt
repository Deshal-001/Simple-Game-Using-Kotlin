package com.example.coursework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class GameActivity : AppCompatActivity() {
    val ArithmeticExpression1 = ArithmeticExpression()
    val ArithmeticExpression2 = ArithmeticExpression()
    val start = 50_000L
    var timer = start
    lateinit var countDownTimer: CountDownTimer
    var correct_answers = 0

    val TAG = "MyActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        val first_expression = findViewById<TextView>(R.id.expression1)
        val second_expression = findViewById<TextView>(R.id.expression2)

        val greater_button = findViewById<Button>(R.id.greater_button)
        val lower_button = findViewById<Button>(R.id.less_button2)
        val equal_button = findViewById<Button>(R.id.equal_button)
        setTextTimer()
        startTimer()







        generate_expression(first_expression, second_expression)
        // second_expression.text= "Expression 2

        greater_button.setOnClickListener {
            set_message("greater")

            generate_expression(first_expression, second_expression)
        }
        lower_button.setOnClickListener {
            set_message("lower")
            generate_expression(first_expression, second_expression)
        }
        equal_button.setOnClickListener {
            set_message("equal")
            generate_expression(first_expression, second_expression)
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
        pauseTimer()
        super.onDestroy()

    }

    fun output_result(): String {
        var result = ""
        if (ArithmeticExpression1.tot > ArithmeticExpression2.tot) {
            result = "greater"
        } else if (ArithmeticExpression1.tot < ArithmeticExpression2.tot) {
            result = "lower"
        } else {
            result = "equal"
        }
        return result
    }

    fun generate_expression(ex1: TextView, ex2: TextView) {
        val length1=(1..3).random()
        var length2=(1..3).random()
        ArithmeticExpression1.generate_arithmeticExpression(ex1,length1)
        println("First Tot: " + ArithmeticExpression1.tot)

        if (length1==length2){
            while (length1==length2){
                 length2=(1..3).random()
            }

        }

        ArithmeticExpression2.generate_arithmeticExpression(ex2,length2)
        println("Second Tot: " + ArithmeticExpression2.tot)
    }

    fun set_message(condition: String) {
        if (output_result() == condition) {
            println("Correct !")
            correct_answers++
            if (correct_answers!=0 && correct_answers%5==0){
                restTimer()
                startTimer()
            }


            Toast.makeText(applicationContext, "Correct ! $correct_answers", Toast.LENGTH_SHORT)
                .show()
        } else {
            println("Wrong !")
            Toast.makeText(applicationContext, "Wrong !", Toast.LENGTH_SHORT).show()

        }

    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(timer, 1000) {
            //            end of timer
            override fun onFinish() {

                Toast.makeText(
                    applicationContext,
                    "end timer $correct_answers ",
                    Toast.LENGTH_SHORT
                ).show()

                val marks = correct_answers.toString()

                intent = Intent(this@GameActivity, MarksActivity::class.java).also {
                    it.putExtra("EXTRA_MESSAGE", marks)
                    startActivity(it)
                    finish()
                }


            }

            override fun onTick(millisUntilFinished: Long) {
                timer = millisUntilFinished
                setTextTimer()
            }

        }.start()
    }

    //    btn pause
    private fun pauseTimer() {
        countDownTimer.cancel()
    }

    //    btn restart
    private fun restTimer() {
        countDownTimer.cancel()
        timer += 10000
        setTextTimer()
    }

    //  timer format
    fun setTextTimer() {
        var m = (timer / 1000) / 60
        var s = (timer / 1000) % 60

        var format = String.format("%02d:%02d", m, s)
        var time = findViewById<TextView>(R.id.time_view)
        time.setText(format)
    }


}