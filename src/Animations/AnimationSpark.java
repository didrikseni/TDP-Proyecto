package Animations;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class AnimationSpark extends Animation {

	public AnimationSpark(int x, int y) {
		super(x, y);
		label.setBounds(x, y + 30, 40, 40);
	}

	@Override
	public void loadImages() {
		this.array = new Icon[12];
		ImageIcon img;
		for(int i = 0; i < array.length; i++) {
			if (i < 9) {
				img  = new ImageIcon(this.getClass().getResource("/Resources/Sparks/sparks_effect_0" + (i + 1) + ".png"));
			} else {
				img = new ImageIcon(this.getClass().getResource("/Resources/Sparks/sparks_effect_" + (i + 1) + ".png"));
			}
			array[i] = new ImageIcon(img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		}
	}

	
	
}
