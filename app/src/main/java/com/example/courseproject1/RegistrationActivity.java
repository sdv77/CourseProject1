package com.example.courseproject1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private EditText editTextName, editTextUsername, editTextPassword;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        editTextName = findViewById(R.id.editTextName);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonRegister = findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получение введенных данных
                String name = editTextName.getText().toString();
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Сохранение пользователя в базе данных
                User user = new User(name, username, password);
                AppDatabase.getInstance(getApplicationContext()).userDao().insert(user);

                Toast.makeText(RegistrationActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                finish(); // Закрытие активности регистрации
            }
        });
    }
}
