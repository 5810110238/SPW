package f2.spw;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.Timer;

public class Enemy extends Sprite    {
	public static final int Y_TO_FADE = 400;
	public static final int Y_TO_DIE = 600;

	private int step = 12 ;
        private int level ;
	private boolean alive = true;
    
	public Enemy(int x, int y) {
		super(x, y, 5, 10);
                
		
	}
       
     


	@Override
	public void draw(Graphics2D g) {
		System.out.println(""+level);
                  
                    
                            //reporter.getLevel()
                      if (level != 0){
                            if(level <=3 ){
                                g.setColor(Color.RED);
                                 g.fillOval(x, y, width, height);
                      }    
                            else if(3< level && level <= 6){
                                width = 15;
                                height = 20 ;
                                g.setColor(Color.RED);
                                g.fillOval(x, y, width, height);
                      }  
                            else if(6< level && level <= 9){
                                width = 20;
                                height = 25 ;
                                g.setColor(Color.PINK);
                                g.fillOval(x, y, width, height);
                      }   
                            else if(9< level ){
                                width = 30;
                                height = 40;
                            
                                g.setColor(Color.ORANGE);
                                g.fillOval(x, y, width, height);
                      }  
                             else if(5< level ){
                                width = 30;
                                height = 40;
                            
                                g.setColor(Color.ORANGE);
                                g.fillOval(x, y, width, height);
                            
                      }
                 
        }              
        }
	public void proceed(){
		y += step;
		if(y > Y_TO_DIE){
			alive = false;
		}
             
	}
	
	public boolean isAlive(){
		return alive;
	}


       
	public void setSpeed(int step){
		this.step = step;	
               // System.out.println(""+step);
	}
        

	public int getSpeed(){
		return step;												
	}

      

    public void setLevel(int level) {
        this.level = level;
        
    }

    
	
            
	
	}


   
