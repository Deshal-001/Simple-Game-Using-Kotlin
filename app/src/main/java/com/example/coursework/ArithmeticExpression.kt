package com.example.coursework

import android.widget.TextView
import java.util.*

class ArithmeticExpression {

    var output: String = ""
    var tot: Int = 0

    var x: Int = 0
    var y: Int = 1
    var opr:Int=0
    var arith_op = arrayOf("/", "*", "+", "-")


    fun generate_arithmeticExpression(view: TextView, ex_length: Int) {

        var length = ex_length; //number of numbers
        var a: Int = 0
        var b: Int = 0
        var c: Int = 0
        var d: Int = 0
        var e: Int = 0


        var numbers = intArrayOf(a, b, c, d, e)
        for (i in 0..length) {
            numbers[i] = (1..20).random()
        } //add numbers


        var num = (0..3).random()
        set_opr(num)
        x = numbers[0]
        y = numbers[1]
        tot = generate_expression_(get_x(), get_y(), num)
        println(tot)


        output = (get_x().toString() + arith_op[get_opr()] + get_y().toString())
        /** 3+2 **/

        if (length + 1 > 2) {
            var i = 2
            while (i != length + 1) {
                y = numbers[i]
                x = tot
                num = (0..3).random()
                set_opr(num)
                tot = generate_expression_(x, y, get_opr())
                println(tot)
                output = "(" + output + ")" + arith_op[get_opr()] + get_y().toString()
                i++
            }
        }
        view.text = output
    }


    fun generate_expression_(x: Int, y: Int, num: Int): Int {
        var bool: Boolean
        var answer: Int = 0
        var yy = y
        var xx=x
        if (num == 0) {
            bool = check_divisible(x, y)
            if (bool == true) {
                var expression = intArrayOf(x.div(y), x.times(y), x.plus(y), x.minus(y))
                answer = expression[num]
            } else {
                while (bool == false) {
                    yy = (1..20).random();
                    bool = check_divisible(x, yy)
                }
                set_y(yy)

                var expression = intArrayOf(x.div(yy), x.times(yy), x.plus(yy), x.minus(yy))
                answer = expression[num]


            }
        } else {
            var total=0
            var number=0
            var bools=true
            var expression = intArrayOf(x.div(get_y()), x.times(get_y()), x.plus(get_y()), x.minus(get_y()))
            answer = expression[num]

            if (answer>=100){
                println("came broooooooo")
                println("x :$x y:$y")

                while(bools){
                   // yy = 1;
                    yy=(1..20).random()
                    number=(0..2).random()
                    println("operator : $number")

                    expression = intArrayOf(x.times(yy), x.plus(yy), x.minus(yy))
                    total = expression[number]
                    if(total<100){
                        bools=false
                    }
                    println("total in the loop : $total")
                    //yy++
                }
                set_opr(number+1)
                answer=total
                set_y(yy)
                println("yy = $yy  x=$x")
                println("Corrected : $answer")

            }

        }




        return answer
    }


    fun check_divisible(x: Int, y: Int): Boolean {
        var divisible: Boolean
        var answer = x.rem(y)
        if (answer == 0 && answer < 100) {
            divisible = true
        } else {
            divisible = false
        }

        return divisible
    }


    fun set_y(y: Int) {
        this.y = y;
    }

    fun get_y(): Int {
        return y
    }

    fun set_x(x: Int) {
        this.x = x;
    }

    fun get_x(): Int {
        return x
    }
    fun set_opr(opr:Int){
        this.opr=opr
    }

    fun get_opr():Int{
        return opr
    }


}






