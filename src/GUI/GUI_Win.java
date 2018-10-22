package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

@SuppressWarnings("serial")
public class GUI_Win extends JFrame {
	private static GUI_Win INSTANCE;

	//private int score;
	private JPanel contentPane;
	private JLabel background;

	public GUI_Win(int score) {
		//this.score = score;
		initialize();
		loadScores();
	}

	public static GUI_Win getInstance(int score) {
		if (INSTANCE == null) {
			INSTANCE = new GUI_Win(score);
		}
		return INSTANCE;
	}
	
private void loadScores() {
		
	}

	private void initialize() {		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1024, 700);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.contentPane.setLayout(null);		
		this.setResizable(false);
		
		ImageIcon img = new ImageIcon(getClass().getResource("/Resources/Levels/game_over_screen.png"));
		Icon icon = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setFont(new Font("Unispace", Font.PLAIN, 17));
		btnSalir.setBounds(425, 75, 150, 50);
		contentPane.add(btnSalir);
		
		JButton btnReintentar = new JButton("Reintentar");
		btnReintentar.setForeground(Color.WHITE);
		btnReintentar.setBackground(Color.BLACK);
		btnReintentar.setFont(new Font("Unispace", Font.PLAIN, 16));
		btnReintentar.setBounds(425, 11, 150, 50);
		contentPane.add(btnReintentar);
		
		JTextPane scorePane = new JTextPane();
		scorePane.setText("--------------------------- Best Scores --------------------------");
		scorePane.setForeground(new Color(34, 139, 34));
		scorePane.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		scorePane.setBackground(Color.DARK_GRAY);
		scorePane.setBounds(200, 480, 600, 180);
		contentPane.add(scorePane);
		scorePane.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		scorePane.setEditable(false);
		
		background = new JLabel();
		background.setIcon(icon);
		background.setBounds(0, 0, 1024, 700);
		contentPane.add(background);
		background.setVisible(true);		
	}

}
