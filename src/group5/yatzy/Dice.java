package group5.yatzy;

import java.util.Random;

/**
 * @author Johan Grunden, Anmar Khazal
 * This is a class which will model a die in the game
 **/

public class Dice {
	private int value;
	private boolean held;
	Random r;
	
	/**
	 * Dice must not be held when initialized
	 */
	public Dice(){
		this.r = new Random();
		this.held = false;
		this.roll();
	}
	
	/**
	 * Rolls die with random nr between 1-6
	*/
	public void roll() {		
		setValue(r.nextInt(6)+1);
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isHeld() {
		return held;
	}

	public void setHeld(boolean held) {
		this.held = held;
	}	
}