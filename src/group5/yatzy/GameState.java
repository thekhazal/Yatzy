package group5.yatzy;

import java.util.ArrayList;

public class GameState {

	ArrayList<Dice> dice;
	ArrayList<Player> players;

	int roundNr;
	int playerTurn;
	int throwTurn;
	int diceBeingHeld;


	public GameState(ArrayList<Dice> dice, ArrayList<Player> players, int roundNr, 
			int playerTurn, int throwTurn, int diceBeingHeld) {

		this.dice = dice;
		this.players = players;
		this.roundNr = roundNr;
		this.playerTurn = playerTurn;
		this.throwTurn = throwTurn;
		this.diceBeingHeld = diceBeingHeld;

	}

	public ArrayList<Dice> getDice() {
		return dice;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public int getRoundNr() {
		return roundNr;
	}

	public int getPlayerTurn() {
		return playerTurn;
	}

	public int getThrowTurn() {
		return throwTurn;
	}

	public int getDiceBeingHeld() {
		return diceBeingHeld;
	}
}


