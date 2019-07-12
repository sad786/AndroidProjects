package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import java.util.Stack
import kotlin.math.*

/*
    *This is the first ui page that will shown when
    * app is launch by the user
    * this includes all the business logic
    * we update ui from this class
 */
class MainActivity : AppCompatActivity() {

    private lateinit var textView:TextView      // this refers to the number pad where mathmatical expression is shown
    private val operatorStack:Stack<String> = Stack()       // it used as in the conversion of expression to postfix
                                                            // it asts as a temporary stack to store all the operator
    private val postfix:ArrayList<String> = ArrayList()     // it is used to store converted postfix expression
    private val answer:Stack<Double> = Stack()              // it is used to store current results
    private var dotPressed = false               // it prevents tbe user not to enter more than one dot (.) symbol

    private val expression = StringBuilder()

    /*
        * This is first method which is called when our app appears on the screen
        * it will show all the UI
        * and initialize all the required objects
        * and set all the required properties for objects
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.pad)
        textView.textAlignment = TextView.TEXT_ALIGNMENT_TEXT_END

    }



    override fun onSaveInstanceState(out:Bundle?)
    {
        super.onSaveInstanceState(out)
        var textData:String
        var express:String
        if(textView.text.isEmpty())
            textData = ""
        else
            textData = textView.text.toString()

        if(expression.isEmpty())
            express = ""
        else
            express = expression.toString()

        out?.putString("textData",textData)
        out?.putString("exp",express)

        out?.putBoolean("dot",dotPressed)
    }

    override fun onRestoreInstanceState(out:Bundle?)
    {
        super.onRestoreInstanceState(out)

        expression.append(out?.getString("exp"))
        textView.text = out?.getString("textData")

        dotPressed = out?.getBoolean("dot")!!
    }


    /*
        * This is the method which is called when user pressed
        * any button on the app
        * and do required operation and show result back to the user
        * this method will call other method to do operation to perform a task
        *
     */
    fun calculate(view:View)
    {
        if(textView.text.toString().equals("0"))
            textView.text = ""


        val btn = view as Button    // type casting of view into a Button
        when(view.id)   // this works as a switch in other programming languages
        {

            R.id.clear -> {
                    textView.text = "0"
                    expression.clear()
                    dotPressed = false
            }    // if user want to clear the number pad


            R.id.one,R.id.two,R.id.three,R.id.four,
            R.id.five,R.id.six,R.id.seven, R.id.eight,
            R.id.nine, R.id.zero            ->  {
                                        val sym = btn.text
                                        textView.append(sym)
                                        expression.append(sym)
                                }

            R.id.plus,R.id.minus, R.id.mul,R.id.div,R.id.mod,R.id.power,
            R.id.open_brace,R.id.close_brace -> {
                                            val sym = btn.text
                                            textView.append(sym)
                                            expression.append(sym)
                                            dotPressed = false
                                        }

            R.id.divBy ->{
                textView.append("1/")
                expression.append("1/")
            }

            R.id.log, R.id.tan,R.id.cos, R.id.sin->{
                    val sym = btn.text
                    textView.append("$sym(")
                    expression.append("${sym[0]}(")
            }

            R.id.abs -> {
                textView.append("abs(")
                expression.append("a(")
            }

            R.id.e -> {
                textView.append("${Math.E}")
                expression.append("${Math.E}")
            }

            R.id.ln ->{
                    textView.append("ln(")
                    expression.append("n(")
            }

            R.id.charClear ->{
                                if(textView.text.isNotEmpty()) {

                                    val sym = expression.last()
                                    val len = expression.length

                                    if(sym=='n')
                                    {
                                        textView.text = textView.text.subSequence(0, textView.text.length - 2)
                                    }else if (sym=='l'|| sym=='c'|| sym=='s' || sym=='t')
                                    {
                                        textView.text = textView.text.subSequence(0,textView.text.length-3)
                                    }else
                                        textView.text = textView.text.subSequence(0, textView.text.length - 1)


                                    expression.deleteCharAt(len-1)

                                    if(textView.text.isEmpty())
                                        dotPressed = false
                                }
            }

            // this prevent user entering more than one dot in between a single number
            R.id.dot -> {
                            if(!dotPressed) {
                                textView.append(btn.text)
                                dotPressed = true
                            }
                        }

            R.id.answer -> textView.text = "${giveAnswer()}"

        }// end of the when statement
    }// end of the calculate method









