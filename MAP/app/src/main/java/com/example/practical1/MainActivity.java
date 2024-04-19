package com.example.practical1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Activity Lifecycle","Activity Created");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Activity Lifecycle","Activity Created");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Activity Lifecycle","Activity Destroyed");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Activity Lifecycle","Activity is running");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Activity Lifecycle","Activity Paused");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Activity Lifecycle","Activity restarted");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Activity Lifecycle","Activity Stopped");
    }
}