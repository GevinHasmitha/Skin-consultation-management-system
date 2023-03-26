package com.mycompany.javacw;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends Person{
    
    private int licenseNo;
    private String specialization;
    ArrayList<Date> dateTimeList = new ArrayList<>();  //This list stores all dates where doctor is available
    
    public Doctor(String name, String surname, LocalDate dateOfBirth, int mobileNo, int licenseNo, String specialization){
        super(name, surname,dateOfBirth, mobileNo);
        this.licenseNo = licenseNo;
        this.specialization = specialization;
                
    }
    public String getName(){
        return super.name;
    }
    public String getSurname(){
        return super.surname;
    }
    public LocalDate getDateOfBirth(){
        return super.dateOfBirth;
    }
       public int getMobileNo(){
        return super.mobileNo;
    }
        public int getlicenseNo(){
        return this.licenseNo;
    }
    public String getSpecialization(){
        return this.specialization;
    }
    
    public void printall(){
        System.out.println("--------------");
        System.out.println("First name: " + super.name);
        System.out.println("Surname: " + super.surname);
//        System.out.println("Date of Birth: " + super.dateOfBirth);
        System.out.println("Mobile nuber: " + super.mobileNo);
        System.out.println("Medical license number: " + this.licenseNo);
        System.out.println("Specialization: " + this.specialization);
        System.out.println("--------------");

    }
    

}
