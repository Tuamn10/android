package com.example.bth122;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private ArrayList<String> arraywork;
    private ArrayAdapter<String> arrAdapter;
    private EditText edtwork, edth, edtm;
    private TextView txtdate;
    private Button btnwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edth = findViewById(R.id.hourInput);
        edtm = findViewById(R.id.minuteInput);
        edtwork = findViewById(R.id.workInput);
        btnwork = findViewById(R.id.addButton);
        lv = findViewById(R.id.workList);
        txtdate = findViewById(R.id.dateText);

        arraywork = new ArrayList<>();
        arrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraywork);
        lv.setAdapter(arrAdapter);

        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText("Hôm Nay: " + simpleDateFormat.format(currentDate));

        btnwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtwork.getText().toString().trim().isEmpty() ||
                        edth.getText().toString().trim().isEmpty() ||
                        edtm.getText().toString().trim().isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Info missing");
                    builder.setMessage("Please enter all information of the work");
                    builder.setPositiveButton("Continue", (dialog, which) -> {
                    });
                    builder.show();
                } else {
                    String hour = edth.getText().toString().trim();
                    String minute = edtm.getText().toString().trim();
                    if (minute.length() == 1) {
                        minute = "0" + minute;
                    }
                    String str = "+ " + edtwork.getText().toString().trim() + " - " + hour + ":" + minute;
                    arraywork.add(str);
                    arrAdapter.notifyDataSetChanged();
                    edth.setText("");
                    edtm.setText("");
                    edtwork.setText("");
                }
            }
        });
    }
}
