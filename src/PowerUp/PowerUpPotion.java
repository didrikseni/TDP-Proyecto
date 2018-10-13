package PowerUp;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entity.Player;
import GUI.GUI_Game;
import Main.Game;
import Visitor.Visitor;

public class PowerUpPotion extends PowerUp {

	public PowerUpPotion(int x, int y, Game g) {
		super(x, y, g);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/PowerUp/icon_46.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}

	@Override
	public void accept(Visitor v) {
		v.visitPowerUp(this);
	}

	@Override
	public void addPowerUp(Player player) {
		player.setPotion();
		GUI_Game.getInstance().repaint();
		game.deadEntity(this);
	}

}
