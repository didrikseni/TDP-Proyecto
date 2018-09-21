package Entity;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

import Game.Game;
import Main.GUI;
import Visitor.Visitor;

public abstract class Entity {
	//Attributes
	protected JLabel graphic;
	protected Icon icon;
	protected int life;
	protected Point pos;
	protected int speed, width, height;
	protected boolean up, down, left, right;
	protected Visitor v;
	protected Game g;
	
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
		this.width = 50;
		this.height = 50;		
		up = down = left = right = false;	
		this.g = g;
	}
	
	//Commands	
	/**
	 * Retorna la posicion de la entidad
	 * @return Point con las coordenadas x e y de la entidad.
	 */
	public Point getPos() {
		return pos;		
	}
	
	/**
	 * Retorna la velocidad de la entidad.
	 * @return Entero con la velocidad de la entidad.
	 */
	public int getSpeed() {
		return speed;		
	}
	
	/**
	 * Consulta que retorna un entero con la vida restante de la unidad.
	 * @return Entero con la vida restante de la unidad.
	 */
	public int getLife() {
		return life;		
	}
	
	/**
	 * Quita una cantidad de vida pasada como un parametro entero a la unidad
	 * Y retorna verdadero si la vida de la unidad es menor o igual a '0' luego de recibir daño,
	 * y falso en caso contrario.
	 * @param Entero 'damage' indicando la cantidad de vida que pierde la unidad.
	 * @return Boolean indicando si la unidad esta muerta o no.
	 */
	public void takeDamage(int damage) {
		if (damage >= 0) {
			life -= damage; 
		}
		if(life <= 0) {
			g.mori(this);
		}
	}
	
	/**
	 * Inicia el movimiento del jugador en la direccion indicada por el parametro entero.
	 * @param Entero indicando la direccion en la que hay que iniciar el movimiento
	 * "0": arriba, "1": abajo, "2": izquierda, "3": derecha.
	 */
	public void move(int dir) {
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
		
	/**
	 * Para el movimiento del jugador en la direccion indicada por el parametro entero.
	 * @param Entero indicando la direccion en la que hay que parar el movimiento.
	 */
	public void stop(int dir) {
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
	
	/**
	 * Actualiza la posicion del jugador.
	 */
	public void update() {
		if(left) { pos.x -= speed; }
		if(right) { pos.x += speed; }
		if(up) { pos.y -= speed; }
		if(down) { pos.y += speed; }
		int gx = GUI.getInstance().getWidth();
		int gy = GUI.getInstance().getHeight();
		if(pos.x < width / 2 - 25) { pos.x = width / 2 - 25; }
		if(pos.y < height / 2- 25) { pos.y = height / 2- 25; }
		if(pos.x >  gx - width - 15) { pos.x = gx - width - 15; }
		if(pos.y > (gy - height - 35)) { pos.y = (gy - height - 35); }		
		this.updateGraphics();
	}
	
	/**
	 * Retorna el grafico de la entidad
	 * @return JLabel que contiene el grafico de la entidad.
	 */
	public JLabel getGraphics() {
		if(this.graphic == null) {
			this.graphic = new JLabel(icon);
			this.graphic.setBounds(this.pos.x, this.pos.y, width, height);			
		}
		return this.graphic;
	}
	
	/**
	 * Retorna el juego.
	 * @return Game.
	 */
	public Game getGame() {
		return g;
	}
	
	/**
	 * Retorna un entero con el ancho de la entidad.
	 * @return Entero indicando el ancho de la entidad.
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Retorna un entero con el alto de la entidad.
	 * @return Entero indicando el alto de la entidad.
	 */
	public int getHeight() {
		return height;
	}

	
	/**
	 * Colision con la entidad e.
	 * @param Entidad e.
	 */
	public void collide(Entity e) {
		e.accept(v);
	}
	
	/**
	 * Acepta un visitor.
	 * @param Visitor v.
	 */
	abstract public void accept(Visitor v);	
	
	/**
	 * Actualiza la posicion de la entidad.
	 */
	protected void updateGraphics() {
		if (this.graphic != null) {
			this.graphic.setBounds(this.pos.x, this.pos.y, width, height);	
		}
	}
}
