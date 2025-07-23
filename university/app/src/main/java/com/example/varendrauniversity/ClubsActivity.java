package com.example.varendrauniversity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ClubsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clubs);

        ImageView goBack = findViewById(R.id.back);
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ClubsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        CardView robotic = findViewById(R.id.robotic);
        robotic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClubsActivity.this, ClubRoboticSocietyActivity.class));
            }
        });
        CardView code = findViewById(R.id.code);
        code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClubsActivity.this, ClubProgrammersWorldActivity.class));
            }
        });
        CardView web = findViewById(R.id.web);
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClubsActivity.this, ClubWebDevelopmentActivity.class));
            }
        });
        CardView eeeClub = findViewById(R.id.eClub);
        eeeClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClubsActivity.this, ClubEClubActivity.class));
            }
        });
        CardView businessClubs = findViewById(R.id.businessClubs);
        businessClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClubsActivity.this, ClubBusinessActivity.class));
            }
        });

        CardView languageClub = findViewById(R.id.languageClub);
        languageClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClubsActivity.this, ClubEnglishLanguageActivity.class));
            }
        });

        CardView journalismClubs = findViewById(R.id.journalismClubs);
        journalismClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClubsActivity.this, ClubJournalismActivity.class));
            }
        });

        CardView mootClubs = findViewById(R.id.mootClubs);
        mootClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClubsActivity.this, ClubMootCourtActivity.class));
            }
        });

        CardView pharmacyClubs = findViewById(R.id.pharmacyClubs);
        pharmacyClubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClubsActivity.this, ClubPharmaBeeActivity.class));
            }
        });
    }
}