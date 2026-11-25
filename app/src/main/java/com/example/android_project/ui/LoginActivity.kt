package com.example.android_project.ui

import android.content.Intent

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android_project.R


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // 화면 요소 연결
        val etLoginId = findViewById<EditText>(R.id.etLoginId)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val cbKeepLogin = findViewById<CheckBox>(R.id.cbKeepLogin)

        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvGoSignup = findViewById<TextView>(R.id.tvGoSignup)

        // 로그인 버튼
        btnLogin.setOnClickListener {

            val loginId = etLoginId.text.toString()
            val password = etPassword.text.toString()
            val keepLogin = cbKeepLogin.isChecked

            if (loginId.isEmpty() || password.isEmpty()) {
                return@setOnClickListener
            }

            // 다음 단계에서 서버 로그인 연결
        }
        // 회원가입 화면 이동
        tvGoSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}