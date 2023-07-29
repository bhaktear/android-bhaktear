package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Assignment3 extends AppCompatActivity {

    private Spinner spinnerOptions;
    private TextView textView;
    private TextView resultView;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assignment_3);

        spinnerOptions = findViewById(R.id.spinnerOptions);
        textView = findViewById(R.id.textView);
        textView.setText(R.string.textView);
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
                String selected = "Selected Division : " + spinnerOptions.getSelectedItem().toString();
                String text = textView.getText().toString();
                Intent intent = new Intent(Assignment3.this,ResultActivity3.class);
                String submittedData = text + "\n" + selected;
                intent.putExtra("data",submittedData);
                startActivity(intent);
            }
        });
    }
}