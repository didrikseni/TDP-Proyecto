package Level;

import GUI.GUI_Game;
import Main.FileOpener;
import Main.Game;

public class Level1 extends Game {
	private static Level1 INSTANCE = null;

	private Level1(GUI_Game gui) {
		super(gui);
	}

	public static synchronized Level1 getInstance(GUI_Game gui) {
		if(INSTANCE == null) {
			INSTANCE = new Level1(gui);
		}
		return INSTANCE;
	}

	protected void loadObjects() {
		FileOpener fileOpener = new FileOpener(this, "/Resources/Levels/Level1.txt", gui);
		fileOpener.loadObjects();
	}
	
}
