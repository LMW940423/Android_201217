package com.android.dialogtest;

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
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("알립니다.");
                builder.setMessage("대화상자를 열었습니다. \n test"); // 문장이 길 때는 String에 넣어서 사용하면 된다.
                builder.setIcon(R.mipmap.mango); // 아이콘은 mipmap에 넣고 사용한다.
                builder.show();
            }
        });
    }
}