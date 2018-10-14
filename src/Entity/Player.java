package Entity;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import GUI.GUI_Game;
import Main.Game;
import Shield.Shield;
import Shield.ShieldDefault;
import Visitor.Visitor;
import Visitor.VisitorPlayer;
import Weapon.Weapon;
import Weapon.WeaponPlayer;

public class Player extends Entity {
	private static Player INSTANCE = null;
	private Icon[] iconos;
	private Weapon weapon;
	private Shield shield;
	private int score;
	private boolean firing;
	private long firingTimer, firingDelay;
	private JLabel graphicShield;
	
	private Player(int cX, int cY, Game g) {
		super(cX, cY, 3, g);
		shield = new ShieldDefault(this);		
		score = 0;
		visitor = new VisitorPlayer(this);
		weapon = new WeaponPlayer(g);
		firing = false;
		firingTimer = System.nanoTime();
		firingDelay = 300;
		iconos = new Icon[3];
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/nave_izq.png"));
		iconos[0] = new ImageIcon(img.getImage().getScaledInstance(width + 20 , height, Image.SCALE_DEFAULT));
		img = new ImageIcon(this.getClass().getResource("/Resources/nave.png"));
		iconos[1] = new ImageIcon(img.getImage().getScaledInstance(width + 20, height, Image.SCALE_DEFAULT));
		img = new ImageIcon(this.getClass().getResource("/Resources/nave_der.png"));		
		iconos[2] = new ImageIcon(img.getImage().getScaledInstance(width + 20, height, Image.SCALE_DEFAULT));
		icon = iconos[1];
		graphicShield = new JLabel();
	}
	
	public static Player getInstance(int x, int y, Game g) {
		if(INSTANCE == null) {
			INSTANCE = new Player(x,y,g);
		}
		return INSTANCE;
	}
	
	public Shield getShield() {
		return shield;
	}
	
	public void setSield(Shield s) {
		shield = s;
		this.graphicShield.setIcon(s.getIcon());
		GUI_Game.getInstance().addComponentInLayer(graphicShield, 50);
	}
	
	public void setPotion() {
		life = 100;
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
		GUI_Game gui = GUI_Game.getInstance();
		if (firing) {
			long elapsed = (System.nanoTime() - firingTimer) / 1000000;
			if(elapsed > firingDelay) {
				weapon.shoot(rectangle.getLocation());
				firingTimer = System.nanoTime();
			}
		}
		cambiarGrafico();
		super.update();
		updateGraphicShield();
		if(rectangle.y <= gui.getHeight() / 5 * 3) 
			rectangle.y = gui.getHeight() / 5 * 3;
		gui.updateScore(score);
	}
	
	private void updateGraphicShield() {
		if (graphicShield.getGraphics() != null)
			this.graphicShield.setBounds(rectangle);
	}

	@Override
	public void accept(Visitor v) {
		v.visitPlayer(this);
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	public JLabel getGraphics() {
		if(this.graphic == null) {
			this.graphic = new JLabel(icon);
			this.graphic.setBounds(rectangle.x, rectangle.y, width, height);
		}
		return this.graphic;
	}
	
	@Override
	public void takeDamage(int damage) {
		int x = shield.takeDamage(damage);
		if (x >= 0) {
			life -= x; 
		}
		if(life <= 0) {
			game.gameOver();
		}
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
			graphic.setBounds(rectangle.x, rectangle.y, width, height);
		}
	}
	
}
