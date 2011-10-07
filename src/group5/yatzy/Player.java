package group5.yatzy;

import java.util.ArrayList;

/**
 * @author Johan Grunden, Anmar Khazal, Daniel Gunnarsson, Viktor Swantesson
 * This is a class which will model a player in the game.
 **/
public class Player {
	
	private String name;
	private static final int BONUSPOINTS = 63;
	private static final int BONUS = 50;
	
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
		this.combos = new ArrayList<Integer>();
		for(int i = 0; i < 18; i++){
			this.combos.add(null);
		}
		this.combos.set(17, 0);
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Updates the player score list with the chosen combination.
	 * Also updates the sums and calculates if a bouns has been earned.
	 * @param position The combination number chosen.
	 * @param score The calculated score for the specific position. 
	 * @return Returns the updated score list.
	 */
	public void updateCombos(int position, int score) {
		combos.set(position, score);
				
		// Update sum for 1-6's
		combos.set(6, getSumScore());
		
		// Check bonus
		if(hasBonus())
			combos.set(7,BONUS);
		
		// Update total score
		combos.set(17, getTotalScore());
	}
	
	/**
	 * @return Returns the score list.
	 */
	public ArrayList<Integer> getCombos() {
		return combos;
	}
	
	/**
	 * @return Returns the value for the first six combinations. This is 
	 * used by hasBonus to calculate if a bonus will be received or not and also shown
	 * on the score board during the game.
	 */
	public int getSumScore() {
		int middle = 0;
		
		for(int i = 0; i < 6; i++){
			if(combos.get(i) != null)
				middle = middle + combos.get(i);
		}
		return middle;
	}

	/**
	 * Returns true if the player gets a bonus.
	 */
	public boolean hasBonus()
	{
		int sum = getSumScore();
		if(sum < BONUSPOINTS)
			return false;
		return true;
	}
	
	/**
	 * @return Returns the total score of the player.
	 */
	public int getTotalScore() {
		int total = 0;
		
		for(int i = 0; i < combos.size()-1; i++)
			if (i != 6 && i != 17 && combos.get(i) != null)
					total += combos.get(i);
		return total;
	}
}
