/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhh_hotelbookingsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 *
 * @author Honghui Zhang
 */
public class LoginInterface {
    
    JFrame jf = new JFrame("Hotel Booking System");
    
    final int WIDTH = 1440;
    final int HEIGHT = 800;
    
    public void init() throws Exception{
        //Get screen width: Toolkit.getDefaultToolkit().getScreenSize().width
        //Get screen height: Toolkit.getDefaultToolkit().getScreenSize().height
        jf.setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - WIDTH)/2, (Toolkit.getDefaultToolkit().getScreenSize().height - HEIGHT)/2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Font loginFont = new Font("Dialog", 1, 16);
        
        BackgroundPanel bgPanel = new BackgroundPanel(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
        BackgroundPanel bgPanelForRegister = new BackgroundPanel(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
        
        JLabel usernameJLabel = new JLabel("Username");
        usernameJLabel.setFont(loginFont);
        usernameJLabel.setForeground(Color.white);
        JLabel passwordJLabel = new JLabel("Password");
        passwordJLabel.setFont(loginFont);
        passwordJLabel.setForeground(Color.white);
        JLabel genderLoginJLabel = new JLabel("Identity");
        genderLoginJLabel.setFont(loginFont);
        genderLoginJLabel.setForeground(Color.white);
        
        JLabel usernameJLabel_register = new JLabel("Username");
        usernameJLabel_register.setFont(loginFont);
        usernameJLabel_register.setForeground(Color.white);
        JLabel passwordJLabel_register = new JLabel("Password");
        passwordJLabel_register.setFont(loginFont);
        passwordJLabel_register.setForeground(Color.white);
        JLabel idnumberJLabel_register = new JLabel("ID number");
        idnumberJLabel_register.setFont(loginFont);
        idnumberJLabel_register.setForeground(Color.white);
        JLabel identityJLabel_register = new JLabel("Identity");
        identityJLabel_register.setFont(loginFont);
        identityJLabel_register.setForeground(Color.white);
        
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);
        
        JTextField usernameField_register = new JTextField(20);
        JTextField passwordField_register = new JTextField(20);
        JTextField idnumberField_register = new JTextField(20);
        
        ButtonGroup genderGroup = new ButtonGroup();
        JRadioButton client = new JRadioButton("Client");
        client.setFont(loginFont);
        client.setForeground(Color.white);
        JRadioButton admin = new JRadioButton("Admin");
        admin.setFont(loginFont);
        admin.setForeground(Color.white);
        genderGroup.add(client);
        genderGroup.add(admin);
        
        
        
        ButtonGroup genderGroupLogin = new ButtonGroup();
        JRadioButton client_login = new JRadioButton("Client");
        client_login.setFont(loginFont);
        client_login.setForeground(Color.white);
        JRadioButton admin_login = new JRadioButton("Admin");
        admin_login.setFont(loginFont);
        admin_login.setForeground(Color.white);
        genderGroupLogin.add(client_login);
        genderGroupLogin.add(admin_login);
        
        Box vBox = Box.createVerticalBox();
        Box vBoxForRegister = Box.createVerticalBox();
        
        Box uBox_register = Box.createHorizontalBox();
        uBox_register.add(usernameJLabel_register);
        uBox_register.add(Box.createHorizontalStrut(20));
        uBox_register.add(usernameField_register);
        
        Box pBox_register = Box.createHorizontalBox();
        pBox_register.add(passwordJLabel_register);
        pBox_register.add(Box.createHorizontalStrut(20));
        pBox_register.add(passwordField_register);
        
        Box idBox_register = Box.createHorizontalBox();
        idBox_register.add(idnumberJLabel_register);
        idBox_register.add(Box.createHorizontalStrut(20));
        idBox_register.add(idnumberField_register);
        
        Box genderBox_register = Box.createHorizontalBox();
        genderBox_register.add(identityJLabel_register);
        genderBox_register.add(Box.createHorizontalStrut(42));
        genderBox_register.add(client);
        genderBox_register.add(Box.createHorizontalStrut(20));
        genderBox_register.add(admin);
        genderBox_register.add(Box.createHorizontalStrut(80));
        
        Box inviteBox = Box.createHorizontalBox();
        JLabel inviteCodeJLabel_register = new JLabel("Invite Code");
        inviteCodeJLabel_register.setFont(loginFont);
        inviteCodeJLabel_register.setForeground(Color.white);
        JTextField inviteCodeField_register = new JTextField(20);
        inviteBox.add(inviteCodeJLabel_register);
        inviteBox.add(Box.createHorizontalStrut(20));
        inviteBox.add(inviteCodeField_register);
        inviteBox.setVisible(false);
        
        Box btnBox_register = Box.createHorizontalBox();
        JButton backButton = new JButton("Back");
        JButton submitButton = new JButton("Submit");
        
        backButton.setForeground(Color.gray);
        backButton.setBackground(Color.lightGray);
        backButton.setFont(loginFont);
        
        submitButton.setForeground(Color.gray);
        submitButton.setBackground(Color.lightGray);
        submitButton.setFont(loginFont);
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bgPanelForRegister.setVisible(false);
                bgPanel.setVisible(true);
            }
        });
        
        //Register submission listener
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField_register.getText().trim();
                String password = passwordField_register.getText().trim();
                String idnumber = idnumberField_register.getText().trim();
                if (username.equals("")) {
                    JOptionPane.showMessageDialog(jf, "Account number cannot be empty! ");
                    return;
                }
                if (password.equals("")) {
                    JOptionPane.showMessageDialog(jf, "Password cannot be empty! ");
                    return;
                }
                if (idnumber.equals("")) {
                    JOptionPane.showMessageDialog(jf, "ID number cannot be empty! ");
                    return;
                }
                if (!client.isSelected() && !admin.isSelected()) {
                    JOptionPane.showMessageDialog(jf, "Identity must be selected! ");
                    return;
                }
                if (!username.equals("") && !password.equals("") && !idnumber.equals("") && (client.isSelected() || admin.isSelected())) {
                    if (admin.isSelected()) {
                        String code = inviteCodeField_register.getText();
                        if (code.equals("666888")) {
                            //registerUser(String username, String password, String IDnumber, int identity, String roomID)
                            String usernameDB = usernameField_register.getText();
                            String passwordDB = passwordField_register.getText();
                            String idnumberDB = idnumberField_register.getText();
                            int identityDB = 1;
                            DBUtil.registerUser(usernameDB, passwordDB, idnumberDB, identityDB, "");
                            JOptionPane.showMessageDialog(jf, "Account registration successful!");
                            bgPanelForRegister.setVisible(false);
                            bgPanel.setVisible(true);
                            usernameField.setText(username);
                        }else {
                            JOptionPane.showMessageDialog(jf, "Invitation code error!");
                        }
                    }
                    if (client.isSelected()) {
                        String usernameDB = usernameField_register.getText();
                        String passwordDB = passwordField_register.getText();
                        String idnumberDB = idnumberField_register.getText();
                        int identityDB = 0;
                        DBUtil.registerUser(usernameDB, passwordDB, idnumberDB, identityDB, "");
                        JOptionPane.showMessageDialog(jf, "Account registration successful!");
                        bgPanelForRegister.setVisible(false);
                        bgPanel.setVisible(true);
                        usernameField.setText(username);
                    }
                }
            }
        });
        
        btnBox_register.add(backButton);
        btnBox_register.add(Box.createHorizontalStrut(160));
        btnBox_register.add(submitButton);
        
        vBoxForRegister.add(Box.createVerticalStrut(270));
        vBoxForRegister.add(uBox_register);
        vBoxForRegister.add(Box.createVerticalStrut(20));
        vBoxForRegister.add(pBox_register);
        vBoxForRegister.add(Box.createVerticalStrut(20));
        vBoxForRegister.add(idBox_register);
        vBoxForRegister.add(Box.createVerticalStrut(20));
        vBoxForRegister.add(genderBox_register);
        vBoxForRegister.add(Box.createVerticalStrut(20));
        vBoxForRegister.add(inviteBox);
        vBoxForRegister.add(Box.createVerticalStrut(20));
        vBoxForRegister.add(btnBox_register);
        
        
        bgPanelForRegister.add(vBoxForRegister);
        
        Box uBox = Box.createHorizontalBox();
        uBox.add(usernameJLabel);
        uBox.add(Box.createHorizontalStrut(20));
        uBox.add(usernameField);
        
        Box pBox = Box.createHorizontalBox();
        pBox.add(passwordJLabel);
        pBox.add(Box.createHorizontalStrut(20));
        pBox.add(passwordField);
        
        Box genderBox_login = Box.createHorizontalBox();
        genderBox_login.add(genderLoginJLabel);
        genderBox_login.add(Box.createHorizontalStrut(42));
        genderBox_login.add(client_login);
        genderBox_login.add(Box.createHorizontalStrut(20));
        genderBox_login.add(admin_login);
        genderBox_login.add(Box.createHorizontalStrut(80));
        
        Box btnBox = Box.createHorizontalBox();
        JButton loginBtn = new JButton("Login");
        JButton registeBtn = new JButton("Register");
        
        loginBtn.setForeground(Color.gray);
        loginBtn.setBackground(Color.lightGray);
        loginBtn.setFont(loginFont);
        
        registeBtn.setForeground(Color.gray);
        registeBtn.setBackground(Color.lightGray);
        registeBtn.setFont(loginFont);
        
        //Login listener
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = String.valueOf(passwordField.getPassword());
                if (username.equals("")) {
                    JOptionPane.showMessageDialog(jf, "Account number cannot be empty! ", "Tips", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (password.equals("")) {
                    JOptionPane.showMessageDialog(jf, "Password cannot be empty! ", "Tips", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (!client_login.isSelected() && !admin_login.isSelected()) {
                    JOptionPane.showMessageDialog(jf, "Identity must be selected! ", "Tips", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                if (!username.equals("") && !password.equals("") && (client_login.isSelected() || admin_login.isSelected())) {
                    //loginAuthentication(String usernameString, String passwordString, int identity)
                    String usernameDB = usernameField.getText();
                    String passwordDB = String.valueOf(passwordField.getPassword());
                    int identityDB = 0;
                    if (client_login.isSelected()) {
                        identityDB = 0;
                    }
                    if (admin_login.isSelected()) {
                        identityDB = 1;
                    }
                    if (DBUtil.loginAuthentication(usernameDB, passwordDB, identityDB)) {
                        //Login success
                        jf.dispose();
                        if (admin_login.isSelected()) {
                            new AdminInterface().init();
                        }else if(client_login.isSelected()){
                            new CustomerInterface().init();
                        }
                    }else {
                        JOptionPane.showMessageDialog(jf, "Wrong account or password！", "Tips", JOptionPane.INFORMATION_MESSAGE);
                        System.out.println(passwordField.getPassword());
                    }
                }
            }
        });
        
        registeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bgPanel.setVisible(false);
                jf.add(bgPanelForRegister);
                bgPanelForRegister.setVisible(true);
                SwingUtilities.updateComponentTreeUI(jf);
            }
        });
        
        admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (admin.isSelected()) {
                    inviteBox.setVisible(true);
                }else{
                    inviteBox.setVisible(false);
                }
            }
        });
        
        client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (client.isSelected()) {
                    inviteBox.setVisible(false);
                }else{
                    inviteBox.setVisible(true);
                }
            }
        });
        
        btnBox.add(loginBtn);
        btnBox.add(Box.createHorizontalStrut(160));
        btnBox.add(registeBtn);
        
        
        vBox.add(Box.createVerticalStrut(300));
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(genderBox_login);
        vBox.add(Box.createVerticalStrut(30));
        vBox.add(btnBox);
        
        bgPanel.add(vBox);
        
        jf.add(bgPanel);
        
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        SwingUtilities.updateComponentTreeUI(jf);
        
        jf.setVisible(true);
    }
    
    public static void main(String[] args) throws Exception {
        new LoginInterface().init();
    }
}
