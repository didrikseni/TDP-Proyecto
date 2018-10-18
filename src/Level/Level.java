package Level;

import GUI.GUI_Game;
import Main.FileOpener;
import Main.Game;

public class Level extends Game {
	
	public Level(GUI_Game gui, String path) {
		super(gui, path);
	}

	protected void loadObjects() {
		FileOpener fileOpener = new FileOpener(this, currentLevel, gui);
		fileOpener.loadObjects();
	}
	
}
