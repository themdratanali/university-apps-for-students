package com.example.vuadmin.faculty;

public class TeachersData {
    private String name, email, number, image, key;

    public TeachersData(){

    }
        public TeachersData(String name, String email, String number, String image, String key) {
            this.name = name;
            this.email = email;
            this.number = number;
            this.image = image;
            this.key = key;
        }

        // Getters
        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getNumber() {
            return number;
        }

        public String getImage() {
            return image;
        }

        public String getKey() {
            return key;
        }

        // Setters
        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }