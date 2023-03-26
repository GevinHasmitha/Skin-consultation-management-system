package com.mycompany.javacw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class LaunchPageGUI {

    private JPanel p1, p2;
    private JButton btn1, btn2, btn3;
    private JLabel headingLabel;

    LaunchPageGUI() {
        
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setPreferredSize(new Dimension(300,800));
        p1.setBackground(Color.BLUE);
        
        try {
            p2 = new JPanelWithBackground("img.jpg");
        } catch (IOException ex) {
            System.out.println("Error creating jpanel");
        }
        p2.setLayout(null);

        MyFrame frame = new MyFrame();
        frame.setTitle("Launch Page");

         btn1 = new JButton("View all Doctors");
        btn1.setBounds(50, 100, 200, 50);
        btn1.addActionListener(e -> {
            frame.dispose();
            ViewDoctorsGUI dTable = new ViewDoctorsGUI();
        });

         btn2 = new JButton("Add consultation");
        btn2.setBounds(50, 160, 200, 50);
        btn2.addActionListener(e -> {
            frame.dispose();
            AddConsultationGUI consultMenu = new AddConsultationGUI();
        });

         btn3 = new JButton("View consultation");
        btn3.setBounds(50, 220, 200, 50);
        btn3.addActionListener(e -> {
            frame.dispose();
            ViewConsultationsGUI viewConsult = new ViewConsultationsGUI();
        });
        
        
        
        
        headingLabel = new JLabel("Hospital Management System");
        headingLabel.setFont(new Font("MV Boli", Font.BOLD, 60));
        headingLabel.setBounds(200, 80, 1380, 70);
        
        
        JLabel text = new JLabel("<html> Welcome to the login menu \n"
                + " for the skin consultation center  Here, you \n"
                + "can access your account and schedule appointments \n"
                + " with for your patients with doctors in a efficient and \n"
                + "easy way. Our latest features allow you to allocate patients \n"
                + "to doctors allowing for easier consultation.\n"
                + "Hope you find our product useful, and thank you for your interest! <html>");
        text.setFont(new Font("Serif", Font.BOLD, 23));
        text.setBounds(250,250, 780, 200);
        
       
        
        p1.add(btn1);
        p1.add(btn2);
        p1.add(btn3);
        p2.add(headingLabel);
        p2.add(text);
        

        frame.add(p1,BorderLayout.WEST);
        frame.add(p2,BorderLayout.CENTER);

        frame.setVisible(true);

    }

}
