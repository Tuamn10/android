package com.example.bth13;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    TextView selection;
    AutoCompleteTextView editauto;
    MultiAutoCompleteTextView multiAutoCompleteTextView1;
    String arr[] = {"Hà Nội", "Huế", "Sài Gòn", "Hà Giang", "Hội An", "Kiên Giang", "Lâm Đồng"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selection = findViewById(R.id.selection);
        editauto = findViewById(R.id.editauto);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        editauto.setAdapter(myAdapter);

        multiAutoCompleteTextView1 = findViewById(R.id.multiAutoCompleteTextView1);
        multiAutoCompleteTextView1.setAdapter(myAdapter);
        multiAutoCompleteTextView1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        editauto.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                selection.setText(editauto.getText());
            }
        });

    }
}