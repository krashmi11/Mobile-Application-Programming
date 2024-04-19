package com.example.prac8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUser extends AppCompatActivity {

    private static final String PREFS_NAME ="MyPrefs";
    private static final String KEY_USERNAME="username";
    private static final String KEY_PASSWORD="password";
    private static final String KEY_BLOOD_GROUP="blood_group";
    EditText username;
    EditText password;
    EditText blood_group;
    Button save,retrieve,log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        blood_group=findViewById(R.id.blood_group);
        log=findViewById(R.id.logB);

        SharedPreferences s=getSharedPreferences(PREFS_NAME,MODE_PRIVATE);

        Register();
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterUser.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

    public void saveInfo(){

        String usernameText = username.getText().toString();
        String passwordText = password.getText().toString();
        String bloodGroupText = blood_group.getText().toString();

        if (usernameText.isEmpty() || passwordText.isEmpty() || bloodGroupText.isEmpty()) {
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString(KEY_USERNAME, usernameText);
        editor.putString(KEY_PASSWORD, passwordText);
        editor.putString(KEY_BLOOD_GROUP, bloodGroupText);

        editor.apply();
        String bloodGroupInfo = FileHelper.readFromFile(this);
        bloodGroupInfo += bloodGroupText + "\n" ;
        FileHelper.writeToFile(this, bloodGroupInfo);

        String Userinfo=FileHelper.readFromFile1(this);
        Userinfo+=usernameText+" "+bloodGroupText +"\n";
        FileHelper.writeToFile1(this,Userinfo);

        Toast.makeText(this, "User Information saved Successfully.", Toast.LENGTH_SHORT).show();
    }

    public void RetrieveInfo(){
        SharedPreferences sf=getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String username=sf.getString(KEY_USERNAME,"");
        String password=sf.getString(KEY_PASSWORD,"");
        String blood=sf.getString(KEY_BLOOD_GROUP,"");
        Toast.makeText(this,"Username:"+username+" Password:"+password+" Blood_group:"+blood,Toast.LENGTH_SHORT).show();
    }
    public void Register(){
        save=findViewById(R.id.button);
        retrieve=findViewById(R.id.retrieve);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveInfo();
            }
        });

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrieveInfo();
            }
        });

    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}