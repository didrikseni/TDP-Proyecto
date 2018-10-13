package Animation;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class AnimationExplotion_2 extends Animation {

	public AnimationExplotion_2(int x, int y) {
		super(x, y);
	}
	
	public void loadImages() {
		this.array = new Icon[12];
		ImageIcon img;
		for(int i = 0; i < array.length; i++) {
			if (i < 10) {
				img  = new ImageIcon(this.getClass().getResource("/Resources/Explosiones/expl_01_000" + i + ".png"));
			} else {
				img = new ImageIcon(this.getClass().getResource("/Resources/Explosiones/expl_01_00" + i  + ".png"));
			}
			array[i] = new ImageIcon(img.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
		}
	}	

}
