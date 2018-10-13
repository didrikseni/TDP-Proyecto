package Entity;

import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.JLabel;

import GUI.GUI_Game;
import Main.Game;
import Visitor.Visitor;

public abstract class Entity {
	//Attributes
	protected JLabel graphic;
	protected Icon icon;
	protected int life, speed, width, height;
	protected Rectangle rectangle;
	protected boolean up, down, left, right;
	protected Visitor visitor;
	protected Game game;
	
	protected Entity(int x, int y, int speed, Game g) {
		this.speed = speed;
		this.life = 100;
		this.width  = this.height = 40;
		up = down = left = right = false;	
		this.game = g;
		rectangle = new Rectangle();
		rectangle.setLocation(x, y);
		rectangle.setSize(width, height);
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}
	
	public Point getPos() {
		return rectangle.getLocation();		
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
		if(left) { rectangle.x -= speed; }
		if(right) { rectangle.x += speed; }
		if(up) { rectangle.y -= speed; }
		if(down) { rectangle.y += speed; }
		int gx = GUI_Game.getInstance().getAncho();
		int gy = GUI_Game.getInstance().getAlto();
		if(rectangle.x < 0) { rectangle.x = 0; }
		if(rectangle.y < 0) { rectangle.y = 0; }
		if(rectangle.x >  gx - width - 10) { rectangle.x = gx - width - 10; }
		if(rectangle.y > (gy - height - 30)) { rectangle.y = (gy - height - 30); }
		
		this.updateGraphics();
	}
	
	public JLabel getGraphics() {
		if(this.graphic == null) {
			this.graphic = new JLabel(icon);
			this.graphic.setBounds(rectangle.x, rectangle.y, width, height);
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
			this.graphic.setBounds(rectangle.x, rectangle.y, width, height);	
		}
	}
}
