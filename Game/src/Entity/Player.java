package Entity;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	private PlayerMovement playerMovement;

	private Player(int cX, int cY, Game g) {
		super(cX, cY, 3, g);
		shield = new ShieldDefault(this);		
		visitor = new VisitorPlayer(this);
		playerMovement = new PlayerMovement(this);
		weapon = new WeaponPlayer(g);
		firing = false;
		firingTimer = System.nanoTime();
		firingDelay = 300;
		iconos = new Icon[3];
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Ships/nave_izq.png"));
		iconos[0] = new ImageIcon(img.getImage().getScaledInstance(rectangle.width + 20 , rectangle.height, Image.SCALE_DEFAULT));
		img = new ImageIcon(this.getClass().getResource("/Resources/Ships/nave.png"));
		iconos[1] = new ImageIcon(img.getImage().getScaledInstance(rectangle.width + 20, rectangle.height, Image.SCALE_DEFAULT));
		img = new ImageIcon(this.getClass().getResource("/Resources/Ships/nave_der.png"));		
		iconos[2] = new ImageIcon(img.getImage().getScaledInstance(rectangle.width + 20, rectangle.height, Image.SCALE_DEFAULT));
		icon = iconos[1];
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

	public void setShield(Shield s) {
		GUI_Game gui = GUI_Game.getInstance();
		if (shield.getGraphics() != null)
			gui.remove(shield.getGraphics());
		shield = s;
		if (shield.getGraphics() != null) {
			gui.add(shield.getGraphics());
			gui.setComponentLayer(shield.getGraphics(), 15); 
		}
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

	public void update() {		
		GUI_Game gui = GUI_Game.getInstance();
		if (firing) {
			long elapsed = (System.nanoTime() - firingTimer) / 1000000;
			if(elapsed > firingDelay) {
				weapon.shoot(rectangle.getLocation());
				firingTimer = System.nanoTime();
			}
		}
		shield.update();
		playerMovement.move();	
		updateGraphics();	
		gui.updateScore(score);
	}

	@Override
	public void accept(Visitor v) {
		v.visitPlayer(this);
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	@Override
	public void takeDamage(int damage) {
		int x = shield.takeDamage(damage);
		if (x >= 0) {
			life -= x; 
		}
		if(life <= 0) {
			game.endGame(true);
		}
	}

	protected void updateGraphics() {
		if(this.icon != null){
			if (playerMovement.getRight()) {
				graphic.setIcon(iconos[2]);
			} else if (playerMovement.getLeft()) {
				graphic.setIcon(iconos[0]);
			} else {
				graphic.setIcon(iconos[1]);
			}
			graphic.setBounds(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		}
	}

	public void setGame(Game game) {
		this.game = game;
		weapon.setGame(game);
		GUI_Game gui = GUI_Game.getInstance();
		if (shield.getGraphics() != null) {
			gui.add(shield.getGraphics());
			gui.setComponentLayer(shield.getGraphics(), 15); 
		}
	}

	public PlayerMovement getPlayerMovement() {
		return playerMovement;
	}	
}