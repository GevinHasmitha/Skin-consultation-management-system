/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.javacw;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Gevin-pc
 */
public class WestminsterSkinConsultationManagerTest {
    
    public WestminsterSkinConsultationManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddDoctor() {
        WestminsterSkinConsultationManager instance = new WestminsterSkinConsultationManager();
        System.out.println("addDoctor");
        String name = "Gevin";
        String surname = "Karunarathne";
        String dob = "2003-12-26";
        String mobile = "0777881248";
        String license = "100";
        String speciaization = "Dentistry";
        ArrayList<Doctor> result = instance.addDoctor(name, surname, dob, mobile, license, speciaization);
        ArrayList<Doctor> result2 = instance.addDoctor(name, surname, dob, "blah", license, speciaization);
        
       assertEquals(name, result.get(0).getName());
       assertEquals(surname, result.get(0).getSurname());
       assertEquals(LocalDate.of(2003, 12, 26), result.get(0).getDateOfBirth());
       assertEquals(777881248, result.get(0).getMobileNo());
       assertEquals(100, result.get(0).getlicenseNo());
       assertEquals(speciaization, result.get(0).getSpecialization());
       
       //If invalid input, the arraylist should not be added the object
       assertNull(result2);
       

    }

    /**
     * Test of dateValidater method, of class WestminsterSkinConsultationManager.
     */
    @Test
    public void testDateValidater() {
        System.out.println("dateValidater");
        String dob = "2005-12-23";
        WestminsterSkinConsultationManager instance = new WestminsterSkinConsultationManager();
        LocalDate expResult = LocalDate.of(2005, 12, 23);
        LocalDate result = instance.dateValidater(dob);
        
        //Checks whether method converts String date to local date format
        assertEquals(expResult, result);
        
        //Checks whether null is returned if input string is in wrong format
        assertNull(instance.dateValidater("12345678"));
        assertNull(instance.dateValidater("2003-43-12"));
        assertNull(instance.dateValidater("2003/23/12"));
    }

    /**
     * Test of deleteDoctor method, of class WestminsterSkinConsultationManager.
     */
    @Test
    public void testDeleteDoctor() {
        System.out.println("deleteDoctor");
        ArrayList<Doctor> docList = new ArrayList<>();
        docList.add(new Doctor("Jason","Derulo",LocalDate.of(2011, 1, 4),777881458,102,"dentistry"));
        int license = 102;
        WestminsterSkinConsultationManager instance = new WestminsterSkinConsultationManager();
        Doctor d1 = docList.get(0);

        //Tests whether specific doctor is deleted
        Doctor result = instance.deleteDoctor(docList, license);
        assertEquals(d1, result);
        
        //tests whether the doctor was actually deleted
        assertNull(instance.deleteDoctor(docList, license));

    }

//    /**
//     * Test of viewDoctors method, of class WestminsterSkinConsultationManager.
//     */
//    @Test
//    public void testViewDoctors() {
//        System.out.println("viewDoctors");
//        WestminsterSkinConsultationManager instance = new WestminsterSkinConsultationManager();
//        ArrayList<Doctor> expResult = null;
//        ArrayList<Doctor> result = instance.viewDoctors();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of sort method, of class WestminsterSkinConsultationManager.
     */
    @Test
    public void testSort() {
        System.out.println("sort");
        WestminsterSkinConsultationManager instance = new WestminsterSkinConsultationManager();
        
        ArrayList<Doctor> list = new ArrayList<>();
         list.add(new Doctor("Jason","Derulo",LocalDate.of(2005, 1, 4),777881458,102,"dentistry"));
         list.add(new Doctor("Bill","Asarp",LocalDate.of(2001, 7, 4),777881458,103,"dentistry"));
         list.add(new Doctor("Clinton","Willy",LocalDate.of(2004, 8, 4),777881458,104,"dentistry"));
        
        ArrayList<Doctor> sortedList = new ArrayList<>();
        sortedList.add(new Doctor("Bill","Asarp",LocalDate.of(2001, 7, 4),777881458,103,"dentistry"));
        sortedList.add(new Doctor("Jason","Derulo",LocalDate.of(2005, 1, 4),777881458,102,"dentistry"));
        sortedList.add(new Doctor("Clinton","Willy",LocalDate.of(2004, 8, 4),777881458,104,"dentistry"));
       
        instance.sort(list);
        
        
        //Checks whether the array list is sorted by surname
        for(int i=0; i <3; i++){
            assertEquals(sortedList.get(i).getSurname(), list.get(i).getSurname());
        }

    }

    /**
     * Test of getDoctorsList method, of class WestminsterSkinConsultationManager.
     */
    @Test
    public void testGetDoctorsList() {
        System.out.println("getDoctorsList");
        ArrayList<Doctor> expResult = new ArrayList<Doctor>();
        ArrayList<Doctor> result = WestminsterSkinConsultationManager.getDoctorsList();
        assertEquals(expResult, result);

    }

//    /**
//     * Test of viewDoctors method, of class WestminsterSkinConsultationManager.
//     */
//    @Test
//    public void testViewDoctors() {
//        System.out.println("viewDoctors");
//        WestminsterSkinConsultationManager instance = new WestminsterSkinConsultationManager();
//        ArrayList<Doctor> expResult = null;
//        ArrayList<Doctor> result = instance.viewDoctors();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of saveToFile method, of class WestminsterSkinConsultationManager.
     */
    @Test
    public void testSaveToFile() throws Exception {
        System.out.println("saveToFile");
        WestminsterSkinConsultationManager instance = new WestminsterSkinConsultationManager();
        instance.saveToFile();

    }

    /**
     * Test of loadDoctors method, of class WestminsterSkinConsultationManager.
     */
    @Test
    public void testLoadDoctors() throws Exception {
        System.out.println("loadDoctors");
        WestminsterSkinConsultationManager instance = new WestminsterSkinConsultationManager();
        instance.loadDoctors();
    }

//    /**
//     * Test of doesDoctorExist method, of class WestminsterSkinConsultationManager.
//     */
//    @Test
//    public void testDoesDoctorExist() {
//        System.out.println("doesDoctorExist");
//        Doctor doctor = null;
//        WestminsterSkinConsultationManager instance = new WestminsterSkinConsultationManager();
//        boolean expResult = false;
//        boolean result = instance.doesDoctorExist(doctor);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
