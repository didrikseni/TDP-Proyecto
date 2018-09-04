package Level;


import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import Obstacles.Obstacles;
import PowerUp.PowerUp;
import Shot.Shot;
import Unit.Enemy;
import Unit.Player;

public abstract class Level extends JFrame {	
	//Attributes
	protected Player player;
	protected ArrayList<Enemy> enemys;
	protected ArrayList<Obstacles> obstacles;
	protected ArrayList<Shot> shots;
	protected ArrayList<PowerUp> powerUps;
	protected JLayeredPane contentPane;
	

	//Constructor
	public Level() {
		this.setTitle("Prueba");
		this.setBounds(100, 100, 600, 700);
		this.setSize(600, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		contentPane = new JLayeredPane();
		contentPane.setLayout(null);
		this.setContentPane(contentPane);		
		
		
		player = new Player(this.getWidth() / 2 - 25 , this.getHeight() / 4 * 3);
		player.initializePlayer();		
		player.setVisible(true);
		player.setBounds(0, 0, 50, 50);
		contentPane.add(player);
		contentPane.setLayer(player, 2);
		
		enemys = new ArrayList<Enemy>();
		obstacles = new ArrayList<Obstacles>();
		shots = new ArrayList<Shot>();
		powerUps = new ArrayList<PowerUp>();
	}
	
}
