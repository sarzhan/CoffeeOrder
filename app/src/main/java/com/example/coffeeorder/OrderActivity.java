package com.example.coffeeorder;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {
    TextView tvFullOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        tvFullOrder = findViewById(R.id.textViewOrder);
        Intent intent = getIntent();
        if (intent.hasExtra("fullOrder")) {
            String order = intent.getStringExtra("fullOrder");
            tvFullOrder.setText(order);
        } else {
            Intent intentBack = new Intent(this, MainActivity.class);
            startActivity(intentBack);
        }
    }
}
