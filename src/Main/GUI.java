package Main;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
	private JLabel background;

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
					shoot(true);
				}
				move(arg0);
			}

			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
					shoot(false);
				}
				stop(arg0);
			}
		});
		
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				background.setBounds(0, 0, getWidth(), getHeight());
				ImageIcon img = new ImageIcon(getClass().getResource("/Resources/6.png"));
				Icon icon = new ImageIcon(img.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
				background.setIcon(icon);
			}			
		});
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 700);
		this.contentPane = new JLayeredPane();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);
		
		ImageIcon img = new ImageIcon(getClass().getResource("/Resources/6.png"));
		background = new JLabel();
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
	
	/**
	 * Mueve el jugador en la dirección indicada.
	 * @param KeyEvent indicando la dirección en la que se
	 * moverá el jugador.
	 */
	protected void move(KeyEvent key){
		g.move(key.getKeyCode());		
		this.repaint();
	}
	
	/**
	 * Detiene el movimiento del jugador en la direccíon indicada.
	 * @param KeyEvent indicando la dirección en la que dejará de moverse
	 * el jugador.
	 */
	protected void stop(KeyEvent key) {
		g.stop(key.getKeyCode());
		this.repaint();		
	}
	
	/**
	 * Añade un componente grafico en una capa especificada por el usuario.
	 * @param Componente e.
	 * @param Entero indicando la capa donde se agrega.
	 */
	public void addLayerGUI(Component e, int layer) {
		this.contentPane.setLayer(e, layer);
	}
	
	
	private void shoot(boolean b) {
		g.shoot(b);
	}
	
}