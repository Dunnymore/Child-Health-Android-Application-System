package com.example.childhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Set click listener for vaccination button
        Button vaccinationButton = findViewById(R.id.addVaccinationReminderButton);
        vaccinationButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, Vaccination.class);
            startActivity(intent);
        });

        // Set click listener for doctor appointment button
        Button doctorAppointmentButton = findViewById(R.id.addDoctorAppointmentButton);
        doctorAppointmentButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, DoctorsAppointment.class);
            startActivity(intent);
        });

        // Set click listener for medication reminder button
        Button medicationReminderButton = findViewById(R.id.addMedicationReminderButton);
        medicationReminderButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, Medication.class);
            startActivity(intent);
        });

        // Set click listener for reminder setup button
        Button reminderSetupButton = findViewById(R.id.buttonPickDateTime);
        reminderSetupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open a date picker dialog
                Calendar currentDate = Calendar.getInstance();
                int year = currentDate.get(Calendar.YEAR);
                int month = currentDate.get(Calendar.MONTH);
                int dayOfMonth = currentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(HomeActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // Open a time picker dialog
                                Calendar currentTime = Calendar.getInstance();
                                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                                int minute = currentTime.get(Calendar.MINUTE);

                                TimePickerDialog timePickerDialog = new TimePickerDialog(HomeActivity.this,
                                        new TimePickerDialog.OnTimeSetListener() {
                                            @Override
                                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                                // Set the selected date and time in the calendar
                                                Calendar calendar = Calendar.getInstance();
                                                calendar.set(Calendar.YEAR, year);
                                                calendar.set(Calendar.MONTH, month);
                                                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                                calendar.set(Calendar.MINUTE, minute);

                                                // Update TextView with selected date and time
                                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault());
                                                TextView textViewDateTime = findViewById(R.id.textViewDateTime);
                                                textViewDateTime.setText("Reminder set for: " + sdf.format(calendar.getTime()));

                                                // Schedule the reminder
                                                scheduleReminder(calendar);
                                            }
                                        }, hour, minute, true);
                                timePickerDialog.show();
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });
    }

    private void scheduleReminder(Calendar calendar) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, ReminderReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Set the alarm to trigger at the specified time
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        Toast.makeText(this, "Reminder set successfully", Toast.LENGTH_SHORT).show();
    }

    public static class ReminderReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            showNotification(context, "Reminder", "PLEASE TAKE YOUR CHILD FOR VACCINATION!");
        }

        private void showNotification(Context context, String title, String message) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            String channelId = "reminder_channel";
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(channelId, "Reminder Channel", NotificationManager.IMPORTANCE_DEFAULT);
                notificationManager.createNotificationChannel(channel);
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, channelId)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
                    .setAutoCancel(true);
            notificationManager.notify(123, builder.build());
        }
    }
}
