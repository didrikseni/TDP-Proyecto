package Entity;

import java.awt.Image;

import javax.swing.ImageIcon;
import Shield.Shield;
import Visitor.Visitor;
import Visitor.VisitorPlayer;

public class Player extends Entity {
	//Static attributes
	private static Player INSTANCE = null;
	private static final int maxLife = 100;
	
	//Attributes
	private Shield shield;
	private int score;
	private Visitor v;
	 
	
	//Constructor
	private Player(int cX, int cY) {
		super(cX,cY,8);
		shield = new Shield();
		score = 0;
		
		v = new VisitorPlayer();
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/XWingArriba.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}
	
	private synchronized static void createInstance(int x, int y) {
		if (INSTANCE == null) {
			INSTANCE = new Player(x,y);
		}	
	}
	
	/**
	 * Metodo que retorna una instancia de Player
	 * @return Retorna una instancia de Player
	 */
	public static Player getInstance(int x, int y) {
		if(INSTANCE == null) {
			createInstance(x,y);
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
	
}
