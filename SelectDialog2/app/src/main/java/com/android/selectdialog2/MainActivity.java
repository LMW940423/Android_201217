package com.android.selectdialog2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int mSelect = 0; // 초기값

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.callBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("음식을 선택하세요.")
                        .setIcon(R.mipmap.ic_launcher)
                        .setSingleChoiceItems(R.array.foods, mSelect, // 라디오 박스
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mSelect = which;
                                    }
                                }
                        )
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String[]foods = getResources().getStringArray(R.array.foods);
                                TextView text = findViewById(R.id.textV);
                                text.setText("선택한 음식 : " + foods[mSelect]);
                            }
                        })
                        .setNegativeButton("취소", null)
                        .show();
            }
        });

    }


}//----------