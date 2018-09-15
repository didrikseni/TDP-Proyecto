package Entity;

import java.awt.Image;

import javax.swing.ImageIcon;

import Game.Game;
import Shield.Shield;
import Shot.PlayerShot;
import Shot.Shot;
import Visitor.Visitor;
import Visitor.VisitorPlayer;

public class Player extends Entity {
	//Static attributes
	private static Player INSTANCE = null;
	private static final int maxLife = 100;
	
	//Attributes
	private Game g;
	private Shield shield;
	private int score;
	private boolean firing;
	private long firingTimer;
	private long firingDelay;
	 
	
	//Constructor
	private Player(int cX, int cY, Game g) {
		super(cX,cY,8, g);
		shield = new Shield();
		score = 0;
		
		this.g = g;
		
		v = new VisitorPlayer(this);
		
		firing = false;
		firingTimer = System.nanoTime();
		firingDelay = 150;
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/XWingArriba.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}
	
	private synchronized static void createInstance(int x, int y, Game g) {
		if (INSTANCE == null) {
			INSTANCE = new Player(x,y,g);
		}	
	}
	
	/**
	 * Metodo que retorna una instancia de Player
	 * @return Retorna una instancia de Player
	 */
	public static Player getInstance(int x, int y, Game g) {
		if(INSTANCE == null) {
			createInstance(x,y,g);
		}
		return INSTANCE;
	}
	
	
	
	//Commands
	public void setSield(Shield s) {
		shield = s;
	}
	
	
	
	/**
	 * Cura todos los puntos de vida del personaje.
	 */
	public void setPotion() {
		life = maxLife;
	}
	
	
	/**
	 * Retorna un entero conteniendo el score del jugador.
	 * @return Entero con el score de jugador.
	 */
	public int getScore() {
		return score;		
	}
	
	
	/**
	 * Añade la cantidad de puntos pasada como parametro al score del jugador.
	 * @param Entero s con los puntos a añadir.
	 */
	public void addScore(int s) {
		score += s;
	}

	public void shoot(boolean b) {
		firing = b;
	}
	
	public void stop(int dir) {
		if (dir < 4) {
			super.stop(dir);
		} else {
			firing = false;
		}
	}
	
	public void update() { 		
		if (firing) {
			long elapsed = (System.nanoTime() - firingTimer) / 1000000;
			if(elapsed > firingDelay) {
				Shot s = new PlayerShot(pos.x, pos.y, g);
				g.addEntity(s);
				firingTimer = System.nanoTime();
			}
		}
		super.update();
	}

	@Override
	public void accept(Visitor v) {
		v.visitPlayer(this);
	}
	
	
}
