/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pb.project.test;

import com.pb.project.entity.impl.Credit;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author voch
 */
public class MyTableModel extends AbstractTableModel {

    private List<Credit> creditList;
    private String[] columnNames = new String[]{"ID кредита", "Название банка", "Сумма кредита", "Валюта", "Невыплаченная сумма", "Дата выдачи", "Дата закрытия", "Просрочка"};

    public MyTableModel(List<Credit> creditList) {
        this.creditList = creditList;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowCount() {
        return creditList.size();
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Credit credit = creditList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return credit.getId();
            case 1:
                return credit.getBank().getName();
            case 2:
                return credit.getCreditAmount();
            case 3:
                return credit.getCurrency().getName();
            case 4:
                return credit.getUnpaidAmount();
            case 5:
                return new SimpleDateFormat("dd-MM-yyyy").format(credit.getDateStart());
            case 6:
                if(credit.getDateEnd() != null){
                return new SimpleDateFormat("dd-MM-yyyy").format(credit.getDateEnd());
                }else {
                  return credit.getDateEnd();
                }
            case 7:
                if(credit.getIsDelay().equals(true)){
                  return "есть";
                }
                else if(credit.getIsDelay().equals(false)) {
                    return "нет";
                }
                
            default:
                return null;
        }
    }
}
