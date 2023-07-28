package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Assignment2 extends AppCompatActivity {
    private Spinner spinnerOptions;
    private TextView textView;
    private TextView resultView;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_2);

        spinnerOptions = findViewById(R.id.spinnerOptions);
        textView = findViewById(R.id.textView);
        textView.setText(R.string.textView);
        resultView  = findViewById(R.id.resultView);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.options_division,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions.setAdapter(adapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selected = "Selected District : " + spinnerOptions.getSelectedItem().toString();
                String text = textView.getText().toString();
                String finalText = "Selected Result after submission: \n" + text + "\n" + selected;
                resultView.setText(finalText);
            }
        });
    }
}