package group5.yatzy;


import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This class controls the game flow and updates the game.xml. 
 * @author Daniel Gunnarsson, Viktor Swantesson
 *
 */
public class GameActivity extends Activity {

	ArrayList<Dice> dice = new ArrayList<Dice>();
	ArrayList<TextView> comboTextViews = new ArrayList<TextView>();
	ArrayList<ImageView> diceImages = new ArrayList<ImageView>();
	ArrayList<String> playerNames;
	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<Integer> tempCombos = new ArrayList<Integer>();
	ArrayList<Integer> tempDice = new ArrayList<Integer>();

	int roundNr = 0;
	int playerTurn = 0;
	int throwTurn = 0;
	int diceBeingHeld = 0;

	TextView gameText;
	TextView playerName;
	TextView ones;
	TextView twos;
	TextView threes;
	TextView fours;
	TextView fives;
	TextView sixes;
	TextView sum;
	TextView bonus;
	TextView onePair;
	TextView twoPairs;
	TextView trips;
	TextView quads;
	TextView smallStraight;
	TextView bigStraight;
	TextView fullHouse;
	TextView chance;
	TextView yatzy;
	TextView total;
	Button done;
	ImageView dice1;
	ImageView dice2;
	ImageView dice3;
	ImageView dice4;
	ImageView dice5;
	Button throwButton;

