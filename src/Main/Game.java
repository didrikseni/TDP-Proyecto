package Main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.swing.JLayeredPane;
import Entity.Enemy;
import Entity.Entity;
import Entity.Player;
import GUI.GUI_Game;
import GUI.GUI_GameOver;

public abstract class Game {	
	protected GUI_Game gui;
	protected int nivel, enemyCount;
	protected Player player;
	protected List<Entity> entities;
	protected JLayeredPane contentPane;
	protected HashMap<Entity, Boolean> deadEntities;

	protected Game(GUI_Game gui) {
		entities = new ArrayList<Entity>();
		this.gui = gui;
		this.enemyCount = 0;
		initializeMap();
	}

	private void initializeMap() {
		player = Player.getInstance(gui.getWidth() / 2 - 25, gui.getHeight() / 6 * 5, this);
		gui.add(player.getGraphics());
		gui.addComponentInLayer(player.getGraphics(), 15);				
		loadObjects();
	}
	
	public void addEnemyCount() { 
		enemyCount++;	
	}
	
	public void substractEnemyCount() {
		enemyCount--;
		if (enemyCount == 0) {
			this.winGame();
		}
	}

	protected abstract void loadObjects();

	public void update() {
		player.update();
		gui.updateLifeBar(player.getLife());
		deadEntities = new HashMap<Entity, Boolean>();
		detectCollisions();
		removeDeadEntities();
	}
	
	public void addEntity(Entity s) {
		entities.add(s);
		gui.add(s.getGraphics());
		gui.addComponentInLayer(s.getGraphics(), 3);
	}

	public void addDeadEntity(Entity e) {
		deadEntities.put(e, true);
	}
	
	public void addDeadEntity(Enemy e, int score) {
		player.addScore(score);
		deadEntities.put(e, true);
	}
	
	public synchronized Collection<Entity> getEntities() {
		return entities;
	}
	
	private void detectCollisions() {
		Entity entity1, entity2;
		for(int i = 0; i < getEntities().size(); i++) {
			entity1 = entities.get(i);
			entity1.update();
			if(player.getRectangle().intersects(entity1.getRectangle())) {
				player.collide(entity1);
				entity1.collide(player);
			}
			for(int j = i + 1; j < entities.size(); j++) {
				entity2 = entities.get(j);
				if(entity1.getRectangle().intersects(entity2.getRectangle())) {
					entity1.collide(entity2);
					entity2.collide(entity1);
				}
			}
		}
	}

	private void removeDeadEntities() {
		for(Entity entity: deadEntities.keySet()) {
			gui.remove(entity.getGraphics());
			entities.remove(entity);
		}
		gui.repaint();
	}

	public void gameOver() {
		int score = player.getScore();
		GUI_GameOver gameOverGui = GUI_GameOver.getInstance(score);
		gameOverGui.setVisible(true);
		gui.dispose();
	}
	
	private void winGame() {
		
	}
}
