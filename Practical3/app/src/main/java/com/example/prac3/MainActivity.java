package com.example.prac3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textview;
    private CountDownTimer countDownTimer;
    private Button nextButton;
    private long milliseconds;
    String timeLeft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=findViewById(R.id.timerTextView);
        milliseconds=1*60*1000;
      countDownTimer=new CountDownTimer(milliseconds,1000) {

            @Override
            public void onTick(long l) {
                milliseconds = l; // Update milliseconds
                long minutes = milliseconds / 60000;
                long seconds = (milliseconds % 60000) / 1000;
                timeLeft = String.format("Time: %02d:%02d", minutes, seconds);
                textview.setText(timeLeft);

            }

            @Override
            public void onFinish() {
                textview.setText("Time's up!");
                Intent i=new Intent(MainActivity.this, TimeUp.class);
                startActivity(i);
            }
        }.start();
        nextButton=findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateScore();
            }
        });
    }
    void calculateScore(){
        int Q1=0;
        int Q2=0;
        int Q3=0;
        int count=0;
        RadioButton selectedButton;
        RadioGroup r5;
        r5=findViewById(R.id.radioGroup);
        selectedButton=findViewById(r5.getCheckedRadioButtonId());
        if(selectedButton!=null){
            if(selectedButton.getId()==R.id.radioButton1){
                Q1++;
            }
            count++;
        }
        r5=findViewById(R.id.radioGroup1);
        selectedButton=findViewById(r5.getCheckedRadioButtonId());
        if(selectedButton!=null){
            if(selectedButton.getId()==R.id.Field){
                Q2++;
            }
            count++;
        }
        r5=findViewById(R.id.radioGroup2);
        selectedButton=findViewById(r5.getCheckedRadioButtonId());
        if(selectedButton!=null){
            if(selectedButton.getId()==R.id.Django){
                Q3++;
            }
            count++;
        }
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("scoreQ1", Q1);
        intent.putExtra("scoreQ2", Q2);
        intent.putExtra("scoreQ3", Q3);
        intent.putExtra("count1",count);
        startActivity(intent);
    }
}