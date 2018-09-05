package Entity;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

import Main.GUI;




public abstract class Entity {
	//Attributes
	protected JLabel graphic;
	protected Icon icon;
	protected int life;
	protected Point pos;
	protected int speed;
	protected int width = 50;
	protected int height = 50;
	protected boolean up;
	protected boolean down;
	protected boolean left;
	protected boolean right;
	
	
	//Constructor
	/**
	 * Constructor de entidad
	 * @param Entero coordenada x
	 * @param Entero coordenada y
	 * @param Entero velocidad
	 */
	protected Entity(int x, int y, int speed) {
		this.pos = new Point(x,y);
		this.speed = speed;		
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
	public int getVelocity() {
		return speed;		
	}
	
	
	/**
	 * Consulta que retorna un entero con la vida restante de la unidad.
	 * @return Entero con la vida restante de la unidad.
	 */
	public int getLife() {
		return life;		
	}
	
	// Command
	
	/**
	 * Quita una cantidad de vida pasada como un parametro entero a la unidad
	 * Y retorna verdadero si la vida de la unidad es menor o igual a '0' luego de recibir daño,
	 * y falso en caso contrario.
	 * @param Entero 'damage' indicando la cantidad de vida que pierde la unidad.
	 * @return Boolean indicando si la unidad esta muerta o no.
	 */
	public boolean setDamage(int damage) {
		if (damage >= 0) {
			life -= damage; 
		}
		return (life <= 0) ? true : false;
	}
	
	
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
	
	
	
	public void update() {
		if(left) {
			pos.x -= speed;
		}
		if(right) {
			pos.x += speed;
		}
		if(up) {
			pos.y -= speed;
		}
		if(down) {
			pos.y += speed;
		}
		
		//Preguntar la chanchada esta.
		if(pos.x < width / 2 - 25) 
			pos.x = width / 2 - 25;
		if(pos.y < height / 2- 25) 
			pos.y = height / 2- 25;
		if(pos.x > 600 - width - 17) 
			pos.x = 600 - width - 17;
		if(pos.y > (700 - height - 40)) 
			pos.y = (700 - height - 40);
		
		
		this.updateGraphics();
	}


	/**
	 * Actualiza la posicion de la entidad.
	 */
	protected void updateGraphics() {
		if (this.graphic != null) {
			this.graphic.setBounds(this.pos.x, this.pos.y, width, height);	
		}
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
}
