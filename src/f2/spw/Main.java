package f2.spw;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.BorderLayout;
import java.io.IOException;	

public class Main {
	public static void main(String[] args){
		JFrame frame = new JFrame("Space War");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 650);
		frame.getContentPane().setLayout(new BorderLayout());
		
		SpaceShip v1 = new SpaceShip(250, 550, 30, 30);
                SpaceShip2 v2 = new SpaceShip2(100, 550, 30, 30);
		GamePanel gp = new GamePanel();
		GameEngine engine = new GameEngine(gp, v1 , v2 );
		frame.addKeyListener(engine);
		frame.getContentPane().add(gp, BorderLayout.CENTER);
		frame.setVisible(true);
                frame.setLocationRelativeTo(null);
		
		engine.start();
	}
}
