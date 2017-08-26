package com.example.user.a4_activityforresultexam;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                String memo = textView.getText().toString().trim();

                Intent intent = new Intent(this,EditActivity.class);
                intent.putExtra("memo",memo);
                //수정 내용을 되돌려 줄 것을 예약한 화면 이동
                //-->이동할 화면에 대하여 일련번호를 지정한다.
                startActivityForResult(intent,100);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){
            case 100:
                if(resultCode == Activity.RESULT_OK){
                    //전달받은 수정 내용 추출
                    String edit = data.getStringExtra("edit");
                    textView.setText(edit);
                }
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
