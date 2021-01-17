/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhh_hotelbookingsystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Honghui Zhang
 */
public class CustomerInterface {
    
    JFrame jf = new JFrame("Hotel Booking System - Customer");
    
    final int WIDTH = 1440;
    final int HEIGHT = 800;
    
    public void init(){
        
        jf.setBounds((Toolkit.getDefaultToolkit().getScreenSize().width - WIDTH)/2, (Toolkit.getDefaultToolkit().getScreenSize().height - HEIGHT)/2, WIDTH, HEIGHT);
        jf.setResizable(false);
        
        JMenuBar menuBar = new JMenuBar();
        JMenu jMenu = new JMenu("Setting");
        JMenuItem changeAccount = new JMenuItem("Change Account");
        JMenuItem quit = new JMenuItem("Quit");
        
        changeAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf.dispose();
                try {
                    new LoginInterface().init();
                } catch (Exception ex) {
                    Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        jMenu.add(changeAccount);
        jMenu.add(quit);
        menuBar.add(jMenu);
        
        jf.setJMenuBar(menuBar);
        
        JSplitPane jSplitPane = new JSplitPane();
        jSplitPane.setContinuousLayout(true);
        jSplitPane.setDividerLocation(200);
        jSplitPane.setDividerSize(5);
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Hotel Information");
        DefaultMutableTreeNode aboutUs = new DefaultMutableTreeNode("About Us");
        DefaultMutableTreeNode standerdRoom = new DefaultMutableTreeNode("Standerd Room");
        DefaultMutableTreeNode deluxeRoom = new DefaultMutableTreeNode("Deluxe Room");
        DefaultMutableTreeNode businessRoom = new DefaultMutableTreeNode("Business Room");
        DefaultMutableTreeNode executiveRoom = new DefaultMutableTreeNode("Executive Room");
        DefaultMutableTreeNode familyRoom = new DefaultMutableTreeNode("Family Room");
        DefaultMutableTreeNode presidentialSuite = new DefaultMutableTreeNode("Presidential Suite");
        
        root.add(aboutUs);
        root.add(standerdRoom);
        root.add(deluxeRoom);
        root.add(businessRoom);
        root.add(executiveRoom);
        root.add(familyRoom);
        root.add(presidentialSuite);
        
        JTree tree = new JTree(root);
        tree.setSelectionRow(0);
        MyRenderer myRenderer = new MyRenderer();
        tree.setCellRenderer(myRenderer);
        tree.putClientProperty("JTree.lineStyle", "None");
        
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                Object lastPathComponent = e.getNewLeadSelectionPath().getLastPathComponent();
                
                if (root.equals(lastPathComponent)) {
                    BackGroundPanelWithoutRoundRect jp = null;
                    try {
                        jp = new BackGroundPanelWithoutRoundRect(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Box vBox = Box.createVerticalBox();
                    Box hBox = Box.createHorizontalBox();
                    JLabel welcome = new JLabel("Welcome, Hotel Booking System !");
                    welcome.setFont(new Font("Dialog", 1, 48));
                    welcome.setForeground(Color.white);
                    hBox.add(welcome);
                    vBox.add(Box.createVerticalStrut(240));
                    vBox.add(hBox);
                    jp.add(vBox);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(200);
                }
                
                if (aboutUs.equals(lastPathComponent)) {
                    AboutUsPane jp = null;
                    try {
                        jp = new AboutUsPane(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(200);
                }
                
                if (standerdRoom.equals(lastPathComponent)) {
                    StanderdRoomPane jp = null;
                    int validNumber = DBUtil.searchNumberOfSpecificRooms("Standerd Room");
                    try {
                        jp = new StanderdRoomPane(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")), 99, 199, validNumber);
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(200);
                }
                
                if (deluxeRoom.equals(lastPathComponent)) {
                    DeluxeAndBusinessRoom jp = null;
                    int validNumber = DBUtil.searchNumberOfSpecificRooms("Deluxe Room");
                    try {
                        jp = new DeluxeAndBusinessRoom(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")), "Deluxe Room", 199, 299, validNumber);
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(200);
                }
                
                if (businessRoom.equals(lastPathComponent)) {
                    DeluxeAndBusinessRoom jp = null;
                    int validNumber = DBUtil.searchNumberOfSpecificRooms("Business Room");
                    try {
                        jp = new DeluxeAndBusinessRoom(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")), "Business Room", 299, 399, validNumber);
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(200);
                }
                
                if (executiveRoom.equals(lastPathComponent)) {
                    ExecutiveAndFamilyAndPresidentialRoom jp = null;
                    int validNumber = DBUtil.searchNumberOfSpecificRooms("Executive Room");
                    try {
                        jp = new ExecutiveAndFamilyAndPresidentialRoom(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")), "Executive Room", 399, 499, validNumber);
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(200);
                }
                
                if (familyRoom.equals(lastPathComponent)) {
                    ExecutiveAndFamilyAndPresidentialRoom jp = null;
                    int validNumber = DBUtil.searchNumberOfSpecificRooms("Family Room");
                    try {
                        jp = new ExecutiveAndFamilyAndPresidentialRoom(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")), "Family Room", 499, 599, validNumber);
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(200);
                }
                
                if (presidentialSuite.equals(lastPathComponent)) {
                    ExecutiveAndFamilyAndPresidentialRoom jp = null;
                    int validNumber = DBUtil.searchNumberOfSpecificRooms("Presidential Suite");
                    try {
                        jp = new ExecutiveAndFamilyAndPresidentialRoom(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")), "Presidential Suite", 699, 799, validNumber);
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(200);
                }
            }
        });
        
        jSplitPane.setLeftComponent(tree);
        jSplitPane.setEnabled(false);
        
        
        BackGroundPanelWithoutRoundRect jp1 = null;
                    try {
                        jp1 = new BackGroundPanelWithoutRoundRect(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Box vBox1 = Box.createVerticalBox();
                    Box hBox1 = Box.createHorizontalBox();
                    JLabel welcome = new JLabel("Welcome, Hotel Booking System !");
                    welcome.setFont(new Font("Dialog", 1, 48));
                    welcome.setForeground(Color.white);
                    hBox1.add(welcome);
                    vBox1.add(Box.createVerticalStrut(240));
                    vBox1.add(hBox1);
                    jp1.add(vBox1);
                    jSplitPane.setRightComponent(jp1);
        
        
        jf.add(jSplitPane);
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(jf);
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    
    public static void main(String[] args) {
        new CustomerInterface().init();
    }
    
    private class MyRenderer extends DefaultTreeCellRenderer{
        private ImageIcon rootIcon = null;
        private ImageIcon bedIcon = null;
        
        public MyRenderer(){
            rootIcon = new ImageIcon("src/zhh_hotelbookingsystem/CustomerHotelIcon.png");
            bedIcon = new ImageIcon("src/zhh_hotelbookingsystem/HotelBed.png");
        }

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            ImageIcon image = null;
            if (value.toString().equals("Hotel Information")) {
                image = rootIcon;
            }else if(value.toString().equals("About Us")){
                image = rootIcon;
            }else {
                image = bedIcon;
            }
            
            this.setIcon(image);
            this.updateUI();
            return  this;//To change body of generated methods, choose Tools | Templates.
        }
    }    
}
