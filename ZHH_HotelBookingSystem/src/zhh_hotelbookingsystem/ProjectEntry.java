/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhh_hotelbookingsystem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Honghui Zhang
 */
public class ProjectEntry {
    
    //The entrance to the whole system
    public static void main(String[] args) {
        DBUtil.createTable();
        try {
            new LoginInterface().init();
        } catch (Exception ex) {
            Logger.getLogger(ProjectEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
