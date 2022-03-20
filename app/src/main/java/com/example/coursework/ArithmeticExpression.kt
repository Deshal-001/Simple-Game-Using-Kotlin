package com.example.coursework

import android.widget.TextView

class ArithmeticExpression {

    var output: String = ""  //display text
    var tot: Int = 0        //total
    var x: Int = 0         //first number
    var y: Int = 1   //second number
    var opr: Int = 0    //operator
    var arith_op = arrayOf("/", "*", "+", "-")  //array of operators


    //function that generates arithmetic expressions
    fun generateArithmeticexpression(view: TextView, ex_length: Int) {
        //length of the expressions
        var length = ex_length
        var a = 0
        var b = 0
        var c = 0
        var d = 0
        var e = 0

        //insert numbers to the array
        var numbers = intArrayOf(a, b, c, d, e)
        for (i in 0..length) {
            //generate random numbers
            numbers[i] = (1..20).random()
        } //add random numbers

        //generate random operator
        var num = (0..3).random()
        //set the index of the operator
        set_opr(num)
        //assign pre-generated values to x and y
        x = numbers[0]
        y = numbers[1]
        //get total
        tot = generateExpression(get_x(), get_y(), num)
        //get output
        output = (get_x().toString() + arith_op[get_opr()] + get_y().toString())

        //check the length of the expression (random generated length)
        if (length + 1 > 2) {
            //assign values to var i
            var i = 2
            //loop until last number
            while (i != length + 1) {
                y = numbers[i]
                x = tot
                //get random operator
                num = (0..3).random()
                set_opr(num)
                tot = generateExpression(x, y, get_opr())
                output = "(" + output + ")" + arith_op[get_opr()] + get_y().toString()
                i++
            }
        }
        //set text of the textview
        view.text = output
    }

    //generate expressions
    fun generateExpression(x: Int, y: Int, num: Int): Int {
        //set bool
        var bool: Boolean
        var answer = 0
        var yy = y
        if (num == 0) {
            //check whether is x subexpression
            bool = checkDivisible(x, y)
            if (bool) {
                //generate expression
                var expression = intArrayOf(x.div(y), x.times(y), x.plus(y), x.minus(y))
                //assign values to answer var
                answer = expression[num]
            } else {
                while (!bool) {
                    //generate new random value for y
                    yy = (1..20).random()
                    //check whether is x subexpression
                    bool = checkDivisible(x, yy)
                }
                //set value for y
                set_y(yy)

                var expression = intArrayOf(x.div(yy), x.times(yy), x.plus(yy), x.minus(yy))
                answer = expression[num]
            }

        } else {
            var total = 0
            var number = 0
            var bools = true
            var expression =
                intArrayOf(x.div(get_y()), x.times(get_y()), x.plus(get_y()), x.minus(get_y()))
            answer = expression[num]
            //check whether is the total lower than 100
            if (answer >= 100) {
                while (bools) {
                    //generate random numbers for y
                    yy = (1..20).random()
                    //generate random operator
                    number = (0..2).random()
                    //generate expression
                    expression = intArrayOf(x.times(yy), x.plus(yy), x.minus(yy))
                    //set total
                    total = expression[number]
                    //check whether is the total lower than 100
                    if (total < 100) {
                        bools = false
                    }
                }
                //set operator
                set_opr(number + 1)
                //assign value for the answer
                answer = total
                //assign value for y
                set_y(yy)
            }
        }
        return answer
    }

    //check subexpressions
    fun checkDivisible(x: Int, y: Int): Boolean {
        var divisible: Boolean
        //store remainder
        var answer = x.rem(y)
        divisible = answer == 0 && answer < 100

        return divisible
    }


    fun set_y(y: Int) {
        this.y = y;
    }

    fun get_y(): Int {
        return y
    }

    fun get_x(): Int {
        return x
    }

    fun set_opr(opr: Int) {
        this.opr = opr
    }

    fun get_opr(): Int {
        return opr
    }


}






