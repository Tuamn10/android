package com.example.bth8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

     Button btncallphone, btnsendsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btncallphone = findViewById(R.id.btncallphone);
        btnsendsms = findViewById(R.id.btnsendsms);

        btncallphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tạo mới một đối tượng intent
                Intent intent1 =new Intent(MainActivity.this,CallPhoneActivity.class);
                //Thực thi Intent1
                startActivity(intent1);
            }
        });

        btnsendsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tạo mới một đối tượng intent
                Intent intent2 =new Intent(MainActivity.this,SendSMSActivity.class);
                //Thực thi Intent1
                startActivity(intent2);
            }
        });
    }
}