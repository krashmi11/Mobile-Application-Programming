package com.example.prac8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BloodDonor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_donor);
        TextView t=findViewById(R.id.usernames);
        String userdata=FileHelper.readFromFile1(this);
        t.setText(userdata);
    }
}