    /*
        * this method will be called by the above calculate() method
        * when user presses equal to (=) button
        * it will return answer calculated to the caller
        * to calculate result it may call another method to perform a given task
     */
    private fun giveAnswer():Number
    {
        var ans:Number = 0  // it represents the end result
                            // if the end result includes decimal points
                            // it will return same other in a Integer form
                            // that is why the Data Type of this variable
                            // it taken as Number to represent any type of number
                            // whether it is double, float or int


        /*
            * This is subroutine used by this method
            * to perform a given task
            * it checks whether the given character is
            * a operator or a digit
         */
        fun isOperator(op:String) = when(op) {
                "+", "-", "*", "/" ,"a","l","n","t","c","s","%","^"-> true
                else -> false
            }

        // it will check the condition required to the calculation
        if(textView.text != "" && textView.text != "Syntax Error")
        {
            convertPostfix()    // this method will return expression in a postfix notation

            for(i in 0 until postfix.size)
            {
                val symbol = postfix[i]   // extract the current symbol on the postfix queue

                if(isOperator(symbol))  // check whether the given symbol is operator or not
                {
                    var first = 0.0
                    var second: Double

                    //extract first two top operand to perform operation
                    if(answer.size>=2 &&(symbol=="+"||symbol=="-"||symbol=="*"||symbol=="/"||symbol=="^"||symbol=="%")) {
                        second = answer.pop()
                        first = answer.pop()
                    }else
                    {
                        second = answer.pop()
                    }

                    // according the corresponding operator the operation will be performed
                    when(symbol){
                        "+" -> answer.push((first+second))

                        "-" -> answer.push(first-second)

                        "*" -> answer.push(first*second)

                        "/" -> answer.push(first/second)

                        "%" -> answer.push(first%second)

                        "^" -> answer.push(first.pow(second))

                        "l" -> answer.push(log10(second))

                        "n" -> answer.push(ln(second))

                        "c" -> answer.push(cos(second))

                        "s" -> answer.push(sin(second))

                        "t" -> answer.push(tan(second))

                        "a" -> answer.push(abs(second))

                    }//end of the when statement

                }else
                {
                    try {

                        answer.push(symbol.toDouble())  // push number to the stack

                    }catch(ex:Exception){}
                }// end of the else block

            }// end of the if block

            val res = answer.pop()  // get the final result from the top of the stack
            ans = res.toInt()
            if(res>ans) ans = res   // check whether answer can be represented as a integer or not
        }

        // after performing all the required task
        // clear all the queues and stacks
        // that is used by the method
        // so that new expression can be stored
        postfix.clear()
        operatorStack.clear()
        answer.clear()
        answer.push(0.0)
        expression.clear()
        expression.append(ans)
        return ans      // return final answer to the caller

    }// end of the giveAnswer method




    /*
        * This is the method that will be called by the above giveAnswer() method
        * it will convert the given Infix Notation expression into the postfix notation
        * postfix notation is very easy to do calculation by the computer machine
     */
    private fun convertPostfix()
    {
        val number = StringBuilder()    // to store a single number in expression
        expression.append(")")  // ")" indicates that the end of the expression
        operatorStack.push("(")     // initial symbol is always we "("
        var index = 0   // it is scalar variable that stores the current location in  the expression


        /*
            * This is the small subroutine that will check
            * whether the given operator is have least precedence
            * to the operator operator on the operatorStack or not
            * if not then return true false other return false
         */
        fun isLeast(op:Char):Boolean
        {
            val top = operatorStack.peek()

            return when
            {
                (top=="a"&& op!='a') ||(top=="^" && op!='^') || (top=="c"||top=="s"||top=="t"||top=="l"||top=="n")&&(op=='+'|| op=='-'||op=='*'||op=='/'||op=='%')
                                        || (top=="/" || top=="*"|| top=="%" && op=='+'||op=='-') -> true

                else -> false
            }
        }// end of the isLeast method



        /*
            * this is another subroutine
            * that will check for given whether it has same precedence
            * to the operator on top of the stack
         */
        fun isSame(op:Char):Boolean
        {
            val top = operatorStack.peek()
             return top==op.toString()

        }// end of the isSame



        //it loops until ends of the expression
        while(index<expression.length)
        {
            //this works as switch statement in other programming languages
            when{

                // if the current character is digit or a dot
                // then this block will be executed and others not
                expression[index].isDigit() or (expression[index]=='.') -> {

                    // it loops until a single number ends
                    // for example if number is 123.45 and index
                    // is pointing the 1 then it will iterate until it reaches 5
                    // then it will consider it as a single number
                    while(expression[index].isDigit()||expression[index]=='.') {
                        number.append(expression[index])  //store current digit
                        index +=1   //increment to point next location

                    }// end of the while

                    // after traversing through the number store to the postfix queue
                    postfix.add(number.toString())
                    number.clear()  // and clear the number means initializing again empty string
                } // end of first block


                // if the current character is '(' symbol then this block will execute
                expression[index] =='(' -> {
                    operatorStack.push("(")     // simply push to the operatorStack not to postfix queue
                    index +=1                   // and increment pointer to the next location
                } // end of the second block


                // if the current char is ')' this block will execute
                expression[index] == ')' -> {

                    // extract operator from the operatorStack until it finds '(' symbol
                    while(operatorStack.size>0 &&  operatorStack.peek()!="(") {
                        postfix.add(operatorStack.pop())
                    }

                    //after finding the '(' symbol pop it from the operatorStack
                    if(operatorStack.size>0)
                        operatorStack.pop()
                    index +=1
                } // end of third block



                // if nothing of the above condition matched
                // that means current character is an operator
                // and this block will be executed
                else -> {

                    val op = expression[index]    // extract the current operator
                    var isLeast = false // if this is true than only for same precedence will be check otherwise not

                    while(isLeast(op))
                    {
                        isLeast = true
                        postfix.add(operatorStack.pop())
                    }// end of the while

                    // this is totally depends on the isLeast veriable and isSame method
                    while(isLeast&&isSame(op))
                    {
                        postfix.add(operatorStack.pop())    // add that operator to the postfix queue
                    }// end of the while

                    operatorStack.push(op.toString())   // after that current operator will added to the operatorStack
                    index +=1
                } // end of the else block

            } // end of the while statement
        }   // end of the when statement
    }   // end of the convert method

}   // end of the class
