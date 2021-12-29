package com.example.testapp;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn_TouchScreen = findViewById(R.id.btn_TouchScreen);
        btn_TouchScreen.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), TouchScreenTest.class);
            startActivity(intent);
        });

        Button btn_Info = findViewById(R.id.btn_Information);
        btn_Info.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), InformationActivity.class);
            startActivity(intent);
        });

    }
}