package com.mycompany.javacw;

import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;


public class Consultation {

    private Doctor doctor;
    private Patient patient;
    private Date appointmentDate;
    private SecretKey key;
    private byte[] encryptedData;
    private int cost;
    private String decryptedData;

    public Consultation(Doctor doctor, Patient patient, Date appointmentDate, SecretKey key, byte[] encryptedData, int cost) {

        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.key = key;
        this.encryptedData = encryptedData;
        this.cost = cost;
        
        try {
            Cipher cipher = Cipher.getInstance("AES");
            decryptedData = Encryption.decryptInputString(encryptedData, key, cipher);
            System.out.println(decryptedData);
        } catch (Exception ex) {
        }

    }

    public SecretKey getKey() {
        return key;
    }

    public byte[] getEncryptedData() {
        return encryptedData;
    }

    public int getCost() {
        return cost;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }
    public String getDecryptedData(){
        return decryptedData;
    }
    
}
