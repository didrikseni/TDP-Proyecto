package Behaviour;

import Entity.Enemy;
import Level.FactoryEnemy;
import Main.Game;

public class BossBehaviour extends Behaviour {
	private long elapsedTime, kamikazeTime, shootTime;
	private int delayGeneral, delayDisparos, rafagaDisparos;
	private FactoryEnemy enemyFactory;
	private Game game;
	
	public BossBehaviour(Game game) {
		elapsedTime = kamikazeTime = 0;
		this.game = game;
		rafagaDisparos = 10;
		delayDisparos = 200;
		delayGeneral = 5000;
		enemyFactory = new FactoryEnemy(game);
	}
	
	@Override
	public void update(Enemy enemy) {
		updateKamikaze(enemy);
		updateShoot(enemy);
		elapsedTime = System.currentTimeMillis();
	}

	private void updateShoot(Enemy enemy) {
		if (elapsedTime >= shootTime) {
			if  (rafagaDisparos > 0) {
				enemy.shoot();
				rafagaDisparos--;
				shootTime = System.currentTimeMillis() + delayDisparos;
			} else {
				rafagaDisparos = 10;
				shootTime = System.currentTimeMillis() + delayGeneral;
			}
		}
	}

	private void updateKamikaze(Enemy enemy) {
		if (elapsedTime >= kamikazeTime) {
			addKamikazes(enemy);
			kamikazeTime = System.currentTimeMillis() + delayGeneral;
		}
	}

	private void addKamikazes(Enemy enemy) {
		Enemy e = enemyFactory.getEnemyKamikaze(enemy.getRectangle().x, enemy.getRectangle().y + enemy.getHeight());
		game.addEntity(e);
		game.addEnemyCount();
		e = enemyFactory.getEnemyKamikaze(enemy.getRectangle().x + enemy.getWidth(), enemy.getRectangle().y + enemy.getHeight());
		game.addEntity(e);
		game.addEnemyCount();
	}

	@Override
	public void changeBehaviour(Enemy enemy) {}
}
