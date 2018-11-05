package Behaviour;

import java.awt.Point;
import Entity.Enemy;
import Entity.Player;

public class KamikazeBehaviour extends Behaviour {
	private Player player;
	
	public KamikazeBehaviour() {
		player = Player.getInstance(0,0,null);
	}
	
	public void update(Enemy e) {
		super.update(e);
		Point p = e.getPos();
		
		e.getRectangle().y += e.getSpeed();
		
	    int playerPosX = player.getPos().x;
        int playerPosY = player.getPos().y;
        
        int vectorX = playerPosX - p.x;
        int vectorY = playerPosY - p.y;
        
        double angle = Math.atan2(vectorY, vectorX);
        
        e.getRectangle().x = (int) (2 * Math.cos(angle) + e.getRectangle().x);
	}

	@Override
	public void changeBehaviour(Enemy enemy) {
		enemy.setComportamiento(new DizzyBehaviour());
	}

}
