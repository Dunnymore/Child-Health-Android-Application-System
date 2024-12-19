package com.example.childhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

// RegistrationActivity.java
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        databaseHelper = new DatabaseHelper(this);
    }

    public void registerUser(View view) {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (databaseHelper.addUser(username, password)) {
            Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, "Username already exists", Toast.LENGTH_SHORT).show();
        }
    }
}
