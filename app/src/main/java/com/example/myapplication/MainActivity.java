package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.visiting_card);

        //call Assignment 2 Activity
        //Intent intent = new Intent(this,Assignment2.class);

        //call Assignment 4
        //Intent intent = new Intent(this, Assignment4.class);

        //call Stopwatch
        Intent intent = new Intent(this,Stopwatch.class);

        startActivity(intent);

    }
}