package com.example.bth73;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity  extends AppCompatActivity {

    EditText edita, editb;
    Button btntong, btnhieu;
    Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        edita = findViewById(R.id.edita);
        editb = findViewById(R.id.editb);
        btntong = findViewById(R.id.btntong);
        btnhieu = findViewById(R.id.btnhieu);
        intent = getIntent();
        int a = intent.getIntExtra("soa",0);
        int b = intent.getIntExtra("sob",0);
        edita.setText(a+"");
        editb.setText(b+"");

        btntong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = a + b;
                // Đẩy kết quả trở lại Intent
                intent.putExtra("kq",sum);
                // Trả intent trở về
                setResult(33,intent);
                //thoát Activity này để quay về
                finish();
            }
        });

        btnhieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sub = a - b;
                intent.putExtra("kq",sub);
                setResult(34, intent);
                finish();
            }
        });

    }
}
