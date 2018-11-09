package Main;

import java.util.ArrayList;
import java.util.Collection;

public class MainThread extends Thread {
	private Game game;
	private static boolean isRunning;
	private static Collection<Excecute> toExcecute;

	public MainThread(Game g) {
		this.game = g;
		toExcecute = new ArrayList<Excecute>();
	}

	public void run() {
		long startTime = 0;
		long elapsedTime = 0;
		long waitTime = 0;
		long targetTime = 6;

		isRunning = true;

		while(isRunning) {
			startTime = System.nanoTime();
			game.update();
			Collection<Excecute> auxiliar = toExcecute;
			toExcecute = new ArrayList<Excecute>();			
			for(Excecute excecute: auxiliar) {
				excecute.excecute();
			}
			elapsedTime = (System.nanoTime() - startTime) / 1000000;
			waitTime = targetTime - elapsedTime;			
			try { 
				Thread.sleep(waitTime);
			} catch (Exception e) {}	
		}
	}

	public static void addToExcecute(Excecute ex) {
		toExcecute.add(ex);	
	}

	public void changeGame(Game game) {
		this.game = game;
	}

	public void stopGame() {
		isRunning = false;
	}

}
