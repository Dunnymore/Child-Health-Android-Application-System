// Medication.java
package com.example.childhealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Medication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medication);

        TextView recordsTextView = findViewById(R.id.recordsTextView);
        recordsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Records functionality
                startActivity(new Intent(Medication.this, Records.class));
            }
        });

        TextView schedulesTextView = findViewById(R.id.schedulesTextView);
        schedulesTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Schedules functionality
                startActivity(new Intent(Medication.this, VaccinationHome.class));
            }
        });

        TextView centersTextView = findViewById(R.id.centersTextView);
        centersTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Centers functionality
                startActivity(new Intent(Medication.this, Centers.class));
            }
        });
    }
}
