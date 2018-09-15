package Main;

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

import Game.Game;
import Game.Level1;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JLayeredPane contentPane;
	
	private Game g;
	private Timer timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public GUI() {
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
					shoot();
				}
				move(arg0);
			}

			public void keyReleased(KeyEvent arg0) {
				stop(arg0);
			}
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(615, 735);
		this.contentPane = new JLayeredPane();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		
		ImageIcon img = new ImageIcon(getClass().getResource("/Resources/6.png"));
		JLabel background = new JLabel();
		Icon icon = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		background.setIcon(icon);
		
		background.setBounds(0, 0, 600, 700);
		contentPane.add(background);
		contentPane.setLayer(background, 1);
		background.setVisible(true);
		
		g = Level1.getInstance(this);
		timer = new Timer(g);
		timer.start();
	}
	
	protected void move(KeyEvent key){
		g.move(key.getKeyCode());		
		this.repaint();
	}
	
	protected void stop(KeyEvent key) {
		g.stop(key.getKeyCode());
		this.repaint();		
	}
	
	public void addLayerGUI(Component e, int layer) {
		this.contentPane.setLayer(e, layer);
	}
	
	private void shoot() {
		g.shoot();
	}
	
}