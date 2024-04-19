package com.example.prac8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    EditText username;
    EditText password;
    Button save, retrieve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.logUser);
        password = findViewById(R.id.logPass);
        save = findViewById(R.id.logInbutton);
        SharedPreferences s = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = username.getText().toString();
                String enteredPassword = password.getText().toString();

                if (s.contains(KEY_USERNAME) && s.contains(KEY_PASSWORD)) {
                    String storedUsername = s.getString(KEY_USERNAME, "");
                    String storedPassword = s.getString(KEY_PASSWORD, "");

                    if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword)) {
                        // Username and password match, navigate to UserActivity
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, UserActivity.class);
                        startActivity(i);
                        finish(); // finish this activity
                    } else {
                        Toast.makeText(MainActivity.this, "You have not Register. Register First!!!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, RegisterUser.class);
                        startActivity(i);
                    }
                }
            }

        });

    }
}