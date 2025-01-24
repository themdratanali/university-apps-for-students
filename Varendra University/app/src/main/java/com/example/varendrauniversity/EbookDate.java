package com.example.varendrauniversity;

public class EbookDate {
    private String name,pdfUrl;

    public EbookDate(){

    }

    public EbookDate(String name, String pdfUrl){
        this.name = name;
        this.pdfUrl = pdfUrl;

    }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPdfUrl() {
            return pdfUrl;
        }

        public void setPdfUrl(String pdfUrl) {
            this.pdfUrl = pdfUrl;
        }
}
