package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        btn.setOnClickListener{
            if(et_user_name.text.toString().isEmpty()){
                Toast.makeText(this, "Please provide a name", Toast.LENGTH_LONG).show()
            }else{
                val name = et_user_name.text.toString()
                val intent = Intent(this, QuestionsActivity()::class.java)
                intent.putExtra("name", name)
                startActivity(intent)
                finish()
            }
        }
    }
}