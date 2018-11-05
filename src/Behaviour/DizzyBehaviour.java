package Behaviour;

import java.util.Random;
import Entity.Enemy;
import GUI.GUI_Game;

public class DizzyBehaviour extends Behaviour {
	private Random rnd;
	private int vectorX, vectorY, delay;
	private long targetTime, elapsedTime;

	public DizzyBehaviour() {
		rnd = new Random();
		delay = 1500;
	}

	@Override
	public void update(Enemy e) {		
		super.update(e);
		if (elapsedTime >= targetTime) {			
			vectorX = rnd.nextInt(GUI_Game.getInstance().getWidth()) - e.getRectangle().x;
			vectorY = rnd.nextInt(GUI_Game.getInstance().getHeight()) - e.getRectangle().y;
			targetTime = delay + System.currentTimeMillis();
		}
		
		double angle = Math.atan2(vectorY, vectorX);

		e.getRectangle().x = (int) (2 * Math.cos(angle) + e.getRectangle().x);
		e.getRectangle().y = (int) (2 * Math.sin(angle) + e.getRectangle().y);
		elapsedTime = System.currentTimeMillis();
	}

	@Override
	public void changeBehaviour(Enemy enemy) {}

}
