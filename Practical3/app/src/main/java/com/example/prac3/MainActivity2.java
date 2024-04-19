package com.example.prac3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Button submit,prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        submit=findViewById(R.id.button2);
        prev=findViewById(R.id.prev);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateScore();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity2.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    void calculateScore() {
        int Q4 = 0;
        int Q5 = 0;
        int count=0;
        RadioButton selectedButton;
        RadioGroup r5;
        r5 = findViewById(R.id.radioGroup4);
        selectedButton = findViewById(r5.getCheckedRadioButtonId());
        if (selectedButton != null) {
            if (selectedButton.getId() == R.id.Java) {
                Q4++;
            }
            count++;
        }
        r5 = findViewById(R.id.radioGroup5);
        selectedButton = findViewById(r5.getCheckedRadioButtonId());
        if (selectedButton != null) {
            if (selectedButton.getId() == R.id.Git) {
                Q5++;
            }
            count++;
        }
        int scoreQ1 = getIntent().getIntExtra("scoreQ1", 0);
        int scoreQ2 = getIntent().getIntExtra("scoreQ2", 0);
        int scoreQ3 = getIntent().getIntExtra("scoreQ3", 0);

        int count1=getIntent().getIntExtra("count1",0);
        int totalScore = scoreQ1 + scoreQ2 + scoreQ3 + Q4 + Q5;
        int totalAttempted=count+count1;
        double total=5.0;
        double percentage=(totalScore/(total))*100;
        Intent intent = new Intent(MainActivity2.this, ResultActivity.class);
        intent.putExtra("totalAttempted", totalAttempted);
        intent.putExtra("percentage", percentage);
        startActivity(intent);

    }
}