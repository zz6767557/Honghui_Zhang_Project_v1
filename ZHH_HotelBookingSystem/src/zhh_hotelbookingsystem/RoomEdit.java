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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;
import javax.swing.*;

/**
 *
 * @author Honghui Zhang
 */
public class RoomEdit extends Box{
    
    final int WIDTH = 1216;
    final int HEIGHT = 728;
    
    private Vector<Vector> tableDate;
    private Font font;
    private Font hintFont;
    
    public RoomEdit(){
        super(BoxLayout.Y_AXIS);
        
        font = new Font("Dialog", 1, 16);
        hintFont = new Font("Dialog", 1, 36);
        
        Box hBox1 = Box.createHorizontalBox();
        JLabel roomNumJLabel = new JLabel("Room Number");
        roomNumJLabel.setFont(font);
        roomNumJLabel.setForeground(Color.white);
        JTextField roomNumField = new JTextField(10);
        roomNumField.setText("Example:1001");
        roomNumField.setForeground(Color.gray);
        roomNumField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (roomNumField.getText().equals("Example:1001")) {
                    roomNumField.setText("");
                    roomNumField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (roomNumField.getText().equals("")) {
                    roomNumField.setText("Example:1001");
                    roomNumField.setForeground(Color.gray);
                }
            }
        });
        JButton searchButton = new JButton("Search");
        hBox1.add(Box.createHorizontalStrut(279));
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(roomNumJLabel);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(roomNumField);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(searchButton);
        hBox1.add(Box.createHorizontalStrut(305));
        
        Box hBox4 = Box.createHorizontalBox();
        JLabel roomNumberEditJLabel = new JLabel("Room Number");
        roomNumberEditJLabel.setFont(font);
        roomNumberEditJLabel.setForeground(Color.white);
        JTextField roomNumberEditJTextField = new JTextField(10);
        roomNumberEditJTextField.setEditable(false);
        JLabel roomPriceEditJLabel = new JLabel("Price");
        roomPriceEditJLabel.setFont(font);
        roomPriceEditJLabel.setForeground(Color.white);
        JTextField roomPriceEditJTextField = new JTextField(10);
        hBox4.add(Box.createHorizontalStrut(20));
        hBox4.add(roomNumberEditJLabel);
        hBox4.add(Box.createHorizontalStrut(20));
        hBox4.add(roomNumberEditJTextField);
        hBox4.add(Box.createHorizontalStrut(150));
        hBox4.add(roomPriceEditJLabel);
        hBox4.add(Box.createHorizontalStrut(20));
        hBox4.add(roomPriceEditJTextField);
        
        Box hBox5 = Box.createHorizontalBox();
        JLabel roomTypeEditJLabel = new JLabel("Room Type");
        roomTypeEditJLabel.setFont(font);
        roomTypeEditJLabel.setForeground(Color.white);
        JComboBox<String> roomTypeEditBox = new JComboBox<>();
        roomTypeEditBox.addItem("Standerd Room");
        roomTypeEditBox.addItem("Deluxe Room");
        roomTypeEditBox.addItem("Business Room");
        roomTypeEditBox.addItem("Executive Room");
        roomTypeEditBox.addItem("Family Room");
        roomTypeEditBox.addItem("Presidential Suite");
        JLabel roomCapacityEditJLabel = new JLabel("Capacity");
        roomCapacityEditJLabel.setFont(font);
        roomCapacityEditJLabel.setForeground(Color.white);
        JComboBox<String> roomCapacityEditBox = new JComboBox<>();
        roomCapacityEditBox.addItem("1");
        roomCapacityEditBox.addItem("2");
        roomCapacityEditBox.addItem("3");
        roomCapacityEditBox.addItem("4");
        hBox5.add(Box.createHorizontalStrut(20));
        hBox5.add(roomTypeEditJLabel);
        hBox5.add(Box.createHorizontalStrut(40));
        hBox5.add(roomTypeEditBox);
        hBox5.add(Box.createHorizontalGlue());
        hBox5.add(roomCapacityEditJLabel);
        hBox5.add(Box.createHorizontalStrut(85));
        hBox5.add(roomCapacityEditBox);
        
        Box hBox6 = Box.createHorizontalBox();
        JLabel roomWifiEditJLabel = new JLabel("Wi-Fi?");
        roomWifiEditJLabel.setFont(font);
        roomWifiEditJLabel.setForeground(Color.white);
        JCheckBox roomWifiEditCheckBox = new JCheckBox();
        JLabel roomWindowEditJLabel = new JLabel("Window?");
        roomWindowEditJLabel.setFont(font);
        roomWindowEditJLabel.setForeground(Color.white);
        JCheckBox roomWindowEditCheckBox = new JCheckBox();
        JLabel roomBreakfastEditJLabel = new JLabel("Breakfast?");
        roomBreakfastEditJLabel.setFont(font);
        roomBreakfastEditJLabel.setForeground(Color.white);
        JCheckBox roomBreakfastEditCheckBox = new JCheckBox();
        JLabel roomValidEditJLabel = new JLabel("Valid?");
        roomValidEditJLabel.setFont(font);
        roomValidEditJLabel.setForeground(Color.white);
        JCheckBox roomValidEditCheckBox = new JCheckBox();
        hBox6.add(Box.createHorizontalStrut(20));
        hBox6.add(roomWifiEditJLabel);
        hBox6.add(Box.createHorizontalStrut(20));
        hBox6.add(roomWifiEditCheckBox);
        hBox6.add(Box.createHorizontalGlue());
        hBox6.add(roomWindowEditJLabel);
        hBox6.add(Box.createHorizontalStrut(20));
        hBox6.add(roomWindowEditCheckBox);
        hBox6.add(Box.createHorizontalGlue());
        hBox6.add(roomBreakfastEditJLabel);
        hBox6.add(Box.createHorizontalStrut(20));
        hBox6.add(roomBreakfastEditCheckBox);
        hBox6.add(Box.createHorizontalGlue());
        hBox6.add(roomValidEditJLabel);
        hBox6.add(Box.createHorizontalStrut(20));
        hBox6.add(roomValidEditCheckBox);
        
        Box hBox7 = Box.createHorizontalBox();
        JButton roomEditButton = new JButton("Edit");
        hBox7.add(roomEditButton);
        
        Box hBoxHint = Box.createHorizontalBox();
        JLabel hintJLabel = new JLabel("Please enter the room number you want to edit to search!");
        hintJLabel.setFont(hintFont);
        hintJLabel.setForeground(Color.white);
        hBoxHint.add(hintJLabel);
        
        hBox4.setVisible(false);
        hBox5.setVisible(false);
        hBox6.setVisible(false);
        hBox7.setVisible(false);
        
        //search the information of the room which want to be edit
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!roomNumField.getText().equals("")) {
                    if (DBUtil.checkRoomExist(roomNumField.getText())) {
                        hBoxHint.setVisible(false);
                        hBox4.setVisible(true);
                        hBox5.setVisible(true);
                        hBox6.setVisible(true);
                        hBox7.setVisible(true);
                        tableDate = DBUtil.searchOneRoom(roomNumField.getText());
                        roomNumberEditJTextField.setText(tableDate.firstElement().firstElement().toString());
                        roomPriceEditJTextField.setText(tableDate.firstElement().get(3).toString());
                        roomTypeEditBox.setSelectedItem(tableDate.firstElement().get(2).toString());
                        roomCapacityEditBox.setSelectedItem(tableDate.firstElement().get(7).toString());
                        roomWifiEditCheckBox.setSelected(tableDate.firstElement().get(4).toString().equals("√"));
                        roomWindowEditCheckBox.setSelected(tableDate.firstElement().get(5).toString().equals("√"));
                        roomBreakfastEditCheckBox.setSelected(tableDate.firstElement().get(6).toString().equals("√"));
                        roomValidEditCheckBox.setSelected(tableDate.firstElement().get(8).toString().equals("√"));
                    }else { 
                        JOptionPane.showMessageDialog(hBox5, "Can't find the room!");
                    }
                }
                if (roomNumField.getText().equals("Example:1001")) {
                    hBoxHint.setVisible(true);
                    hBox4.setVisible(false);
                    hBox5.setVisible(false);
                    hBox6.setVisible(false);
                    hBox7.setVisible(false);
                }
            }
        });
        
        //update the information of the room after modify
        roomEditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameString = roomNumField.getText();
                int priceInt = Integer.parseInt(roomPriceEditJTextField.getText());
                String typeString = roomTypeEditBox.getSelectedItem().toString();
                int capacity = Integer.parseInt(roomCapacityEditBox.getSelectedItem().toString());
                int wifiInt = roomWifiEditCheckBox.isSelected() ? 1 : 0;
                int windowInt = roomWindowEditCheckBox.isSelected() ? 1 : 0;
                int breakfastInt = roomBreakfastEditCheckBox.isSelected() ? 1 : 0;
                int validInt = roomValidEditCheckBox.isSelected() ? 1 : 0;
                DBUtil.editRoomInformation(nameString, priceInt, typeString, capacity, wifiInt, windowInt, breakfastInt, validInt);
                JOptionPane.showMessageDialog(hBox5, "Edited successfully!");
            }
        });
        
        this.add(Box.createVerticalStrut(78));
        this.add(hBox1);
        this.add(Box.createVerticalStrut(160));
        this.add(hBox4);
        this.add(Box.createVerticalStrut(30));
        this.add(hBox5);
        this.add(Box.createVerticalStrut(30));
        this.add(hBox6);
        this.add(Box.createVerticalStrut(30));
        this.add(hBox7);
        this.add(Box.createVerticalStrut(30));
        this.add(hBoxHint);
    }
    
}
