package Level;

import GUI.GUI_Game;
import Main.FileOpener;
import Main.Game;

public class Level2 extends Game {
	private static Level2 INSTANCE = null;
	
	private Level2(GUI_Game gui) {
		super(gui);
	}
	
	public static synchronized Level2 getInstance(GUI_Game gui) {
		if(INSTANCE == null) {
			INSTANCE = new Level2(gui);
		}
		return INSTANCE;
	}

	protected void loadObjects() {
		FileOpener fileOpener = new FileOpener(this, "/Resources/Levels/Level2.txt", gui);
		fileOpener.loadObjects();
	}
}
