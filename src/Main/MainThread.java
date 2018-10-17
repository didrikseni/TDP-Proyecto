package Main;

public class MainThread extends Thread {
	private Game game;
	private static boolean isRunning;
	
	public MainThread(Game g) {
		this.game = g;
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
			
			elapsedTime = (System.nanoTime() - startTime) / 1000000;
			waitTime = targetTime - elapsedTime;			
			try { 
				Thread.sleep(waitTime);
			} catch (Exception e) {}	
		}
	}
	
	public synchronized void pauseGame() {
		if (isRunning) {
			isRunning = false;
		} else {
			isRunning = true;
			this.notify();
		}
	}
	
	public void changeGame(Game game) {
		this.game = game;
	}
	
}
