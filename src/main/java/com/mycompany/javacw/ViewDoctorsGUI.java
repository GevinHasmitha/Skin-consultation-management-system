package com.mycompany.javacw;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

/**
 *
 * @author Gevin-pc
 */


public class ViewDoctorsGUI {

    private MyFrame frame = new MyFrame();
    private TableModelDoctor tModel;
    private JTable table;
    private JButton backBtn = new JButton("Back");
    private JScrollPane scrollPane = new JScrollPane();
    private JPanel p1, p2;
    private JLabel headingLabel;
    private ArrayList<Doctor> sortedDoctorsList;
    

    public ViewDoctorsGUI() {
        
        frame.setTitle("view all doctors");
        
        headingLabel = new JLabel("View All Added Doctors");
        headingLabel.setFont(new Font("MV Boli", Font.BOLD, 45));

        try {
            /**
             * A custom JPanel was created by extending JPanel in order to set a
             * background image for the JPanel*
             */
            p1 = new JPanelWithBackground("img.jpg");
        } catch (IOException ex) {
        }

        p2 = new JPanel();

        p2.setLayout(null);
        p2.setBackground(Color.BLUE);
        p2.setPreferredSize(new Dimension(300, 800));
        
        sortedDoctorsList = (ArrayList<Doctor>) WestminsterSkinConsultationManager.getDoctorsList().clone();
        sort(sortedDoctorsList);
        tModel = new TableModelDoctor(sortedDoctorsList);
        table = new JTable(tModel);
        table.setRowHeight(50);
        

        backBtn.setBounds(50, 660, 100, 50);
        backBtn.addActionListener(e -> {
            frame.dispose();
            LaunchPageGUI launch = new LaunchPageGUI();
        });

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        table.setPreferredScrollableViewportSize(new Dimension(900, 600));

        scrollPane.add(table);
        scrollPane.setViewportView(table);

        p1.add(headingLabel, BorderLayout.NORTH);
        p1.add(scrollPane,BorderLayout.CENTER);
        p2.add(backBtn);

        
        frame.add(p1, BorderLayout.CENTER);
        frame.add(p2, BorderLayout.WEST);

        frame.setVisible(true);

    }
    
    /**Sorts arraylist in order of ascending doctor name**/
    public static void sort(ArrayList<Doctor> list) {
        list.sort((o1, o2)
                -> o1.getName().compareTo(
                        o2.getName()));
    }

}
