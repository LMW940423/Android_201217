package com.android.question1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int num1 = 3;
    int num2 = 4;
    int resultNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.callBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("질문")
                        .setMessage("어떤 연산을 하시겠습니까?")
                        .setPositiveButton("덧셈", mClick)
                        .setNegativeButton("곱셈", mClick)
                        .setIcon(R.mipmap.ic_launcher)
                        .show();
            }
        });
    }
    DialogInterface.OnClickListener mClick = new DialogInterface.OnClickListener() { // 다이얼로그의 클릭은 다음과 같이 선언한다.
        @Override
        public void onClick(DialogInterface dialog, int which) { //which가 선택된 값을 알고 있다.
            if(which == DialogInterface.BUTTON_POSITIVE){
                resultNum = num1 + num2;
            }else{
                resultNum = num1 * num2;
            }

            TextView text = findViewById(R.id.textV);
            text.setText("연산결과 : " + resultNum);

        }
    };
}