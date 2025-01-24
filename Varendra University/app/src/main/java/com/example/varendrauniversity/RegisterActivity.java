package com.example.varendrauniversity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWebException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    private EditText RegisterFullName,RegisterEmail,RegisterStudentId,RegisterDep,RegisterNumber,RegisterPassword,RegisterConfirmPassword;
    private ProgressBar progressBar;
    private static final String TAG= "RegisterActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toast.makeText(RegisterActivity.this, "You can register now", Toast.LENGTH_LONG).show();
        progressBar = findViewById(R.id.progressBar);
        RegisterFullName = findViewById(R.id.register_name);
        RegisterEmail = findViewById(R.id.register_email);
        RegisterStudentId = findViewById(R.id.register_studentId);
        RegisterDep = findViewById(R.id.register_department);
        RegisterNumber = findViewById(R.id.register_phonenumber);
        RegisterPassword = findViewById(R.id.register_password);
        RegisterConfirmPassword = findViewById(R.id.register_confirmpass);

        Button buttonRegister = findViewById(R.id.button_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Obtain the entered data
                String textFullname = RegisterFullName.getText().toString();
                String textEmail = RegisterEmail.getText().toString();
                String textStudentId = RegisterStudentId.getText().toString();
                String textDep = RegisterDep.getText().toString();
                String textNumber = RegisterNumber.getText().toString();
                String textPassword = RegisterPassword.getText().toString();
                String textConfirmPassword = RegisterConfirmPassword.getText().toString();

                // Validate mobile number
                String mobileRegex="01[3456789]{1}[0-9]{8}";
                Matcher mobileMatcher;
                Pattern mobilePattern = Pattern.compile(mobileRegex);
                mobileMatcher = mobilePattern.matcher(textNumber);

                // Validate student id
                String studentIdRegex="22[123456789]{1}[123456789]{1}[0-9]{5}";
                Matcher studentIdMatcher;
                Pattern studentIdPattern = Pattern.compile(studentIdRegex);
                studentIdMatcher = studentIdPattern.matcher(textStudentId);

                if(TextUtils.isEmpty(textFullname)){
                    Toast.makeText(RegisterActivity.this,"Please enter your full name",Toast.LENGTH_LONG).show();
                    RegisterFullName.setError("Full name is required");
                    RegisterFullName.requestFocus();
                }else if(TextUtils.isEmpty(textEmail)){
                    Toast.makeText(RegisterActivity.this,"Please enter your email",Toast.LENGTH_LONG).show();
                    RegisterEmail.setError("Email is required");
                    RegisterEmail.requestFocus();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()){
                    Toast.makeText(RegisterActivity.this,"Please re-enter your email",Toast.LENGTH_LONG).show();
                    RegisterEmail.setError("Valid email is required");
                    RegisterEmail.requestFocus();
                }else if(TextUtils.isEmpty(textStudentId)) {
                    Toast.makeText(RegisterActivity.this, "Please enter your Student Id", Toast.LENGTH_LONG).show();
                    RegisterStudentId.setError("Student Id is required");
                    RegisterStudentId.requestFocus();
                }else if(!studentIdMatcher.find()){
                    Toast.makeText(RegisterActivity.this, "Please re-enter your Student Id", Toast.LENGTH_LONG).show();
                    RegisterStudentId.setError("You Student Id is not valid");
                    RegisterStudentId.requestFocus();
                }else if(TextUtils.isEmpty(textDep)) {
                    Toast.makeText(RegisterActivity.this, "Please enter your Department", Toast.LENGTH_LONG).show();
                    RegisterDep.setError("Department is required");
                    RegisterDep.requestFocus();
                } else if(TextUtils.isEmpty(textNumber)) {
                    Toast.makeText(RegisterActivity.this, "Please enter your Number", Toast.LENGTH_LONG).show();
                    RegisterNumber.setError("Number is required");
                    RegisterNumber.requestFocus();
                }else if(textNumber.length() !=11){
                    Toast.makeText(RegisterActivity.this, "Please re-enter your Number", Toast.LENGTH_LONG).show();
                    RegisterNumber.setError("Number should be 11 digits");
                    RegisterNumber.requestFocus();
                }else if(!mobileMatcher.find()){
                    Toast.makeText(RegisterActivity.this, "Please re-enter your Number", Toast.LENGTH_LONG).show();
                    RegisterNumber.setError("Mobile No. is not valid");
                    RegisterNumber.requestFocus();
                } else if(TextUtils.isEmpty(textPassword)) {
                    Toast.makeText(RegisterActivity.this, "Please the Password", Toast.LENGTH_LONG).show();
                    RegisterPassword.setError("Password is required");
                    RegisterPassword.requestFocus();
                }else if(textPassword.length() < 6){
                    Toast.makeText(RegisterActivity.this, "Please re-enter your Number", Toast.LENGTH_LONG).show();
                    RegisterPassword.setError("Number should be 6 digits");
                    RegisterPassword.requestFocus();
                }else if(TextUtils.isEmpty(textConfirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Please confirm the Password", Toast.LENGTH_LONG).show();
                    RegisterConfirmPassword.setError("Password confirmation is required");
                    RegisterConfirmPassword.requestFocus();
                }else if(!textPassword.equals(textConfirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Please enter same Password", Toast.LENGTH_LONG).show();
                    RegisterConfirmPassword.setError("Enter same is required");
                    RegisterConfirmPassword.requestFocus();
                    //clear the entered password
                    RegisterPassword.clearComposingText();
                    RegisterConfirmPassword.clearComposingText();
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                    registerUser(textFullname,textEmail,textStudentId,textDep,textNumber,textPassword,textConfirmPassword);
                }
            }
        });
        Button buttonCancel = findViewById(R.id.register_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        Button registerCancel = findViewById(R.id.register_cancel);
        registerCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, GetStartedActivity.class);
                startActivity(intent);
            }
        });

        TextView go2 = findViewById(R.id.textview_login);
        go2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
    //Register User using the credentials given
    private void registerUser(String textName, String textEmail, String textStudentID, String textBatch, String textDep, String textNumber, String textPassword) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(textEmail,textPassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_LONG).show();
                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    //enter user data info the firebase realtime database
                    ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(textName,textDep,textNumber,textStudentID);

                    DatabaseReference referenceProfile= FirebaseDatabase.getInstance().getReference("Registered Users");
                    referenceProfile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                // Send verification email
                                firebaseUser.sendEmailVerification();
                                Toast.makeText(RegisterActivity.this, "User registered successfully. Please verify you email", Toast.LENGTH_LONG).show();
                                // Open user profile
                                Intent intent = new Intent(RegisterActivity.this,GetStartedActivity.class);
                                // To prevent user from returning back to register activity on pressing back button
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK
                                        | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivities(new Intent[]{intent});
                                finish(); // to close register activity
                            }else {
                                Toast.makeText(RegisterActivity.this,"User registered Failed. Please try again", Toast.LENGTH_LONG).show();
                            }
                            progressBar.setVisibility(View.GONE);
                        }
                    });

                }else {
                    try {
                        throw task.getException();
                    }catch (FirebaseAuthWebException e){
                        RegisterPassword.setError("You password is too weak.");
                        RegisterPassword.requestFocus();
                    }catch (FirebaseAuthInvalidCredentialsException e){
                        RegisterPassword.setError("Your email is invalid or already in use");
                        RegisterPassword.requestFocus();
                    }catch (FirebaseAuthUserCollisionException e){
                        RegisterEmail.setError("User is already registered with this email");
                        RegisterEmail.requestFocus();
                    }catch (Exception e){
                        Log.e(TAG,e.getMessage());
                        Toast.makeText(RegisterActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                } progressBar.setVisibility(View.GONE);
            }
        });
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(RegisterActivity.this);
        alertDialog.setTitle("Exit App");
        alertDialog.setMessage("Do you want to exit app?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }
}