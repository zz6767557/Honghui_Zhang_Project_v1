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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author Honghui Zhang
 */
public class CheckIn extends Box{
    
    private Font font;
    
    public CheckIn(){
        super(BoxLayout.Y_AXIS);
        
        font = new Font("Dialog", 1, 16);
        
        Box hBox1 = Box.createHorizontalBox();
        JLabel roomNumberJLabel = new JLabel("Room Number");
        roomNumberJLabel.setFont(font);
        roomNumberJLabel.setForeground(Color.WHITE);
        JTextField roomNumberField = new JTextField(10);
        roomNumberField.setText("Example:1001");
        roomNumberField.setForeground(Color.gray);
        roomNumberField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (roomNumberField.getText().equals("Example:1001")) {
                    roomNumberField.setText("");
                    roomNumberField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (roomNumberField.getText().equals("")) {
                    roomNumberField.setText("Example:1001");
                    roomNumberField.setForeground(Color.gray);
                }
            }
        });
        JLabel checkInTimeJLabel = new JLabel("Check-in time");
        checkInTimeJLabel.setFont(font);
        checkInTimeJLabel.setForeground(Color.WHITE);
        JTextField checkInTimeField = new JTextField(10);
        checkInTimeField.setText("Example:2020/09/10");
        checkInTimeField.setForeground(Color.gray);
        JLabel lineJLabel = new JLabel("-");
        lineJLabel.setFont(font);
        lineJLabel.setForeground(Color.WHITE);
        JTextField checkOutTimeField = new JTextField(10);
        checkOutTimeField.setText("Example:2020/09/13");
        checkOutTimeField.setForeground(Color.gray);
        JLabel numberJLabel = new JLabel("The number of people");
        numberJLabel.setFont(font);
        numberJLabel.setForeground(Color.WHITE);
        JComboBox<String> numberBox = new JComboBox<>();
        numberBox.addItem("1");
        numberBox.addItem("2");
        numberBox.addItem("3");
        numberBox.addItem("4");
        
        checkInTimeField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (checkInTimeField.getText().equals("Example:2020/09/10")) {
                    checkInTimeField.setText("");
                    checkInTimeField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (checkInTimeField.getText().equals("")) {
                    checkInTimeField.setText("Example:2020/09/10");
                    checkInTimeField.setForeground(Color.gray);
                }
            }
        });
        
        checkOutTimeField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (checkOutTimeField.getText().equals("Example:2020/09/13")) {
                    checkOutTimeField.setText("");
                    checkOutTimeField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (checkOutTimeField.getText().equals("")) {
                    checkOutTimeField.setText("Example:2020/09/13");
                    checkOutTimeField.setForeground(Color.gray);
                }
            }
        });
        
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(roomNumberJLabel);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(roomNumberField);
        hBox1.add(Box.createHorizontalStrut(30));
        hBox1.add(checkInTimeJLabel);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(checkInTimeField);
        hBox1.add(Box.createHorizontalStrut(5));
        hBox1.add(lineJLabel);
        hBox1.add(Box.createHorizontalStrut(5));
        hBox1.add(checkOutTimeField);
        hBox1.add(Box.createHorizontalStrut(30));
        hBox1.add(numberJLabel);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(numberBox);
        
        Box hBox2 = Box.createHorizontalBox();
        JLabel guestName1JLabel = new JLabel("Name of Customer 1");
        guestName1JLabel.setFont(font);
        guestName1JLabel.setForeground(Color.WHITE);
        JTextField guestName1JTextField = new JTextField(10);
        JLabel guestID1JLabel = new JLabel("ID of Customer 1");
        guestID1JLabel.setFont(font);
        guestID1JLabel.setForeground(Color.WHITE);
        JTextField guestID1JTextField = new JTextField(15);
        JLabel guestContact1JLabel = new JLabel("Contact of Customer 1");
        guestContact1JLabel.setFont(font);
        guestContact1JLabel.setForeground(Color.WHITE);
        JTextField guestContact1JTextField = new JTextField(10);
        hBox2.add(Box.createHorizontalStrut(20));
        hBox2.add(guestName1JLabel);
        hBox2.add(Box.createHorizontalStrut(10));
        hBox2.add(guestName1JTextField);
        hBox2.add(Box.createHorizontalStrut(20));
        hBox2.add(guestID1JLabel);
        hBox2.add(Box.createHorizontalStrut(10));
        hBox2.add(guestID1JTextField);
        hBox2.add(Box.createHorizontalStrut(20));
        hBox2.add(guestContact1JLabel);
        hBox2.add(Box.createHorizontalStrut(10));
        hBox2.add(guestContact1JTextField);
        
        Box hBox3 = Box.createHorizontalBox();
        JLabel guestName2JLabel = new JLabel("Name of Customer 2");
        guestName2JLabel.setFont(font);
        guestName2JLabel.setForeground(Color.WHITE);
        JTextField guestName2JTextField = new JTextField(10);
        JLabel guestID2JLabel = new JLabel("ID of Customer 2");
        guestID2JLabel.setFont(font);
        guestID2JLabel.setForeground(Color.WHITE);
        JTextField guestID2JTextField = new JTextField(15);
        JLabel guestContact2JLabel = new JLabel("Contact of Customer 2");
        guestContact2JLabel.setFont(font);
        guestContact2JLabel.setForeground(Color.WHITE);
        JTextField guestContact2JTextField = new JTextField(10);
        hBox3.add(Box.createHorizontalStrut(20));
        hBox3.add(guestName2JLabel);
        hBox3.add(Box.createHorizontalStrut(10));
        hBox3.add(guestName2JTextField);
        hBox3.add(Box.createHorizontalStrut(20));
        hBox3.add(guestID2JLabel);
        hBox3.add(Box.createHorizontalStrut(10));
        hBox3.add(guestID2JTextField);
        hBox3.add(Box.createHorizontalStrut(20));
        hBox3.add(guestContact2JLabel);
        hBox3.add(Box.createHorizontalStrut(10));
        hBox3.add(guestContact2JTextField);
        hBox3.setVisible(false);
        
        Box hBox4 = Box.createHorizontalBox();
        JLabel guestName3JLabel = new JLabel("Name of Customer 3");
        guestName3JLabel.setFont(font);
        guestName3JLabel.setForeground(Color.WHITE);
        JTextField guestName3JTextField = new JTextField(10);
        JLabel guestID3JLabel = new JLabel("ID of Customer 3");
        guestID3JLabel.setFont(font);
        guestID3JLabel.setForeground(Color.WHITE);
        JTextField guestID3JTextField = new JTextField(15);
        JLabel guestContact3JLabel = new JLabel("Contact of Customer 3");
        guestContact3JLabel.setFont(font);
        guestContact3JLabel.setForeground(Color.WHITE);
        JTextField guestContact3JTextField = new JTextField(10);
        hBox4.add(Box.createHorizontalStrut(20));
        hBox4.add(guestName3JLabel);
        hBox4.add(Box.createHorizontalStrut(10));
        hBox4.add(guestName3JTextField);
        hBox4.add(Box.createHorizontalStrut(20));
        hBox4.add(guestID3JLabel);
        hBox4.add(Box.createHorizontalStrut(10));
        hBox4.add(guestID3JTextField);
        hBox4.add(Box.createHorizontalStrut(20));
        hBox4.add(guestContact3JLabel);
        hBox4.add(Box.createHorizontalStrut(10));
        hBox4.add(guestContact3JTextField);
        hBox4.setVisible(false);
        
        Box hBox5 = Box.createHorizontalBox();
        JLabel guestName4JLabel = new JLabel("Name of Customer 4");
        guestName4JLabel.setFont(font);
        guestName4JLabel.setForeground(Color.WHITE);
        JTextField guestName4JTextField = new JTextField(10);
        JLabel guestID4JLabel = new JLabel("ID of Customer 4");
        guestID4JLabel.setFont(font);
        guestID4JLabel.setForeground(Color.WHITE);
        JTextField guestID4JTextField = new JTextField(15);
        JLabel guestContact4JLabel = new JLabel("Contact of Customer 4");
        guestContact4JLabel.setFont(font);
        guestContact4JLabel.setForeground(Color.WHITE);
        JTextField guestContact4JTextField = new JTextField(10);
        hBox5.add(Box.createHorizontalStrut(20));
        hBox5.add(guestName4JLabel);
        hBox5.add(Box.createHorizontalStrut(10));
        hBox5.add(guestName4JTextField);
        hBox5.add(Box.createHorizontalStrut(20));
        hBox5.add(guestID4JLabel);
        hBox5.add(Box.createHorizontalStrut(10));
        hBox5.add(guestID4JTextField);
        hBox5.add(Box.createHorizontalStrut(20));
        hBox5.add(guestContact4JLabel);
        hBox5.add(Box.createHorizontalStrut(10));
        hBox5.add(guestContact4JTextField);
        hBox5.setVisible(false);
        
        Box hBox6 = Box.createHorizontalBox();
        JButton submit = new JButton("Check-In");
        hBox6.add(submit);
        
        numberBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                int i = numberBox.getSelectedIndex();
                switch(i){
                    case 0:
                        hBox3.setVisible(false);
                        hBox4.setVisible(false);
                        hBox5.setVisible(false); 
                        break;
                    case 1:
                        hBox3.setVisible(true);
                        hBox4.setVisible(false);
                        hBox5.setVisible(false); 
                        break;
                    case 2:
                        hBox3.setVisible(true);
                        hBox4.setVisible(true);
                        hBox5.setVisible(false); 
                        break;
                    case 3:
                        hBox3.setVisible(true);
                        hBox4.setVisible(true);
                        hBox5.setVisible(true); 
                        break;
                }
            }
        });
        
        //Monitor the check-in button to complete the database operation of customer check-in
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DBUtil.checkRoomExist(roomNumberField.getText())) {
                    String roomNum = roomNumberField.getText();
                    int number = numberBox.getSelectedIndex() + 1;
                    if (number == 1) {
                        if (DBUtil.checkUserExist(guestID1JTextField.getText())) {
                            DBUtil.checkInUser(guestID1JTextField.getText(), roomNum);
                        }else {
                            //registerUser(String username, String password, String IDnumber, int Hotelidentity, String roomID)
                            DBUtil.registerUser(guestContact1JTextField.getText(), "123456", guestID1JTextField.getText(), 0, roomNum);
                        }
                    }else if (number == 2) {
                        if (DBUtil.checkUserExist(guestID1JTextField.getText())) {
                            DBUtil.checkInUser(guestID1JTextField.getText(), roomNum);
                        }else {
                            DBUtil.registerUser(guestContact1JTextField.getText(), "123456", guestID1JTextField.getText(), 0, roomNum);
                        }
                        if (DBUtil.checkUserExist(guestID2JTextField.getText())) {
                            DBUtil.checkInUser(guestID2JTextField.getText(), roomNum);
                        }else {
                            DBUtil.registerUser(guestContact2JTextField.getText(), "123456", guestID2JTextField.getText(), 0, roomNum);
                        }
                    }else if (number == 3) {
                        if (DBUtil.checkUserExist(guestID1JTextField.getText())) {
                            DBUtil.checkInUser(guestID1JTextField.getText(), roomNum);
                        }else {
                            DBUtil.registerUser(guestContact1JTextField.getText(), "123456", guestID1JTextField.getText(), 0, roomNum);
                        }
                        if (DBUtil.checkUserExist(guestID2JTextField.getText())) {
                            DBUtil.checkInUser(guestID2JTextField.getText(), roomNum);
                        }else {
                            DBUtil.registerUser(guestContact2JTextField.getText(), "123456", guestID2JTextField.getText(), 0, roomNum);
                        }
                        if (DBUtil.checkUserExist(guestID3JTextField.getText())) {
                            DBUtil.checkInUser(guestID3JTextField.getText(), roomNum);
                        }else {
                            DBUtil.registerUser(guestContact3JTextField.getText(), "123456", guestID3JTextField.getText(), 0, roomNum);
                        }
                    }else if (number == 4) {
                        if (DBUtil.checkUserExist(guestID1JTextField.getText())) {
                            DBUtil.checkInUser(guestID1JTextField.getText(), roomNum);
                        }else {
                            DBUtil.registerUser(guestContact1JTextField.getText(), "123456", guestID1JTextField.getText(), 0, roomNum);
                        }
                        if (DBUtil.checkUserExist(guestID2JTextField.getText())) {
                            DBUtil.checkInUser(guestID2JTextField.getText(), roomNum);
                        }else {
                            DBUtil.registerUser(guestContact2JTextField.getText(), "123456", guestID2JTextField.getText(), 0, roomNum);
                        }
                        if (DBUtil.checkUserExist(guestID3JTextField.getText())) {
                            DBUtil.checkInUser(guestID3JTextField.getText(), roomNum);
                        }else {
                            DBUtil.registerUser(guestContact3JTextField.getText(), "123456", guestID3JTextField.getText(), 0, roomNum);
                        }
                        if (DBUtil.checkUserExist(guestID4JTextField.getText())) {
                            DBUtil.checkInUser(guestID4JTextField.getText(), roomNum);
                        }else {
                            DBUtil.registerUser(guestContact4JTextField.getText(), "123456", guestID4JTextField.getText(), 0, roomNum);
                        }
                    }
                    JOptionPane.showMessageDialog(hBox1, "Check in success!");
                }else {
                    JOptionPane.showMessageDialog(hBox1, "This room doesn't exist!");
                }
            }
        });
        
        this.add(Box.createVerticalStrut(80));
        this.add(hBox1);
        this.add(Box.createVerticalStrut(140));
        this.add(hBox2);
        this.add(Box.createVerticalStrut(30));
        this.add(hBox3);
        this.add(Box.createVerticalStrut(30));
        this.add(hBox4);
        this.add(Box.createVerticalStrut(30));
        this.add(hBox5);
        this.add(Box.createVerticalStrut(30));
        this.add(hBox6);
    }
    
}
