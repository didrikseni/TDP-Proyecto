package PowerUp;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entity.Player;
import Main.Game;
import Visitor.Visitor;

public class Freeze extends TemporalMagic {
	public Freeze(int x, int y, Game g) {
		super(x, y, g);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shots/pwup.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitPowerUp(this);
	}

	@Override
	public void addPowerUp(Player player) {
		ThreadFreeze threadFreeze = new ThreadFreeze(game);
		game.deadEntity(this);
		Thread thread = new Thread(threadFreeze);
		thread.start();
		
	}
	
	@Override
	public void update() {}

}
