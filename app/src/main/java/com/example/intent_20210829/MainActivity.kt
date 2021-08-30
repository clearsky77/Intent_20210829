package com.example.intent_20210829

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICK_NAME = 1004 //String이다.
    val REQ_FOR_PHONE_NUM = 1005 //nuber다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editNicknameBtn.setOnClickListener {
//            닉네임 변경 화면으로 이동. 돌아 올 때는 새로는 닉넴을 받아와야함. (왕복)
            val myIntent = Intent(this, EditNicnameActivity::class.java)
//            startActivity()를 쓰지 않는다.
//            데이터(새 닉네임)을 받아오는 왕복을 해야한다.
            startActivityForResult(myIntent, REQ_FOR_NICK_NAME) // <--왕복용
        }


//            메시지 보내기가 눌리면?
        sendMessageBtn.setOnClickListener {
//            입력한 내용이 어떻게 되는지 변수에 저장
            var inputContent = messageEdt.text.toString()
//            메시지 조회 화면으로 입력 내용을 가지고 이동
            val myIntent = Intent(this, ViewMessageActivity::class.java)
            myIntent.putExtra("inputMessage", inputContent) //짐을 첨부할 때 구분할 이름표를 붙여주자.
            myIntent.putExtra("number", 2021) //짐을 첨부할 때 구분할 이름표를 붙여주자.
            startActivity(myIntent)
        }

        moveToOtherBtn.setOnClickListener {
//            다른 화면으로 이동하기가 눌리면
//            어느 화면으로 갈 것인지 정보 명시.
            val myIntent = Intent(this, OtherActivity2::class.java) // (출발지, 목적지)
            startActivity(myIntent) //이 변수보고 이동하자.
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d("onActivityResult", requestCode.toString())
        Log.d("onActivityResult", resultCode.toString())

        if (requestCode == REQ_FOR_NICK_NAME) {
            if (data != null) {
                Log.d("onActivityResult", data.getStringExtra("newNickname").toString())
                nicknameTxt.text = data.getStringExtra("newNickname").toString()
                Toast.makeText(this,"닉네임이 변경되었습니다.", Toast.LENGTH_SHORT).show()
            }
        } else{
            Toast.makeText(this,"입력값 오류 발생", Toast.LENGTH_SHORT).show()
        }
    }
}