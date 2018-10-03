package Entity;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import Main.GUI;
import Main.Game;
import Shield.Shield;
import Visitor.Visitor;
import Visitor.VisitorPlayer;
import Weapon.Weapon;
import Weapon.WeaponPlayer;

public class Player extends Entity {
	//Static attributes
	private static Player INSTANCE = null;
	private static final int maxLife = 100;
	//Attributes
	private Icon[] iconos;
	private Weapon weapon;
	private Shield shield;
	private int score;
	private boolean firing;
	private long firingTimer;
	private long firingDelay;	 
	
	//Constructor
	private Player(int cX, int cY, Game g) {
		super(cX, cY, 3, g);
		shield = new Shield();
		score = 0;
		visitor = new VisitorPlayer(this);
		weapon = new WeaponPlayer(g);
		firing = false;
		firingTimer = System.nanoTime();
		firingDelay = 250;
		iconos = new Icon[3];
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/nave_izq.png"));
		iconos[0] = new ImageIcon(img.getImage().getScaledInstance(width + 20 , height, Image.SCALE_DEFAULT));
		img = new ImageIcon(this.getClass().getResource("/Resources/nave.png"));
		iconos[1] = new ImageIcon(img.getImage().getScaledInstance(width + 20, height, Image.SCALE_DEFAULT));
		img = new ImageIcon(this.getClass().getResource("/Resources/nave_der.png"));		
		iconos[2] = new ImageIcon(img.getImage().getScaledInstance(width + 20, height, Image.SCALE_DEFAULT));
		icon = iconos[1];
	}
	
	private synchronized static void createInstance(int x, int y, Game g) {
		if (INSTANCE == null) {
			INSTANCE = new Player(x,y,g);
		}
	}
	
	public static Player getInstance(int x, int y, Game g) {
		if(INSTANCE == null) {
			createInstance(x,y,g);
		}
		return INSTANCE;
	}
	
	public Shield getShield() {
		return shield;
	}
	
	public void setSield(Shield s) {
		shield = s;
	}	
	
	public void setPotion() {
		life = maxLife;
	}	
	
	public int getScore() {
		return score;		
	}	
	
	public void addScore(int s) {
		score += s;
	}

	public void shoot(boolean b) {
		firing = b;
	}	
	
	@Override
	public void update() { 
		GUI gui = GUI.getInstance();
		if (firing) {
			long elapsed = (System.nanoTime() - firingTimer) / 1000000;
			if(elapsed > firingDelay) {
				weapon.shoot(pos);
				firingTimer = System.nanoTime();
			}
		}
		cambiarGrafico();
		super.update();
		if(pos.y <= gui.getHeight() / 5 * 3) { pos.y = gui.getHeight() / 5 * 3; }
		gui.updateScore(score);
	}
	
	public void aumentarArma() {
		firingDelay = 150;
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
