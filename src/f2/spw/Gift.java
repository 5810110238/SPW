package f2.spw;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.Timer;

public class Gift extends Sprite    {
	public static final int Y_TO_FADE = 400;
	public static final int Y_TO_DIE = 600;

	private int step = 12 ;
        private int level ;
	private boolean alive = true;
    
	public Gift(int x, int y) {
		super(x, y, 5, 10);
                
		
	}


	@Override
	public void draw(Graphics2D g) {
		System.out.println(""+level);
                  
                    
                 
                            //reporter.getLevel()
                            g.setColor(Color.GREEN);
                            g.fillRect(x, y, width, height);
                 
                  
        }
	public void proceed(){
		y += step;
		if(y > Y_TO_DIE){
			alive = false;
		}
             
	}
	
	public boolean isAlive2(){
		return alive;
	}


       

    void remove() {
        width =0 ;
        height = 0 ;
    }

    
	
            
	
	}


   
