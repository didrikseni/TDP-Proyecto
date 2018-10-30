package Entity;

import GUI.GUI_Game;

public class PlayerMovement {
	private Player player;
	private boolean up, down, left, right;

	public PlayerMovement(Player player) {
		this.player = player;
		up = down = left = right = false;
	}

	public void startMove(int dir) {
		switch (dir) {
		case 0 : //Arriba
			up = true;
			break;
		case 1 : //Abajo
			down = true;
			break;
		case 2 : //Izquierda
			left = true;
			break;
		case 3 : //Derecha
			right = true;
			break;
		}
	}

	public void stopMove(int dir) {
		switch (dir) {
		case 0 : //Arriba
			up = false;
			break;
		case 1 : //Abajo
			down = false;
			break;
		case 2 : //Izquierda
			left = false;
			break;
		case 3 : //Derecha
			right = false;
			break;
		}
	}

	public void move() {
		int gx = GUI_Game.getInstance().getWidth();
		int gy = GUI_Game.getInstance().getHeight();

		if(left) 
			player.getRectangle().x -= player.getSpeed(); 
		if(right) 
			player.getRectangle().x += player.getSpeed(); 
		if(up)
			player.getRectangle().y -= player.getSpeed();
		if(down) 
			player.getRectangle().y += player.getSpeed();
		checkCoordX(gx);
		checkCoordY(gy);
	}

	private void checkCoordY(int gy) {
		if(player.getRectangle().y < 0)
			player.getRectangle().y = 0;
		if(player.getRectangle().y > (gy - player.getHeight() - 30))
			player.getRectangle().y = (gy - player.getHeight() - 30);
		if(player.getRectangle().y <= gy / 5 * 3) 
			player.getRectangle().y = gy / 5 * 3;		
	}

	private void checkCoordX(int gx) {
		if(player.getRectangle().x < 0)
			player.getRectangle().x = 0;
		if(player.getRectangle().x >  gx - player.getWidth())
			player.getRectangle().x = gx - player.getWidth(); 
	}

	public boolean getRight() {
		return right;
	}

	public boolean getLeft() {
		return left;
	}	
}
