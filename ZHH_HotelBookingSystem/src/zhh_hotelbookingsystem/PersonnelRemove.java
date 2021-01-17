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
public class PersonnelRemove extends Box{
    
    final int WIDTH = 1216;
    final int HEIGHT = 728;
    
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableDate;
    private DefaultTableModel tableModel;
    private Font font;
    
    public PersonnelRemove(){
        super(BoxLayout.Y_AXIS);
        
        font = new Font("Dialog", 1, 16);
        
        Box hBox1 = Box.createHorizontalBox();
        JLabel personnelNameJLabel = new JLabel("Name");
        personnelNameJLabel.setFont(font);
        personnelNameJLabel.setForeground(Color.white);
        JTextField personnelNameField = new JTextField(10);
        JButton searchPersonnelButton = new JButton("Search");
        JLabel messageJLabel = new JLabel("Are you sure you want to delete it?");
        messageJLabel.setFont(font);
        messageJLabel.setForeground(Color.white);
        JButton confirmButton = new JButton("YES");
        JButton cancelButton = new JButton("NO");
        hBox1.add(Box.createHorizontalStrut(320));
        hBox1.add(personnelNameJLabel);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(personnelNameField);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(searchPersonnelButton);
        hBox1.add(Box.createHorizontalStrut(376));
        
        Box hboxButton = Box.createHorizontalBox();
        hboxButton.add(messageJLabel);
        hboxButton.add(Box.createHorizontalStrut(20));
        hboxButton.add(confirmButton);
        hboxButton.add(Box.createHorizontalStrut(20));
        hboxButton.add(cancelButton);
        hboxButton.setVisible(false);
        
        
        
        Box gapBox = Box.createVerticalBox();
        gapBox.add(Box.createVerticalStrut(30));
        
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
        
        //Get user information
        searchPersonnelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DBUtil.checkOneStuffExist(personnelNameField.getText())) {
                    tableDate.clear();
                    tableDate = DBUtil.searchOnePersonnel(personnelNameField.getText());
                    tableModel.getDataVector().clear();
                    tableModel.setDataVector(tableDate, titles);
                    tableModel.fireTableDataChanged();
                    gapBox.setVisible(false);
                    hboxButton.setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(hBox3, "The person you want to delete does not exist!");
                }
            }
        });
        
        //Delete the user
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBUtil.deleteOnePersonnel(personnelNameField.getText());
                tableDate.clear();
                tableDate = DBUtil.searchAllPersonnel();
                tableModel.getDataVector().clear();
                tableModel.setDataVector(tableDate, titles);
                tableModel.fireTableDataChanged();
                gapBox.setVisible(true);
                hboxButton.setVisible(false);
                personnelNameField.setText("");
                JOptionPane.showMessageDialog(hBox3, "Successfylly delete!");
            }
        });
        
        //Cancel deletion
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableDate.clear();
                tableDate = DBUtil.searchAllPersonnel();
                tableModel.getDataVector().clear();
                tableModel.setDataVector(tableDate, titles);
                tableModel.fireTableDataChanged();
                gapBox.setVisible(true);
                hboxButton.setVisible(false);
                personnelNameField.setText("");
            }
        });
        
        this.add(Box.createVerticalStrut(80));
        this.add(hBox1);
        this.add(gapBox);
        this.add(hboxButton);
        this.add(Box.createVerticalStrut(107));
        this.add(hBox3);
    }
    
}
