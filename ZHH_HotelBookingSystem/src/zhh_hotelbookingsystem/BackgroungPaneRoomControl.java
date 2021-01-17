/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhh_hotelbookingsystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Honghui Zhang
 */
public class BackgroungPaneRoomControl extends JPanel{
    private Image backImage;
    
    public BackgroungPaneRoomControl(Image baImage){
        this.backImage = baImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(backImage, 0, 0, this.getWidth(), this.getHeight(), null);
        g.setColor(new Color(255, 255, 255, 50));
        g.fillRoundRect(10, 10, this.getWidth() - 20 , 200, 20, 20);
        g.fillRoundRect(10, 220, this.getWidth() - 20 , this.getHeight() - 230, 20, 20);
    }
}
