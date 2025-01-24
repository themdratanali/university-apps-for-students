package com.example.vuadmin.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.vuadmin.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView cseDepartment,eeeDepartment,bbaDepartment,englishDepartment,economics,journalism,law,pharmacyDepartment,politicalScienceDepartment,sociologyDepartment;
    private LinearLayout cseNoData,eeeNoData, bbaNoData,englishNoData,economicsNoData,journalismNoData,lawNoData,pharmacyNoData,politicalNoData,sociologyNoData;
    private List<TeachersData> list1,list2,list3,list4,list5,list6,list7,list8,list9,list10;
    private TeacherAdapter adapter;
    private DatabaseReference reference,dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        cseDepartment = findViewById(R.id.cseDeparment);
        eeeDepartment = findViewById(R.id.eeeDeparment);
        bbaDepartment = findViewById(R.id.bbaDeparment);
        englishDepartment = findViewById(R.id.englishDeparment);
        economics = findViewById(R.id.economics);
        journalism = findViewById(R.id.journalism);
        law = findViewById(R.id.law);
        pharmacyDepartment = findViewById(R.id.pharmacyDeparment);
        politicalScienceDepartment = findViewById(R.id.politicalScienceDeparment);
        sociologyDepartment = findViewById(R.id.sociologyDeparment);

        cseNoData = findViewById(R.id.cseNoData);
        eeeNoData = findViewById(R.id.eeeNoData);
        bbaNoData = findViewById(R.id.bbaNoData);
        englishNoData = findViewById(R.id.englishNoData);
        economicsNoData = findViewById(R.id.economicsNoData);
        journalismNoData = findViewById(R.id.journalismNoData);
        lawNoData = findViewById(R.id.lawNoData);
        pharmacyNoData = findViewById(R.id.pharmacyNoData);
        politicalNoData = findViewById(R.id.politicalNoData);
        sociologyNoData = findViewById(R.id.sociologyNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        cseDepartment();
        eeeDepartment();
        bbaDepartment();
        englishDepartment();
        economics();
        journalism();
        law();
        pharmacyDepartment();
        politicalScienceDepartment();
        sociologyDepartment();

        fab = findViewById(R.id.feb);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFaculty.this, AddTeachers.class));
            }
        });
    }

    private void cseDepartment() {
        dbRef = reference.child("CSE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    cseNoData.setVisibility(View.VISIBLE);
                    cseDepartment.setVisibility(View.GONE);
                } else {
                    cseNoData.setVisibility(View.GONE);
                    cseDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list1.add(data);
                    }
                    cseDepartment.setHasFixedSize(true);
                    cseDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1, UpdateFaculty.this);
                    cseDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void eeeDepartment() {
        dbRef = reference.child("EEE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    eeeNoData.setVisibility(View.VISIBLE);
                    eeeDepartment.setVisibility(View.GONE);
                } else {
                    eeeNoData.setVisibility(View.GONE);
                    eeeDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list2.add(data);
                    }
                    eeeDepartment.setHasFixedSize(true);
                    eeeDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2, UpdateFaculty.this);
                    eeeDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void bbaDepartment() {
        dbRef = reference.child("BBA");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    bbaNoData.setVisibility(View.VISIBLE);
                    bbaDepartment.setVisibility(View.GONE);
                } else {
                    bbaNoData.setVisibility(View.GONE);
                    bbaDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list3.add(data);
                    }
                    bbaDepartment.setHasFixedSize(true);
                    bbaDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3, UpdateFaculty.this);
                    bbaDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void englishDepartment() {
        dbRef = reference.child("English");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    englishNoData.setVisibility(View.VISIBLE);
                    englishDepartment.setVisibility(View.GONE);
                } else {
                    englishNoData.setVisibility(View.GONE);
                    englishDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list4.add(data);
                    }
                    englishDepartment.setHasFixedSize(true);
                    englishDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4, UpdateFaculty.this);
                    englishDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void economics() {
        dbRef = reference.child("Economics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list5 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    economicsNoData.setVisibility(View.VISIBLE);
                    economics.setVisibility(View.GONE);
                } else {
                    economicsNoData.setVisibility(View.GONE);
                    economics.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list5.add(data);
                    }
                    economics.setHasFixedSize(true);
                    economics.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list5, UpdateFaculty.this);
                    economics.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void journalism() {
        dbRef = reference.child("Journalism");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list6 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    journalismNoData.setVisibility(View.VISIBLE);
                    journalism.setVisibility(View.GONE);
                } else {
                    journalismNoData.setVisibility(View.GONE);
                    journalism.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list6.add(data);
                    }
                    journalism.setHasFixedSize(true);
                    journalism.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list6, UpdateFaculty.this);
                    journalism.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void law() {
        dbRef = reference.child("Law and Human Rights");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list7 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    lawNoData.setVisibility(View.VISIBLE);
                    law.setVisibility(View.GONE);
                } else {
                    lawNoData.setVisibility(View.GONE);
                    law.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list7.add(data);
                    }
                    law.setHasFixedSize(true);
                    law.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list7, UpdateFaculty.this);
                    law.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void pharmacyDepartment() {
        dbRef = reference.child("Pharmacy");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list8 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pharmacyNoData.setVisibility(View.VISIBLE);
                    pharmacyDepartment.setVisibility(View.GONE);
                } else {
                    pharmacyNoData.setVisibility(View.GONE);
                    pharmacyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list8.add(data);
                    }
                    pharmacyDepartment.setHasFixedSize(true);
                    pharmacyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list8, UpdateFaculty.this);
                    pharmacyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void politicalScienceDepartment() {
        dbRef = reference.child("Political Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list9 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    pharmacyNoData.setVisibility(View.VISIBLE);
                    pharmacyDepartment.setVisibility(View.GONE);
                } else {
                    pharmacyNoData.setVisibility(View.GONE);
                    pharmacyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list9.add(data);
                    }
                    pharmacyDepartment.setHasFixedSize(true);
                    pharmacyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list9, UpdateFaculty.this);
                    pharmacyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void sociologyDepartment() {
        dbRef = reference.child("Sociology");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list10 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    sociologyNoData.setVisibility(View.VISIBLE);
                    sociologyDepartment.setVisibility(View.GONE);
                } else {
                    sociologyNoData.setVisibility(View.GONE);
                    sociologyDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeachersData data = snapshot.getValue(TeachersData.class);
                        list10.add(data);
                    }
                    sociologyDepartment.setHasFixedSize(true);
                    sociologyDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list10, UpdateFaculty.this);
                    sociologyDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}