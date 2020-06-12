package com.example.progressautologin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.editText
import kotlinx.android.synthetic.main.activity_login.editText2
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    lateinit var pref : SharedPreferences
    lateinit var editor :SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        var pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        editor = pref.edit()

        button2.setOnClickListener{
            if(editText.text.isNullOrBlank() || editText2.text.isNullOrBlank()){
                Toast.makeText(this, "아이디 혹은 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)

                editor.putString("id",editText.text.toString() )
                editor.putString("password",editText2.text.toString())
                editor.commit()

                intent.putExtra("id", editText.text.toString())
                intent.putExtra("password", editText.text.toString())
                startActivity(intent)


        }


    }
}}
