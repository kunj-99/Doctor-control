package com.example.doctor_control.Model;

public class Certification {
    private String name;
    private String filePath;

    public Certification(String name, String filePath) {
        this.name = name;
        this.filePath = filePath;
    }

    public String getName() {
        return name;
    }

    public String getFilePath() {
        return filePath;
    }
}