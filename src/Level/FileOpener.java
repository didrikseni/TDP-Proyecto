package Level;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Entity.Entity;
import GUI.GUI_Game;
import Main.Game;

public class FileOpener {
	private Game game;
	private EnemyFactory factory;
	private String fileName;
	private GUI_Game gui;

	public FileOpener(Game game, String fileName, GUI_Game gui) {
		this.game = game;
		factory = new FactoryEnemy(game);
		this.fileName = fileName;
		this.gui = gui;
	}

	public void loadObjects() {
		BufferedReader br = null;
		fileName = getClass().getResource(fileName).getPath();
		try {
			String [] arr;
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileName));
			game.setNextLevel(br.readLine());
			sCurrentLine = br.readLine();
			cargarBackground(sCurrentLine);
			while ((sCurrentLine = br.readLine()) != null) {
				arr = sCurrentLine.split(";");  
				addEntityAuxiliar(arr);
			}
		} catch (IOException e) { 
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void addEntityAuxiliar(String[] arr) {
		Entity entity;
		switch (arr[0]) {
		case "w" :
			entity = factory.getEnemyWeapon(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
			game.addEntity(entity);
			game.addEnemyCount();
			break;
		case "k":
			entity = factory.getEnemyKamikaze(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
			game.addEntity(entity);
			game.addEnemyCount();
			break;
		case "t":
			entity = factory.getEnemyTracker(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
			game.addEntity(entity);
			game.addEnemyCount();
			break;
		case "b":
			entity = factory.getBarricade(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
			game.addEntity(entity);
			break;
		case "d" :
			entity = factory.getDestroyable(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
			game.addEntity(entity);
			break;
		case "f": 
			entity = factory.getFinalBoss(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
			game.addEntity(entity);
			game.addEnemyCount();
			break;
		default :            	
		}
	}

	private void cargarBackground(String sCurrentLine) {
		JLabel background = new JLabel();
		background.setBounds(0, 0, gui.getWidth(), gui.getHeight());	
		ImageIcon img = new ImageIcon(this.getClass().getResource(sCurrentLine));
		Icon icon = img;
		background.setIcon(icon);
		gui.setNewBackground(background);
	}
}