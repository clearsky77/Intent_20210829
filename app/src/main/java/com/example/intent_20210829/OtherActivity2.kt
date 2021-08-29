package com.example.intent_20210829

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_other2.*

class OtherActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other2)

        returnToMainBtn.setOnClickListener {
//            이전 화면으로 복귀: Intent 사용X, 현재화면 종료처리 finish()
            finish()
        }
    }
}