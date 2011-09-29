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
	
	TextView player1;
	TextView player2;
	TextView player3;
	TextView player4;
	
	Spinner nrOfPlayers;
	
	Button startButton;
	
	int intendedPlayers;
	ArrayList<Player> players;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newgame);
        
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
        players = new ArrayList<Player>();
        /**
         * Button for start game
         */ 
        startButton = (Button) findViewById(R.id.startButton);

        
		/**
		 * Actionlistener for start game button
		 */
		startButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				
				if(intendedPlayers == 1) {
					Player playerOne = new Player(player1.getText().toString());
					players.add(playerOne);
				}
				else if(intendedPlayers == 2){
					Player playerOne = new Player(player1.getText().toString());
					Player playerTwo = new Player(player2.getText().toString());
					players.add(playerOne);
					players.add(playerTwo);
				}
				else if(intendedPlayers == 3){
					Player playerOne = new Player(player1.getText().toString());
					Player playerTwo = new Player(player2.getText().toString());
					Player playerThree = new Player(player3.getText().toString());
					players.add(playerOne);
					players.add(playerTwo);
					players.add(playerThree);
				}
				else if(intendedPlayers == 4){
					Player playerOne = new Player(player1.getText().toString());
					Player playerTwo = new Player(player2.getText().toString());
					Player playerThree = new Player(player3.getText().toString());
					Player playerFour = new Player(player4.getText().toString());
					players.add(playerOne);
					players.add(playerTwo);
					players.add(playerThree);
					players.add(playerFour);
				}
				else {
					// Do nothing
				}
				Intent gameIntent = new Intent(NewGameActivity.this,GameActivity.class);
				gameIntent.putExtra("NewGameActivity", players);
				startActivity(gameIntent);
			}
		}); 
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
