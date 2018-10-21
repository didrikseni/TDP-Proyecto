package Animation;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class AnimationSuperMissile extends Animation {

	public AnimationSuperMissile(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void loadImages() {
		this.array = new Icon[12];
		ImageIcon img;
		for(int i = 0; i < array.length; i++) {
			img  = new ImageIcon(this.getClass().getResource("/Resources/Effects/expl_01_" + i + ".png"));
			array[i] = new ImageIcon(img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		}
	}

}
