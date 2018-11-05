package Level;

import GUI.GUI_Game;
import Main.Game;
import Sound.SoundMananger;

public class Level extends Game {
	protected SoundMananger soundClip;
	
	public Level(GUI_Game gui, String path) {
		super(gui, path);
		soundClip = new SoundMananger("background.wav");
		soundClip.playLoopSound();
	}

	protected void loadObjects() {
		FileOpener fileOpener = new FileOpener(this, currentLevel, gui);
		fileOpener.loadObjects();
	}
	
	@Override
	public void endGame(boolean b) {
		soundClip.getClip().stop();
		soundClip.getClip().close();
		super.endGame(b);
	}
	
}
