package Unit;

public abstract class Unit {
	//Attributes
	protected int life;
	protected int coordX; 
	protected int coordY;
	
	//Commands
	/**
	 * Consulta que retorna un entero con la posicion X de la unidad.
	 * @return Entero con la posicion X de la unidad.
	 */
	public int getX() {
		return coordX;
	}
	
	/**
	 * Consulta que retorna un entero con la posicion Y de la unidad.
	 * @return Entero con la posicion Y de la unidad.
	 */
	public int getY() {
		return coordY;		
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
	 * Y retorna verdadero si la unidad esta muerta luego de recibir daño,
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
	
	
	
}
