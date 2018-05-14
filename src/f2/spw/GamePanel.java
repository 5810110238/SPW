package f2.spw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel  {
	
	private BufferedImage bi;	
	Graphics2D big;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();
        private BufferedImage background = null;
        
          

	public GamePanel() {
                
		bi = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		big = (Graphics2D) bi.getGraphics();
                background = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
                ;
                
	}
       @Override
	public void paint(Graphics g) {
                
                
		Graphics2D g2d = (Graphics2D) g;
               
		g2d.drawImage(bi, null, 0, 0);
                
                
             
	}

	public void updateGameUI(GameReporter reporter){
               
                
		big.clearRect(0, 0, 400, 600);
		big.setColor(Color.WHITE);		
		big.drawString(String.format("BLUE : "+"%06d", reporter.getScore1()), 130 , 20);
                big.drawString(String.format("RED : "+"%06d", reporter.getScore2()), 10 , 20);
                big.drawString(String.format("MAX Score : "+"%08d", reporter.getMaxScore()), 250, 20);
                
		
               
                for(Sprite s : sprites){
			s.draw(big);
		}
		
		repaint();
                
	}
       
	

}
