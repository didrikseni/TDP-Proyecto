package GUI;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class GUI_HomeScreen extends JFrame {
	private static GUI_HomeScreen INSTANCE;
	
	private static GUI_Game gui;
	private JLayeredPane contentPane;
	private JLabel background;

	public GUI_HomeScreen() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 700);
		this.contentPane = new JLayeredPane();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);		
		this.setResizable(false);
		
		ImageIcon img = new ImageIcon(getClass().getResource("/Resources/PantallaInicio.jpg"));
		background = new JLabel();
		Icon icon = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		background.setIcon(icon);
		background.setBounds(0, 0, 1024, 700);
		contentPane.add(background);
		contentPane.setLayer(background, 1);
		background.setVisible(true);
		
		JButton btnStart = new JButton("Start game");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startGame();
			}
		});
		contentPane.setLayer(btnStart, 2);
		btnStart.setBounds(42, 53, 150, 40);
		contentPane.add(btnStart);
		btnStart.setBackground(Color.BLACK);
		btnStart.setBorder(new LineBorder(Color.lightGray.darker(), 2));
		btnStart.setForeground(Color.white);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startSettings();
			}
		});
		contentPane.setLayer(btnSettings, 2);
		btnSettings.setBounds(42, 104, 150, 40);
		contentPane.add(btnSettings);
		btnSettings.setBackground(Color.BLACK);
		btnSettings.setBorder(new LineBorder(Color.lightGray.darker(), 2));
		btnSettings.setForeground(Color.white);		
	}	
	
	private void startGame() {
		gui = GUI_Game.getInstance();
		gui.setVisible(true);
		this.setVisible(false);
	}
	
	private void startSettings() {
		
	}

	public static GUI_HomeScreen getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new GUI_HomeScreen();
		}
		return INSTANCE;
	}
}
