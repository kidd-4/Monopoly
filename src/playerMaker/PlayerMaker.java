package playerMaker;

import java.awt.Color;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import player.Player;


/**
 * 
 * @author Local_win8
 *
 */

public class PlayerMaker {
	public static Player makePlayer(String playerName, int money, int points, Color color){
		Player player = null;
		try {
			Class clazz =  Class.forName("player.Player");
			Constructor constructor = clazz.getConstructor(String.class, int.class, int.class, Color.class);
			player = (Player) constructor.newInstance(playerName, money, points, color);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return player;
	}
	
}
