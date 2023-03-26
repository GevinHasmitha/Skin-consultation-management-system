package com.mycompany.javacw;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class TableModelConsultation extends AbstractTableModel {

    private ArrayList<Consultation> list;
    private String[] coloumnNames = {"Doctor name", "Doctor Licence",
         "Patient name", "Patient Surname", "Patient Id", "Birth Date", "Patient mobile", "Consultation date", "cost", "Additional Notes"};

    public TableModelConsultation(ArrayList<Consultation> consultationList) {
        this.list = consultationList;
    }

    @Override
    public int getRowCount() {
        return list.size();

    }

    @Override
    public int getColumnCount() {
        return coloumnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null;
        if (columnIndex == 0) {
            temp = list.get(rowIndex).getDoctor().getName();
        } else if (columnIndex == 1) {
            temp = list.get(rowIndex).getDoctor().getlicenseNo();
        } else if (columnIndex == 2) {
            temp = list.get(rowIndex).getPatient().getName();
        } else if (columnIndex == 3) {
            temp = list.get(rowIndex).getPatient().getSurname();
        }else if (columnIndex == 4) {
            temp = list.get(rowIndex).getPatient().getPatientId();
        }else if (columnIndex == 5) {
            temp = list.get(rowIndex).getPatient().getDateOfBirth();
        }else if (columnIndex == 6) {
            temp = list.get(rowIndex).getPatient().getMobileNo();
        }else if (columnIndex == 7) {
            temp = list.get(rowIndex).getAppointmentDate();
        }else if (columnIndex == 8) {
            temp = list.get(rowIndex).getCost();
        }else if (columnIndex == 9) {
            temp = list.get(rowIndex).getDecryptedData();
        }
        return temp;

    }

    @Override
    public String getColumnName(int col) {
        return coloumnNames[col];
    }

}
