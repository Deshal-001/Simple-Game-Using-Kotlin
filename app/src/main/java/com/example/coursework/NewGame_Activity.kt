package com.example.coursework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class NewGame_Activity : AppCompatActivity() {
    val ArithmeticExpression1= ArithmeticExpression()
    val ArithmeticExpression2= ArithmeticExpression()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_game)

        val first_expression=findViewById<TextView>(R.id.expression1)
        val second_expression=findViewById<TextView>(R.id.expression2)
        
        val greater_button=findViewById<Button>(R.id.greater_button)
        val lower_button=findViewById<Button>(R.id.less_button2)
        val equal_button=findViewById<Button>(R.id.equal_button)




        generate_expression(first_expression,second_expression)
       // second_expression.text= "Expression 2

        greater_button.setOnClickListener {
            set_message("greater")

            generate_expression(first_expression,second_expression)
        }
        lower_button.setOnClickListener {
            set_message("lower")
            generate_expression(first_expression,second_expression)
        }
        equal_button.setOnClickListener {
            set_message("equal")
            generate_expression(first_expression,second_expression)
        }


    }

    fun output_result():String{
        var result:String=""
        if (ArithmeticExpression1.tot>ArithmeticExpression2.tot){
            result="greater"
        }
        else if(ArithmeticExpression1.tot<ArithmeticExpression2.tot){
            result="lower"
        }
        else{
            result="equal"
        }
        return result
    }

    fun generate_expression(ex1:TextView,ex2:TextView){
        ArithmeticExpression1.generate_arithmeticExpression(ex1)
        println ("First Tot: "+ArithmeticExpression1.tot)
        ArithmeticExpression2.generate_arithmeticExpression(ex2)
        println ("Second Tot: "+ArithmeticExpression2.tot)
    }

    fun set_message(condition:String){
        if (output_result()==condition){
            println("Correct !")
            Toast.makeText(applicationContext,"Correct !",Toast.LENGTH_SHORT).show()
        }
        else{
            println ("Wrong !")
            Toast.makeText(applicationContext,"Wrong !",Toast.LENGTH_SHORT).show()

        }

    }





}