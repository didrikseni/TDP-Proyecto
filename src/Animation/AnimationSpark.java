package Animation;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class AnimationSpark extends Animation {

	public AnimationSpark(int x, int y) {
		super(x,y, 40, 40);
		label.setBounds(x, y + 30, 40, 40);
	}

	@Override
	public void loadImages() {
		this.array = new Icon[12];
		ImageIcon img;
		for(int i = 0; i < array.length; i++) {
			img  = new ImageIcon(this.getClass().getResource("/Resources/Effects/sparks_effect_" + (i + 1) + ".png"));
			array[i] = new ImageIcon(img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		}
	}

	
	
}
