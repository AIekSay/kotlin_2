package com.example.first

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.linear_layout_main.*
class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.linear_layout_main)
    }
    fun sendQuestion(view: View){
        val data= Intent(this,SecondActivity::class.java).apply{
            putExtra("Question",editText.text.toString())
        }
        startActivityForResult(data,  REQUEST_CODE)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {


        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode ==  REQUEST_CODE) {
            if (data != null) {
                textView.setText(data.getStringExtra("Answer"))
            }
        }
    }
}