	/** Called when the activity is first created.*/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);

		gameText 	= (TextView) 	findViewById(R.id.headText);
		playerName 	= (TextView) 	findViewById(R.id.playerNameText);
		ones 		= (TextView) 	findViewById(R.id.ones);
		twos 		= (TextView) 	findViewById(R.id.twos);
		threes 		= (TextView) 	findViewById(R.id.threes);
		fours 		= (TextView) 	findViewById(R.id.fours);
		fives 		= (TextView) 	findViewById(R.id.fives);
		sixes 		= (TextView) 	findViewById(R.id.sixes);
		sum 		= (TextView) 	findViewById(R.id.sum);
		bonus 		= (TextView) 	findViewById(R.id.bonus);
		onePair 	= (TextView) 	findViewById(R.id.onePair);
		twoPairs 	= (TextView) 	findViewById(R.id.twoPair);
		trips 		= (TextView) 	findViewById(R.id.trips);
		quads 		= (TextView) 	findViewById(R.id.quads);
		smallStraight = (TextView) 	findViewById(R.id.smallStraight);
		bigStraight = (TextView) 	findViewById(R.id.bigStraight);
		fullHouse 	= (TextView) 	findViewById(R.id.fullHouse);
		chance 		= (TextView) 	findViewById(R.id.chance);
		yatzy 		= (TextView) 	findViewById(R.id.yatzy);
		total 		= (TextView) 	findViewById(R.id.total);
		done		= (Button)		findViewById(R.id.doneButton);
		dice1		= (ImageView)	findViewById(R.id.dice1);
		dice2		= (ImageView)	findViewById(R.id.dice2);
		dice3		= (ImageView)	findViewById(R.id.dice3);	
		dice4		= (ImageView)	findViewById(R.id.dice4);
		dice5		= (ImageView)	findViewById(R.id.dice5);
		throwButton = (Button)		findViewById(R.id.throwButton);

		/**
		 * The combinations are being added to the comboTextViews' list.
		 */
		for(int i = 0; i < 18; i++){
			comboTextViews.add(null);
		}
		
		comboTextViews.set(0,ones);
		comboTextViews.set(1,twos);
		comboTextViews.set(2,threes);
		comboTextViews.set(3,fours);
		comboTextViews.set(4,fives);
		comboTextViews.set(5,sixes);
		comboTextViews.set(6,sum);
		comboTextViews.set(7,bonus);
		comboTextViews.set(8,onePair);
		comboTextViews.set(9,twoPairs);
		comboTextViews.set(10,trips);
		comboTextViews.set(11,quads);
		comboTextViews.set(12,smallStraight);
		comboTextViews.set(13,bigStraight);
		comboTextViews.set(14,fullHouse);
		comboTextViews.set(15,chance);
		comboTextViews.set(16,yatzy);
		comboTextViews.set(17,total);
		
		/**
		 * Creates the five dice.
		 */
		for(int i = 0; i < 5; i++){
			dice.add(new Dice());
		}
		
		/**
		 * The dice views are being added to the diceImages list.
		 */
		diceImages.add(dice1);
		diceImages.add(dice2);
		diceImages.add(dice3);
		diceImages.add(dice4);
		diceImages.add(dice5);

		/**
		 * List with names of players to start game withf
		 */
		playerNames = getIntent().getStringArrayListExtra("NewGameActivity");

		/**
		 * Puts all the players in the "players"-list.
		 */
		for(int i = 0; i < playerNames.size()-1; i++){
			players.add(new Player(playerNames.get(i)));
		}

		/**
		 * Only happens once when the game is started for the first time to
		 * give all the five dice random numbers when started.
		 */
		for(int i = 0; i < 5; i++){
			if(dice.get(i).getValue() == 1)
				diceImages.get(i).setImageResource(R.drawable.one);
			if(dice.get(i).getValue() == 2)
				diceImages.get(i).setImageResource(R.drawable.two);
			if(dice.get(i).getValue() == 3)
				diceImages.get(i).setImageResource(R.drawable.three);
			if(dice.get(i).getValue() == 4)
				diceImages.get(i).setImageResource(R.drawable.four);
			if(dice.get(i).getValue() == 5)
				diceImages.get(i).setImageResource(R.drawable.five);
			if(dice.get(i).getValue() == 6)
				diceImages.get(i).setImageResource(R.drawable.six);
		}

		/**
		 * Listener for the throw button. Checks if a dice is being held or not
		 * before throwing a dice. If held nothing happens. After each 
		 */
		throwButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				for(int i = 0; i < dice.size(); i++){

					if(!dice.get(i).isHeld()){
						dice.get(i).roll();
						updateDice(dice.get(i), i);
					}
				}
				//updateTempCombos(dice);
				nextThrow();
			}
		});

		/**
		 * Listeners for all the dice. Marks if a dice will be held/not held
		 * when clicked.
		 */
		dice1.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				if(throwTurn == 1 || throwTurn == 2){
					updateHeldStatus(dice.get(0));
					updateDice(dice.get(0), 0);
				}
			}
		});
		dice2.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				if(throwTurn == 1 || throwTurn == 2){
					updateHeldStatus(dice.get(1));
					updateDice(dice.get(1), 1);
				}
			}
		});
		dice3.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				if(throwTurn == 1 || throwTurn == 2){
					updateHeldStatus(dice.get(2));
					updateDice(dice.get(2), 2);
				}
			}
		});
		dice4.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				if(throwTurn == 1 || throwTurn == 2){
					updateHeldStatus(dice.get(3));
					updateDice(dice.get(3), 3);
				}
			}
		});
		dice5.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				if(throwTurn == 1 || throwTurn == 2){
					updateHeldStatus(dice.get(4));
					updateDice(dice.get(4), 4);
				}
			}
		});
		//CharSequence as = (CharSequence) playerNames.get(0);
		//test.setText(as);
	}

	private void updateTempCombos(ArrayList<Dice> dice) {
		for(int i = 0; i < dice.size(); i++){
			tempDice.set(i, dice.get(i).getValue());
		}
		
		Integer temp = Combinations.calcCombos(players.get(playerTurn).getCombos(),tempDice).get(0);
		//comboTextViews.get(0).setText((CharSequence) temp.toString());
		
		/*tempCombos.set(0,Combinations.calcCombos(players.get(playerTurn).getCombos(),tempDice).get(0));
		CharSequence temp = (CharSequence) tempCombos.get(0).toString();*/
		if(temp != null)
			comboTextViews.get(0).setText((CharSequence) Integer.toString(temp));
		/*
		for(int i = 0; i < 18; i++){
			if(Combinations.calcCombos(players.get(playerTurn).getCombos(),tempDices).get(i) != 0){
				CharSequence temp = (CharSequence) tempCombos.get(0).toString();
				comboTextViews.get(0).setText(temp);
			}
		}*/
	}
	
	/**
	 * This method updates a dice current holding status with the inverse
	 * boolean value.
	 * @param dice The die that will be updated.
	 */
	private void updateHeldStatus(Dice dice) {
		dice.setHeld(!dice.isHeld());

		if(dice.isHeld()){
			diceBeingHeld++;

			if(diceBeingHeld >= 5)
				throwButton.setClickable(false);
		}
		else {
			diceBeingHeld--;
			throwButton.setClickable(true);
		}
	}

	/**
	 * This method updates the dice on the screen to its correct dice status
	 * (held/not held).
	 * @param dice The dice that will be updated.
	 * @param diceNr The number of that specific dice in the diceImages list.
	 */
	private void updateDice(Dice dice, int diceNr) {
		// For a dice that will be unheld
		if(!dice.isHeld()){

			if(dice.getValue() == 1)
				diceImages.get(diceNr).setImageResource(R.drawable.one);

			if(dice.getValue() == 2)
				diceImages.get(diceNr).setImageResource(R.drawable.two);

			if(dice.getValue() == 3)
				diceImages.get(diceNr).setImageResource(R.drawable.three);

			if(dice.getValue() == 4)
				diceImages.get(diceNr).setImageResource(R.drawable.four);

			if(dice.getValue() == 5)
				diceImages.get(diceNr).setImageResource(R.drawable.five);

			if(dice.getValue() == 6)
				diceImages.get(diceNr).setImageResource(R.drawable.six);
		}
		// For a dice that will be held
		else {
			if(dice.getValue() == 1)
				diceImages.get(diceNr).setImageResource(R.drawable.oneheld);

			if(dice.getValue() == 2)
				diceImages.get(diceNr).setImageResource(R.drawable.twoheld);

			if(dice.getValue() == 3)
				diceImages.get(diceNr).setImageResource(R.drawable.threeheld);

			if(dice.getValue() == 4)
				diceImages.get(diceNr).setImageResource(R.drawable.fourheld);

			if(dice.getValue() == 5)
				diceImages.get(diceNr).setImageResource(R.drawable.fiveheld);

			if(dice.getValue() == 6)
				diceImages.get(diceNr).setImageResource(R.drawable.sixheld);
		}
	}

	public int roundCheck() {
		return roundNr;
	}

	public void nextPlayer() {
		playerTurn++;
		if (playerTurn >= players.size())
			playerTurn = 1;
	}

	/**
	 * This method increases the current throw turn. If the throw turn is equal
	 * to three the throw button will be unclickable.
	 */
	public void nextThrow() {
		throwTurn++;

		if(throwTurn == 3)
			throwButton.setClickable(false);
	}
}