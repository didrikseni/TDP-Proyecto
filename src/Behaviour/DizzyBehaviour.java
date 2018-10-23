package Behaviour;

import java.util.Random;
import Entity.Enemy;
import GUI.GUI_Game;

public class DizzyBehaviour extends Behaviour {
	private int vectorX, vectorY, delay;
	private Random rnd;
	private long elapsedTime, waitTime;

	public DizzyBehaviour() {
		rnd = new Random();
		delay = 2000;
		vectorX = rnd.nextInt(rnd.nextInt(1000));
		vectorY = rnd.nextInt(rnd.nextInt(680));
		waitTime = 0;
		elapsedTime = 0;
	}

	@Override
	public void update(Enemy e) {		
		super.update(e);		
		if (elapsedTime >= waitTime) {
			vectorX = rnd.nextInt(GUI_Game.getInstance().getWidth() - e.getWidth()) + e.getWidth();
			vectorY = rnd.nextInt(GUI_Game.getInstance().getHeight() - e.getHeight() + e.getHeight());
			waitTime = System.currentTimeMillis() + delay;
		}
		
		int toMoveX = vectorX - e.getRectangle().x;
		int toMoveY = vectorY - e.getRectangle().y;
		
		double angle = Math.atan2(toMoveY, toMoveX);

		e.getRectangle().x = (int) (2 * Math.cos(angle) + e.getRectangle().x);
		e.getRectangle().y = (int) (2 * Math.cos(angle) + e.getRectangle().y);
		elapsedTime = System.currentTimeMillis();
	}
	
}
