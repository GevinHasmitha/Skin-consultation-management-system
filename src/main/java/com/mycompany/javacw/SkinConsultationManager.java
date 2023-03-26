package com.mycompany.javacw;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public interface SkinConsultationManager {
    ArrayList<Doctor> addDoctor(String name, String surname, String dob, String mobile, String license, String speciaization);
    LocalDate dateValidater(String dob);
    Doctor deleteDoctor(ArrayList<Doctor> docList, int license);
    ArrayList<Doctor> viewDoctors();
    void sort(ArrayList<Doctor> list);
    void saveToFile() throws IOException;
    void loadDoctors() throws IOException;
    boolean doesDoctorExist(Doctor doctor) ;
  
}
