package group5.yatzy;

import java.util.ArrayList;

/**
 * @author Daniel Gunnarsson & Victor Swantesson
 * This Class will handle different combinations given the specified Dice.
 */
public class Combinations {

	private ArrayList<Integer> combos;
	private Integer temp = null;


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
		 * The "TopSum" and "Bonus" fields are not to be calculated here.
		 */
		this.combos.add(6, playerList.get(6));
		this.combos.add(7, playerList.get(7));

		/**
		 * The Pair field gets calculated.
		 */
		if (playerList.get(8) == null) 
			this.combos.add(8, calcPair(dice));
		else 
			this.combos.add(8, playerList.get(8));



		/**
		 * The TwoPair field gets calculated.
		 */
		if (playerList.get(9) == null)  
			this.combos.add(9, calcTwoPair(dice));
		else 
			this.combos.add(9, playerList.get(9));



		/**
		 * The Trips field gets calculated.
		 */
		if (playerList.get(10) == null) 
			this.combos.add(10, calcTrips(dice));
		else 
			this.combos.add(10, playerList.get(10));


		/**
		 * The Quads field gets calculated.
		 */
		if (playerList.get(11) == null) 
			this.combos.add(11, calcQuads(dice));
		else 
			this.combos.add(11, playerList.get(11));


		/**
		 * The SmallStraight field gets calculated.
		 */
		if (playerList.get(12) == null) {
			temp = calcStraight(dice);
			if (temp == 15)
				this.combos.add(12, temp);
			else 
				this.combos.add(12, null);
		}
		else 
			this.combos.add(12, playerList.get(12));


		/**
		 * The BigStraight field gets calculated.
		 */
		if (playerList.get(13) == null) {
			temp = calcStraight(dice);
			if (temp == 20)
				this.combos.add(13, temp);
			else 
				this.combos.add(13, null);
		}
		else 
			this.combos.add(13, playerList.get(13));	

		/**
		 * The FullHouse field gets calculated.
		 */
		if (playerList.get(14) == null) 
			this.combos.add(14, calcFullHouse(dice));
		else 
			this.combos.add(14, playerList.get(14));

		/**
		 * The Chance field gets calculated.
		 */
		if (playerList.get(15) == null) 
			this.combos.add(15, calcChance(dice));
		else 
			this.combos.add(15, playerList.get(15));

		/**
		 * The Yatzy field gets calculated.
		 */
		if (playerList.get(16) == null) 
			this.combos.add(16, calcYatzy(dice));
		else 
			this.combos.add(16, playerList.get(16));

		/**
		 * The "TotalSum" field are not to be calculated here.
		 */
		this.combos.add(17, playerList.get(17));

		return combos;
	}



	/**
	 * This method calculates the number of occurrences of a specified dice 
	 * value there are.
	 * @param diceValue
	 * @param dice: set of dice
	 * @return The combination value of the sum of that specific dice value,
	 * if no occurrence returns null.
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
	 * @return The combination value of the pair if there is a valid one,
	 * otherwise returns null.
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
	 * This method calculates if there are two pairs of any kind.
	 * @param dice set of dice.
	 * @return The combination value of two pairs if there is a valid one,
	 * otherwise returns null.
	 */
	public Integer calcTwoPair(int[] dice){
		int pair1 = 0;
		int pair2 = 0;

		dice = sort(dice);

		//pair1 = calcPair(dice);
		//
		//for(int i = 2; i < 4; i++) {
		//	if(dice[i] == dice[i++])
		//		pair2 = dice[i] * 2;
		//		
		//		if(pair1 != pair2)
		//			return pair1 + pair2;
		//}
		//return null;
		//
		//dice = sort(dice);

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
	 * This method calculates if there are trips of any kind. 
	 * @param dice set of dice.
	 * @return The combination value of trips if there is a valid one,
	 * otherwise returns null.
	 */
	public Integer calcTrips(int[] dice) {
		dice = sort(dice);

		for(int i = 0; i < 3; i++){
			if(dice[i] == dice[i+1]){
				if(dice[i] == dice[i+2])
					return dice[i] * 3; 
			}
		}
		return null;
	}

	/**
	 * This method calculates if there are quads of any kind.
	 * @param dice set of dice.
	 * @return The combination value of quads if there is a valid one,
	 * otherwise returns null.
	 */
	public Integer calcQuads(int[] dice) {
		dice = sort(dice);

		for(int i = 0; i < 2; i++){
			if(dice[i] == dice[i+1])
				if(dice[i] == dice[i+2])
					if(dice[i] == dice[i+3])
						return dice[i] * 4;
		}
		return null;
	}


	public Integer calcStraight(int[] dice){
		dice = sort(dice);

		for(int i = 0; i < 4; i++){
			if(dice[i] != dice[i+1] + 1)
				return null;
		}

		if(dice[0] == 6)
			return 20;

		return 15;
	}

	/**
	 * This method calculates if there are a full house of any kind.
	 * @param dice set of dice.
	 * @return The combination value of the full house if there is a valid one,
	 * otherwise returns null.
	 */
	public Integer calcFullHouse(int[] dice) {

		Integer temp1 = 0;
		Integer temp2 = 0;

		temp1 = calcTrips(dice);
		if(temp1 == null)
			return null;
		else{
			for(int i = 0; i < 4; i++){
				if(dice[i] == dice[i+1] && dice[i] != (temp1 / 3)){
					temp2 = dice[i] * 2;

					return temp1 + temp2;
				}
			}
		}
		return null;
	}

	/**
	 * This method calculates the value of the chance field, given the 
	 * current dice
	 * @param dice the set of dice
	 * @return the value of all the dice added.
	 */
	public Integer calcChance(int[] dice) {
		int chance = 0;
		for (int i = 0; i < 5; i++) {
			chance += dice[i];
		}
		return chance;
	}

	/**
	 * This method calculates if there is a Yatzy.
	 * @param dice set of dice.
	 * @return If a Yatzy exists returns the value 50 otherwise returns null.
	 */
	public Integer calcYatzy(int[] dice) {

		dice = sort(dice);

		if(dice[0] == dice[4])
			return 50;

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
