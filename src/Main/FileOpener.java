package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Entity.Entity;
import Levels.ConcreteFactory;
import Levels.Factory;

public class FileOpener {
	private Game game;
	private Factory factory;
		
	public FileOpener(Game game) {
		this.game = game;
		factory = new ConcreteFactory(game);
	}
	
    public void readFile() {
        BufferedReader br = null;
        String fileName = getClass().getResource("/Resources/Levels/Level1.txt").getPath();
        try {
        	String [] arr;
        	String sCurrentLine;
        	Entity entity;
            br = new BufferedReader(new FileReader(fileName));
            while ((sCurrentLine = br.readLine()) != null) {
            	arr = sCurrentLine.split(";");            	
            	switch (arr[0]) {
	            	case "w" :
	            		entity = factory.getEnemyWeapon(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
	            		game.addEntity(entity);
	            		break;
	            	case "k":
	            		entity = factory.getEnemyChase(Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
	            		game.addEntity(entity);
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
	            		System.out.print("x");
            	
            	}
            	System.out.println("");
            }
        } catch (IOException e) { 
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}