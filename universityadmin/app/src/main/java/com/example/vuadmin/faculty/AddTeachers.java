package com.example.vuadmin.faculty;

import static android.provider.MediaStore.Images.Media.insertImage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vuadmin.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AddTeachers extends AppCompatActivity {

    private ImageView addTeachersImage;
    private EditText addTeachersName;
    private EditText addTeachersEmail;
    private EditText addTeachersNumber;

    private Spinner addTeacherCategory;
    private Button addTeacherBtn;
    private final int REQ = 1;
    private Bitmap bitmap;
    private String category;
    private String name, email, number, downloadUrl = "";
    private ProgressDialog pd;

    private StorageReference storageReference;
    private DatabaseReference reference,dbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teachers);

        addTeachersImage = findViewById(R.id.addTeachersImage);
        addTeachersName  = findViewById(R.id.addTeachersName);
        addTeachersEmail  = findViewById(R.id.addTeachersEmail);
        addTeachersNumber  = findViewById(R.id.addTeachersNumber);
        addTeacherCategory  = findViewById(R.id.addTeacherCategory);
        addTeacherBtn  = findViewById(R.id.addTeacherBtn);

        pd = new ProgressDialog(this);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");
        storageReference = FirebaseStorage.getInstance().getReference();

        String[] items = new String[]{"Select Category", "CSE", "EEE", "BBA", "English", "Economics", "Journalism", "Law and Human Rights", "Pharmacy", "Political Science", "Public Health", "Sociology"};
        addTeacherCategory.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items));

        addTeacherCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = items[position]; // Retrieve the selected item from the array
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle nothing selected if needed
            }
        });

        addTeachersImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        addTeacherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidation();
            }
        });
    }

    private void checkValidation() {
        name = addTeachersName.getText().toString();
        email = addTeachersEmail.getText().toString();
        number = addTeachersNumber.getText().toString();

        if (name.isEmpty()){
            addTeachersName.setError("Empty");
            addTeachersName.requestFocus();
        }else if (email.isEmpty()){
            addTeachersEmail.setError("Empty");
            addTeachersEmail.requestFocus();
        }else if (number.isEmpty()){
            addTeachersNumber.setError("Empty");
            addTeachersNumber.requestFocus();
        }else if (category.equals("Select Category")){
            Toast.makeText(this, "Add Teacher Category ", Toast.LENGTH_SHORT).show();
        }else if (bitmap == null){
            insertData();
        }else {
            insertImage();
        }
    }

    private void insertData() {
        dbRef = reference.child(category);
        final String uniqueKey = dbRef.push().getKey();

        TeachersData teachersData = new TeachersData(name, email, number, downloadUrl, uniqueKey);

        dbRef.child(uniqueKey).setValue(teachersData).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                pd.dismiss();
                Toast.makeText(AddTeachers.this,"Teachers Added",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(AddTeachers.this,"Something went wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void insertImage() {
        pd.setMessage("Uploading.....");
        pd.show();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,50,baos);
        byte[] finalimg = baos.toByteArray();
        final StorageReference filePath;
        filePath = storageReference.child ("Teachers").child(finalimg+"jpg");
        final UploadTask uploadTask = filePath.putBytes(finalimg);

        uploadTask.addOnCompleteListener(AddTeachers.this, new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if (task.isSuccessful()){
                    uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            filePath.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    downloadUrl = String.valueOf(uri);
                                    insertData();

                                }
                            });
                        }
                    });
                } else {
                    pd.dismiss();
                    Toast.makeText(AddTeachers.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void openGallery() {
        Intent pickImage = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickImage,REQ);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ && resultCode == RESULT_OK){
            Uri uri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),uri);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            addTeachersImage.setImageBitmap(bitmap);
        }
    }
}