/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.javacw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager{

    private static ArrayList<Doctor> doctorsList = new ArrayList<Doctor>(10);

    public static void main(String[] args) {

        int choice = 0;
        int count = 0;
        while (choice != 7) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter 1 to add a new doctor \n"
                    + "Enter 2 to delete a doctor \n"
                    + "Enter 3 to view all doctors \n"
                    + "Enter 4 to save information to file \n"
                    + "Enter 5 to load stored information \n"
                    + "Enter 6 for GUI implementation \n"
                    + "Enter 7 to quit");
            choice = scanner.nextInt();
            WestminsterSkinConsultationManager main = new WestminsterSkinConsultationManager();

            switch (choice) {
                case 1:

                    if (doctorsList.size() < 10) {
                        System.out.println("Enter doctor's name");
                        String fname = scanner.next();

                        System.out.println("Enter doctor's surname");
                        String surname = scanner.next();

                        System.out.println("Enter doctor's date of birth(yyyy-MM-dd)");
                        String dob = scanner.next();

                        System.out.println("Enter mobile number");
                        String mobile = scanner.next();

                        System.out.println("Enter license number");
                        String license = scanner.next();

                        System.out.println("Enter specialization");
                        String specialization = scanner.next();

                        main.addDoctor(fname, surname, dob, mobile, license, specialization);
                        break;

                    } else {
                        System.out.println("-------------------------------------------");
                        System.out.println("Only a maximum of 10 doctors can be added");
                        System.out.println("-------------------------------------------");
                    }

                    break;
                case 2:
                    System.out.println("Enter license No ");
                    int license = scanner.nextInt();
                    main.deleteDoctor(doctorsList, license);
                    break;

                case 3:
                    main.viewDoctors();
                    break;

                case 4:          
                    try {
                    main.saveToFile();
                } catch (IOException ex) {
                }
                break;

                case 5:
                    System.out.println("Loading saved data.....");
                    try {
                        main.loadDoctors();
                    } catch (FileNotFoundException ex) {
                    }
                    break;

                case 6:
                    LaunchPageGUI launchPage = new LaunchPageGUI();
                    break;
            }
        }
    }

    
    
    @Override
    public ArrayList<Doctor> addDoctor(String name, String surname, String dob,
            String mobile, String license, String speciaization) {
        int mobileNo;
        int lisenceNo;
        

        WestminsterSkinConsultationManager main = new WestminsterSkinConsultationManager();

        LocalDate dateOfBirth = main.dateValidater(dob); //validates date
        if (dateOfBirth == null) {
            return null;
        }
        try {
             mobileNo = Integer.parseInt(mobile);
        } catch (Exception e) {
            System.out.println("Invalid mobile number");
            return null;
        }
        try {
             lisenceNo = Integer.parseInt(license);
        } catch (Exception e) {
            System.out.println("Invalid license number");
            return null;
        }

        doctorsList.add(new Doctor(name, surname, dateOfBirth, mobileNo, lisenceNo, speciaization));
        return doctorsList;
    }

    /* This Method converts string date into LocalDate format and validates
    the date entered by the user*/
    @Override
    public LocalDate dateValidater(String dob) {
        try {
            LocalDate dateOfBirth = LocalDate.parse(dob, DateTimeFormatter.ISO_DATE);
            return dateOfBirth;

        } catch (IllegalArgumentException e) {
            System.out.println("Wrong date format, please enter in correct format");
        } catch (DateTimeParseException e) {
            System.out.println("Wrong date format, please enter in correct format");
        }
        return null;

    }

    @Override
    public Doctor deleteDoctor(ArrayList<Doctor> docList, int license) {

        for (int i = 0; i < docList.size(); i++) {
            Doctor d = docList.get(i);
            if (d.getlicenseNo() == license) {
                System.out.println("The following doctor has been removed");
                docList.get(i).printall();
                docList.remove(i);
                System.out.println("Remaining amount of doctors: " + doctorsList.size());
                System.out.println("");
                return d;
            }
        }
        System.out.println("Invalid License No");
        return null;
    }

    @Override
    public ArrayList<Doctor> viewDoctors() {

        ArrayList<Doctor> sortedDoctorsList = (ArrayList<Doctor>) doctorsList.clone();

        sort(sortedDoctorsList);

        try {
            for (Doctor i : sortedDoctorsList) {
                i.printall();
            }
        } catch (Exception e) {
            System.out.println("Error during sorting ");
        }
        return doctorsList;

    }

    /**
     * Sorts Arraylist in ascending order of doctor surname
     *
     *
     * @param list
     */
    @Override
    public void sort(ArrayList<Doctor> list) {
        list.sort((o1, o2)
                -> o1.getSurname().compareTo(
                        o2.getSurname()));
    }

    @Override
    public void saveToFile() throws IOException {
        FileWriter fileWriter = new FileWriter("doctorFile.txt");
        for (int i = 0; i < doctorsList.size(); i++) {
            /**We can split the text at the "," positions to obtained the required values
             when loading from the file**/
            fileWriter.write(doctorsList.get(i).getName() + "," + doctorsList.get(i).getSurname()
                    + "," + doctorsList.get(i).getDateOfBirth() + "," + doctorsList.get(i).getMobileNo()
                    + "," + doctorsList.get(i).getlicenseNo() + "," + doctorsList.get(i).getSpecialization());
            fileWriter.write("\n");
        }
        fileWriter.close();
        System.out.println("File saved successfully");
    }

    @Override
    public void loadDoctors() throws FileNotFoundException {
        File file = new File("doctorFile.txt");
        Scanner data = new Scanner(file);
        while (data.hasNextLine()) {
            String[] split = data.nextLine().split(",");
            Doctor doc = new Doctor(split[0], split[1], LocalDate.parse(split[2], DateTimeFormatter.ISO_DATE), Integer.parseInt(split[3]), Integer.parseInt(split[4]), split[5]);
            if (doesDoctorExist(doc) == true) {
                continue;
            } else {
                doctorsList.add(doc);
            }
        }
    }

    @Override
    public boolean doesDoctorExist(Doctor doctor) {
        for (Doctor doc : doctorsList) {
            if (doc.getlicenseNo() == doctor.getlicenseNo()) {
                return true;
            }
        }
        return false;

    }

    public static ArrayList<Doctor> getDoctorsList() {
        return doctorsList;
    }


}
