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
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Honghui Zhang
 */

//Management interface
public class AdminInterface {
    
    JFrame jf = new JFrame("Hotel Booking System - Administrator");
    
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
        
        //Assemble the left JTree
        JSplitPane jSplitPane = new JSplitPane();
        jSplitPane.setContinuousLayout(true);
        jSplitPane.setDividerLocation(205);
        jSplitPane.setDividerSize(5);
        
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Hotel Management");
        DefaultMutableTreeNode room = new DefaultMutableTreeNode("Room Management");
        DefaultMutableTreeNode roomAdd = new DefaultMutableTreeNode("Room Add");
        DefaultMutableTreeNode roomRemove = new DefaultMutableTreeNode("Room Remove");
        DefaultMutableTreeNode roomEdit = new DefaultMutableTreeNode("Room Edit");
        DefaultMutableTreeNode roomSearch = new DefaultMutableTreeNode("Room Sreach");
        DefaultMutableTreeNode personnel = new DefaultMutableTreeNode("Personnel Management");
        DefaultMutableTreeNode personnelAdd = new DefaultMutableTreeNode("Personnel Add");
        DefaultMutableTreeNode personnelRemove = new DefaultMutableTreeNode("Personnel Remove");
        DefaultMutableTreeNode personnelEdit = new DefaultMutableTreeNode("Personnel Edit");
        DefaultMutableTreeNode personnelSearch = new DefaultMutableTreeNode("Personnel Search");
        DefaultMutableTreeNode bookingManagement = new DefaultMutableTreeNode("Booking Management");
        DefaultMutableTreeNode checkIn = new DefaultMutableTreeNode("Check In");
        DefaultMutableTreeNode checkOut = new DefaultMutableTreeNode("Check Out");
        
        root.add(room);
        root.add(personnel);
        root.add(bookingManagement);
        
        room.add(roomAdd);
        room.add(roomRemove);
        room.add(roomEdit);
        room.add(roomSearch);
        
        personnel.add(personnelAdd);
        personnel.add(personnelRemove);
        personnel.add(personnelEdit);
        personnel.add(personnelSearch);
        
        bookingManagement.add(checkIn);
        bookingManagement.add(checkOut);
        
        Color color = new Color(222,221,229);
        Color color2 = new Color(185,185,193);
        JTree tree = new JTree(root);
        MyRenderer myRenderer = new MyRenderer();
        myRenderer.setBackgroundNonSelectionColor(color);
        myRenderer.setBackgroundSelectionColor(color2);
        tree.setCellRenderer(myRenderer);
        tree.putClientProperty("JTree.lineStyle", "None");
        tree.setBackground(color);
        
        tree.setSelectionRow(0);
        
