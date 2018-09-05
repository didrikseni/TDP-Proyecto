package Entity;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Game.Game;
import Shield.Shield;
import Shot.Shot;

public class Player extends Entity {
	private static final int maxLife = 100;
	
	//Attributes
	private Shield shield;
	private int score;
	private Shot shot;
	
	//Constructor
	public Player(int cX, int cY) {
		super(cX,cY,8);
		shield = new Shield();
		shot = new Shot();
		score = 0;
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/XWingArriba.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		
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
