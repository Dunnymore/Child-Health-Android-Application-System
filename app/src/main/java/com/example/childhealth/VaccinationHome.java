package com.example.childhealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VaccinationHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination_home);

        TextView immunizationKnowledgeTextView = findViewById(R.id.immunizationKnowledgeTextView);
        immunizationKnowledgeTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Immunization Knowledge functionality
                startActivity(new Intent(VaccinationHome.this, ImmunizationKnowledge.class));
            }
        });

        TextView immunizationTimeTableTextView = findViewById(R.id.immunizationTimeTableTextView);
        immunizationTimeTableTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Immunization Time Table functionality
                startActivity(new Intent(VaccinationHome.this, Vaccination.class));
            }
        });

        TextView aboutUsTextView = findViewById(R.id.aboutUsTextView);
        aboutUsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to About Us functionality
                startActivity(new Intent(VaccinationHome.this, Centers.class));
            }
        });
    }
}
