package group5.yatzy;


import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {

	ArrayList<String> playerNames;
	ArrayList<Player> players;
	int roundNr = 1;
	int playerTurn = 1;
	int throwTurn = 1;
	
	TextView ones;
	TextView twos;
	TextView threes;
	TextView fours;
	TextView fives;
	TextView sixes;
	TextView sum;
	TextView bonus;
	TextView onePair;
	TextView twoPair;
	TextView trips;
	TextView quads;
	TextView smallStraight;
	TextView bigStraight;
	TextView fullHouse;
	TextView chance;
	TextView yatzy;
	TextView total;
	
		/** Called when the activity is first created.*/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		
		
		/**
		 * List with names of players to start game withf
		 */
		playerNames = getIntent().getStringArrayListExtra("NewGameActivity");
		
		
		for(int i = 0; i < playerNames.size()-1; i++){
			players.add(i, new Player(playerNames.get(i)));
		}
		
		TextView ones = (TextView) findViewById(R.id.ones);
		TextView twos = (TextView) findViewById(R.id.twos);
		TextView threes = (TextView) findViewById(R.id.threes);
		TextView fours = (TextView) findViewById(R.id.fours);
		TextView fives = (TextView) findViewById(R.id.fives);
		TextView sixes = (TextView) findViewById(R.id.sixes);
		TextView sum = (TextView) findViewById(R.id.sum);
		TextView bonus = (TextView) findViewById(R.id.bonus);
		TextView onePair = (TextView) findViewById(R.id.onePair);
		TextView twoPair = (TextView) findViewById(R.id.twoPair);
		TextView trips = (TextView) findViewById(R.id.trips);
		TextView quads = (TextView) findViewById(R.id.quads);
		TextView smallStraight = (TextView) findViewById(R.id.smallStraight);
		TextView bigStraight = (TextView) findViewById(R.id.bigStraight);
		TextView fullHouse = (TextView) findViewById(R.id.fullHouse);
		TextView chance = (TextView) findViewById(R.id.chance);
		TextView yatzy = (TextView) findViewById(R.id.yatzy);
		TextView total = (TextView) findViewById(R.id.total);
		
		CharSequence as = (CharSequence) playerNames.get(0);
		test.setText(as);
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
		throwTurn++;
	}
	
	
	
}
