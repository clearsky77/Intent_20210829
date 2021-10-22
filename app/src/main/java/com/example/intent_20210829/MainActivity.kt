package com.example.intent_20210829

import android.content.Intent
import android.net.Uri
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

        loadText() // 이전에 저장되었던 닉네임을 UI에 표현

//      스토어로 바로가기
        smsBtn.setOnClickListener{
            val myUri = Uri.parse("market://details?id=com.kakao.talk")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

//      웹 사이트로 바로가기
        smsBtn.setOnClickListener{
            val myUri = Uri.parse("https://naver.com")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

//        문자보내기
        smsBtn.setOnClickListener{
            val inputPhoneNum = inputPhomeNum.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            //문자보내기 화면에 표시할 전달해주기
            myIntent.putExtra("sms_body","전달할 내용")
            startActivity(myIntent)
        }

//        전화 걸기 바로 가는 코드
//        문법상 문제가 없어도 앱이 정지된다. 권한 획득해야 정상 동작.
        callBtn.setOnClickListener {
            val inputPhoneNum = inputPhomeNum.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }

//        전화 걸기 (DIAL) Intent 활용 예시.
        dialbtn.setOnClickListener(){
//            전화번호 받아오기
            val inputPhoneNum = inputPhomeNum.text.toString()
//            어디에 걸지 Uri
            val myUri = Uri.parse("tel:${inputPhoneNum}") //코틀린에서 바로바로 받아올 수 있는 ${}문법
//            전화 화면으로 이동
            val myIntent = Intent(Intent.ACTION_DIAL, myUri) //ACTION_DIAL 사용.
            startActivity(myIntent)
        }

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

    //startActivityForResult를 통해서 이동화면에서 -> 메인 화면으로 복귀하면 실행시켜주는 함수.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // 1. requestCode : Int -> 어디를 다녀온 것인지 알려주는 역할.
        // 2. resultCode : Int -> RESULT_OK를 가져 왔는지, 취소값 가져왔는지.
        super.onActivityResult(requestCode, resultCode, data)

        Toast.makeText(this, "결과를 가지고 왔다.", Toast.LENGTH_SHORT).show()

//        Log.d("onActivityResult", requestCode.toString())
//        Log.d("onActivityResult", resultCode.toString())


        if (requestCode == REQ_FOR_NICK_NAME) {
            if (resultCode == RESULT_OK) {
                val newNickname = data?.getStringExtra("newNickname")
                nicknameTxt.text = newNickname
            }
        } else{
            Toast.makeText(this,"입력값 오류 발생", Toast.LENGTH_SHORT).show()
        }

    }

//    ---------------- 이하 메소드 ----------------

    //  저장소에 저장된 텍스트를 UI에 표현
    private fun loadText() {
        val pref = getSharedPreferences("pref", 0 )
        nicknameTxt.setText(pref.getString("SP_nickname","")) // 키 값, 키 값에 데이터가 없을 때 대체 값
    }

}