package com.mycompany.javacw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class ViewConsultationsGUI {

    private MyFrame frame = new MyFrame();
    private TableModelConsultation consultModel = new TableModelConsultation(AddConsultationGUI.getConsultationList());
    private JTable table = new JTable(consultModel);
    private JButton backBtn = new JButton("Back");
    private JScrollPane scrollPane = new JScrollPane();
    private JPanel p1,p2;
    private JLabel headingLabel;

    public ViewConsultationsGUI() {
        
        frame.setTitle("View all Consultations");
        
        headingLabel = new JLabel("View Consultations");
        headingLabel.setFont(new Font("MV Boli", Font.BOLD, 45));

        table.setRowHeight(50);
        table.getColumnModel().getColumn(9).setPreferredWidth(200);
        table.getColumnModel().getColumn(7).setPreferredWidth(150);

        /**
         * A custom JPanel was created by extending JPanel in order to set a
         * background image for the JPanel*
         */
        try {
            p1 = new JPanelWithBackground("img.jpg");
        } catch (IOException ex) {

        }

        p2 = new JPanel();

        p2.setLayout(null);
        p2.setBackground(Color.BLUE);
        p2.setPreferredSize(new Dimension(300, 800));

        backBtn.setBounds(50, 660, 100, 50);
        backBtn.addActionListener(e -> {
            frame.dispose();
            LaunchPageGUI launch = new LaunchPageGUI();
        });

        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        table.setPreferredScrollableViewportSize(new Dimension(1240, 600));

        scrollPane.add(table);
        scrollPane.setViewportView(table);
        
        p1.add(headingLabel, BorderLayout.NORTH);
        p1.add(scrollPane,BorderLayout.CENTER);
        p2.add(backBtn);

        
        frame.add(p1, BorderLayout.CENTER);
        frame.add(p2, BorderLayout.WEST);

    }

}
