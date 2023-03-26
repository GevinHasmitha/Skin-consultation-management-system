package com.mycompany.javacw;

import java.time.LocalDate;


public class Patient extends Person {
    
    private Doctor assignedDoc;
    private int patientId;
    
    public Patient(String name, String surname, LocalDate dateOfBirth, int mobileNo, Doctor assignedDoc, int patientId){
        super(name, surname, dateOfBirth, mobileNo);
        this.assignedDoc = assignedDoc;
        this.patientId = patientId;
    }

    public int getPatientId() {
        return patientId;
    }
   public String getName(){
        return super.name;
    }
    public String getSurname(){
        return super.surname;
    }
    public int getMobileNo(){
        return super.mobileNo;
    }
    public LocalDate getDateOfBirth(){
        return super.dateOfBirth;
    }
}
