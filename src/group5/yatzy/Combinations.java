package group5.yatzy;

import java.util.ArrayList;

/**
 * @author Daniel Gunnarsson & Victor Swantesson
 * This Class will handle different combinations given the specified Dice.
 */
public class Combinations {
	
	private ArrayList<Integer> combos;
	
	/**
	 * This method calculates what options of combinations are available to the user
	 * @param playerList: the players current combination list.
	 * @param dice: the rolled dice
	 * @return The player combination list with the values to be chosen from.
	 */
	public ArrayList<Integer> calcCombos(ArrayList<Integer> playerList, int[] dice) {

		/**
		 * Fields from One to Six are calculated and inserted in the list.
		 */
		for (int i = 0; i < 6; i++) {
			if (playerList.get(i) == null) 
				this.combos.add(i, calcOnetoSix(i, dice));
			else 
				this.combos.add(i, playerList.get(i));
		}

		/**
		 * The "Sum" and "Bonus" fields are not to be calculated here.
		 */
		this.combos.add(6, playerList.get(6));
		this.combos.add(7, playerList.get(7));

		/**
		 * The Pair field gets calculated.
		 */
		if (playerList.get(8) == null) {
			if (playerList.get(8) == null) 
				this.combos.add(8, calcPair(dice));
			else 
				this.combos.add(8, playerList.get(8));
		}


		/**
		 * The TwoPair field gets calculated.
		 */
		if (playerList.get(9) == null) {
			if (playerList.get(9) == null) 
				this.combos.add(9, calcTwoPair(dice));
			else 
				this.combos.add(9, playerList.get(8));
		}		

		return combos;

	}


	/**
	 * This method calculates the number of occurences of a specified dice 
	 * value there are
	 * @param diceValue
	 * @param dice: set of dice
	 * @return The calculated combination value
	 */
	public Integer calcOnetoSix(int diceValue, int[] dice){
		int occurence = 0;

		for(int i = 0; i < 5; i++){
			if(diceValue == dice[i]){
				occurence++;
			}
		}

		if (occurence == 0)
			return null;
		return (diceValue * occurence);
	}

	/**
	 * This method calculates if there are any pairs within the given set of 
	 * dice.
	 * @param dice: set of dice
	 * @return The calculated combination value
	 */
	public Integer calcPair(int[] dice) {
		dice = sort(dice);

		for (int i = 0; i < 5; i++) {
			if (dice[i] == dice[i+1])
				return (dice[i]*2);
		}

		return null;
	}


	/**
	 * This method calculates if there are two pair of any kind of the 
	 * specified dice
	 * @param dice set of dice.
	 * @return The combination value of two pair if valid.
	 */
	public Integer calcTwoPair(int[] dice){
		int pair1 = 0;
		int pair2 = 0;
		dice = sort(dice);

		for(int i = 0; i < 2; i++){
			if(dice[i] == dice[i+1]) {
				pair1 = dice[i] * 2;

				for (int j = (i+2); j < 4; j++) {
					if (dice[j] == dice[j+1]) {
						pair2 = dice[j] * 2;

						if(pair1 != pair2)
							return pair1 + pair2;
					}
				}
			}
		}
		return null;
	}



	/**
	 * This sorts a set of dice with the highest value first.
	 * @param dice The sets of dice which you want to sort.
	 * @return A sorted array with the highest value first.
	 */
	public int[] sort(int[] dice) {
		for(int i = 0; i < dice.length; i++) {
			for(int j = 0; j < dice.length; j++) {
				if(dice[i] < dice[i+1]) {
					int temp = dice[i];
					dice[i] = dice[i+1];
					dice[i+1] = temp;
				}
			}
		}
		return dice;
	}




}
