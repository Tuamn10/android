package com.example.bth4;

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

    Button btnCel, btnFah, btnClear;
    EditText editF, editC;

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

        editC = findViewById(R.id.editC);
        editF = findViewById(R.id.editF);
        btnCel = findViewById(R.id.btnCel);
        btnFah = findViewById(R.id.btnFah);
        btnClear = findViewById(R.id.btnClear);

        btnCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf=new DecimalFormat("#.00");
                String doF = editF.getText()+"";
                int F=Integer.parseInt(doF);
                editC.setText(""+dcf.format((F-32)/1.8));
            }
        });

        btnFah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf=new DecimalFormat("#.00");
                String doC = editC.getText()+"";
                int C=Integer.parseInt(doC);
                editF.setText(""+dcf.format(C*1.8+32));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editC.setText("");
                editF.setText("");
            }
        });
    }
}