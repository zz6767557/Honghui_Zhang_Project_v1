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
import javax.swing.*;

/**
 *
 * @author Honghui Zhang
 */
public class CheckOut extends Box{
    
    private Font font;
    
    public CheckOut(){
        super(BoxLayout.Y_AXIS);
        
        font = new Font("Dialog", 1, 16);
        
        Box hBox1 = Box.createHorizontalBox();
        JLabel roomNumberJLabel = new JLabel("Room Number");
        roomNumberJLabel.setFont(font);
        roomNumberJLabel.setForeground(Color.WHITE);
        JTextField roomNumberJTextField = new JTextField(10);
        roomNumberJTextField.setText("Example:1001");
        roomNumberJTextField.setForeground(Color.gray);
        roomNumberJTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (roomNumberJTextField.getText().equals("Example:1001")) {
                    roomNumberJTextField.setText("");
                    roomNumberJTextField.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (roomNumberJTextField.getText().equals("")) {
                    roomNumberJTextField.setText("Example:1001");
                    roomNumberJTextField.setForeground(Color.gray);
                }
            }
        });

        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(roomNumberJLabel);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(roomNumberJTextField);
        
        Box hBox6 = Box.createHorizontalBox();
        JButton submit = new JButton("Check-Out");
        hBox6.add(submit);
        
        
        //Monitor the check-out button to complete the database operation of customer check-out
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DBUtil.checkRoomHaveGuest(roomNumberJTextField.getText())) {
                    DBUtil.checkOutUser(roomNumberJTextField.getText());
                    JOptionPane.showMessageDialog(hBox6, "Check out success!");
                    roomNumberJTextField.setText("");
                }else {
                    JOptionPane.showMessageDialog(hBox6, "There is no guest in this room, please check the room number!");
                    roomNumberJTextField.setText("");
                }
            }
        });
        
        this.add(Box.createVerticalStrut(80));
        this.add(hBox1);
        this.add(Box.createVerticalStrut(260));
        this.add(hBox6);
    }
    
}
