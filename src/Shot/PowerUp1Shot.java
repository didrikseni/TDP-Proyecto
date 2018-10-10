package Shot;

import java.awt.Image;
import javax.swing.ImageIcon;
import Main.Game;
import Visitor.Visitor;
import Visitor.VisitorShotPlayer;

public class PowerUp1Shot extends PlayerShot {
	private int movimientoHorizontal;
	
	public PowerUp1Shot(int x, int y, int movHor, Game g) {
		super(x, y, g);
		damage = 30;
		visitor = new VisitorShotPlayer(this);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shots/disparo.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		movimientoHorizontal = movHor;
	}

	@Override
	public void accept(Visitor v) {
		
	}
	
	public void update() {
		rectangle.x += movimientoHorizontal;
		super.update();		
	}

}
