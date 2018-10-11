package Main;

public class MainThread extends Thread {
	private Game g;
	private static boolean isRunning;
	
	public MainThread(Game g) {
		this.g = g;	
	}
	
	public void run() {
		long startTime = 0;
		long elapsedTime = 0;
		long waitTime = 0;
		long targetTime = 6;
	
		isRunning = true;
		
		while(isRunning) {
			startTime = System.nanoTime();			
			
			g.update();
			
			elapsedTime = (System.nanoTime() - startTime) / 1000000;
			waitTime = targetTime - elapsedTime;			
			try { 
				Thread.sleep(waitTime);
			} catch (Exception e) {}	
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void pauseGame() {
		if (isRunning) {
			isRunning = false;
		} else {
			isRunning = true;
			MainThread.currentThread().resume();
		}
	}
	
}
