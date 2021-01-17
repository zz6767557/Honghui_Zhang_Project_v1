/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhh_hotelbookingsystem;

import java.awt.Graphics;
import java.awt.*;
import javax.swing.JPanel;

/**
 *
 * @author Honghui Zhang
 */
public class BackgroundPanel extends JPanel{
    private Image backImage;
    private Font font;
    private Font font2;
    
    public BackgroundPanel(Image baImage){
        this.backImage = baImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        font = new Font("Dialog", 1, 64);
        font2 = new Font("Dialog", 1, 16);
        g.drawImage(backImage, 0, 0, this.getWidth(), this.getHeight(), null);
        g.setColor(new Color(255, 255, 255, 50));
        g.fillRoundRect(450, 250, 540, 300, 20, 20);
        g.setFont(font);
        g.drawString("Hotel Booking System", 380, 150);
        g.setFont(font2);
        g.drawString("Design by Honghui Zhang - CJLU", 600, this.getHeight() - 20);
    }
    
}
