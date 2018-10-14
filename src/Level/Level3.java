package Level;

import GUI.GUI_Game;
import Main.FileOpener;
import Main.Game;

public class Level3 extends Game {
	private static Level3 INSTANCE = null;
	
	private Level3(GUI_Game gui) {
		super(gui);
	}
	
	public static synchronized Level3 getInstance(GUI_Game gui) {
		if(INSTANCE == null) {
			INSTANCE = new Level3(gui);
		}
		return INSTANCE;
	}

	protected void loadObjects() {
		FileOpener fileOpener = new FileOpener(this, "/Resources/Levels/Level3.txt", gui);
		fileOpener.loadObjects();
	}
}
