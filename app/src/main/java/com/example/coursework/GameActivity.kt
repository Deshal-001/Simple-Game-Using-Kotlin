package com.example.coursework

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView

class GameActivity : AppCompatActivity() {
    //generate first arithmetic expression
    val ArithmeticExpression1 = ArithmeticExpression()

    //generate second arithmetic expression
    val ArithmeticExpression2 = ArithmeticExpression()

    //set satrting time
    val start = 50_000L
    var timer = start

    //creates countdown timer
    lateinit var countDownTimer: CountDownTimer

    //store correct answers
    var correctAnswers = 0

    //store incorrect answers
    var incorrectAnswers = 0

    //assign values to tag var
    val TAG = "MyActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)
        //hide action bar
        supportActionBar?.hide()

        //creates text view for display expression
        val firstExpression = findViewById<TextView>(R.id.expression1)
        val secondExpression = findViewById<TextView>(R.id.expression2)
        //creates buttons
        val greaterButton = findViewById<Button>(R.id.greater_button)
        val lowerButton = findViewById<Button>(R.id.less_button2)
        val equalButton = findViewById<Button>(R.id.equal_button)
        //creates text view for display correctness of the answer
        val answerText = findViewById<TextView>(R.id.text_c)
        //set and start the timer
        setTextTimer()
        startTimer()

        //generate expressions
        generate_expression(firstExpression, secondExpression)

        //greater button
        greaterButton.setOnClickListener {
            textAnimation(answerText)
            setMessage("greater")
            //set text

            generate_expression(firstExpression, secondExpression)
        }
        //lower button
        lowerButton.setOnClickListener {
            textAnimation(answerText)
            setMessage("lower")
            //set text
            generate_expression(firstExpression, secondExpression)
        }
        //equal button
        equalButton.setOnClickListener {
            textAnimation(answerText)
            setMessage("equal")
            //set text
            generate_expression(firstExpression, secondExpression)
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

    //evaluate expressions
    fun outputResult(): String {
        var result = ""
        result = when {
            //check first expression is greater than second
            ArithmeticExpression1.tot > ArithmeticExpression2.tot -> {
                "greater"
            }
            //check first expression is lower than second
            ArithmeticExpression1.tot < ArithmeticExpression2.tot -> {
                "lower"
            }
            //check first expression is greater than second
            else -> {
                "equal"
            }
        }
        //return whether expression 1 greater,equal or lower than the second one
        return result
    }

    //generates the lengths of the expressions randomly
    fun generate_expression(ex1: TextView, ex2: TextView) {
        //assign random values to variables
        val length1 = (1..3).random()
        var length2 = (1..3).random()
        ArithmeticExpression1.generateArithmeticexpression(ex1, length1)

        // check whether the lengths are same or not
        if (length1 == length2) {
            while (length1 == length2) {
                length2 = (1..3).random()
            }

        }
        //generate second expression

        ArithmeticExpression2.generateArithmeticexpression(ex2, length2)

    }

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    fun setMessage(condition: String) {
        //set text view
        val answerText = findViewById<TextView>(R.id.text_c)

        //check condition
        if (outputResult() == condition) {
            answerText.setBackgroundResource(R.color.teal_200)
            //if condition true, set text as corrects
            answerText.text = "CORRECT !"
            //increase the number of correct answers by one
            correctAnswers++
            if (correctAnswers != 0 && correctAnswers % 5 == 0) {
                //if user enters 5 correct answer, 10 seconds will add
                restTimer()
                startTimer()
            }

        } else {
            //if the condition is false set text as wrong
            answerText.setBackgroundResource(R.color.red)
            answerText.text = "WRONG !"
            //increase incorrect answers variable by one
            incorrectAnswers++


        }

    }

    //function for start the time
    private fun startTimer() {
        //set countdown timer and count down interval as 1000 mills
        countDownTimer = object : CountDownTimer(timer, 1000) {
            //end of timer
            override fun onFinish() {
                //assign values to variables
                val marks = correctAnswers.toString()
                val incorrectAns = incorrectAnswers.toString()

                //creates new intent and parse values
                intent = Intent(this@GameActivity, MarksActivity::class.java).also {
                    it.putExtra("CORRECT_ANS", marks)
                    it.putExtra("INCORRECT_ANS", incorrectAns)
                    startActivity(it)
                    //end this context
                    finish()
                }


            }

            override fun onTick(millisUntilFinished: Long) {
                timer = millisUntilFinished
                setTextTimer()
            }

        }.start()
    }

    //pause timer
    private fun pauseTimer() {
        countDownTimer.cancel()
    }

    //restart timer
    private fun restTimer() {
        countDownTimer.cancel()
        timer += 10000
        setTextTimer()
    }

    //  timer format
    fun setTextTimer() {
        var m = (timer / 1000) / 60
        var s = (timer / 1000) % 60
        //set format
        var format = String.format("%02d:%02d", m, s)
        //set timer as textview
        var time = findViewById<TextView>(R.id.time_view)
        //set text
        time.text = format
    }


    //set text animation
    private fun textAnimation(textView: TextView) {
        textView.animate().apply {
            //set duration
            duration = 550
            //set rotaion
            rotationYBy(360f)

        }.start()
    }


}


