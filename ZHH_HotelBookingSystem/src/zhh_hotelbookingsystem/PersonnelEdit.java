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

/**
 *
 * @author Honghui Zhang
 */
public class PersonnelEdit extends Box{
    
    final int WIDTH = 1216;
    final int HEIGHT = 728;
    
    private Vector<Vector> tableDate;
    private Font font;
    private Font hintFont;
    
    public PersonnelEdit(){
        super(BoxLayout.Y_AXIS);
        
        font = new Font("Dialog", 1, 16);
        hintFont = new Font("Dialog", 1, 36);
        
        Box hBox1 = Box.createHorizontalBox();
        JLabel personnelNameJLabel = new JLabel("Name");
        personnelNameJLabel.setFont(font);
        personnelNameJLabel.setForeground(Color.white);
        JTextField personnelNameField = new JTextField(10);
        JButton searchPersonnelEditButton = new JButton("Search");
        hBox1.add(Box.createHorizontalStrut(320));
        hBox1.add(personnelNameJLabel);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(personnelNameField);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(searchPersonnelEditButton);
        hBox1.add(Box.createHorizontalStrut(401));
        
        Box hBox4 = Box.createHorizontalBox();
        JLabel personnelNameEditJLabel = new JLabel("Name");
        personnelNameEditJLabel.setFont(font);
        personnelNameEditJLabel.setForeground(Color.white);
        JTextField personnelNameEditJTextField = new JTextField(10);
        JLabel personnelContactEditJLabel = new JLabel("Contact");
        personnelContactEditJLabel.setFont(font);
        personnelContactEditJLabel.setForeground(Color.white);
        JTextField personnelContactEdtJTextField = new JTextField(10);
        hBox4.add(Box.createHorizontalStrut(20));
        hBox4.add(personnelNameEditJLabel);
        hBox4.add(Box.createHorizontalStrut(20));
        hBox4.add(personnelNameEditJTextField);
        hBox4.add(Box.createHorizontalStrut(200));
        hBox4.add(personnelContactEditJLabel);
        hBox4.add(Box.createHorizontalStrut(20));
        hBox4.add(personnelContactEdtJTextField);
        
        Box hBox5 = Box.createHorizontalBox();
        JLabel personnelGenderEditJLabel = new JLabel("Gender");
        personnelGenderEditJLabel.setFont(font);
        personnelGenderEditJLabel.setForeground(Color.white);
        JComboBox<String> personnelGenderEditComboBox = new JComboBox<>();
        personnelGenderEditComboBox.addItem("male");
        personnelGenderEditComboBox.addItem("female");
        JLabel personnelDepartmentEditJLabel = new JLabel("Department");
        personnelDepartmentEditJLabel.setFont(font);
        personnelDepartmentEditJLabel.setForeground(Color.white);
        JComboBox<String> personnelDepartmentEditComboBox = new JComboBox<>();
        personnelDepartmentEditComboBox.addItem("FRONT OFFICE MANAGER");
        personnelDepartmentEditComboBox.addItem("FOOD & BEVERAGE");
        personnelDepartmentEditComboBox.addItem("HUMAN RESOURCES");
        personnelDepartmentEditComboBox.addItem("FINANCIAL DEPARTMENT");
        personnelDepartmentEditComboBox.addItem("RECEPTION");
        personnelDepartmentEditComboBox.addItem("HOUSEKEEPING DEPARTMENT");
        hBox5.add(Box.createHorizontalStrut(20));
        hBox5.add(personnelGenderEditJLabel);
        hBox5.add(Box.createHorizontalStrut(20));
        hBox5.add(personnelGenderEditComboBox);
        hBox5.add(Box.createHorizontalStrut(360));
        hBox5.add(personnelDepartmentEditJLabel);
        hBox5.add(Box.createHorizontalStrut(20));
        hBox5.add(personnelDepartmentEditComboBox);
        
        Box hBox6 = Box.createHorizontalBox();
        JButton personnelEditButton = new JButton("Edit");
        hBox6.add(personnelEditButton);
        
        Box hBox7 = Box.createHorizontalBox();
        JLabel hintJLabel = new JLabel("Please enter the name you want to edit to search!");
        hintJLabel.setFont(hintFont);
        hintJLabel.setForeground(Color.white);
        hBox7.add(hintJLabel);
        
        hBox4.setVisible(false);
        hBox5.setVisible(false);
        hBox6.setVisible(false);
        
        //Get the person information users want to edit
        searchPersonnelEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!personnelNameField.getText().equals("")) {
                    if (DBUtil.checkOneStuffExist(personnelNameField.getText())) {
                        hBox4.setVisible(true);
                        hBox5.setVisible(true);
                        hBox6.setVisible(true);
                        hBox7.setVisible(false);
                        tableDate = DBUtil.searchOnePersonnel(personnelNameField.getText());
                        personnelNameEditJTextField.setText(tableDate.firstElement().firstElement().toString());
                        personnelContactEdtJTextField.setText(tableDate.firstElement().lastElement().toString());
                        personnelGenderEditComboBox.setSelectedItem(tableDate.firstElement().get(1));
                        personnelDepartmentEditComboBox.setSelectedItem(tableDate.firstElement().get(2));
                    }else {
                        JOptionPane.showMessageDialog(hBox4, "Can't find the person!");
                    }    
                }else {
                    hBox4.setVisible(false);
                    hBox5.setVisible(false);
                    hBox6.setVisible(false);
                    hBox7.setVisible(true);
                }
            }
        });
        
        //Update user's modified information
        personnelEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String oldName = personnelNameField.getText();
                String newName = personnelNameEditJTextField.getText();
                int newGender = personnelGenderEditComboBox.getSelectedIndex();
                String newDepartment = personnelDepartmentEditComboBox.getSelectedItem().toString();
                String newContact = personnelContactEdtJTextField.getText();
                DBUtil.editStaffInformation(oldName, newName, newGender, newDepartment, newContact);
                JOptionPane.showMessageDialog(hBox5, "Edited successfully!");
            }
        });
        
        this.add(Box.createVerticalStrut(80));
        this.add(hBox1);
        this.add(Box.createVerticalStrut(157));
        this.add(hBox4);
        this.add(Box.createVerticalStrut(30));
        this.add(hBox5);
        this.add(Box.createVerticalStrut(30));
        this.add(hBox6);
        this.add(Box.createVerticalStrut(30));
        this.add(hBox7);
    }
    
}
