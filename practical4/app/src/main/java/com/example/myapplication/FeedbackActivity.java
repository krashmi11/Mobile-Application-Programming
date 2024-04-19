package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        EditText editTextFeedback = findViewById(R.id.editTextFeedback);
        Button buttonSubmitFeedback = findViewById(R.id.buttonSubmitFeedback);

        buttonSubmitFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user's feedback from the EditText
                String userFeedback = editTextFeedback.getText().toString();
                Toast.makeText(getApplicationContext(),"Feedback Submitted Successfully.", Toast.LENGTH_LONG).show();

                finish(); // Close the feedback activity
            }
        });
    }
}
