package group5.yatzy;

import java.util.ArrayList;

/**
 * @author Johan Grunden, Anmar Khazal, Daniel Gunnarsson, Viktor Swantesson
 * This is a class which will model a player in the game.
 **/
public class Player {
	
	private String name;
	
	/**
	 * This list will be used to store the players chosen combinations during
	 * the game.
	 */
	private ArrayList<Integer> combos;
	
	/**
	 * A new player needs a name and his score set to zero,
	 * he also get a score list in which all his score are being kept.
	**/
	public Player(String name) { 
		this.name = name;
		this.combos = new ArrayList<Integer>(18);
		this.combos.add(17, 0);
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Updates the player score list with the chosen combination.
	 * @param position The combination number chosen.
	 * @param score The calculated score for the specific position. 
	 * @return Returns the updated score list.
	 */
	public ArrayList<Integer> updateCombos(int position, int score) {
		combos.add(position, score);
		return combos;
	}
	
	/**
	 * @return Returns the score list.
	 */
	public ArrayList<Integer> getCombos() {
		return combos;
	}
	
	/**
	 * @return Returns the value for the first six combinations. This will be
	 * used to calculate if a bonus will be received or not and also shown
	 * on the score board during the game.
	 */
	public int getBonusScore() {
		int middle = 0;
		
		for(int i = 0; i < 6; i++){
			middle = middle + combos.get(i);
		}
		return middle;
	}
	
	/**
	 * @return Returns the total score of the player.
	 */
	public int getTotalScore() {
		int total = 0;
		
		for(int i = 0; i < combos.size(); i++)
			if (i != 6 || i != 17)
				total = total + i;
		return total;
	}
}
