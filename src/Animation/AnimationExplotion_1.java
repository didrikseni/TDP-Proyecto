package Animation;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class AnimationExplotion_1 extends Animation {
	
	public AnimationExplotion_1(int x, int y) {
		super(x - 10, y - 10, 60, 60);
	}
	
	public void loadImages() {
		this.array = new Icon[12];
		ImageIcon img;
		for(int i = 0; i < array.length; i++) {
			img  = new ImageIcon(this.getClass().getResource("/Resources/Effects/expl_11_" + i + ".png"));
			array[i] = new ImageIcon(img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		}
	}	
}
