package Behaviour;

import java.awt.Point;
import Entity.Enemy;
import Entity.Player;
import GUI.GUI_Game;

public class KamikazeBehaviour extends Behaviour {
	private Player player;
	
	public KamikazeBehaviour() {
		player = Player.getInstance(0,0,null);
	}
	
	public void update(Enemy e) {
		super.update(e);
		Point p = e.getPos();
		GUI_Game gui = GUI_Game.getInstance();
		e.getRectangle().y += e.getSpeed();
		
	    int playerPosX = player.getPos().x;
        int playerPosY = player.getPos().y;
        
        int vectorX = playerPosX - p.x;
        int vectorY = playerPosY - p.y;
        
        double angle = Math.atan2(vectorY, vectorX);
        
        e.getRectangle().x = (int) (2 * Math.cos(angle) + e.getRectangle().x);
		if(p.y > (gui.getHeight() - e.getHeight() - 40)) {
			e.setPos(p.x, 0); 
		}
	}
}
