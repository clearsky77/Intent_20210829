package com.example.intent_20210829

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToOtherBtn.setOnClickListener {
//            다른 화면으로 이동하기가 눌리면
//            어느 화면으로 갈 것인지 정보 명시.
            val myIntent = Intent(this, OtherActivity2::class.java) //여기서 액티비티로 가겠다.
            startActivity(myIntent) //이 변수보고 이동하자.

        }
    }
}