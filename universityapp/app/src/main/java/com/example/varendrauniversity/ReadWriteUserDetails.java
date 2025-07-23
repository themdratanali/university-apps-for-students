package com.example.varendrauniversity;

public class ReadWriteUserDetails {
    public String Name,Dep,Number,StudentId;

    public ReadWriteUserDetails() {

    };

    public ReadWriteUserDetails(String textName, String textDep, String textNumber, String textStudentID){
        this.Name=textName;
        this.StudentId=textStudentID;
        this.Dep=textDep;
        this.Number=textNumber;
    }
}
