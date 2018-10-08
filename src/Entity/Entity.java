package Entity;

import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JLabel;
import Main.GUI;
import Main.Game;
import Visitor.Visitor;

public abstract class Entity {
	//Attributes
	protected JLabel graphic;
	protected Icon icon;
	protected int life;
	protected Point pos;
	protected int speed, width, height;
	protected boolean up, down, left, right;
	protected Visitor visitor;
	protected Game game;
	
	//Constructor
	/**
	 * Constructor de entidad
	 * @param Game g
	 * @param Entero coordenada x
	 * @param Entero coordenada y
	 * @param Entero velocidad
	 */
	protected Entity(int x, int y, int speed, Game g) {
		this.pos = new Point(x,y);
		this.speed = speed;
		this.life = 100;
		this.width = 40;
		this.height = 40;		
		up = down = left = right = false;	
		this.game = g;
	}
	
	public Point getPos() {
		return pos;		
	}
	
	public int getSpeed() {
		return speed;		
	}
	
	public int getLife() {
		return life;		
	}
	
	public void takeDamage(int damage) {
		if (damage >= 0) {
			life -= damage; 
		}
		if(life <= 0) {
			game.deadEntity(this);
		}
	}
	
	public void startMove(int dir) {
		switch (dir) {
			case 0 : //Arriba
				up = true;
				break;
			case 1 : //Abajo
				down = true;
				break;
			case 2 : //Izquierda
				left = true;
				break;
			case 3 : //Derecha
				right = true;
				break;
		}
	}
		
	public void stopMove(int dir) {
		switch (dir) {
			case 0 : //Arriba
				up = false;
				break;
			case 1 : //Abajo
				down = false;
				break;
			case 2 : //Izquierda
				left = false;
				break;
			case 3 : //Derecha
				right = false;
				break;
		}
	}
	
	public void update() {
		if(left) { pos.x -= speed; }
		if(right) { pos.x += speed; }
		if(up) { pos.y -= speed; }
		if(down) { pos.y += speed; }
		int gx = GUI.getInstance().getAncho();
		int gy = GUI.getInstance().getAlto();
		if(pos.x < 0) { pos.x = 0; }
		if(pos.y < 0) { pos.y = 0; }
		if(pos.x >  gx - width - 10) { pos.x = gx - width - 10; }
		if(pos.y > (gy - height - 30)) { pos.y = (gy - height - 30); }
		this.updateGraphics();
	}
	
	public JLabel getGraphics() {
		if(this.graphic == null) {
			this.graphic = new JLabel(icon);
			this.graphic.setBounds(this.pos.x, this.pos.y, width, height);			
		}
		return this.graphic;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public void collide(Entity e) {
		e.accept(visitor);
	}
	
	abstract public void accept(Visitor v);	
	
	protected void updateGraphics() {
		if (this.graphic != null) {
			this.graphic.setBounds(this.pos.x, this.pos.y, width, height);	
		}
	}
}
