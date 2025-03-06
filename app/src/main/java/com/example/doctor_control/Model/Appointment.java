package com.example.doctor_control.Model;

public class Appointment {
    private String patientName;
    private String problem;

    public Appointment(String patientName, String problem) {
        this.patientName = patientName;
        this.problem = problem;
    }

    // Getters and setters
    public String getPatientName() { return patientName; }
    public String getProblem() { return problem; }
}