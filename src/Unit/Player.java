package Unit;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Level.Level;

public class Player extends Unit {
	private static final int maxLife = 100;
	
	//Attributes
	private int shield;
	private int score;
	
	private int dx;
	private int dy;
	private int speed;
	private boolean left;
	private boolean right;
	private boolean up;
	private boolean down;
	
	//Constructor
	public Player(int cX, int cY) {
		life = maxLife;
		shield = 0;
		score = 0;
		r = 5;
		
		//initializePlayer();
		
		coordX = cX;
		coordY = cY;
		dx = dy = 0;
		speed = 5;
		left = right = up = down = false;
	}
	
	
	//Commands
	public void setSield() {
		shield = 100;
	}
	
	
	@Override
	/**
	 * Redefine el metodo setDamage() de Unit.
	 * @return Boolean si el personaje esta muerto luego de recibir daño,
	 * falso caso contrario.
	 */
	public boolean setDamage(int damage) {
		if(shield > 0) {
			 int diff = damage - shield;
			 if (diff > 0) {
				 shield = 0;
				 return super.setDamage(damage - shield);
			 } else {
				 shield -= damage;
				 return false;
			 }
		}
		return super.setDamage(damage);
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
	 * Setea el movimiento hacia la izquierda de acuerdo a un booleano
	 * pasado como parametro.
	 * @param Booleano que determina el movimiento hacia la izquierda.
	 */
	public void setLeft(boolean b) {
		left = b;
	}
	
	
	/**
	 * Setea el movimiento hacia la derecha de acuerdo a un booleano
	 * pasado como parametro.
	 * @param Booleano que determina el movimiento hacia la derecha.
	 */
	public void setRight(boolean b) {
		right = b;
	}
	
	
	/**
	 * Setea el movimiento hacia arriba de acuerdo a un booleano
	 * pasado como parametro.
	 * @param Booleano que determina el movimiento hacia arriba.
	 */
	public void setUp(boolean b) {
		up = b;
	}
	
	
	/**
	 * Setea el movimiento hacia abajo de acuerdo a un booleano
	 * pasado como parametro.
	 * @param Booleano que determina el movimiento hacia abajo.
	 */
	public void setDown(boolean b) {
		down = b;
	}
	
	
	/**
	 * Añade la cantidad de puntos pasada como parametro al score del jugador.
	 * @param Entero s con los puntos a añadir.
	 */
	public void addScore(int s) {
		score += s;
	}
	
	
	/**
	 * Actualiza al jugador de acuerdo a los atributos.
	 */
	public void update() {
		if(left) {
			dx = -speed;
		}
		if(right) {
			dx = speed;
		}
		if(up) {
			dy = -speed;
		}
		if(down) {
			dy = speed;
		}
		
		coordX += dx;
		coordY += dy;
		
		if(coordX < r) coordX = r;
		if(coordY < r) coordY = r;
		
		if(coordX > Level.WIDTH - r ) {
			coordX = Level.WIDTH - r;
		}
		if(coordY > Level.HEIGHT - r ) {
			coordY = Level.HEIGHT - r;
		}
		
		
		dx = 0;
		dy = 0;
	}
	
	public Player initializePlayer() {
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/XWingArriba.png"));
		Icon icon = new ImageIcon(img.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		this.setIcon(icon);
		return this;
	}
	
}
