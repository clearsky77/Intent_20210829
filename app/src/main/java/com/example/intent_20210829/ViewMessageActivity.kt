package com.example.intent_20210829

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_view_message.*

class ViewMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_message)
//        이 화면으로 올 때 전달 받은 데이터를 꺼내서 변수에 저장.
        val receivedMessage = intent.getStringExtra("inputMessage") //나한테 올 때 받은 인텐트에 포함된 짐을 받는다.
//        messageTxt의 속성에 저장해둔 내용을 대입
        messageText.text = receivedMessage

    }
}