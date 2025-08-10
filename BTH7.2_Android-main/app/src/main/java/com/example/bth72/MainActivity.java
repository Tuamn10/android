package com.example.bth72;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edita, editb;
    Button btnKQ;

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

        edita = findViewById(R.id.edita);
        editb = findViewById(R.id.editb);
        btnKQ = findViewById(R.id.btnKQ);

        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edita.getText().toString().trim());
                int b = Integer.parseInt(editb.getText().toString().trim());
                Bundle bundle = new Bundle();
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                bundle.putInt("soa", a);
                bundle.putInt("sob", b);
                intent.putExtra("mypackage", bundle);
                startActivity(intent);
            }
        });
    }
}