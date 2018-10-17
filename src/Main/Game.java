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
	protected HashMap<Entity, Boolean> deadEntities, toAddEntities;

	protected Game(GUI_Game gui) {
		entities = new ArrayList<Entity>();
		this.gui = gui;
		initializeMap();
	}

	private void initializeMap() {
		player = Player.getInstance(gui.getWidth() / 2 - 25, gui.getHeight() / 6 * 5, this);
		toAddEntities = new HashMap<Entity,Boolean>();
		gui.getContentPane().add(player.getGraphics());
		gui.setComponentLayer(player.getGraphics(), 15);				
		loadObjects();
	}
	
	public void addEnemyCount() { 
		enemyCount++;
	}
	
	public void substractEnemyCount() {
		enemyCount--;
		if (enemyCount == 0) {
			gui.changeLevel();
		}
	}

	protected abstract void loadObjects();

	public void update() {
		player.update();
		gui.updateLifeBar(player.getLife());
		deadEntities = new HashMap<Entity, Boolean>();
		addEntitiesToCollection();
		detectCollisions();
		removeDeadEntities();
	}
	
	public void addEntity(Entity s) {
		toAddEntities.put(s, true);
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
	
	private void addEntitiesToCollection() {
		HashMap<Entity,Boolean> aux = toAddEntities;
		toAddEntities = new HashMap<Entity,Boolean>();
		for(Entity ent: aux.keySet()) {
			entities.add(ent);
			gui.getContentPane().add(ent.getGraphics());
			gui.setComponentLayer(ent.getGraphics(), 5);
		}
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
			gui.getContentPane().remove(entity.getGraphics());
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
}
