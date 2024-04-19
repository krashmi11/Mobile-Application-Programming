package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SubmissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        // Retrieve data from the Intent
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String dateOfBirth = getIntent().getStringExtra("Date of Birth");
        String interests = getIntent().getStringExtra("Interests");
        String mobile = getIntent().getStringExtra("Mobile");
        String gender = getIntent().getStringExtra("Gender");
        String country = getIntent().getStringExtra("Country");

        // Set the data to the TextViews in the layout
        TextView nameTextView = findViewById(R.id.Name);
        nameTextView.setText("Name: " + name);

        TextView emailTextView = findViewById(R.id.Email);
        emailTextView.setText("Email: " + email);

        TextView dobTextView = findViewById(R.id.DateOfBirth);
        dobTextView.setText("Date of Birth: " + dateOfBirth);

        TextView interestsTextView = findViewById(R.id.Interests);
        interestsTextView.setText("Interests: " + interests);

        TextView mobileTextView = findViewById(R.id.Mobile);
        mobileTextView.setText("Mobile: " + mobile);

        TextView genderTextView = findViewById(R.id.Gender);
        genderTextView.setText("Gender: " + gender);

        TextView countryTextView = findViewById(R.id.Country);
        countryTextView.setText("Country: " + country);

        // Add onClickListeners for the action buttons
        TextView callHelpline = findViewById(R.id.CallHelpline);
        TextView submitFeedback = findViewById(R.id.SubmitFeedback);
        TextView reachLocation = findViewById(R.id.ReachLocation);
        TextView writeToUs = findViewById(R.id.WriteToUs);
        TextView downloadApp = findViewById(R.id.DownloadApp);

        // Set onClickListeners for each action
        callHelpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implicit intent to dial a helpline number
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:+917020709427")); // Replace with the actual helpline number
                startActivity(dialIntent);
            }
        });

        submitFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implicit intent to open a feedback form or activity
                // Replace FeedbackActivity.class with your actual feedback activity
                Intent feedbackIntent = new Intent(SubmissionActivity.this, FeedbackActivity.class);
                startActivity(feedbackIntent);
            }
        });

        reachLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double latitude = 21.1766;
                double longitude = -79.06166;
                // Implicit intent to open a map for the location
                Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude + "?q=" + latitude + "," + longitude);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        writeToUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implicit intent to open an email app for writing to the specified email address
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "kanharkarrm@rknec.edu", null)); // Replace with your actual email address
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Query/Feedback");
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        downloadApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implicit intent to open the Play Store for app download
                Intent playStoreIntent = new Intent(Intent.ACTION_VIEW);
                playStoreIntent.setData(Uri.parse("market://details?id=com.example.yourapp")); // Replace with your app's package name
                startActivity(playStoreIntent);
            }
        });
    }
}