        //Add a listener to the node of JTree to switch the right interface
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
                    jSplitPane.setDividerLocation(205);
                }
                
                if (room.equals(lastPathComponent)) {
                    BackGroundPanelWithoutRoundRect jp = null;
                    try {
                        jp = new BackGroundPanelWithoutRoundRect(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Box vBox = Box.createVerticalBox();
                    Box hBox = Box.createHorizontalBox();
                    JLabel welcome = new JLabel("Welcome, Room Management !");
                    welcome.setFont(new Font("Dialog", 1, 48));
                    welcome.setForeground(Color.white);
                    hBox.add(welcome);
                    vBox.add(Box.createVerticalStrut(240));
                    vBox.add(hBox);
                    jp.add(vBox);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(205);
                }
                if (roomAdd.equals(lastPathComponent)) {
                    BackgroungPaneRoomControl jp = null;
                    try {
                        jp = new BackgroungPaneRoomControl(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    RoomAdd roomAdd = new RoomAdd();
                    jp.add(roomAdd);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(205);
                }
                if (roomRemove.equals(lastPathComponent)) {
                    BackgroungPaneRoomControl jp = null;
                    try {
                        jp = new BackgroungPaneRoomControl(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    RoomRemove roomRemove = new RoomRemove();
                    jp.add(roomRemove);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(205);
                }
                if (roomEdit.equals(lastPathComponent)) {
                    BackgroungPaneRoomControl jp = null;
                    try {
                        jp = new BackgroungPaneRoomControl(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    RoomEdit roomEdit = new RoomEdit();
                    jp.add(roomEdit);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(205);
                }
                if (roomSearch.equals(lastPathComponent)) {
                    BackgroungPaneRoomControl jp = null;
                    try {
                        jp = new BackgroungPaneRoomControl(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    RoomSearch roomSearch = new RoomSearch();
                    jp.add(roomSearch);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(205);
                }
                
                if (personnel.equals(lastPathComponent)) {
                    BackGroundPanelWithoutRoundRect jp = null;
                    try {
                        jp = new BackGroundPanelWithoutRoundRect(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Box vBox = Box.createVerticalBox();
                    Box hBox = Box.createHorizontalBox();
                    JLabel welcome = new JLabel("Welcome, Personnel Management !");
                    welcome.setFont(new Font("Dialog", 1, 48));
                    welcome.setForeground(Color.white);
                    hBox.add(welcome);
                    vBox.add(Box.createVerticalStrut(240));
                    vBox.add(hBox);
                    jp.add(vBox);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(205);
                }
                if (personnelAdd.equals(lastPathComponent)) {
                    BackgroungPaneRoomControl jp = null;
                    try {
                        jp = new BackgroungPaneRoomControl(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    PersonnelAdd personnelAdd = new PersonnelAdd();
                    jp.add(personnelAdd);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(205);
                }
                if (personnelRemove.equals(lastPathComponent)) {
                    BackgroungPaneRoomControl jp = null;
                    try {
                        jp = new BackgroungPaneRoomControl(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    PersonnelRemove personnelRemove = new PersonnelRemove();
                    jp.add(personnelRemove);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(205);
                }
                if (personnelEdit.equals(lastPathComponent)) {
                    BackgroungPaneRoomControl jp = null;
                    try {
                        jp = new BackgroungPaneRoomControl(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    PersonnelEdit personnelEdit = new PersonnelEdit();
                    jp.add(personnelEdit);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(205);
                }
                if (personnelSearch.equals(lastPathComponent)) {
                    BackgroungPaneRoomControl jp = null;
                    try {
                        jp = new BackgroungPaneRoomControl(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    PersonnelSearch personnelSearch = new PersonnelSearch();
                    jp.add(personnelSearch);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(205);
                }
                
                if (bookingManagement.equals(lastPathComponent)) {
                    BackGroundPanelWithoutRoundRect jp = null;
                    try {
                        jp = new BackGroundPanelWithoutRoundRect(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Box vBox = Box.createVerticalBox();
                    Box hBox = Box.createHorizontalBox();
                    JLabel welcome = new JLabel("Welcome, Booking Management !");
                    welcome.setFont(new Font("Dialog", 1, 48));
                    welcome.setForeground(Color.white);
                    hBox.add(welcome);
                    vBox.add(Box.createVerticalStrut(240));
                    vBox.add(hBox);
                    jp.add(vBox);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(205);
                }
                if (checkIn.equals(lastPathComponent)) {
                    BackgroungPaneRoomControl jp = null;
                    try {
                        jp = new BackgroungPaneRoomControl(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    CheckIn checkIn = new CheckIn();
                    jp.add(checkIn);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(205);
                }
                if (checkOut.equals(lastPathComponent)) {
                    BackgroungPaneRoomControl jp = null;
                    try {
                        jp = new BackgroungPaneRoomControl(ImageIO.read(new File("src/zhh_hotelbookingsystem/bg_gaitubao_1800x1000.jpg")));
                    } catch (IOException ex) {
                        Logger.getLogger(AdminInterface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    CheckOut checkOut = new CheckOut();
                    jp.add(checkOut);
                    jSplitPane.setRightComponent(jp);
                    jSplitPane.setDividerLocation(205);
                }
            }
        });
        
        jSplitPane.setLeftComponent(tree);
        jSplitPane.setEnabled(false);
        
        //Draw background
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
        
        //Set style
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
        new AdminInterface().init();
    }
    
    //Customize the style of JTree
    private class MyRenderer extends DefaultTreeCellRenderer{
        private ImageIcon rootIcon = null;
        private ImageIcon roomIcon = null;
        private ImageIcon personnelIcon = null;
        private ImageIcon bookingIcon = null;
        
        public MyRenderer(){
                rootIcon = new ImageIcon("src/zhh_hotelbookingsystem/HotelA.png");
                roomIcon = new ImageIcon("src/zhh_hotelbookingsystem/Bed.png");
                personnelIcon = new ImageIcon("src/zhh_hotelbookingsystem/Stormtrooper.png");
                bookingIcon = new ImageIcon("src/zhh_hotelbookingsystem/Reception.png");
        }

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            ImageIcon image = null;
            
            //root Icon
            if (value.toString().equals("Hotel Management")) {
                image = rootIcon;
            }
            
            //Room Icon
            if (value.toString().equals("Room Management")) {
                image = roomIcon;
            }
            if (value.toString().equals("Room Add")) {
                image = roomIcon;
            }
            if (value.toString().equals("Room Remove")) {
                image = roomIcon;
            }
            if (value.toString().equals("Room Edit")) {
                image = roomIcon;
            }
            if (value.toString().equals("Room Sreach")) {
                image = roomIcon;
            }
            
            //Personnel Icon
            if (value.toString().equals("Personnel Management")) {
                image = personnelIcon;
            }
            if (value.toString().equals("Personnel Add")) {
                image = personnelIcon;
            }
            if (value.toString().equals("Personnel Remove")) {
                image = personnelIcon;
            }
            if (value.toString().equals("Personnel Edit")) {
                image = personnelIcon;
            }
            if (value.toString().equals("Personnel Search")) {
                image = personnelIcon;
            }
            
            //Booking Icon
            if (value.toString().equals("Booking Management")) {
                image = bookingIcon;
            }
            if (value.toString().equals("Check In")) {
                image = bookingIcon;
            }
            if (value.toString().equals("Check Out")) {
                image = bookingIcon;
            }
            
            this.setIcon(image);
            this.updateUI();
            return this;
        }
        
    }
    
}
