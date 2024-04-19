package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    TextView et;
    EditText username;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraint_layout);
        b1=findViewById(R.id.loginButton);
        et=findViewById(R.id.login);
        username=findViewById(R.id.usernameEditText);
        EditText pass=findViewById(R.id.passwordEditText);
        radioGroup=(RadioGroup) findViewById(R.id.rdGrp1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pwd=pass.getText().toString();
                if(isValid(user,pwd)){
                    et.setText("Login Successful😍");
                    Toast.makeText(MainActivity.this, "Login Successful😍", Toast.LENGTH_SHORT).show();
                }else{
                    et.setText("Invalid Credentials. Try Again.");
                    Toast.makeText(MainActivity.this, "Invalid Credentials. Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        radioGroup.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
//
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//
//            }
//        });
    }
    public boolean isValid(String user,String pass){
        if(user.isEmpty() || pass.isEmpty()){
            return false;
        }else if(user.equals("rashmi") && pass.equals("rash")){
            return true;
        }
        return false;
    }
}