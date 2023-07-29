package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity3 extends AppCompatActivity {
    private TextView resultView;
    private String data = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_assign_3);

        resultView = findViewById(R.id.resultView);
        Intent intent = getIntent();
        if(intent != null){
            data = intent.getStringExtra("data");
        }
        resultView.setText("Selected Result: \n " + data);

    }
}