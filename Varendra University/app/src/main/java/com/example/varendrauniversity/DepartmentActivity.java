package com.example.varendrauniversity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DepartmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        ImageView goBack = findViewById(R.id.back);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DepartmentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        CardView vuDepartmentCSE = findViewById(R.id.vuDepartmentCSE);
        vuDepartmentCSE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DepartmentActivity.this, Depatments_CSEActivity.class));
            }
        });

        CardView vuBBA = findViewById(R.id.vuBBA);
        vuBBA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DepartmentActivity.this, BusinessActivity.class));
            }
        });

        CardView vuEEE = findViewById(R.id.vuEEE);
        vuEEE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DepartmentActivity.this, EEEActivity.class));
            }
        });

        CardView english = findViewById(R.id.english);
        english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DepartmentActivity.this, EnglishActivity.class));
            }
        });
        CardView law = findViewById(R.id.law);
        law.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DepartmentActivity.this, LawActivity.class));
            }
        });
        CardView journalism = findViewById(R.id.journalism);
        journalism.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DepartmentActivity.this, JournalismActivity.class));
            }
        });
        CardView Pharmacy = findViewById(R.id.pharmacy);
        Pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DepartmentActivity.this, PharmacyActivity.class));
            }
        });
        CardView politicalScience = findViewById(R.id.politicalScience);
        politicalScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DepartmentActivity.this, PoliticalScienceActivity.class));
            }
        });
        CardView sociology = findViewById(R.id.sociology);
        sociology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DepartmentActivity.this, SociologyActivity.class));
            }
        });
        CardView publicHealth = findViewById(R.id.publicHealth);
        publicHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DepartmentActivity.this, PublicHealthActivity.class));
            }
        });

        CardView economics = findViewById(R.id.economics);
        economics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DepartmentActivity.this, EconomicsActivity.class));
            }
        });
    }
}