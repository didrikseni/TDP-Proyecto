package PowerUp;

import java.util.Collection;
import java.util.Iterator;

import Entity.Entity;
import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorThreadFreeze;

public class ThreadFreeze implements Runnable {
	private static ThreadFreeze INSTANCE = null;
	protected static boolean isRunning = false;
	protected Visitor visitor;
	protected Game game;
	
	
	private ThreadFreeze(Game game) {
		visitor = VisitorThreadFreeze.getInstance();
		this.game = game;
	}
	
	public synchronized static ThreadFreeze getInstance(Game game) {
		if (INSTANCE == null) {
			INSTANCE = new ThreadFreeze(game);
		} 
		return INSTANCE;
	}
	
	@Override
	public void run() {
		isRunning = true;
		changeBehaviour();
		long elapsedTime = System.currentTimeMillis();
		long targetTime = System.currentTimeMillis() + 3000;
		while (isRunning) {
			elapsedTime = System.currentTimeMillis();
			isRunning = elapsedTime < targetTime;
			try { 
				Thread.sleep(10);
			} catch (Exception e) {}
		}
		changeBehaviour();
	}
	
	public static boolean isRunning() {
		return isRunning;
	}

	private void changeBehaviour() {
		Collection<Entity> entidades = game.getEntities();
		Iterator<Entity> it = entidades.iterator();
		while (it.hasNext()) {
			it.next().accept(this.visitor);
		}
	}
}
