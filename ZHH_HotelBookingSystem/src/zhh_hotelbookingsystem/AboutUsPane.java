/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zhh_hotelbookingsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Honghui Zhang
 */
public class AboutUsPane extends JPanel{
    private Image backImage;
    private Font titleFont;
    private Image hotelImage;
    private Image peopleImage;
    private Image earthImage;
    private Font subTitleFont;
    private Font describeFont;
    private Font contactFont;
    
    public AboutUsPane(Image baImage){
        this.backImage = baImage;
    }

    //paint the About Us page
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        titleFont = new Font("Mononspace", Font.ITALIC, 64);
        subTitleFont = new Font("Mononspace", 1, 36);
        describeFont = new Font("Mononspace", 1, 64);
        contactFont = new Font("Dialog", 1, 16);
        try {
            hotelImage = ImageIO.read(new File("src/zhh_hotelbookingsystem/aboutUsBed.png"));
            peopleImage = ImageIO.read(new File("src/zhh_hotelbookingsystem/People.png"));
            earthImage = ImageIO.read(new File("src/zhh_hotelbookingsystem/earth.png"));
        } catch (IOException ex) {
            Logger.getLogger(AboutUsPane.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(backImage, 0, 0, this.getWidth(), this.getHeight(), null);
        g.setColor(new Color(255, 255, 255, 50));
        g.fillRoundRect(10, 10, this.getWidth() - 20 , this.getHeight() - 20, 20, 20);
        g.setColor(new Color(255, 255, 255));
        g.setFont(titleFont);
        g.drawString("About Us", 480, 150);
        g.drawImage(hotelImage, this.getWidth()/2 - hotelImage.getWidth(this)/2, 250, hotelImage.getWidth(this), hotelImage.getHeight(this), null);
        g.drawImage(peopleImage, this.getWidth()/2 - hotelImage.getWidth(this)/2 - 200 - 2 * (peopleImage.getWidth(this)/2), 250, peopleImage.getWidth(this), peopleImage.getHeight(this), null);
        g.drawImage(earthImage, this.getWidth()/2 + hotelImage.getWidth(this)/2 + 200, 250, earthImage.getWidth(this), earthImage.getHeight(this), null);
        g.setFont(subTitleFont);
        g.drawString("Staff", this.getWidth()/2 - hotelImage.getWidth(this)/2 - 200 - 2 * (peopleImage.getWidth(this)/2) + 20, 420);
        g.drawString("Room", this.getWidth()/2 - hotelImage.getWidth(this)/2 + 30, 420);
        g.drawString("Worldwide", this.getWidth()/2 + hotelImage.getWidth(this)/2 + 180, 420);
        g.setFont(describeFont);
        g.drawString("1000+", this.getWidth()/2 - hotelImage.getWidth(this)/2 - 200 - 2 * (peopleImage.getWidth(this)/2) - 20, 520);
        g.drawString("600+", this.getWidth()/2 - hotelImage.getWidth(this)/2 + 10, 520);
        g.drawString("18", this.getWidth()/2 + hotelImage.getWidth(this)/2 + 230, 520);
        g.setFont(contactFont);
        g.drawString("Reservation call: (86)-888-888 | Working time: 6:00am - 24:00 pm", this.getWidth()/2 - hotelImage.getWidth(this)/2 - 150, this.getHeight() - 40);
        g.drawString("Location:The most inconspicuous corner of Mars", this.getWidth()/2 - hotelImage.getWidth(this)/2 - 100, this.getHeight() - 70);
    }
    
    
}
