package com.example.coffeeorder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView userName;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.editTextUserName);
        password = findViewById(R.id.editTextPassword);
    }

    public void coffeeOrder(View view) {

        String name = userName.getText().toString().trim();
        String pass = password.getText().toString().trim();


        if (!name.isEmpty() && !pass.isEmpty()) {
            Intent intent = new Intent(this, ChooseActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("pass", pass);
            startActivity(intent);
        } else {
            Toast.makeText(this,R.string.warning,Toast.LENGTH_SHORT).show();
        }
    }
}
