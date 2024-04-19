package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button; // Added import for Button
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView; // Added import for TextView
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] country = { "0.1","0.4","0.6","1"};
    String[] interests={"Machine Learning","General Knowledge","History","Politics"};
    private Button setButton;
    private TextView dateTextView;
    private ListView l;
    String selectedItemsText;
    private CheckBox check;
    private Button submit;
    String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spin = findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, country); // Fixed ArrayAdapter declaration
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        l=findViewById(R.id.list_item);
        Button displaySelectedButton = findViewById(R.id.displaySelectedButton);

        aa=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice,interests);
        l.setAdapter(aa);
        l.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        setButton = findViewById(R.id.setButton);
        dateTextView = findViewById(R.id.dateTextView);

        displaySelectedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> al=new ArrayList<String>();
                for(int i=0;i< interests.length;i++){
                    if(l.isItemChecked(i)){
                        al.add(interests[i]);
                    }
                }
                selectedItemsText = "Selected Items: ";
                for(String item:al){
                    selectedItemsText+=item+" ";
                }
                if (!al.isEmpty()) {
                    selectedItemsText = selectedItemsText.substring(0, selectedItemsText.length() - 2); // Remove the trailing comma and space
                    Toast.makeText(getApplicationContext(), selectedItemsText, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No items selected", Toast.LENGTH_LONG).show();
                }
            }
        });
        EditText nameEditText = findViewById(R.id.editName);
        EditText emailEditText = findViewById(R.id.editEmail);
        EditText editMobile=findViewById(R.id.editMobile);

        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the current date as the default date in the DatePicker
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                                // Handle the selected date
                                String selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                                dateTextView.setText("Selected Date: " + selectedDate);
                            }
                        }, year, month, day);

                // Show the DatePickerDialog
                datePickerDialog.show();
            }
        });

        check=findViewById(R.id.checkBox);
        submit=findViewById(R.id.buttonS);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit.setEnabled(check.isChecked()); //enable the submit button
            }
        });
        RadioGroup rg=findViewById(R.id.radioGroup);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                if(radioButton!=null){
                    gender= radioButton.getText().toString();
                    Toast.makeText(MainActivity.this, "Selected gender: " + gender, Toast.LENGTH_SHORT).show();
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check.isChecked()){
                    String name =nameEditText.getText().toString();
                    String email = emailEditText.getText().toString();
                    String date=dateTextView.getText().toString();
                    String number=editMobile.getText().toString();
                    Spinner spinner = findViewById(R.id.spinner);
                    String selectedCountry = spinner.getSelectedItem().toString();

                    // Create an explicit intent to submit the form data to SubmissionActivity
                    Intent intent = new Intent(MainActivity.this, SubmissionActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("email", email);
                    intent.putExtra("Date of Birth",date);
                    intent.putExtra("Interests",selectedItemsText);
                    intent.putExtra("Mobile",number);
                    intent.putExtra("Gender",gender);
                    intent.putExtra("Country", selectedCountry); // Put the selected country into the intent

                    // Start the SubmissionActivity with the intent
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Handle when nothing is selected in the Spinner
    }

}
