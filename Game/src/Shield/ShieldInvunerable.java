package Shield;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Entity.Player;
import Sound.SoundMananger;

public class ShieldInvunerable extends Shield {
	private Shield previouShield;
	private SoundMananger soundClip;
	
	public ShieldInvunerable(Player player) {
		super(player);
		previouShield = player.getShield();
		reduction = 100;
		ImageIcon img = new ImageIcon(this.getClass().getResource("/Resources/Shields/shield_3.png"));
		this.icon = new ImageIcon(img.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		this.shieldGraphics = new JLabel(icon);
	}
	
	public Shield getPrev() {
		return previouShield;
	}

	public void stopSound() {
		soundClip.getClip().stop();
		soundClip.getClip().close();
	}

	public void startSound() {
		soundClip = new SoundMananger("invulnerable.wav");
		soundClip.playSound();
	}
}
