package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GUI_Victory extends JFrame {
	private static GUI_Victory INSTANCE;

	private int score;
	private JPanel contentPane;
	private JLabel background;

	public GUI_Victory(int score) {
		this.score = score;
		initialize();
	}

	public static GUI_Victory getInstance(int score) {
		if (INSTANCE == null) {
			INSTANCE = new GUI_Victory(score);
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

		ImageIcon img = new ImageIcon(getClass().getResource("/Resources/Levels/winScreen.png"));
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
		btnSalir.setBounds(425, 75, 150, 50);
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
