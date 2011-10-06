package group5.yatzy;

import java.io.*;

/**
 * This class handles the saving and loading of a current game
 * @author Daniel Gunnarsson & Emma Bogren
 */
public class RWState {

	/**
	 * This method saves a current game.
	 * @param gamestate: the gamestate.
	 */
	public static void writeState(GameState gamestate) {
		ObjectOutputStream outputStream = null;

		File state = new File("state");
		
		try {
			outputStream = new ObjectOutputStream(new FileOutputStream(state));
			outputStream.writeObject(gamestate);
			outputStream.close();
		} catch (IOException ex) {}
	}	

	/**
	 * This method loads a previously saved gamestate.
	 * @return gamestate.
	 */
	public static GameState readState() {
		ObjectInputStream inputStream = null;
		GameState gamestate = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream("state"));
			gamestate = (GameState)inputStream.readObject();
			inputStream.close();
		} catch (IOException ex) {}
		catch(ClassNotFoundException ex2) {}

		return gamestate;
	}

	/**
	 * This method is used in YatzyActivity to see if there is a game to be
	 * resumed.
	 * @return true if exists, false if not.
	 */
	public static boolean fileExists() {
		File state = new File("state");
		boolean exists = state.exists();
		return exists;
	}

	/**
	 * This method is used to delete a saved game.
	 */
	public static void deleteFile() {
		File state = new File("state");
		state.delete();
	}
}