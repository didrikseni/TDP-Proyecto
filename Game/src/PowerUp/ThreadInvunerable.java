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
		shield.startSound();
		long elapsedTime;
		long targetTime = System.currentTimeMillis() + 6000;
		while (isRunning) {
			elapsedTime = System.currentTimeMillis();
			isRunning = elapsedTime < targetTime && player.getShield().equals(shield);
			try { 
				Thread.sleep(25);
			} catch (Exception e) {}
		}
		shield.stopSound();
		player.setShield(shield.getPrev());
	}
}
