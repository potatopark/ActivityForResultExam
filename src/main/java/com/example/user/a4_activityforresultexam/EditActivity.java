package com.example.user.a4_activityforresultexam;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity implements
        View.OnClickListener{

    String memo;//넘겨받은 값 저장
    EditText editText;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editText = (EditText) findViewById(R.id.editText);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        //넘어온 값 추출
        Intent fromIntent = getIntent();
        memo = fromIntent.getStringExtra("memo");
        //컴포넌트에 넘어온 값 설정
        editText.setText(memo);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                String edit = editText.getText().toString().trim();

                //수정내용을 전달하기 위한 빈 인텐트
                Intent intent = new Intent();
                intent.putExtra("edit",edit);

                //성공되었다는 결과와 함께 수정된 내용을 설정함
                setResult(Activity.RESULT_OK,intent);
                //현재 화면 종료
                finish();
                break;

            case R.id.button2://취소버튼 ---> 작업이 취소되었음을 알려준다.
                setResult(Activity.RESULT_CANCELED);
                //현재 화면 종료
                finish();
                break;
        }
    }
}
