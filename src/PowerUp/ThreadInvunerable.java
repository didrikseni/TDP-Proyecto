package PowerUp;

import Entity.Player;
import Shield.ShieldInvunerable;

public class ThreadInvunerable implements Runnable {
	private boolean isRunning;
	private Player player;
	
	public ThreadInvunerable(Player player) {
		this.player = player;
	}
	
	@Override
	public void run() {
		isRunning = true;
		ShieldInvunerable shield = new ShieldInvunerable(player);
		player.setShield(shield);
		long elapsedTime;
		long targetTime = System.currentTimeMillis() + 7000;
		while (isRunning) {
			elapsedTime = System.currentTimeMillis();
			isRunning = elapsedTime < targetTime;
			try { 
				Thread.sleep(25);
			} catch (Exception e) {}
		}
		player.setShield(shield.getPrev());
	}
}
