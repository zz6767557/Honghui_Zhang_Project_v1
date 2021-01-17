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
public class PersonnelSearch extends Box{
    
    final int WIDTH = 1216;
    final int HEIGHT = 728;
    
    private JTable table;
    private Vector<String> titles;
    private Vector<Vector> tableDate;
    private DefaultTableModel tableModel;
    private Font font;
    
    public PersonnelSearch(){
        super(BoxLayout.Y_AXIS);
        
        font = new Font("Dialog", 1, 16);
        
        Box hBox1 = Box.createHorizontalBox();
        JLabel personnelNameJLabel = new JLabel("Name");
        personnelNameJLabel.setFont(font);
        personnelNameJLabel.setForeground(Color.white);
        JTextField personnelNameField = new JTextField(10);
        JButton searchPersonnelButton = new JButton("Search");
        hBox1.add(Box.createHorizontalStrut(320));
        hBox1.add(personnelNameJLabel);
        hBox1.add(Box.createHorizontalStrut(10));
        hBox1.add(personnelNameField);
        hBox1.add(Box.createHorizontalStrut(20));
        hBox1.add(searchPersonnelButton);
        hBox1.add(Box.createHorizontalStrut(383));
        
        String[] ts = {"Name", "Gender", "Title", "Contact"};
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
        
        //Find users
        searchPersonnelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DBUtil.checkOneStuffExist(personnelNameField.getText())) {
                    tableDate.clear();
                    tableDate = DBUtil.searchOnePersonnel(personnelNameField.getText());
                    tableModel.getDataVector().clear();
                    tableModel.setDataVector(tableDate, titles);
                    tableModel.fireTableDataChanged();
                    personnelNameField.setText("");
                }else {
                    JOptionPane.showMessageDialog(hBox3, "Can't find the person!");
                }
            }
        });
        
        this.add(Box.createVerticalStrut(80));
        this.add(hBox1);
        this.add(Box.createVerticalStrut(137));
        this.add(hBox3);
    }
    
}
