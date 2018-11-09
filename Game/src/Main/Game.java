package Main;

import java.util.ArrayList;
import java.util.Collection;
import Entity.Enemy;
import Entity.Entity;
import Entity.Player;
import GUI.GUI_Game;
import GUI.GUI_GameOver;
import GUI.GUI_Victory;

public abstract class Game {	
	protected GUI_Game gui;
	protected int nivel, enemyCount;
	protected Player player;
	protected ArrayList<Entity> entities, deadEntities, toAddEntities;
	protected String nextLevel, currentLevel;

	protected Game(GUI_Game gui, String path) {
		entities = new ArrayList<Entity>();
		this.gui = gui;
		currentLevel = path;
		initializeMap();
	}

	private void initializeMap() {
		player = Player.getInstance(gui.getWidth() / 2 - 25, gui.getHeight() / 6 * 5, this);
		toAddEntities = new ArrayList<Entity>();
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
		deadEntities = new ArrayList<Entity>();
		addEntitiesToCollection();
		detectCollisions();
		removeDeadEntities();
	}

	public void addEntity(Entity s) {
		toAddEntities.add(s);
	}

	public void addDeadEntity(Entity e) {
		deadEntities.add(e);
	}

	public void addDeadEntity(Enemy e, int score) {
		player.addScore(score);
		deadEntities.add(e);
	}

	public synchronized Collection<Entity> getEntities() {
		return entities;
	}

	private void addEntitiesToCollection() {
		ArrayList<Entity> aux = toAddEntities;
		toAddEntities = new ArrayList<Entity>();
		for(Entity ent: aux) {
			entities.add(ent);
			gui.add(ent.getGraphics());
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
		for(Entity entity: deadEntities) {
			gui.getContentPane().remove(entity.getGraphics());
			entities.remove(entity);
		}
		gui.repaint();
	}

	public void endGame(boolean gameOver) {
		gui.stopGame();
		for(Entity entity: entities) {
			entity.endSound();
		}
		if (gameOver) {			
			GUI_GameOver gameOverGui = GUI_GameOver.getInstance(player.getScore());
			gameOverGui.setVisible(true);
		} else {
			GUI_Victory winGame = GUI_Victory.getInstance(player.getScore());
			winGame.setVisible(true);
		}
		gui.dispose();
	}

	public String getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(String level) {
		this.nextLevel = level;
	}
}