package com.example.bth6;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editHoTen, editCMND, editBosung;
    CheckBox chkdocbao, chkdocsach, chkdoccoding;
    RadioGroup radGrp;
    Button btnguitt;

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

        editHoTen = findViewById(R.id.editHoTen);
        editCMND = findViewById(R.id.editCMND);
        editBosung = findViewById(R.id.editBosung);
        chkdocbao = findViewById(R.id.chkdocbao);
        chkdoccoding = findViewById(R.id.chkdoccoding);
        chkdocsach = findViewById(R.id.chkdocsach);
        btnguitt = findViewById(R.id.btnguitt);
        radGrp = findViewById(R.id.radgrp);
        radGrp.check(R.id.raddh);
        btnguitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfo();
            }
        });
    }

    public void showInfo() {
        String ten = editHoTen.getText().toString().trim();
        if(ten.length()<3)
        {
            editHoTen.requestFocus();
            editHoTen.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        String cmnd = editCMND.getText().toString().trim();
        if(cmnd.length() != 9)
        {
            editCMND.requestFocus();
            editCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        String bang = "";
        int id = radGrp.getCheckedRadioButtonId();
        RadioButton rad = findViewById(id);
        bang = rad.getText().toString();

        String sothich="";
        if(chkdocbao.isChecked())
            sothich+=chkdocbao.getText()+"\n";
        else if(chkdocsach.isChecked())
            sothich+=chkdocsach.getText()+"\n";
        else if(chkdoccoding.isChecked())
            sothich+=chkdoccoding.getText()+"\n";
        else {
            Toast.makeText(this, "Chọn ít nhất 1 sở thích", Toast.LENGTH_LONG).show();
            return;
        }

        String bosung=editBosung.getText()+"";

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.cancel();
                    }
                });
        //tạo nội dung
        String msg=ten+"\n";
        msg+= cmnd+"\n";
        msg+=bang+"\n";
        msg+=sothich;
        msg+="—————————–\n";
        msg+="Thông tin bổ sung:\n";
        msg+=bosung+ "\n";
        msg+="—————————–";
        builder.setMessage(msg);//thiết lập nội dung
        builder.create().show();//hiển thị Dialog

        // Khởi tạo OnBackPressedDispatcher
        OnBackPressedDispatcher dispatcher = getOnBackPressedDispatcher();

        // Tạo callback cho sự kiện back
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Question");
                b.setMessage("Are you sure you want to exit?");
                b.setIcon(android.R.drawable.ic_dialog_info); // Sử dụng ic_dialog_info thay vì inform
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                b.show();
            }
        };

        // Đăng ký callback với dispatcher
        dispatcher.addCallback(this, callback);
    }
}