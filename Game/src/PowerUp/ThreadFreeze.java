package PowerUp;

import Entity.Entity;
import Main.Excecute;
import Main.Game;
import Main.MainThread;
import Visitor.Visitor;
import Visitor.VisitorThreadFreeze;

public class ThreadFreeze implements Runnable, Excecute {
	protected static boolean isRunning = false;
	protected Visitor visitor;
	protected Game game;


	public ThreadFreeze(Game game) {
		visitor = VisitorThreadFreeze.getInstance();
		this.game = game;
	}

	@Override
	public void run() {
		isRunning = true;
		MainThread.addToExcecute(this);
		long elapsedTime = System.currentTimeMillis();
		long targetTime = System.currentTimeMillis() + 3000;
		while (isRunning) {
			elapsedTime = System.currentTimeMillis();
			isRunning = elapsedTime < targetTime;
			try { 
				Thread.sleep(10);
			} catch (Exception e) {}
		}
		MainThread.addToExcecute(this);
		PowerUpFreeze.setInstanceNull();
	}

	public static boolean isRunning() {
		return isRunning;
	}

	private void changeBehaviour() {
		for(Entity ent: game.getEntities()) {
			ent.accept(visitor);
		}
	}

	@Override
	public void excecute() {
		this.changeBehaviour();
	}
}
