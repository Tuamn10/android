package com.example.bth14;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edta,edtb;
    Button btncong;
    ListView lv1;
    ArrayList<String> list;
    ArrayAdapter<String> myarray;


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

        addControl();
        addEvent();
    }

    private void addEvent() {
        btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Xulycong();
            }

            private void Xulycong() {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                String c = a+" + "+b+" = "+(a+b);
                list.add(c);
                myarray.notifyDataSetChanged();
                edta.setText("");
                edtb.setText("");
            }
        });
    }

    private void addControl() {
        TabHost tab=(TabHost)findViewById(R.id.tabhost);
        tab.setup();
        TabHost.TabSpec tab1=tab.newTabSpec("t1");
        tab1.setContent(R.id.tab1);
        tab1.setIndicator("Phép cộng", ContextCompat.getDrawable(MainActivity.this, R.drawable.outline_add_24));
        tab.addTab(tab1);
        TabHost.TabSpec tab2=tab.newTabSpec("t2");
        tab2.setContent(R.id.tab2);
        tab2.setIndicator("Lịch sử", ContextCompat.getDrawable(MainActivity.this, R.drawable.outline_family_history_24));
        tab.addTab(tab2);
        edta =(EditText) findViewById(R.id.edta);
        edtb =(EditText) findViewById(R.id.edtb);
        btncong = (Button) findViewById(R.id.btn);
        lv1 = (ListView) findViewById(R.id.lv1);
        list =new ArrayList<String>();
        myarray = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                list);
        lv1.setAdapter(myarray);
    }
}