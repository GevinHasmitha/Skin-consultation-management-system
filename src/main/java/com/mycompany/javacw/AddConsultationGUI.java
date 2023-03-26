package com.mycompany.javacw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddConsultationGUI {

    private static ArrayList<Patient> patientsList = new ArrayList<>();
    private static ArrayList<Consultation> consultationList = new ArrayList<>();

    private MyFrame frame = new MyFrame();
    private JPanel detailsPanel, navPanel;

    private JLabel nameLabel, surnameLabel, dobLabel, mobileLabel, patientIdLabel, infoLabel, idLabel, dateLabel, headingLabel;
    private JTextField nameField, surnameField, dobField, mobField, patientIdField, idField, dateField;
    private JTextArea infoField;

    private String name, surname, dob, inputText;
    private LocalDate patientBirthDate;
    private int mobileNo;
    private SecretKey key = null;
    private byte[] encryptedData = null;
    private Date appointmentdate;

    private JButton backBtn, submitBtn;
    private int cost = 0;

    public AddConsultationGUI() {

        headingLabel = new JLabel("Add a new Consultation");
        headingLabel.setBounds(400, 20, 600, 80);
        headingLabel.setFont(new Font("MV Boli", Font.BOLD, 45));

        nameLabel = new JLabel("First Name");
        surnameLabel = new JLabel("Surname");
        dobLabel = new JLabel("Date Of Birth  (yyyy-MM-dd)");
        mobileLabel = new JLabel("Mobile No");
        patientIdLabel = new JLabel("Enter the patient Id");
        infoLabel = new JLabel("Enter any additional notes");
        idLabel = new JLabel("Enter the doctor's License Number");
        dateLabel = new JLabel("Enter appointment date (yyyy-MM-dd;HH:mm)");

        nameField = new JTextField();
        surnameField = new JTextField();
        dobField = new JTextField();
        mobField = new JTextField();
        patientIdField = new JTextField();
        idField = new JTextField();
        dateField = new JTextField();
        infoField = new JTextArea();

        navPanel = new JPanel();
        navPanel.setLayout(null);
        navPanel.setPreferredSize(new Dimension(300, 800));
        navPanel.setBackground(Color.BLUE);
        
        frame.setTitle("Add new Consultation");

        try {
            /**
             * A custom JPanel was created by extending JPanel in order to set a
             * background image for the JPanel The try catch is required as the
             * custom JPanel throws an exception*
             */
            detailsPanel = new JPanelWithBackground("img.jpg");
        } catch (IOException ex) {
        }

        detailsPanel.setLayout(null);

        nameLabel.setFont(new Font("Sans Serif", Font.BOLD, 15));
        surnameLabel.setFont(new Font("Sans Serif", Font.BOLD, 15));
        dobLabel.setFont(new Font("Sans Serif", Font.BOLD, 15));
        mobileLabel.setFont(new Font("Sans Serif", Font.BOLD, 15));
        infoLabel.setFont(new Font("Sans Serif", Font.BOLD, 15));
        patientIdLabel.setFont(new Font("Sans Serif", Font.BOLD, 15));
        idLabel.setFont(new Font("Sans Serif", Font.BOLD, 15));
        dateLabel.setFont(new Font("Sans Serif", Font.BOLD, 15));

        nameLabel.setBounds(200, 160, 110, 30);
        surnameLabel.setBounds(200, 220, 110, 30);
        dobLabel.setBounds(200, 280, 200, 30);
        mobileLabel.setBounds(200, 340, 110, 30);
        infoLabel.setBounds(660, 160, 220, 30);
        patientIdLabel.setBounds(660, 260, 260, 30);

        nameField.setBounds(400, 160, 200, 30);
        surnameField.setBounds(400, 220, 200, 30);
        dobField.setBounds(400, 280, 200, 30);
        mobField.setBounds(400, 340, 200, 30);
        infoField.setBounds(910, 160, 200, 80);
        patientIdField.setBounds(910, 260, 60, 30);

        idLabel.setBounds(200, 480, 250, 30);
        idField.setBounds(540, 480, 200, 30);

        dateLabel.setBounds(200, 520, 350, 30);
        dateField.setBounds(540, 520, 200, 30);

        detailsPanel.add(headingLabel);

        detailsPanel.add(nameLabel);
        detailsPanel.add(nameField);

        detailsPanel.add(surnameLabel);
        detailsPanel.add(surnameField);

        detailsPanel.add(dobLabel);
        detailsPanel.add(dobField);

        detailsPanel.add(infoLabel);
        detailsPanel.add(infoField);

        detailsPanel.add(mobileLabel);
        detailsPanel.add(mobField);

        detailsPanel.add(patientIdLabel);
        detailsPanel.add(patientIdField);
        backBtn = new JButton("Back");
        backBtn.setBounds(50, 660, 100, 40);
        backBtn.addActionListener(e -> {
            frame.dispose();
            LaunchPageGUI launch = new LaunchPageGUI();
        });

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(50, 600, 100, 40);
        submitBtn.addActionListener(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String dob = dobField.getText();
            LocalDate patientBirthDate;
            int mobileNo;
            int patientId;

            SecretKey key = null;
            byte[] encryptedData = null;
            String inputText = infoField.getText();
            Date appointmentdate;

//======================================Input validation=============================================================
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(detailsPanel,
                        "Name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                //  clearTextFields();
                return;
            }
            if (surname.isEmpty()) {
                JOptionPane.showMessageDialog(detailsPanel,
                        "Surname cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                //clearTextFields();
                return;
            }

            /**
             * validates and converts String patient birth date to LocalDate
             * format*
             */
            WestminsterSkinConsultationManager main = new WestminsterSkinConsultationManager();
            if (main.dateValidater(dob) == null) {
                //   clearTextFields();
                JOptionPane.showMessageDialog(detailsPanel,
                        "Invalid date of birth", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            patientBirthDate = main.dateValidater(dob);

            /**
             * Validates the mobile number*
             */
            try {
                mobileNo = Integer.parseInt(mobField.getText());
            } catch (Exception x) {
                JOptionPane.showMessageDialog(detailsPanel,
                        "Mobile should be integer", "Error", JOptionPane.ERROR_MESSAGE);
                //  clearTextFields();
                return;
            }
            
             /**
             * Validates the Patient id number*
             */
            try {
                patientId = Integer.parseInt(patientIdField.getText());
            } catch (Exception x) {
                JOptionPane.showMessageDialog(detailsPanel,
                        "Patient Id should be integer", "Error", JOptionPane.ERROR_MESSAGE);
                //  clearTextFields();
                return;
            }

            if (inputText.isEmpty()) {
                JOptionPane.showMessageDialog(detailsPanel,
                        "You should enter any additional notes", "Error", JOptionPane.ERROR_MESSAGE);
                //clearTextFields();
                return;
            } else {
                /**
                 * Encrypts the data from the additional notes text area *
                 */
                try {
                    Encryption encryption = new Encryption();
                    key = encryption.generateKey("AES");
                    Cipher cipher = Cipher.getInstance("AES");

                    encryptedData = encryption.encryptInputString(inputText, key, cipher);
                    String encryptedString = new String(encryptedData);

                    //For testing purposes
                    System.out.println(encryptedString);

                } catch (Exception ex) {
                    System.out.println("Error during encryption");
                }
            }

//===================================================================================================================            
            /**
             * validates appointment date, If suitable doctor found he is
             * assigned to the respective patient*
             */
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd;HH:mm");

            try {
                appointmentdate = sf.parse(dateField.getText());
                System.out.println(appointmentdate);
            } catch (Exception s) {
                JOptionPane.showMessageDialog(detailsPanel,
                        "Invalid date time format for appointment", "Error", JOptionPane.ERROR_MESSAGE);
                //s.printStackTrace();
                appointmentdate = null;
                return;
            }
            
            /**If no previous consultations, first consultation cost is 15
             otherwise cost is 25**/
            for (Consultation consults : consultationList){
                if (consults.getPatient().getPatientId()==patientId){
                    cost=25;
                    break;
                }else{
                    cost=15;
                    break;
                }
            }

            /**
             * Checks to see if user's doctor of choice is available, if
             * available returns the respective doctor, otherwise returns a
             * random doctor*
             */
            Doctor doc = checkDoctorAvailability(idField.getText(), appointmentdate);

            /**
             * Creates a new patient and a consultation*
             */
            if (doc != null) {
                patientsList.add(new Patient(name, surname, patientBirthDate, mobileNo, doc, patientId));
                consultationList.add(new Consultation(doc, patientsList.get(patientsList.size() - 1),
                        appointmentdate, key, encryptedData, cost));
            }
            if (doc == null) {
                System.out.println("Error occured");
            }

            for (Consultation p : consultationList) {
                System.out.println(p.getDoctor().getName());
                System.out.println(p.getPatient().getName());
                System.out.println(p.getAppointmentDate());
            }

            clearTextFields();
        });

        detailsPanel.add(idLabel);
        detailsPanel.add(idField);
        detailsPanel.add(dateLabel);
        detailsPanel.add(dateField);

        navPanel.add(backBtn);
        navPanel.add(submitBtn);

        frame.add(navPanel, BorderLayout.WEST);
        frame.add(detailsPanel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

    public void clearTextFields() {
        nameField.setText("");
        surnameField.setText("");
        dobField.setText("");
        mobField.setText("");
        dateField.setText("");
        idField.setText("");
        infoField.setText("");
        patientIdField.setText("");
    }

    public Doctor checkDoctorAvailability(String licenceId, Date appointmentdate) {

        Doctor randomDoctor;

        int licenceNo = Integer.parseInt(licenceId);

        int i = 0;

        /**
         * Checks all doctors to see if the selected doctor is available, If
         * doctor is available that respective doctor will be called otherwise
         * getRandomDoctor() will be called which in turn will return a random
         * doctor*
         */
        for (Doctor d : WestminsterSkinConsultationManager.getDoctorsList()) {
            if (d.getlicenseNo() == licenceNo) {
                if (d.dateTimeList.isEmpty()) {
                    d.dateTimeList.add(appointmentdate);
                    JOptionPane.showMessageDialog(detailsPanel,
                            "The doctor has been booked", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    cost = 15;
                    return d;
                }
                for (Date ld : d.dateTimeList) {

                    if (ld.compareTo(appointmentdate) == 0) {  //Localdates compareTo method returns 0 if dates are equal
                        randomDoctor = getRandomDoctor(appointmentdate);
                        System.out.println(randomDoctor);
                        if (randomDoctor == null) {
                            JOptionPane.showMessageDialog(detailsPanel,
                                    "No doctors available", "Alert", JOptionPane.ERROR_MESSAGE);
                            return null;
                        }

                        JOptionPane.showMessageDialog(detailsPanel,
                                "The doctor chosen is not available at that date, another doctor has been assigned", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                        randomDoctor.dateTimeList.add(appointmentdate);
                        return randomDoctor;

                    }

                }
                JOptionPane.showMessageDialog(detailsPanel,
                        "The doctor has been booked", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                d.dateTimeList.add(appointmentdate);
                cost = 25;
                return d;
            } else {
                i = 1;
            }

        }
        if (i == 1) {
            JOptionPane.showMessageDialog(detailsPanel,
                    "Invalid License No", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;

    }

    /**
     * Returns a random doctor if user's choice oo doctor is not available*
     */
    public Doctor getRandomDoctor(Date appointmentdate) {

        Random random = new Random();

        Doctor doc;
        ArrayList<Doctor> availableDocList = new ArrayList<>();

        for (Doctor d : WestminsterSkinConsultationManager.getDoctorsList()) {
            doc = checkDoctorEligibility(d, appointmentdate);
            if (doc == null) {
                continue;
            } else {
                availableDocList.add(doc);
            }
        }

        if (availableDocList.isEmpty()) {
            return null;
        }

        int randomNum = random.nextInt(availableDocList.size());
        return availableDocList.get(randomNum);

    }

    /**
     * Checks whether the doctor is available*
     */
    public Doctor checkDoctorEligibility(Doctor doc, Date appDate) {
        if (doc.dateTimeList.isEmpty()) {
            return doc;
        }
        for (Date date : doc.dateTimeList) {
            if (date.compareTo(appDate) == 0) {
                return null;
            }
        }
        return doc;

    }

    public static ArrayList<Consultation> getConsultationList() {
        return consultationList;
    }

    public static ArrayList<Patient> getPatientsList() {
        return patientsList;
    }

}
