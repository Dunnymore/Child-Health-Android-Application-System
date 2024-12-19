package com.example.childhealth;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Vaccination extends AppCompatActivity {

    EditText childNameEditText, dobEditText;
    RadioGroup genderRadioGroup;
    RadioButton selectedGenderRadioButton;
    Button submitButton;
    RelativeLayout babyDetailsLayout;
    RelativeLayout.LayoutParams layoutParams;

    TextView textViewDateTime;

    Calendar calendar;
    DatePickerDialog.OnDateSetListener date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccination);

        childNameEditText = findViewById(R.id.child_name_edit_text);
        dobEditText = findViewById(R.id.dob_edit_text);
        genderRadioGroup = findViewById(R.id.gender_radio_group);
        submitButton = findViewById(R.id.submit_button);
        babyDetailsLayout = findViewById(R.id.baby_details_layout);

        textViewDateTime = findViewById(R.id.textViewDateTime);

        layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.addRule(RelativeLayout.BELOW, R.id.submit_button);

        calendar = Calendar.getInstance();

        dobEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Vaccination.this, date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });

        // Set OnClickListener for textViewDateTime
        textViewDateTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVaccineListActivity();
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        dobEditText.setText(sdf.format(calendar.getTime()));
    }

    private void submitForm() {
        String childName = childNameEditText.getText().toString();
        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        selectedGenderRadioButton = findViewById(selectedGenderId);
        String gender = selectedGenderRadioButton.getText().toString();
        String dob = dobEditText.getText().toString();

        // Display child details
        String childDetails ="\t\t\t\t\t\t\t\t\t\t\tCHILD VACCINATIONS\t\t\t\t\t\t\t" + "\n\nChild Name: " + childName + "\nDate of Birth: " + dob;
        textViewDateTime.setText(childDetails);
    }

    private void openVaccineListActivity() {
        Intent intent = new Intent(this, Vaccinelist.class);
        startActivity(intent);
    }
}
