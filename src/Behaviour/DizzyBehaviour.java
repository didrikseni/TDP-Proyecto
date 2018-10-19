package Behaviour;

import java.util.Random;
import Entity.Enemy;
import GUI.GUI_Game;

public class DizzyBehaviour extends Behaviour {
	private long delay, elapsedTime;
	private int vectorX, vectorY;
	private Random rnd;
	
	public DizzyBehaviour() {
		delay = 1000;
		rnd = new Random();
		elapsedTime = System.nanoTime();
	}
	
	@Override
	public void update(Enemy e) {		
		super.update(e);
		GUI_Game gui = GUI_Game.getInstance();
		if(System.currentTimeMillis() - elapsedTime > delay) {
			vectorX = rnd.nextInt(1024) - e.getRectangle().x;
			vectorY = rnd.nextInt(700) - e.getRectangle().y;
			
			double angle = Math.atan2(vectorY, vectorX);
			
			e.getRectangle().x = (int) (10 * Math.cos(angle)) + e.getRectangle().x;
			e.getRectangle().y = (int) (10 * Math.sin(angle)) + e.getRectangle().y;
			
			elapsedTime = System.currentTimeMillis();
		}
		
		
		
		
		
		if(e.getRectangle().y > (gui.getHeight() - e.getHeight() - 40)) {
			e.setPos(e.getRectangle().x, 0); 
		}
	}
}
