package GUI;

import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import Entity.Player;
import Level.*;
import Main.*;

@SuppressWarnings("serial")
public class GUI_Game extends JFrame {
	private static GUI_Game INSTANCE = null;

	private JLayeredPane contentPane;
	private MainThread mainThread;
	private JLabel background, score, lifeBar, auxBar;
	private PlayerInteractionMananger playerInteraction;
	private Game game;

	private GUI_Game() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Game frame = getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		addKeyListener(new KeyListener(this));
		inicializar();		
		game = new Level(this, "/Resources/Levels/Level1.txt");
		playerInteraction = new PlayerInteractionMananger(Player.getInstance(0,0,null));
		mainThread = new MainThread(game);
		mainThread.start();
	}

	private void inicializar() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 700);
		this.contentPane = new JLayeredPane();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);		
		this.setResizable(false);
		initLifeBar();
		initScore();			
	}

	public synchronized static GUI_Game getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new GUI_Game();
		}
		return INSTANCE;
	}

	protected void playerStartMove(KeyEvent key){
		playerInteraction.playerStartMove(key.getKeyCode());
	}

	protected void playerStopMove(KeyEvent key) {
		playerInteraction.playerStopMove(key.getKeyCode());
	}

	public void setComponentLayer(Component e, int layer) {
		this.contentPane.setLayer(e, layer);
		e.setVisible(true);
	}

	protected void shoot(boolean b) {
		playerInteraction.playerShoot(b);
	}

	public void updateScore(int s) {
		score.setText("Score: " + s);
	}

	public void updateLifeBar(int l) {
		auxBar.setSize(((lifeBar.getWidth() - 18) * l) / 100, auxBar.getHeight());
	}

	private void initScore() {
		score = new JLabel();
		score.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		score.setText("Score: " + 0);
		score.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setForeground(Color.green.darker());
		score.setBounds(0, 630, 100, 40);
		contentPane.add(score);
		contentPane.setLayer(score, 10);
		score.setVisible(true);
	}

	private void initLifeBar() {
		lifeBar = new JLabel();
		lifeBar.setBounds(900,630, 100, 22);
		ImageIcon img = new ImageIcon(getClass().getResource("/Resources/health_bar.png"));
		Icon icon = new ImageIcon(img.getImage().getScaledInstance(lifeBar.getWidth(), lifeBar.getHeight(), Image.SCALE_DEFAULT));
		lifeBar.setIcon(icon);
		auxBar = new JLabel();
		lifeBar.add(auxBar);
		auxBar.setBounds(909, 635, lifeBar.getWidth() - 18, lifeBar.getHeight() - 10);
		img = new ImageIcon(getClass().getResource("/Resources/health_bar_color.png"));
		icon = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		auxBar.setIcon(icon);
		contentPane.add(lifeBar);		
		contentPane.setLayer(lifeBar, 10);
		contentPane.add(auxBar);
		contentPane.setLayer(auxBar, 11);
		lifeBar.setVisible(true);
		auxBar.setVisible(true);
	}
	
	public void changeLevel() {
		if (!game.getNextLevel().equals("")) {
			contentPane.removeAll();		
			this.inicializar();		
			game = new Level(this, game.getNextLevel());
			mainThread.changeGame(game);
			Player.getInstance(0, 0, game).setGame(game);
		} else {
			game.endGame(false);
		}
	}

	public void setNewBackground(JLabel background) {
		this.remove(background);
		this.background = background;
		contentPane.add(this.background);
		setComponentLayer(this.background, 1);
		this.repaint();
	}

	public void stopGame() {
		this.mainThread.stopGame();
	}
}