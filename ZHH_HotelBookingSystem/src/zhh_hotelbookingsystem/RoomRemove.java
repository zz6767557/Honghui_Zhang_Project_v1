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
public class RoomRemove extends Box{
    
    final int WIDTH = 1216;
    final int HEIGHT = 728;
    
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableDate;
    private DefaultTableModel tableModel;
    private Font font;

    public RoomRemove() {
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
        JButton search = new JButton("Search");
        hBox1.add(Box.createHorizontalStrut(279));
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(roomNumJLabel);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(roomNumField);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(search);
        hBox1.add(Box.createHorizontalStrut(280));
        
        JLabel messageJLabel = new JLabel("Are you sure you want to delete it?");
        messageJLabel.setFont(font);
        messageJLabel.setForeground(Color.white);
        JButton confirmButton = new JButton("YES");
        JButton cancelButton = new JButton("NO");
        Box hboxButton = Box.createHorizontalBox();
        hboxButton.add(messageJLabel);
        hboxButton.add(Box.createHorizontalStrut(20));
        hboxButton.add(confirmButton);
        hboxButton.add(Box.createHorizontalStrut(20));
        hboxButton.add(cancelButton);
        hboxButton.setVisible(false);
        
        Box gapBox = Box.createVerticalBox();
        gapBox.add(Box.createVerticalStrut(30));
        
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
        
        //search the room
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (roomNumField.getText().equals("Example:1001")) {
                    JOptionPane.showMessageDialog(hBox3, "Please input room number!");
                }else {
                    if (DBUtil.checkRoomExist(roomNumField.getText())) {
                        String searchRoomNumberString = roomNumField.getText();
                        tableDate.clear();
                        tableDate = DBUtil.searchOneRoom(searchRoomNumberString);
                        tableModel.getDataVector().clear();
                        tableModel.setDataVector(tableDate, titles);
                        tableModel.fireTableDataChanged();
                        gapBox.setVisible(false);
                        hboxButton.setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(hBox3, "Can't find the room!");
                    }
                }
            }
        });
        
        //delete the room
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBUtil.deleteOneRoom(roomNumField.getText());
                tableDate.clear();
                tableDate = DBUtil.searchAllRoom();
                tableModel.getDataVector().clear();
                tableModel.setDataVector(tableDate, titles);
                tableModel.fireTableDataChanged();
                gapBox.setVisible(true);
                hboxButton.setVisible(false);
                roomNumField.setText("");
                JOptionPane.showMessageDialog(hBox3, "Successfylly delete!");
            }
        });
        
        //cancle to delete it 
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableDate.clear();
                tableDate = DBUtil.searchAllRoom();
                tableModel.getDataVector().clear();
                tableModel.setDataVector(tableDate, titles);
                tableModel.fireTableDataChanged();
                gapBox.setVisible(true);
                hboxButton.setVisible(false);
                roomNumField.setText("");
            }
        });
        
        this.add(Box.createVerticalStrut(78));
        this.add(hBox1);
        this.add(gapBox);
        this.add(hboxButton);
        this.add(Box.createVerticalStrut(110));
        this.add(hBox3);
    }
    
}
