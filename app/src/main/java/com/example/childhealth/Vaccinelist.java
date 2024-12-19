package com.example.childhealth;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Vaccinelist extends AppCompatActivity {

    ListView vaccineListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccinelist);

        vaccineListView = findViewById(R.id.vaccineListView);

        // Get the child's date of birth from previous activity
        String dob = getIntent().getStringExtra("dob");

        // Generate list of vaccines and dates based on child's date of birth
        ArrayList<String> vaccines = generateVaccinesList(dob);

        // Display the list in ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vaccines);
        vaccineListView.setAdapter(adapter);
    }

    private ArrayList<String> generateVaccinesList(String dob) {
        ArrayList<String> vaccines = new ArrayList<>();

        // Parse child's date of birth
        Calendar dobCal = Calendar.getInstance();
        try {
            dobCal.setTime(new SimpleDateFormat("MM-dd-yyyy", Locale.getDefault()).parse(dob));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Calculate the child's age in months
        Calendar today = Calendar.getInstance();
        int ageInMonths = calculateAgeInMonths(dobCal, today);

        // Add vaccines and dates based on the child's age in months
        vaccines.add("BCG - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 0));
        vaccines.add("Birth Polio - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 0));
        vaccines.add("Hepatitis B - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 0));

        vaccines.add("DPT\n HepB\n HIB - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 6));
        vaccines.add("OPV - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 6));
        vaccines.add("PCV - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 6));
        vaccines.add("Rotavirus - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 6));


        vaccines.add("FLU - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 6));
        vaccines.add("Vitamin A - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 6));
        vaccines.add("Influenza - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 6));

        vaccines.add("FLU - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" +  formatDate(dobCal, 7));
        vaccines.add("Influenza - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 7));

        vaccines.add("Measles - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 9));
        vaccines.add("Yellow Fever - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 9));

        vaccines.add("Meningitis - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 10));

        vaccines.add("DPT\n HepB\n HIB - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 10));
        vaccines.add("OPV - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 10));
        vaccines.add("PCV - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 10));
        vaccines.add("Rotavirus - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 10));

        vaccines.add("Varicella - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 12));
        vaccines.add("Hepatitis A - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 12));
        vaccines.add("Cholera - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 12));
        vaccines.add("Chicken Pox - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 12));
        vaccines.add("Hepatitis A - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 12));
        vaccines.add("Cholera - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 12));

        vaccines.add("MMR - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 15));

        vaccines.add("Typhoid - \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + formatDate(dobCal, 24));

        return vaccines;
    }

    private int calculateAgeInMonths(Calendar dobCal, Calendar today) {
        int ageInMonths = 0;
        try {
            int yearsDiff = today.get(Calendar.YEAR) - dobCal.get(Calendar.YEAR);
            int monthsDiff = today.get(Calendar.MONTH) - dobCal.get(Calendar.MONTH);
            ageInMonths = yearsDiff * 12 + monthsDiff;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ageInMonths;
    }

    private String formatDate(Calendar dobCal, int monthsToAdd) {
        // Add the number of months to the child's date of birth and format it
        Calendar date = (Calendar) dobCal.clone(); // Clone to avoid modifying original date
        date.add(Calendar.MONTH, monthsToAdd);
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy", Locale.getDefault());
        return sdf.format(date.getTime());
    }
}
