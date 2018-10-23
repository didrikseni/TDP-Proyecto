package Level;

import GUI.GUI_Game;
import Main.FileOpener;
import Main.Game;
import Main.SoundMananger;

public class Level extends Game {
	protected Thread soundClip;
	
	public Level(GUI_Game gui, String path) {
		super(gui, path);
		soundClip = SoundMananger.playLoopSound("background.wav");
	}

	protected void loadObjects() {
		FileOpener fileOpener = new FileOpener(this, currentLevel, gui);
		fileOpener.loadObjects();
	}
	
	@Override
	public void endGame(boolean b) {
		soundClip.interrupt();
		super.endGame(b);
	}
	
}
