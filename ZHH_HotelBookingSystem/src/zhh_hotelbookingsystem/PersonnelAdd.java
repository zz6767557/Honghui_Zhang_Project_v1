/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhh_hotelbookingsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Honghui Zhang
 */
public class PersonnelAdd extends Box{
    
    final int WIDTH = 1216;
    final int HEIGHT = 728;
    
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableDate;
    private DefaultTableModel tableModel;
    private Font font;
    
    public PersonnelAdd(){
        super(BoxLayout.Y_AXIS);
        
        font = new Font("Dialog", 1, 16);
        
        Box hBox1 = Box.createHorizontalBox();
        JLabel personnelNameJLabel = new JLabel("Name");
        personnelNameJLabel.setFont(font);
        personnelNameJLabel.setForeground(Color.white);
        JTextField personnelNameField = new JTextField(10);
        JLabel personnelGenderJLabel = new JLabel("Gender");
        personnelGenderJLabel.setFont(font);
        personnelGenderJLabel.setForeground(Color.white);
        JComboBox<String> GenderBox = new JComboBox<>();
        GenderBox.addItem("male");
        GenderBox.addItem("female");
        JLabel personnelDepartmentJLabel = new JLabel("Department");
        personnelDepartmentJLabel.setFont(font);
        personnelDepartmentJLabel.setForeground(Color.white);
        JComboBox<String> DepartmentBox = new JComboBox<>();
        DepartmentBox.addItem("FRONT OFFICE MANAGER");
        DepartmentBox.addItem("FOOD & BEVERAGE");
        DepartmentBox.addItem("HUMAN RESOURCES");
        DepartmentBox.addItem("FINANCIAL DEPARTMENT");
        DepartmentBox.addItem("RECEPTION");
        DepartmentBox.addItem("HOUSEKEEPING DEPARTMENT");
        JLabel personnelContactJLabel = new JLabel("Contact");
        personnelContactJLabel.setFont(font);
        personnelContactJLabel.setForeground(Color.white);
        JTextField personnelContactField = new JTextField(10);
        JButton addPersonnelButton = new JButton("Add");
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(personnelNameJLabel);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(personnelNameField);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(personnelGenderJLabel);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(GenderBox);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(personnelDepartmentJLabel);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(DepartmentBox);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(personnelContactJLabel);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(personnelContactField);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(addPersonnelButton);
        
        
        String[] ts = {"Name", "Gender", "Department", "Contact"};
        titles = new Vector<>();
        for (String t : ts) {
            titles.add(t);
        }

        tableDate = DBUtil.searchAllPersonnel();
        
        tableModel = new DefaultTableModel(tableDate, titles);
        
        table = new JTable(tableModel);
        table.setDragEnabled(false);
        table.setEnabled(false);
        TableColumn column = table.getColumnModel().getColumn(2);
        column.setMinWidth(100);
        
        Box hBox3 = Box.createHorizontalBox();
        hBox3.add(Box.createHorizontalStrut(20));
        JScrollPane js = new JScrollPane(table);
        Color transparentColor = new Color(255, 255, 255, 50);
        js.getViewport().setBackground(transparentColor);
        hBox3.add(js);
        
        //Add personnel information
        addPersonnelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (personnelNameField.getText().equals("") || personnelContactField.getText().equals("")) {
                    JOptionPane.showMessageDialog(hBox3, "Please input the information!");
                }else {
                    if (DBUtil.checkOneStuffExist(personnelNameField.getText())) {
                        JOptionPane.showMessageDialog(hBox3, "This person already exists!");
                    }else {
                        String personnelName = personnelNameField.getText();
                        int personnelGender = GenderBox.getSelectedIndex();
                        String personnelDepartment = DepartmentBox.getItemAt(DepartmentBox.getSelectedIndex());
                        String personnelContact = personnelContactField.getText();
                        DBUtil.addPersonnel(personnelName, personnelGender, personnelDepartment, personnelContact);
                        JOptionPane.showMessageDialog(hBox1, "Data added successfully!");
                        personnelNameField.setText("");
                        GenderBox.setSelectedIndex(0);
                        DepartmentBox.setSelectedIndex(0);
                        personnelContactField.setText("");
                        tableDate.clear();
                        tableDate = DBUtil.searchAllPersonnel();
                        tableModel.getDataVector().clear();
                        tableModel.setDataVector(tableDate, titles);
                        tableModel.fireTableDataChanged();
                    }
                }
            }
        });
        
        this.add(Box.createVerticalStrut(80));
        this.add(hBox1);
        this.add(Box.createVerticalStrut(137));
        this.add(hBox3);
    }
    
}
