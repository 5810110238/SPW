package f2.spw;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;

public class SpaceShip extends Sprite{
        Bg bg;
       
	int step = 8;
     
	
	public SpaceShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		bg = new Bg(0,20);
               
	}

	@Override
	public void draw(Graphics2D g) {
                bg.draw(g);
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
               
		
	}
      

  
        

	public void moveX(int direction){
           
		x += (step * direction);
		if(x < 0)
			x = 0;
		if(x > 380 - width)
			x = 380 - width;
        }
        public void moveY(int direction){
           
		y += (step * direction);
		if(y < 0)
			y = 0;
		if(y > 580 - height)
			y = 580 - height;
        }

        void remove() {
            width =0 ;
            height = 0 ;
        }
    }


