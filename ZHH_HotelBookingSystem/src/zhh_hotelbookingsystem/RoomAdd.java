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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Honghui Zhang
 */
public class RoomAdd extends Box{
    
    final int WIDTH = 1216;
    final int HEIGHT = 728;
    
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableDate;
    private DefaultTableModel tableModel;
    private Font font;
    
    public RoomAdd(){
        super(BoxLayout.Y_AXIS);
        
        font = new Font("Dialog", 1, 16);
        
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
        JLabel roomFloorJLabel = new JLabel("Room Floor");
        roomFloorJLabel.setFont(font);
        roomFloorJLabel.setForeground(Color.white);
        JComboBox<String> floorSelect = new JComboBox<>();
        floorSelect.addItem("1");
        floorSelect.addItem("2");
        floorSelect.addItem("3");
        floorSelect.addItem("4");
        floorSelect.addItem("5");
        floorSelect.addItem("6");
        JLabel roomType = new JLabel("Room Type");
        roomType.setFont(font);
        roomType.setForeground(Color.white);
        JComboBox<String> roomTypeSelect = new JComboBox<>();
        roomTypeSelect.addItem("Standerd Room");
        roomTypeSelect.addItem("Deluxe Room");
        roomTypeSelect.addItem("Business Room");
        roomTypeSelect.addItem("Executive Room");
        roomTypeSelect.addItem("Family Room");
        roomTypeSelect.addItem("Presidential Suite");
        JLabel roomPrice = new JLabel("Price($)/1 day");
        roomPrice.setFont(font);
        roomPrice.setForeground(Color.white);
        JTextField roomPriceField = new JTextField(10);
        roomPriceField.setText("Range:69 - 999");
        roomPriceField.setForeground(Color.gray);
        roomPriceField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (roomPriceField.getText().equals("Range:69 - 999")) {
                    roomPriceField.setText("");
                    roomPriceField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (roomPriceField.getText().equals("")) {
                    roomPriceField.setText("Range:69 - 999");
                    roomPriceField.setForeground(Color.gray);
                }
            }
        });
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(roomNumJLabel);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(roomNumField);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(roomFloorJLabel);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(floorSelect);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(roomType);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(roomTypeSelect);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(roomPrice);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(roomPriceField);
        
        Box hBox2 = Box.createHorizontalBox();
        JLabel roomWifiJLabel = new JLabel("Wi-Fi?");
        roomWifiJLabel.setFont(font);
        roomWifiJLabel.setForeground(Color.white);
        JCheckBox haveWifiBox = new JCheckBox();
        JLabel roomWindowJLabel = new JLabel("Window?");
        roomWindowJLabel.setFont(font);
        roomWindowJLabel.setForeground(Color.white);
        JCheckBox haveWindowBox = new JCheckBox();
        JLabel roomBreakfastJLabel = new JLabel("Breakfast?");
        roomBreakfastJLabel.setFont(font);
        roomBreakfastJLabel.setForeground(Color.white);
        JCheckBox haveBreakfastBox = new JCheckBox();
        JLabel roomCapacity = new JLabel("Capacity");
        roomCapacity.setFont(font);
        roomCapacity.setForeground(Color.white);
        JComboBox<String> capacitySelect = new JComboBox<>();
        capacitySelect.addItem("1");
        capacitySelect.addItem("2");
        capacitySelect.addItem("3");
        capacitySelect.addItem("4");
        JButton addRoomButton = new JButton("Add");
        hBox2.add(Box.createHorizontalStrut(20));
        hBox2.add(roomWifiJLabel);
        hBox2.add(Box.createHorizontalStrut(10));
        hBox2.add(haveWifiBox);
        hBox2.add(Box.createHorizontalStrut(40));
        hBox2.add(roomWindowJLabel);
        hBox2.add(Box.createHorizontalStrut(10));
        hBox2.add(haveWindowBox);
        hBox2.add(Box.createHorizontalStrut(40));
        hBox2.add(roomBreakfastJLabel);
        hBox2.add(Box.createHorizontalStrut(10));
        hBox2.add(haveBreakfastBox);
        hBox2.add(Box.createHorizontalStrut(40));
        hBox2.add(roomCapacity);
        hBox2.add(Box.createHorizontalStrut(10));
        hBox2.add(capacitySelect);
        hBox2.add(Box.createHorizontalStrut(40));
        hBox2.add(addRoomButton);
        
        String[] ts = {"Room Number", "Floor", "Room Type", "Price", "Wi-Fi", "Window", "Breakfast", "Capacity", "Valid"};
        titles = new Vector<>();
        for (String t : ts) {
            titles.add(t);
        }

        tableDate = DBUtil.searchAllRoom();
        
        tableModel = new DefaultTableModel(tableDate, titles);
        table = new JTable(tableModel);
        table.setDragEnabled(false);
        table.setEnabled(false);
        
        Box hBox3 = Box.createHorizontalBox();
        hBox3.add(Box.createHorizontalStrut(20));
        JScrollPane js = new JScrollPane(table);
        Color transparentColor = new Color(255, 255, 255, 50);
        js.getViewport().setBackground(transparentColor);
        hBox3.add(js);
        
        //Add the room information to the database
        addRoomButton.addActionListener(new ActionListener() {
            //(RoomID VARCHAR(50),Floor INT,RoomType VARCHAR(50),Price INT,Wifi INT,HotelWindow INT,Breakfast INT,Capacity INT,Valid INT)
            @Override
            public void actionPerformed(ActionEvent e) {
                String newRoomNumberString = roomNumField.getText();
                int newRoomFloor = Integer.parseInt(floorSelect.getSelectedItem().toString());
                String newRoomTypeString = roomTypeSelect.getSelectedItem().toString();
                int newRoomWifi = (haveWifiBox.isSelected()) ? 1 : 0;
                int newRoomWindow = (haveWindowBox.isSelected()) ? 1 : 0;
                int newRoomBreakfast = (haveBreakfastBox.isSelected()) ? 1 : 0;
                int newRoomCapacity = Integer.parseInt(capacitySelect.getSelectedItem().toString());
                if (newRoomNumberString.equals("Example:1001") || roomPriceField.getText().equals("Range:69 - 999")) {
                    JOptionPane.showMessageDialog(hBox3, "Room number or price not entered!");
                }else {
                    if (DBUtil.checkRoomExist(newRoomNumberString)) {
                        JOptionPane.showMessageDialog(hBox3, "The room already exists!");
                    }else {
                            int newRoomPrice = Integer.parseInt(roomPriceField.getText());
                            DBUtil.addRoom(newRoomNumberString, newRoomFloor, newRoomTypeString, newRoomPrice, newRoomWifi, newRoomWindow, newRoomBreakfast, newRoomCapacity);
                            JOptionPane.showMessageDialog(hBox1, "Data added successfully!");
                            roomNumField.setText("");
                            floorSelect.setSelectedIndex(0);
                            roomTypeSelect.setSelectedIndex(0);
                            roomPriceField.setText("");
                            haveWifiBox.setSelected(false);
                            haveWindowBox.setSelected(false);
                            haveBreakfastBox.setSelected(false);
                            capacitySelect.setSelectedIndex(0);
                            tableDate.clear();
                            tableDate = DBUtil.searchAllRoom();
                            tableModel.getDataVector().clear();
                            tableModel.setDataVector(tableDate, titles);
                            tableModel.fireTableDataChanged();
                        }
                }
            }
        });
        
        this.add(Box.createVerticalStrut(50));
        this.add(hBox1);
        this.add(Box.createVerticalStrut(40));
        this.add(hBox2);
        this.add(Box.createVerticalStrut(100));
        this.add(hBox3);
        
    }
    
}
