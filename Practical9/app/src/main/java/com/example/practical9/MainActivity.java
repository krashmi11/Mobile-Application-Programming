package com.example.practical9;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button register, reset, viewall;
    EditText name, roll, marks;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase("sample", Context.MODE_PRIVATE,null);
        register = findViewById(R.id.submit);
        reset = findViewById(R.id.reset);
        viewall = findViewById(R.id.display);
        name = findViewById(R.id.name);
        roll = findViewById(R.id.rollnum);
        marks = findViewById(R.id.marks);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = openOrCreateDatabase("sample", Context.MODE_PRIVATE,null);
                db.execSQL("create table if not exists student(roll number not null, name varchar not null, marks number not null, constraint pk primary key(roll));");
                if(roll.getText().toString()!=null && name.getText().toString()!=null && marks.getText().toString()!=null)
                {
                    db.execSQL("insert into student values("+Integer.parseInt(roll.getText().toString())+",'"+name.getText().toString()+"',"+Integer.parseInt(marks.getText().toString())+")");
                    Toast.makeText(MainActivity.this, "Student Added", Toast.LENGTH_SHORT).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, MainActivity2.class),1);
            }
        });

        viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, MainActivity3.class),2);
            }
        });
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if(resultCode == 1 && resultCode == RESULT_OK || resultCode == 2 && resultCode == RESULT_OK)
//        {
//            db = openOrCreateDatabase("sample", Context.MODE_PRIVATE,null);
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    @Override
    public void onStop()
    {
        db.close();
        super.onStop();
    }
}