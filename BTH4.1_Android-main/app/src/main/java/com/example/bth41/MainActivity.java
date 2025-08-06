package com.example.bth41;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editName, editHeight, editWeight, editBmi, editDia;
    Button btnCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editName=findViewById(R.id.editName);
        editHeight= findViewById(R.id.editHeight);
        editWeight= findViewById(R.id.editWeight);
        editBmi= findViewById(R.id.editBmi);
        editDia= findViewById(R.id.editDia);
        btnCal = findViewById(R.id.btnCal);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double H=Double.parseDouble(editHeight.getText()+"");
                double W=Double.parseDouble(editWeight.getText()+"");
                double BMI=W/Math.pow(H,2);
                String chandoan="";

                if(BMI<18)
                    chandoan="gầy";
                else if(BMI<=24.9)
                    chandoan="bình thường";
                else if(BMI<=29.9)
                    chandoan="béo phì độ 1";
                else if(BMI<=34.9)
                    chandoan="béo phì độ 2";
                else
                    chandoan="béo phì độ 3";

                DecimalFormat dcf=new DecimalFormat("#.0");
                editBmi.setText(dcf.format(BMI));
                editDia.setText("Bệnh nhân " + editName.getText().toString() + " " + chandoan);
            }
        });
    }
}