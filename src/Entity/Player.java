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
		firingDelay = 200;
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/XWingArriba.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}
	
	//Se asegura que no exista una instancia antes de crearla.
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
	/**
	 * Setea un escudo al jugador.
	 * @param Shield s.
	 */
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

	/**
	 * El jugador comienza a disparar de acuerdo con el boolean pasado 
	 * como parametro.
	 * @param Boolean b indicando si el jugador dispara.
	 */
	public void shoot(boolean b) {
		firing = b;
	}
	
	
	/**
	 * Actualiza el jugador.
	 * @Override
	 */
	public void update() { 		
		if (firing) {
			long elapsed = (System.nanoTime() - firingTimer) / 1000000;
			if(elapsed > firingDelay) {
				Shot s = new PlayerShot(pos.x, pos.y, g);
				g.addEntity(s);
				firingTimer = System.nanoTime();
			}
		}
		
		
		if(left) {
			pos.x -= speed;
		}
		if(right) {
			pos.x += speed;
		}
		if(up) {
			pos.y -= speed;
		}
		if(down) {
			pos.y += speed;
		}
		
		int gx = g.getGUI().getWidth();
		int gy = g.getGUI().getHeight();
		
		if(pos.x < width / 2 - 25) {
			pos.x = width / 2 - 25;
		}
		if(pos.y < 3 * gy / 5) {
			pos.y = 3 * gy / 5 ;
		}
		if(pos.x >  gx - width - 15) {
			pos.x = gx - width - 15;
		}
		if(pos.y > (gy - height - 35)) {
			pos.y = (gy - height - 35);
		}
		
		this.updateGraphics();
	}

	
	@Override
	public void accept(Visitor v) {
		v.visitPlayer(this);
	}
	
	
}
