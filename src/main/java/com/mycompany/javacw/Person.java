package com.mycompany.javacw;


import java.time.LocalDate;

public class Person {
    protected String name;
    protected String surname;
    protected int mobileNo;
    protected LocalDate dateOfBirth;
    
    public Person(String name, String surname, LocalDate dateOfBirth, int mobileNo){

        this.name = name;       
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNo = mobileNo ;      
    }

    
 

       
}   

    
  
