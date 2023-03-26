package com.mycompany.javacw;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TableModelDoctor extends AbstractTableModel {
    
   
    private ArrayList<Doctor> list ;
    private String[] coloumnNames = {"First name","Surname","Date of Birth","Mobile No.","License No.","specialization"};
    

    public TableModelDoctor(ArrayList<Doctor> doctorList){
        this.list = doctorList;
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
        if(columnIndex == 0){
            temp = list.get(rowIndex).getName();
        }else if(columnIndex == 1){
            temp = list.get(rowIndex).getSurname();
        }else if(columnIndex == 2){
            temp = list.get(rowIndex).getDateOfBirth();
        }else if(columnIndex == 3){
            temp = list.get(rowIndex).getMobileNo();
        }else if(columnIndex == 4){
            temp = list.get(rowIndex).getlicenseNo();
        }else if(columnIndex == 5){
            temp = list.get(rowIndex).getSpecialization();
        }
        return temp;

    }
    
    @Override
    public String getColumnName(int col){
        return coloumnNames[col];
    }

}
