package com.example.coursework

import android.widget.TextView
import java.util.*

class ArithmeticExpression {
   private var length:Int=1
   var  arith_exp_one: String? =null
   var  arith_exp_two: String? =null


   var output:String=""
   var tot:Int=0

   var x:Int=0
   var y:Int=1
   var arith_op=arrayOf("/","*","+","-")

   fun generate_arithmeticExpression(view: TextView){

      var length=(1..3).random(); //number of numbers
      var a:Int=0
      var b:Int=0
      var c:Int=0
      var d:Int=0
      var e:Int=0


      var numbers = intArrayOf(a,b,c,d,e)
      for(i in 0..length){
         numbers[i]=(1..10).random()
      } //add numbers



      var num=(0..3).random()
      x=numbers[0]
      y=numbers[1]



      println(Arrays.toString(numbers))
      println(length+1)

      println("x= "+x)
      println("y= "+get_y())
      tot=generate_expression_(x,get_y(),num)
      println("x= "+x)
      println("y= "+get_y())

      output=(x.toString()+arith_op[num]+get_y().toString())
      println(output)
      println("Previous tot = "+tot)

      if(length+1>2){

         var i=2
         while(i!=length+1){
            y=numbers[i]
            x=tot
            num=(0..3).random()

            tot=generate_expression_(x,y,num)
            println(output+arith_op[num]+get_y().toString())
            println("New tot = "+tot)

            println("done")
            output= "("+output+")"+arith_op[num]+get_y().toString()


            i++

         }

      }

      println("Bro Final output is :"+output )


      view.text=output
   }

   fun generate_expression(x:Int,y:Int,num:Int): Int {
      var expression=intArrayOf(x.div(y),x.times(y),x.plus(y),x.minus(y))
      var tot=expression[num]
      println("tot "+tot)
      return tot

   }


   fun generate_expression_(x: Int, y: Int,num:Int): Int {
      var bool :Boolean
      var answer:Int=0
      var yy=y
      if (num==0){
         bool= check_divisible(x,y)
         if(bool==true){
            var expression=intArrayOf(x.div(y),x.times(y),x.plus(y),x.minus(y))
            answer=expression[num]
         }

         else{
            print("bool is: "+bool)
            while(bool==false){

               yy=(1..10).random();
               bool= check_divisible(x,yy)
               println("yy : "+yy)
            }
            set_y(yy)
            println("Man Y is : "+get_y())
            var expression=intArrayOf(x.div(yy),x.times(yy),x.plus(yy),x.minus(yy))
            answer=expression[num]

         }
      }
      else{
         var expression=intArrayOf(x.div(y),x.times(y),x.plus(y),x.minus(y))
         answer=expression[num]
      }


      return answer
   }


   fun check_divisible(x:Int,y:Int):Boolean{
      var divisible:Boolean
      var answer=x.rem(y)
      if (answer==0){divisible=true}
      else{divisible=false}
      println(divisible)
      return divisible
   }

   fun set_y(y:Int){
      this.y=y;
   }

   fun get_y():Int{
      return y
   }



}






