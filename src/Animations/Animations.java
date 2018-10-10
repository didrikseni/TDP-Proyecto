package Animations;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Animations {
	private static Animations INSTANCE;
	private AnimationMananger animationMananger;
	
	private Animations() {
		animationMananger = AnimationMananger.getInstance();
	}
	
	public synchronized static Animations getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Animations();
		}
		return INSTANCE;		
	}
	
	public void startSparkAnimation(int x, int y) {
		Icon[] arr = new Icon[24];
		ImageIcon img;
		for(int i = 0; i < arr.length; i++) {
			if (i < 10) {
				img  = new ImageIcon(this.getClass().getResource("/Resources/Explosiones/expl_11_000" + i + ".png"));
			} else {
				img = new ImageIcon(this.getClass().getResource("/Resources/Explosiones/expl_11_00" + i  + ".png"));
			}
			arr[i] = new ImageIcon(img.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
		}
		animationMananger.addAnimation(arr, x, y);
	}
	
}
