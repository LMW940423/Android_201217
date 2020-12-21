package com.android.selectdialog4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.callBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LinearLayout linear = (LinearLayout) View.inflate(MainActivity.this, R.layout.order, null); //권장사항 final
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("주문 정보를 입력하세요.")
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setView(linear)
                        .setCancelable(false)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText prdName = linear.findViewById(R.id.product); // 해당 xml에서 가져온다는 걸 명시해야 오류가 안난다.
                                EditText prdQty = linear.findViewById(R.id.number);
                                CheckBox payMethod = linear.findViewById(R.id.payMethod);
                                TextView text = findViewById(R.id.textV);

                                text.setText("주문제품 : " + prdName.getText() + " 주문수량 : " + prdQty.getText() + "개 " +
                                                (payMethod.isChecked() ? "착불결제O" : "착불결제X"));

                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                TextView text = findViewById(R.id.textV);
                                text.setText("주문을 취소했습니다.");
                            }
                        })
                        .show();


            }
        });


    }


}//-------------