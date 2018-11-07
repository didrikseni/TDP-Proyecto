package GUI;

import java.awt.Color;
import java.awt.Font;
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
	private GUI_Game gui;
	private JLayeredPane contentPane;
	private JLabel background;
	private JButton btnStart, btnHelp;

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

		btnStart = new JButton("Start game");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startGame();
			}
		});
		contentPane.setLayer(btnStart, 2);
		btnStart.setBounds(42, 53, 150, 40);
		contentPane.add(btnStart);
		btnStart.setBackground(Color.BLACK);
		btnStart.setFont(new Font("Unispace", Font.PLAIN, 16));
		btnStart.setBorder(new LineBorder(Color.lightGray.darker(), 2));
		btnStart.setForeground(Color.white);

		btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startHelp();
			}
		});
		contentPane.setLayer(btnHelp, 2);
		btnHelp.setBounds(42, 104, 150, 40);
		contentPane.add(btnHelp);
		btnHelp.setFont(new Font("Unispace", Font.PLAIN, 16));
		btnHelp.setBackground(Color.BLACK);
		btnHelp.setBorder(new LineBorder(Color.lightGray.darker(), 2));
		btnHelp.setForeground(Color.white);	

		JButton btnCredits = new JButton("About");
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startAbout();
			}
		});
		contentPane.setLayer(btnCredits, 2);
		btnCredits.setBounds(42, 154, 150, 40);
		contentPane.add(btnCredits);
		btnCredits.setFont(new Font("Unispace", Font.PLAIN, 16));
		btnCredits.setBackground(Color.BLACK);
		btnCredits.setBorder(new LineBorder(Color.lightGray.darker(), 2));
		btnCredits.setForeground(Color.white);	
	}	

	private void startGame() {
		gui = GUI_Game.getInstance();
		gui.setVisible(true);
		this.dispose();
	}

	private void startHelp() {
		GUI_Help help = new GUI_Help(this);
		disableAllComponents();
		this.setContentPane(help.getPanel());
	}

	private void disableAllComponents() {
		this.btnHelp.setEnabled(false);
		this.btnStart.setEnabled(false);
		//this.contentPane.setVisible(false);
	}

	private void startAbout() {
		GUI_About about = new GUI_About(this);
		disableAllComponents();
		this.setContentPane(about.getPanel());
	}

	public static GUI_HomeScreen getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new GUI_HomeScreen();
		}
		return INSTANCE;
	}

	public void regresar() {
		this.setContentPane(contentPane);
		this.contentPane.setVisible(true);
		this.btnHelp.setEnabled(true);
		this.btnStart.setEnabled(true);		
	}
}
