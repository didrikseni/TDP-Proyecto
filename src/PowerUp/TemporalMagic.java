package PowerUp;

import Main.Game;

public abstract class TemporalMagic extends PowerUp implements Runnable {

	protected TemporalMagic(int x, int y, Game g) {
		super(x, y, g);
	}

}
