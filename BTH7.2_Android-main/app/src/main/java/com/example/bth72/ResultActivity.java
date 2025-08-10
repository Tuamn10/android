package com.example.bth72;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    TextView txtKQ;
    Button btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtKQ = findViewById(R.id.txtKq);
        btnBack = findViewById(R.id.btnBack);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("mypackage");
        int a = bundle.getInt("soa");
        int b = bundle.getInt("sob");
        String kq = "";

        if(a==0 && b==0)
        {
            kq="Vô số nghiệm";
        }
        else if(a==0 && b!=0)
        {
            kq="Vô nghiệm";
        }
        else
        {
            DecimalFormat dcf=new DecimalFormat("0.##");
            kq=dcf.format(-b*1.0/a);
        }
        txtKQ.setText(kq);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
