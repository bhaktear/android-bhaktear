package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Assignment4 extends AppCompatActivity {
    private static final int REQUEST_CALL_PERMISSION = 1;
    private TextView textPhone;
    private TextView textEmail;
    private TextView website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment4);

        textEmail = findViewById(R.id.textEmail);
        textPhone = findViewById(R.id.textPhone);
        website = findViewById(R.id.website);

        textPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(Assignment4.this, Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED){
                    String phoneNumber = textPhone.getText().toString();
                    makePhoneCall(phoneNumber);
                }else{
                    ActivityCompat.requestPermissions(Assignment4.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            REQUEST_CALL_PERMISSION);
                }
            }
        });

        textEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddress =   textEmail.getText().toString();
                composeEmail(emailAddress);
            }
        });

        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String webUrl = website.getText().toString();
                openWeb(webUrl);
            }
        });

    }

    private void openWeb(String webUrl) {
        Uri webPage = Uri.parse(webUrl);
        Intent webIntent = new Intent(Intent.ACTION_VIEW,webPage);
        startActivity(webIntent);
    }

    private void composeEmail(String emailAddress) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto" + emailAddress));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello World");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello Android");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    private void makePhoneCall(String phoneNumber) {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        startActivity(callIntent);
    }

    /*
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CALL_PERMISSION){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, make the call
                textPhone = findViewById(R.id.textPhone);
                String phoneNumber = textPhone.getText().toString();
                makePhoneCall(phoneNumber);
            }else{

            }
        }
    }

     */
}