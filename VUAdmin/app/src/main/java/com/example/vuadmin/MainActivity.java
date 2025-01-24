package com.example.vuadmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.vuadmin.faculty.UpdateFaculty;
import com.example.vuadmin.notice.DeleteNoticeActivity;
import com.example.vuadmin.notice.UploadNotice;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView addNotie = findViewById(R.id.addNotie);
        addNotie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UploadNotice.class));
            }
        });

        CardView addBook = findViewById(R.id.addBook);
        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UploadBook.class));
            }
        });

        CardView addTeachers = findViewById(R.id.addTeachers);
        addTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UpdateFaculty.class));
            }
        });

        CardView deleteNotice = findViewById(R.id.deleteNotice);
        deleteNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DeleteNoticeActivity.class));
            }
        });
    }
}