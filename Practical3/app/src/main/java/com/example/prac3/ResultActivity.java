package com.example.prac3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        double totalScore = getIntent().getDoubleExtra("percentage", 0.0);
        int attempted=getIntent().getIntExtra("totalAttempted", 0);
        TextView scoreTextView = findViewById(R.id.scoreTextView);
        TextView attemptedtextview=findViewById(R.id.attempted);
        scoreTextView.setText("Total Score: " + totalScore);
        attemptedtextview.setText("Total Questions Attempted:"+attempted);
        Log.d("ResultActivity", "totalScore: " + totalScore);
        Log.d("ResultActivity", "attempted: " + attempted);
        TextView res = findViewById(R.id.res);

        if(totalScore>=35){
            res.setText("Result:Pass");
        }else{
            res.setText("Result:Fail");
        }
    }
}