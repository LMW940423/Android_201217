package com.android.quiz_201217;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int leftNum;
    int rightNum;
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
                        .setMessage("좌변을 선택하십시오.")
                        .setPositiveButton("3", mClick)
                        .setNegativeButton("4", mClick)
                        .setIcon(R.mipmap.ic_launcher)
                        .show();
            }
        });
    }
    DialogInterface.OnClickListener mClick = new DialogInterface.OnClickListener() { // 다이얼로그의 클릭은 다음과 같이 선언한다.
        @Override
        public void onClick(DialogInterface dialog, int which) { //which가 선택된 값을 알고 있다.
            if(which == DialogInterface.BUTTON_POSITIVE){
                leftNum = 3;
            }else{
                leftNum = 4;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("질문2")
                    .setMessage("우변을 선택하십시오.")
                    .setPositiveButton("5", m2Click)
                    .setNegativeButton("6", m2Click)
                    .setIcon(R.mipmap.ic_launcher)
                    .show();

        }
    };

    DialogInterface.OnClickListener m2Click = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                rightNum = 5;
            }else{
                rightNum = 6;
            }
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("질문3")
                    .setMessage("어떤 연산을 하시겠습니까?")
                    .setPositiveButton("덧셈", m3Click)
                    .setNegativeButton("곱셈", m3Click)
                    .setIcon(R.mipmap.ic_launcher)
                    .show();

        }

    };
    DialogInterface.OnClickListener m3Click = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if(which == DialogInterface.BUTTON_POSITIVE){
                resultNum = leftNum + rightNum;
            }else{
                resultNum = leftNum * rightNum;
            }

            TextView text = findViewById(R.id.textV);
            text.setText("연산결과 : " + resultNum);

        }

    };
}