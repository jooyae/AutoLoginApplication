package com.example.progressautologin

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var pref : SharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE)
        var editor :SharedPreferences.Editor = pref.edit()

        editText.setText(intent.getStringExtra("id")?.toString())
        editText2.setText(intent.getStringExtra("password")?.toString())

        autoLogin()

        textView.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener{
            if(editText.text.isNullOrBlank() || editText2.text.isNullOrBlank()){
                Toast.makeText(this, "아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()

            }else{
                editor.putString("id", editText.text.toString())
                editor.putString("pw", editText2.text.toString())
                editor.commit()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }
    fun autoLogin(){
        var pref : SharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE)
        if(!(pref.getString("id", null).isNullOrBlank()|| pref.getString("pw",null ).isNullOrBlank())){
            val id = pref.getString("id",null).toString()

            if(!id.isNullOrBlank()){
                Toast.makeText(this, "자동로그인", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

}
