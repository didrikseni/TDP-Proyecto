package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import Levels.Level1;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	private static GUI INSTANCE = null;
	
	private JLayeredPane contentPane;
	private Game g;
	private MainThread timer;
	private JLabel background, score, lifeBar, auxBar;

	private GUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
					shoot(true);
				}
				playerStartMove(arg0);
			}

			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
					shoot(false);
				}
				playerStopMove(arg0);
			}
		});
		inicializar();		
		g = Level1.getInstance(this);
		timer = new MainThread(g);
		timer.start();
	}
	
	private void inicializar() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 700);
		this.contentPane = new JLayeredPane();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);		
		this.setResizable(false);
		
		ImageIcon img = new ImageIcon(getClass().getResource("/Resources/6.png"));
		background = new JLabel();
		Icon icon = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		background.setIcon(icon);
		background.setBounds(0, 0, 1024, 700);
		contentPane.add(background);
		contentPane.setLayer(background, 1);
		background.setVisible(true);
		
		lifeBar = new JLabel();
		lifeBar.setBounds(900,630, 100, 22);
		lifeBar.setBorder(new LineBorder(Color.lightGray.darker(), 2));
		auxBar = new JLabel();
		lifeBar.add(auxBar);
		auxBar.setBounds(902, 632, lifeBar.getWidth() - 4, lifeBar.getHeight() - 4);
		auxBar.setBackground(Color.green.darker());
		auxBar.setOpaque(true);
		contentPane.add(lifeBar);
		contentPane.setLayer(lifeBar, 40);
		contentPane.add(auxBar);
		contentPane.setLayer(auxBar, 45);
		lifeBar.setVisible(true);
		auxBar.setVisible(true);
		
		score = new JLabel();
		score.setText("Score: " + 0);
		score.setForeground(Color.green.darker());
		score.setBounds(0, 630, 100, 50);
		contentPane.add(score);
		contentPane.setLayer(score, 20);
		score.setVisible(true);	
	}

	private synchronized static void createInstance() {
		if (INSTANCE == null) {
			INSTANCE = new GUI();
		}	
	}

	public synchronized static GUI getInstance() {
		if(INSTANCE == null) {
			createInstance();
		}
		return INSTANCE;
	}
	
	protected void playerStartMove(KeyEvent key){
		g.playerStartMove(key.getKeyCode());
		this.repaint();
	}
	
	protected void playerStopMove(KeyEvent key) {
		g.playerStopMove(key.getKeyCode());
		this.repaint();		
	}
	
	public void addComponentInLayer(Component e, int layer) {
		this.contentPane.setLayer(e, layer);
	}
	
	protected void shoot(boolean b) {
		g.playerShoot(b);
	}

	public int getAncho() {
		return background.getWidth();
	}
	
	public int getAlto() {
		return background.getHeight();
	}

	public void updateScore(int s) {
		score.setText("Score: " + s);
	}
	
	public void updateLifeBar(int l) {
		auxBar.setSize((lifeBar.getWidth() * l) / 100, lifeBar.getHeight() - 4);
	}
}