package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity() {
    lateinit var name:String
    var selectedAnswer: Int = -1
    var answerShown = false
    var currentQuestionNumber = 0
    var userPoint = 0
    private lateinit var questionList: ArrayList<Question>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        name = intent.getStringExtra("name")
        questionList = QuestionList.getQuestions()
        tv_question_text.text = questionList[currentQuestionNumber].question
        tv_option_one.text = questionList[currentQuestionNumber].option1
        tv_option_two.text = questionList[currentQuestionNumber].option2
        tv_option_three.text = questionList[currentQuestionNumber].option3
        tv_option_four.text = questionList[currentQuestionNumber].option4
    }

    fun optionClicked(view: View){
        val btn = view as Button
        if(selectedAnswer == -1){
            btn.setBackgroundColor(resources.getColor(R.color.colorAccent))
            when(btn.id){
                R.id.tv_option_one -> { selectedAnswer = 1}
                R.id.tv_option_two -> { selectedAnswer = 2 }
                R.id.tv_option_three -> { selectedAnswer = 3 }
                R.id.tv_option_four -> { selectedAnswer = 4 }
            }

            btn_submit_button.text = "Check Answer"
        }
    }

    fun submitAnswer(view: View){
        if(!answerShown && (selectedAnswer!=-1)){
           val actualAnswer = questionList[currentQuestionNumber].correctOption
            if(actualAnswer == selectedAnswer){
                userPoint += 1
                when(selectedAnswer){
                    1 -> tv_option_one.setBackgroundColor(Color.GREEN)
                    2 -> tv_option_two.setBackgroundColor(Color.GREEN)
                    3 -> tv_option_three.setBackgroundColor(Color.GREEN)
                    4 -> tv_option_four.setBackgroundColor(Color.GREEN)
                }
            }else{
                when(selectedAnswer){
                    1 -> tv_option_one.setBackgroundColor(Color.RED)
                    2 -> tv_option_two.setBackgroundColor(Color.RED)
                    3 -> tv_option_three.setBackgroundColor(Color.RED)
                    4 -> tv_option_four.setBackgroundColor(Color.RED)
                }
                when(actualAnswer){
                    1 -> tv_option_one.setBackgroundColor(Color.GREEN)
                    2 -> tv_option_two.setBackgroundColor(Color.GREEN)
                    3 -> tv_option_three.setBackgroundColor(Color.GREEN)
                    4 -> tv_option_four.setBackgroundColor(Color.GREEN)
                }
            }
            answerShown = true
            btn_submit_button.text = "Next"
        }else if(answerShown){
            if(currentQuestionNumber < questionList.size-1){
                currentQuestionNumber ++
                tv_question_text.text = questionList[currentQuestionNumber].question
                tv_option_one.text = questionList[currentQuestionNumber].option1
                tv_option_two.text = questionList[currentQuestionNumber].option2
                tv_option_three.text = questionList[currentQuestionNumber].option3
                tv_option_four.text = questionList[currentQuestionNumber].option4
                answerShown = false
                selectedAnswer = -1
                tv_option_one.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
                tv_option_two.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
                tv_option_three.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))
                tv_option_four.setBackgroundColor(resources.getColor(R.color.colorPrimaryDark))

            }else{
//                final page
                //Toast.makeText(this, "Completed, your score $userPoint out of ${questionList.size} questions", Toast.LENGTH_LONG).show()
                val intent = Intent(this, ResultActivity()::class.java)
                intent.putExtra("result", "Hey $name, you have got $userPoint questions correct out of ${questionList.size} question")
                startActivity(intent)
                finish()
            }
        }
    }
}