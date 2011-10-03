package group5.yatzy;


import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends Activity {

	ArrayList<Dice> dice = new ArrayList<Dice>();
	ArrayList<ImageView> diceImages = new ArrayList<ImageView>();
	ArrayList<String> playerNames;
	ArrayList<Player> players = new ArrayList<Player>();
	int roundNr = 1;
	int playerTurn = 1;
	int throwTurn = 1;
	
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
		
		for(int i = 0; i < 5; i++){
			dice.add(new Dice());
		}
		
		/**
		* List with names of players to start game withf
		 */
		playerNames = getIntent().getStringArrayListExtra("NewGameActivity");
		
		
		for(int i = 0; i < playerNames.size()-1; i++){
			players.add(new Player(playerNames.get(i)));
		}
		
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
		
		diceImages.add(dice1);
		diceImages.add(dice2);
		diceImages.add(dice3);
		diceImages.add(dice4);
		diceImages.add(dice5);
		
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
		
		throwButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				for(int i = 0; i < dice.size(); i++){
					if(!dice.get(i).isHeld()){
						dice.get(i).roll();
						updateDice(dice.get(i), i);
					}
				}
				nextThrow();
			}
		});
		
		dice1.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				
				if(!dice.get(0).isHeld()){
					dice.get(0).setHeld(true);
					diceImages.get(0).setImageResource(R.drawable.one);
				}
				
				if(dice.get(0).isHeld()){
					dice.get(0).setHeld(false);
					diceImages.get(0).setImageResource(R.drawable.icon);
				}
			}
		});
		//CharSequence as = (CharSequence) playerNames.get(0);
		//test.setText(as);
	}
	
	public void updateDice(Dice dice, int diceNr) {
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
		//SÄTT RÖD RAM RUNT PÅ ELSE!
		else {
			if(dice.getValue() == 1)
				diceImages.get(diceNr).setImageResource(R.drawable.icon);
			
			if(dice.getValue() == 2)
				diceImages.get(diceNr).setImageResource(R.drawable.icon);
			
			if(dice.getValue() == 3)
				diceImages.get(diceNr).setImageResource(R.drawable.icon);
			
			if(dice.getValue() == 4)
				diceImages.get(diceNr).setImageResource(R.drawable.icon);
			
			if(dice.getValue() == 5)
				diceImages.get(diceNr).setImageResource(R.drawable.icon);
			
			if(dice.getValue() == 6)
				diceImages.get(diceNr).setImageResource(R.drawable.icon);
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

	public void nextThrow() {
		if(throwTurn == 3)
			throwTurn = 0;
		throwTurn++;
	}
}
