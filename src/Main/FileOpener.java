package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Entity.Entity;
import GUI.GUI_Game;
import Level.ConcreteFactory;
import Level.Factory;

public class FileOpener {
	private Game game;
	private Factory factory;
	private String fileName;
	private GUI_Game gui;
		
	public FileOpener(Game game, String fileName, GUI_Game gui) {
		this.game = game;
		factory = new ConcreteFactory(game);
		this.fileName = fileName;
		this.gui = gui;
	}
	
    public void loadObjects() {
        BufferedReader br = null;
        fileName = getClass().getResource(fileName).getPath();
        try {
        	String [] arr;
        	String sCurrentLine;
        	Entity entity;
            br = new BufferedReader(new FileReader(fileName));
            game.nextLevel = br.readLine();
            sCurrentLine = br.readLine();
            cargarBackground(sCurrentLine);
            while ((sCurrentLine = br.readLine()) != null) {
            	arr = sCurrentLine.split(";");            	
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
	            	case "b" :
	            		entity = factory.getBarricade(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
	            		game.addEntity(entity);
	            		break;
	            	case "d" :
	            		entity = factory.getDestroyable(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
	            		game.addEntity(entity);
	            		break;
	            	default :            	
            	}
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
    
	private void cargarBackground(String sCurrentLine) {
    	JLabel background = new JLabel();
		background.setBounds(0, 0, gui.getWidth(), gui.getHeight());	
		ImageIcon img = new ImageIcon(this.getClass().getResource(sCurrentLine));
		Icon icon = img;
		background.setIcon(icon);
		gui.setNewBackground(background);
    }
}