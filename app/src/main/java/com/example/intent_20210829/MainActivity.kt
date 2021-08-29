package com.example.intent_20210829

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//            메시지 보내기가 눌리면?
        sendMessageBtn.setOnClickListener {
//            입력한 내용이 어떻게 되는지 변수에 저장
            var inputContent = messageEdt.text.toString()
//            메시지 조회 화면으로 입력 내용을 가지고 이동
            val myIntent = Intent(this, ViewMessageActivity::class.java)
            myIntent.putExtra("inputMessage", inputContent) //짐을 첨부할 때 구분할 이름표를 붙여주자.
            startActivity(myIntent)
        }

        moveToOtherBtn.setOnClickListener {
//            다른 화면으로 이동하기가 눌리면
//            어느 화면으로 갈 것인지 정보 명시.
            val myIntent = Intent(this, OtherActivity2::class.java) // (출발지, 목적지)
            startActivity(myIntent) //이 변수보고 이동하자.


        }
    }
}