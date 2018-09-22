package Entity;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import Game.Game;
import Main.GUI;
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
	private Icon[] iconos;
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
		visitor = new VisitorPlayer(this);		
		firing = false;
		firingTimer = System.nanoTime();
		firingDelay = 200;
		iconos = new Icon[3];

		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/nave_izq.png"));
		iconos[0] = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		img = new ImageIcon(this.getClass().getResource("/Resources/nave.png"));
		iconos[1] = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		img = new ImageIcon(this.getClass().getResource("/Resources/nave_der.png"));		
		iconos[2] = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		
		icon = iconos[1];
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
		GUI gui = GUI.getInstance();
		if (firing) {
			long elapsed = (System.nanoTime() - firingTimer) / 1000000;
			if(elapsed > firingDelay) {
				Shot s = new PlayerShot(pos.x, pos.y, game);
				game.addEntity(s);
				firingTimer = System.nanoTime();
			}
		}
		cambiarGrafico();
		super.update();
		if(pos.y <= gui.getHeight() / 5 * 3) { pos.y = gui.getHeight() / 5 * 3; }
		gui.updateScore(score);
	}
	
	public void aumentarArma() {
		firingDelay = 100;
	}
	
	@Override
	public void accept(Visitor v) {
		v.visitPlayer(this);
	}	
	
	protected void cambiarGrafico(){
		if(this.icon != null){
			if (right) {
				graphic.setIcon(iconos[2]);
			} else if (left) {
				graphic.setIcon(iconos[0]);
			} else {
				graphic.setIcon(iconos[1]);
			}
			graphic.setBounds(this.pos.x, this.pos.y, width, height);
		}
	}
	
	
}
