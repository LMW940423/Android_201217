package com.android.dialogbutton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.callBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("알립니다.")
                        .setMessage("대화 상자를 열었습니다.")
                        .setIcon(R.mipmap.ic_launcher)
                        .setCancelable(false) // 닫기버튼을 눌러야만 꺼진다.
                        .setNeutralButton("닫기", null)
                        .show();
            }
        });
    }
}