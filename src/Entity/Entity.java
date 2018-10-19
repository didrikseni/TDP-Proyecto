package Entity;

import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.JLabel;
import Main.Game;
import Visitor.Visitor;

public abstract class Entity {
	protected JLabel graphic;
	protected Icon icon;
	protected int life, speed, width, height;
	protected Rectangle rectangle;
	protected Visitor visitor;
	protected Game game;
	
	protected Entity(int x, int y, int speed, Game g) {
		this.speed = speed;
		this.life = 100;
		this.width  = this.height = 40;	
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
			game.addDeadEntity(this);
		}
	}
	
	public abstract void update();
	
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
