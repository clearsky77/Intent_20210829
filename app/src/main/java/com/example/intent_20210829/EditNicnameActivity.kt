package com.example.intent_20210829

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nicname.*

class EditNicnameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nicname)

        okBtn.setOnClickListener {
//            확인 버튼 눌리면?

//            입력 닉네임 변수에 저장
            val inputNickname = nicknameEdt.text.toString()

//            변경된 닉넴을 들고 이전 화면 복귀
            val resultIntent = Intent() //<- 왕복용으로 온 것이라서 출발지, 목적지를 비운다. 그냥 닉네임 첨부하려고 만듦
            resultIntent.putExtra("newNickname", inputNickname)

//            완료(ok)를 누를 수도 있지만 뒤로 버튼을 누를 수도 있기에
//            완료 부른 것이 맞아야 Intent를 세팅한다.
            setResult(RESULT_OK, resultIntent)

//            복귀 처리
            finish()

        }
    }
}