package PowerUp;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entity.Player;
import Game.Game;
import Visitor.Visitor;

public class WeaponUpgrade1 extends PowerUp {

	public WeaponUpgrade1(int x, int y, Game g) {
		super(x, y, g);
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/pwup.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitPowerUp(this);
	}

	@Override
	public void addPowerUp(Player player) {
		player.aumentarArma();
		game.imDead(this);
		
	}

}
