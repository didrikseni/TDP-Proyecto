package PowerUp;

import java.util.Collection;

import Entity.Entity;
import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorThreadFreeze;

public class ThreadFreeze implements Runnable {
	Visitor visitor;
	Game game;
	
	public ThreadFreeze(Game game) {
		visitor = VisitorThreadFreeze.getInstance();
		this.game = game;
	}	
	
	@Override
	public void run() {
		changeBehaviour();
		long elapsedTime = System.currentTimeMillis();
		long targetTime = System.currentTimeMillis() + 1000;
		while (elapsedTime < targetTime) {
			elapsedTime = System.currentTimeMillis();
			try { 
				Thread.sleep(10);
			} catch (Exception e) {}	
		}
		changeBehaviour();
	}

	private void changeBehaviour() {
		Collection<Entity> entidades = game.getEntities();
		for(Entity ent: entidades) {
			ent.accept(this.visitor);
		}
	}
	
}
