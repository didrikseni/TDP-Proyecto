package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class GUI_About extends JLayeredPane {
	private GUI_HomeScreen home;
	private JLabel background;
	private JButton btnSalir;

	public GUI_About(GUI_HomeScreen frame) {
		this.home = frame;
		this.setSize(home.getSize());
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.setVisible(true);

		ImageIcon img = new ImageIcon(getClass().getResource("/Resources/PantallaAbout.png"));
		background = new JLabel();
		Icon icon = new ImageIcon(img.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		background.setIcon(icon);
		background.setBounds(0, 0, 1024, 700);
		this.add(background);
		this.setLayer(background, 1);

		btnSalir = new JButton("Back");
		btnSalir.setVisible(true);
		btnSalir.setBounds(850, 53, 150, 40);
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setFont(new Font("Unispace", Font.PLAIN, 16));
		btnSalir.setBorder(new LineBorder(Color.lightGray.darker(), 2));
		btnSalir.setForeground(Color.white);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				home.regresar();
			}
		});
		this.add(btnSalir);
		this.setLayer(btnSalir, 2);
	}

	public Container getPanel() {
		return this;
	}


}
