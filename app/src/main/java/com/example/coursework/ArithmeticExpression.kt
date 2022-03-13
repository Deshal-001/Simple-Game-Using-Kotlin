package com.example.coursework

import android.widget.TextView
import java.util.*

class ArithmeticExpression {
   private var length:Int=1
   var  arith_exp_one: String? =null
   var  arith_exp_two: String? =null


   var output:String=""
   var tot:Int=0
      get() = field
      set(value) {
         field = value
      }

   fun generate_arithmeticExpression(view: TextView){
      var length=(1..3).random(); //number of numbers
      var a:Int=0
      var b:Int=0
      var c:Int=0
      var d:Int=0
      var e:Int=0

      var x:Int=0
      var y:Int=1



      var numbers = intArrayOf(a,b,c,d,e)
      for(i in 0..length){
         numbers[i]=(1..20).random()
      } //add numbers



      var num=(0..3).random()
      x=numbers[0]
      y=numbers[1]


      var arith_op=arrayOf("/","*","+","-")
    //  println(Arrays.toString(numbers))
     // println(length+1)

    ////  println("x= "+x)
     // println("y= "+y)
      output=(x.toString()+arith_op[num]+y.toString())


      tot=generate_expression_(x,y,num)
    //  println(output)
     // println("Previous tot = "+tot)


      if(length+1>2){

         var i=2
         while(i!=length+1){
            y=numbers[i]
            x=tot
            num=(0..3).random()
            tot=generate_expression_(x,y,num)
           // println(output+arith_op[num]+y.toString())
          //  println("New tot = "+tot)

            output= "("+output+")"+arith_op[num]+y.toString()

            i++

         }



      }


      view.text=output
   }


   fun generate_expression_(x: Int, y: Int,num:Int): Int {
      var expression=intArrayOf(x.div(y),x.times(y),x.plus(y),x.minus(y))
      return expression[num]
   }

}






