package com.example.prac8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // Read blood group data from the file
        String bloodGroupInfo = FileHelper.readFromFile(this);

        // Count blood group occurrences and write counts to a file
        String bloodCount=FileHelper.countAndWriteBloodGroupCounts(this, bloodGroupInfo);

        // Display blood group counts in the TextView
        TextView bloodCountTextView = findViewById(R.id.count);
        bloodCountTextView.setText(bloodCount);
        Button b=findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(UserActivity.this,BloodDonor.class);
                startActivity(i);
            }
        });
    }
}
