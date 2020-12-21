package com.android.selectdialog1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.callBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("음식을 선택하세요.")
                        .setItems(R.array.foods,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        String[] foods = getResources().getStringArray(R.array.foods);
                                        TextView text = findViewById(R.id.textV);
                                        text.setText("선택한 음식은 : " + foods[which]); // which를 통해 선택한 값을 알아내는 법!
                                    }
                                }
                        )
                        .setNegativeButton("취소", null)
                        .setIcon(R.mipmap.ic_launcher)
                        .show();
            }
        });
    }


}//--------------