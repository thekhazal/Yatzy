package group5.yatzy;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * 
 * @author Johan Grundén
 * 
 * Controller class for starting a new game
 */
public class NewGameActivity extends Activity {
	
	private TextView player1;
	private TextView player2;
	private TextView player3;
	private TextView player4;
	
	private Spinner nrOfPlayers;
	
	private Button startButton;
	
	private int intendedPlayers;
	private ArrayList<String> players;
	private String playerOne, playerTwo, playerThree, playerFour;
	
	private int[] highscores;

	public static final int MAX_LENGTH = 4;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newgame);
        
        Bundle extras = getIntent().getExtras();
        highscores = (int[]) extras.get("Highscores");
        
        /**
         * Drop down menu with number of players
         */
        nrOfPlayers = (Spinner) findViewById(R.id.nrOfPlayers);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.players_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nrOfPlayers.setAdapter(adapter);
        
        /**
         * Actionlistener for drop down menu
         */
        nrOfPlayers.setOnItemSelectedListener(new MyOnItemSelectedListener());
        
        /**
         * Textviews for player names.
         * Should be invisible at first.
         */
        player1 = (TextView) findViewById(R.id.player1);
        player2 = (TextView) findViewById(R.id.player2);
        player3 = (TextView) findViewById(R.id.player3);
        player4 = (TextView) findViewById(R.id.player4);
        player1.setVisibility(TextView.INVISIBLE);
        player2.setVisibility(TextView.INVISIBLE);
        player3.setVisibility(TextView.INVISIBLE);
        player4.setVisibility(TextView.INVISIBLE);  
        
        // Set intended players to zero, user has not made choice yet.
        intendedPlayers = 0;
        players = new ArrayList<String>();
        /**
         * Button for start game
         */ 
        startButton = (Button) findViewById(R.id.startButton);

        
		/**
		 * Actionlistener for start game button
		 */
		startButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				
				Boolean startGame = false;
				
				playerOne = player1.getText().toString();
				playerTwo = player2.getText().toString();
				playerThree = player3.getText().toString();
				playerFour = player4.getText().toString();
				
				if(intendedPlayers == 1 && nameIsOk(playerOne)) {
					players.clear();
					players.add(playerOne);
					startGame = true;
				}
				else if(intendedPlayers == 2 && nameIsOk(playerOne) && nameIsOk(playerTwo)){
					players.clear();
					players.add(playerOne);
					players.add(playerTwo);
					startGame = true;
				}
				else if(intendedPlayers == 3 && nameIsOk(playerOne) && nameIsOk(playerTwo) && nameIsOk(playerThree)){
					players.clear();
					players.add(playerOne);
					players.add(playerTwo);
					players.add(playerThree);
					startGame = true;
				}
				else if(intendedPlayers == 4 && nameIsOk(playerOne) && nameIsOk(playerTwo) && nameIsOk(playerThree) && nameIsOk(playerFour)){
					players.clear();
					players.add(playerOne);
					players.add(playerTwo);
					players.add(playerThree);
					players.add(playerFour);
					startGame = true;
				}
				else {
					// Do nothing
					startGame = false;
				}
				
				if(startGame){	
					Intent gameIntent = new Intent(NewGameActivity.this,GameActivity.class);
					gameIntent.putExtra("NewGameActivity", players);
					gameIntent.putExtra("Highscores", highscores);
					startActivity(gameIntent);
				}
			}
		}); 
    }
    
    /**
     * Check if entered player name is ok
     * @param name The name to check
     * @return True if name is not empty or not too long
     */
    private boolean nameIsOk(String name) {
    	return (name.length() <= MAX_LENGTH && name.length() > 0);
    }
    
    public class MyOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent,
            View view, int pos, long id) {
        	
        	// User chose One player, display one textfield.
        	if((parent.getItemAtPosition(pos).toString()).equals("One")){
        		player1.setVisibility(TextView.VISIBLE);
                player2.setVisibility(TextView.INVISIBLE);
                player3.setVisibility(TextView.INVISIBLE);
                player4.setVisibility(TextView.INVISIBLE);
                intendedPlayers = 1;
        	}
        	
        	// User chose Two players, display two textfields.
        	else if((parent.getItemAtPosition(pos).toString()).equals("Two")){
        		player1.setVisibility(TextView.VISIBLE);
                player2.setVisibility(TextView.VISIBLE);
                player3.setVisibility(TextView.INVISIBLE);
                player4.setVisibility(TextView.INVISIBLE);
                intendedPlayers = 2;
        	}
        	
        	// User chose Three player, display three textfields.
        	else if((parent.getItemAtPosition(pos).toString()).equals("Three")){
        		player1.setVisibility(TextView.VISIBLE);
                player2.setVisibility(TextView.VISIBLE);
                player3.setVisibility(TextView.VISIBLE);
                player4.setVisibility(TextView.INVISIBLE);
                intendedPlayers = 3;
        	}
        	
        	// User chose Four players, display four textfields.
        	else if((parent.getItemAtPosition(pos).toString()).equals("Four")){
        		player1.setVisibility(TextView.VISIBLE);
                player2.setVisibility(TextView.VISIBLE);
                player3.setVisibility(TextView.VISIBLE);
                player4.setVisibility(TextView.VISIBLE);
                intendedPlayers = 4;
        	}
        	
        	else {
        		player1.setVisibility(TextView.INVISIBLE);
                player2.setVisibility(TextView.INVISIBLE);
                player3.setVisibility(TextView.INVISIBLE);
                player4.setVisibility(TextView.INVISIBLE);
                intendedPlayers = 0;
        	}

        }
    
        public void onNothingSelected(AdapterView parent) {
          // Do nothing.
        }
    }

}
