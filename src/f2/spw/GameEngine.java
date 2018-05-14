
package f2.spw;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import static javax.swing.Spring.height;
import static javax.swing.Spring.width;

import javax.swing.Timer;


public class GameEngine implements KeyListener, GameReporter{
	GamePanel gp1;
        GamePanel gp2;
        
		
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
        private ArrayList<Gift> gift = new ArrayList<Gift>();
	private SpaceShip v1;	
        private SpaceShip2 v2;
	
	private Timer timer;
	
	private long score1 = 0;
        private long score2 = 0;
        private long maxScore = 0;
        private int Level = 1;
        private int speed = 8;
        private int count1 =0;
        private int count2 =0;
	private double difficulty = 0.1;
     
	
	public GameEngine(GamePanel gp, SpaceShip v1 ,SpaceShip2 v2  ) {
		this.gp1 = gp;
                this.gp2 = gp;
		this.v1 = v1;
                this.v2 = v2;
            
		gp.sprites.add(v1);
		gp.sprites.add(v2);
                
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process1();
                                process2();
			}
		});
              
		timer.setRepeats(true);
		
	}
	
	public void start(){
		timer.start();
              
	}
	
	private void generateEnemy(){
		Enemy e = new Enemy((int)(Math.random()*390), 30);
		gp1.sprites.add(e);
		enemies.add(e);
	}
        private void generateGift(){
		Gift g = new Gift((int)(Math.random()*400), 40);
		gp2.sprites.add(g);
		gift.add(g);
        }
	private void process1(){
		if(Math.random() < difficulty){
			generateEnemy();
                        
		}
		gp1.updateGameUI(this);
		
		Rectangle2D.Double vr1 = v1.getRectangle();
                Rectangle2D.Double vr2 = v2.getRectangle();
            
		Rectangle2D.Double er;
               
		Iterator<Enemy> e_iter = enemies.iterator();
                
		while(e_iter.hasNext()){
			Enemy e = e_iter.next();
			e.proceed();
                        e.setLevel(Level);
			er = e.getRectangle();
			if(er.intersects(vr1)){
                            count1++ ;
                            v1.remove();
                            
                            }
                        
                        else if(er.intersects(vr2)){
                            count2 ++;
                            v2.remove();
                        	
			}
                        else if (count1 ==1 && count2 == 1){
                            die();
                             if(score2>score1)
                                    JOptionPane.showMessageDialog(null, "RED Team Winner!!!!! Score :"+score2 );
                              else if(score2<score1)
                                    JOptionPane.showMessageDialog(null, "Blue Team Winner!!!!! "+score1 );
                             else
                                  JOptionPane.showMessageDialog(null, "Game Over" );
                           
                            return ;
                        }
                        
                       
                        else if(score1 >score2 && score1 > maxScore){
						maxScore = score1;
			}
                        else if(score2 >score1 && score2 > maxScore){
						maxScore = score2;
			}
                        else if(!e.isAlive()){
				e_iter.remove();
				gp1.sprites.remove(e);
                                if(count1 != 1)
                                    score1 += 100;
                                if(count2 != 1)
                                    score2 += 100;
                                if((score1 % 100 == 0) && (score1 != 0)){
					speed += 10;								
					e.setSpeed(speed);

				}
                                if((score2 % 100 == 0) && (score2 != 0)){
					speed += 10;								
					e.setSpeed(speed);
                                    
                                      
				}
                                 if((score2 % 1000 == 0) || score1 % 1000 == 0 ){
                                     if(score2 !=0 && score1 !=0 )
							//level up ever 1000 point
						Level += 1;
                                               // e.setLevel(Level);
                                               
                                        }
                                    
                                      
				}
                                
                             
            }
        }
        private void process2(){
            if(Math.random() < difficulty){
		
                        generateGift();
		}
		gp2.updateGameUI(this);
		
		Rectangle2D.Double vr1 = v1.getRectangle();
                Rectangle2D.Double vr2 = v2.getRectangle();
            
		
                Rectangle2D.Double gr;
		
                Iterator<Gift> g_iter = gift.iterator();
                while(g_iter.hasNext()){
			Gift g = g_iter.next();
			g.proceed();
                       
			gr = g.getRectangle();
			if(gr.intersects(vr1)){
                            score1 +=200;
                            g.remove();
                            
                            }
                        
                        else if(gr.intersects(vr2)){
                            
                            score1 +=200;
                            g.remove();
                        
                }
        }
        }
                       
	
	
	
	public void die(){
		timer.stop();
	}
      
	
	void controlVehicle1(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			v1.moveX(-1);
			break;
		case KeyEvent.VK_RIGHT:
			v1.moveX(1);
			break;
               case KeyEvent.VK_DOWN:
			v1.moveY(1);
			break;
		case KeyEvent.VK_UP:
			v1.moveY(-1);
			break;
                    
                    
		case KeyEvent.VK_F:
			difficulty += 0.1;
			break;
		}
	}
        void controlVehicle2(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			v2.moveX(-1);
			break;
		case KeyEvent.VK_D:
			v2.moveX(1);
			break;
               case KeyEvent.VK_S:
			v2.moveY(1);
			break;
		case KeyEvent.VK_W:
			v2.moveY(-1);
			break;
                    
                    
		case KeyEvent.VK_G:
			difficulty += 0.1;
			break;
		}
	}

        @Override
	public long getScore1(){
       
		return score1;
	}
         @Override
	public long getScore2(){
       
		return score2;
	}
        
        @Override
        public long getMaxScore(){
       
		return maxScore;
	}
        
	public long getLevel(){
       
		return Level;
	}
	@Override
        
	public void keyPressed(KeyEvent e) {
		controlVehicle1(e);
                controlVehicle2(e);
                
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//do nothing
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//do nothing		
	}

  


    
}
