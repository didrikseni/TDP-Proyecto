package Level;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Unit.Player;

public class Level1 extends Level implements Runnable, KeyListener {
	//Attributes
	
	//Constructor
	public Level1() {
		super();		
		initializeMap();
	}
	
	
	//Commands
	
	/**
	 * Inicializa el mapa, cargando jugador, obstaculos, y enemigos.
	 */
	private void initializeMap() {
		ImageIcon img = new ImageIcon(getClass().getResource("/Resources/Fondo.png"));
		Icon icon = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		JLabel background = new JLabel();
		background.setVisible(true);
		background.setIcon(icon);
		background.setBounds(0, 0, 600, 700);
		contentPane.add(background);
		contentPane.setLayer(background, 1);	
		
	}

	
	private void update() {
		
		
	}

	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_LEFT) {
			player.setLeft(true);
		}
		if(keyCode == KeyEvent.VK_RIGHT) {
			player.setRight(true);
		}
		if(keyCode == KeyEvent.VK_UP) {
			player.setUp(true);
		}
		if(keyCode == KeyEvent.VK_DOWN) {
			player.setDown(true);
		}		
		player.update();
		update();
	}
	


	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_LEFT) {
			player.setLeft(false);
		}
		if(keyCode == KeyEvent.VK_RIGHT) {
			player.setRight(false);
		}
		if(keyCode == KeyEvent.VK_UP) {
			player.setUp(false);
		}
		if(keyCode == KeyEvent.VK_DOWN) {
			player.setDown(false);
		}
		player.update();
	}
	public void keyTyped(KeyEvent e) {}
	

	
	public void run() {
		
		
	}
	
}
