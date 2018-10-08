package Main;

public class MainThread extends Thread {
	private Game g;
	
	public MainThread(Game g) {
		this.g = g;	
	}
	
	public void run() {
		long startTime = 0;
		long elapsedTime = 0;
		long waitTime = 0;
		long targetTime = 6;
		
		while(true) {
			startTime = System.nanoTime();			
			g.update();
			elapsedTime = (System.nanoTime() - startTime) / 1000000;
			waitTime = targetTime - elapsedTime;			
			try { 
				Thread.sleep(waitTime);
			} catch (Exception e) {}	
		}
		
	}

}
