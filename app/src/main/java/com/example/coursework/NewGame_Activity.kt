package com.example.coursework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NewGame_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        val first_expression=findViewById<TextView>(R.id.expression1)
        val second_expression=findViewById<TextView>(R.id.expression2)
        val ArithmeticExpression= ArithmeticExpression()
        ArithmeticExpression.generate_arithmeticExpression(first_expression)
        ArithmeticExpression.generate_arithmeticExpression(second_expression)
       // second_expression.text= "Expression 2"
    }




}