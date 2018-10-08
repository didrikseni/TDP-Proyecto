package Main;


public class Animations {
	private static Animations INSTANCE = null;
	private GUI gui;
	private Thread animator;
		
	private Animations(GUI gui) {
		animator = null;
		this.gui = gui;
	}
	
	public synchronized Animations getInstance(GUI gui) {
		if (INSTANCE == null) {
			INSTANCE = new Animations(gui);
		}
		return INSTANCE;
	}
	
	public void startSparkAnimation(int x, int y) {
		
	}
	
}
