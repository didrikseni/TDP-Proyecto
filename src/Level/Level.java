package Level;

import GUI.GUI_Game;
import Main.FileOpener;
import Main.Game;
import Main.SoundMananger;

public class Level extends Game {
	
	public Level(GUI_Game gui, String path) {
		super(gui, path);
		SoundMananger.playBackgroundSound("backgroundLevel1.wav");
	}

	protected void loadObjects() {
		FileOpener fileOpener = new FileOpener(this, currentLevel, gui);
		fileOpener.loadObjects();
	}
	
}
