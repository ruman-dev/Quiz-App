package com.rumanweb.quizapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Display.Mode
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    var index = 0
    private val questions = listOf<ModelQuestion>(
        ModelQuestion(
            "WWW stands for","World Whole Web","Wide World Web","Web World Wide","World Wide Web","World Wide Web"
        ),
        ModelQuestion(
            "Which of the following are components of Central Processing Unit (CPU) ?","Arithmetic logic unit,Mouse","Arithmetic logic unit, Control unit","Arithmetic logic unit, Integrated Circuits","Control Unit, Monitor","Arithmetic logic unit, Control unit"
        ),
        ModelQuestion(
            "Where is RAM located-","Expansion Board","External Drive","Mother Board","All of above","Mother Board"
        ),
        ModelQuestion(
            "If a computer has more than one processor then it is known as ?","Uniprocess","Multiprocessor","Multithreaded","Multiprogramming","Multiprocessor"
        ),
        ModelQuestion(
            "If a computer provides database services to other, then it will be known as ?","Web server","Application server","Database server","FTP server","Database server"
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rl_opt1: RelativeLayout = findViewById(R.id.rl_opt1)
        var rl_opt2: RelativeLayout = findViewById(R.id.rl_opt2)
        var rl_opt3: RelativeLayout = findViewById(R.id.rl_opt3)
        var rl_opt4: RelativeLayout = findViewById(R.id.rl_opt4)

        var tv_Ques: TextView = findViewById(R.id.tv_Ques)
        var tv_opt_01: TextView = findViewById(R.id.tv_opt_01)
        var tv_opt_02: TextView = findViewById(R.id.tv_opt_02)
        var tv_opt_03: TextView = findViewById(R.id.tv_opt_03)
        var tv_opt_04: TextView = findViewById(R.id.tv_opt_04)

        var check_opt1: ImageView = findViewById(R.id.check_opt1)
        var check_opt2: ImageView = findViewById(R.id.check_opt2)
        var check_opt3: ImageView = findViewById(R.id.check_opt3)
        var check_opt4: ImageView = findViewById(R.id.check_opt4)

        var Next_btn: Button = findViewById(R.id.Next_btn)
        var tv_ques_no: TextView = findViewById(R.id.tv_ques_no)

        tv_Ques.text = questions[0].mQues
        tv_opt_01.text = questions[0].mopt1
        tv_opt_02.text = questions[0].mopt2
        tv_opt_03.text = questions[0].mopt3
        tv_opt_04.text = questions[0].mopt4

        tv_ques_no.text = "Quiz : ${index+1}/${questions.size}"

        rl_opt1.setOnClickListener {
            check_opt1.visibility = View.VISIBLE
            check_opt2.visibility = View.INVISIBLE
            check_opt3.visibility = View.INVISIBLE
            check_opt4.visibility = View.INVISIBLE
            questions[index].mUserSelectedAns = "A"
        }
        rl_opt2.setOnClickListener {
            check_opt1.visibility = View.INVISIBLE
            check_opt2.visibility = View.VISIBLE
            check_opt3.visibility = View.INVISIBLE
            check_opt4.visibility = View.INVISIBLE
            questions[index].mUserSelectedAns = "B"
        }
        rl_opt3.setOnClickListener {
            check_opt1.visibility = View.INVISIBLE
            check_opt2.visibility = View.INVISIBLE
            check_opt3.visibility = View.VISIBLE
            check_opt4.visibility = View.INVISIBLE
            questions[index].mUserSelectedAns = "C"
        }
        rl_opt4.setOnClickListener {
            check_opt1.visibility = View.INVISIBLE
            check_opt2.visibility = View.INVISIBLE
            check_opt3.visibility = View.INVISIBLE
            check_opt4.visibility = View.VISIBLE
            questions[index].mUserSelectedAns = "D"
        }

        Next_btn.setOnClickListener {
            if(index < questions.size-1) {
                index++

            check_opt1.visibility = View.INVISIBLE
            check_opt2.visibility = View.INVISIBLE
            check_opt3.visibility = View.INVISIBLE
            check_opt4.visibility = View.INVISIBLE

            tv_Ques.text = questions[index].mQues
            tv_opt_01.text = questions[index].mopt1
            tv_opt_02.text = questions[index].mopt2
            tv_opt_03.text = questions[index].mopt3
            tv_opt_04.text = questions[index].mopt4
            tv_ques_no.text = "Quiz : ${index+1}/${questions.size}"
            if(index == questions.size-1) Next_btn.text = "SUBMIT"
        }
        else{
            questions.forEach {
                Log.d("ans", it.mUserSelectedAns)
            }

        }
    }
    }
}
