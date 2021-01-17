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

/**
 *
 * @author Honghui Zhang
 */
public class DeluxeAndBusinessRoom extends BackgroungPaneRoomControl{
    private Font titleFont;
    private Font subTitleFont;
    private Font describeFont;
    private Image smokingImage;
    private Image telephoneImage;
    private Image wifiImage;
    private Image hairDyerImage;
    private Image todayPriceImage;
    private Image validRoomImage;
    private String titleString;
    private String startPrice;
    private String endPrice;
    private String validNumber;
    
    public DeluxeAndBusinessRoom(Image baImage, String str, int startPrice, int endPrice, int validNumber) {
        super(baImage);
        this.titleString  = str;
        this.startPrice = startPrice + "";
        this.endPrice = endPrice + "";
        this.validNumber = validNumber + "";
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        titleFont = new Font("Mononspace", Font.ITALIC, 48);
        subTitleFont = new Font("Mononspace", 1, 36);
        describeFont = new Font("Mononspace", 1, 64);
        
        try {
            smokingImage = ImageIO.read(new File("src/zhh_hotelbookingsystem/noSmoking.png"));
            telephoneImage = ImageIO.read(new File("src/zhh_hotelbookingsystem/telephone.png"));
            wifiImage = ImageIO.read(new File("src/zhh_hotelbookingsystem/wifi.png"));
            hairDyerImage = ImageIO.read(new File("src/zhh_hotelbookingsystem/hairDyer.png"));
            todayPriceImage = ImageIO.read(new File("src/zhh_hotelbookingsystem/todayPrice.png"));
            validRoomImage = ImageIO.read(new File("src/zhh_hotelbookingsystem/validRoom.png"));
        } catch (IOException ex) {
            Logger.getLogger(AboutUsPane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        g.setColor(new Color(255, 255, 255));
        g.setFont(titleFont);
        if (titleString.equals("Deluxe Room")) {
            g.drawString("Deluxe Room", 440, 80);
        }else{
            g.drawString("Business Room", 420, 80);
        }
        g.drawImage(smokingImage, this.getWidth()/2 - 150 - smokingImage.getWidth(this) - wifiImage.getWidth(this), 120, smokingImage.getWidth(this), smokingImage.getHeight(this), null);
        g.drawImage(wifiImage, this.getWidth()/2 - 50 - wifiImage.getWidth(this), 120, wifiImage.getWidth(this), wifiImage.getHeight(this), null);
        g.drawImage(telephoneImage, this.getWidth()/2 + 50, 120, telephoneImage.getWidth(this), telephoneImage.getHeight(this), null);
        g.drawImage(hairDyerImage, this.getWidth()/2 + 150 + telephoneImage.getWidth(this), 120, hairDyerImage.getWidth(this), hairDyerImage.getHeight(this), null);
        g.drawImage(todayPriceImage, this.getWidth()/2 - 200 - todayPriceImage.getWidth(this), 250, todayPriceImage.getWidth(this), todayPriceImage.getHeight(this), null);
        g.drawImage(validRoomImage, this.getWidth()/2 + 200, 250, validRoomImage.getWidth(this), validRoomImage.getHeight(this), null);
        g.setFont(subTitleFont);
        g.drawString("Today's Price", 230, 420);
        g.drawString("Remaining Quantity", 700, 420);
        g.setFont(describeFont);
        g.drawString(" - ", 310, 520);
        g.drawString(startPrice, 210, 520);
        g.drawString(endPrice, 360, 520);
        g.drawString(validNumber, 850, 520);
    }
}
