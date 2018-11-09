package Shot;

import Entity.Entity;
import Main.Game;
import Sound.SoundMananger;

public abstract class Shot extends Entity {
	protected int damage;
	
	public Shot(int x, int y, Game g) {
		super(x, y, 4, g);
		rectangle.height = 30; 
		rectangle.width = 10;
		this.soundClip = new SoundMananger("laser.wav");
		this.soundClip.playSound();
	}
	
	@Override
	public void update() {
		this.updateGraphics();
		if(rectangle.y < -15) {
			game.addDeadEntity(this);
		}
	}

	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {	
		this.damage = damage; 
	}
	
}
