package f2.spw;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public class Bg  {
    protected Image image = new ImageIcon("background.png").getImage();
    private int x;
    private int y;
 
   
    public Bg(int x,int y){
     this.x = x;
     this.y = y;     
    System.out.println("11");
    }
    
    public void draw(Graphics2D g2d){
        g2d.drawImage(image, x, y, null);

    }   


}

