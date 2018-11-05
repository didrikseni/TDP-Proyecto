package GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GUI_GameOver extends JFrame {
	private static GUI_GameOver INSTANCE = null;
	
	private int score;
	private JPanel contentPane;
	private JLabel background;

	private GUI_GameOver(int score) {
		this.score = score;
		initialize();
	}

	public synchronized static GUI_GameOver getInstance(int score) {
		if (INSTANCE == null) {
			INSTANCE = new GUI_GameOver(score);
		}
		return INSTANCE;
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
		
		JLabel lblNewLabel = new JLabel("Tu score es " + score);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(416, 501, 226, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setFont(new Font("Unispace", Font.PLAIN, 17));
		btnSalir.setBounds(440, 11, 150, 50);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitFromGame();
			}
		});
		
		background = new JLabel();
		background.setIcon(icon);
		background.setBounds(0, 0, 1024, 700);
		contentPane.add(background);
		background.setVisible(true);		
	}
	
	private void exitFromGame() {
		this.dispose();
	}
}
