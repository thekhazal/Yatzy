package group5.yatzy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author Johan Grundén
 * testkommentar
 * Controller class for starting a new game
 */
public class NewGameActivity extends Activity {
	
	TextView player1;
	TextView player2;
	TextView player3;
	TextView player4;
	
	Spinner nrOfPlayers;
	
	//TextView player1 = (TextView) findViewById(R.id.player1);
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
        nrOfPlayers.setOnItemSelectedListener(new MyOnItemSelectedListener());
        
        /**
         * Textviews for player names.
         */
        player1 = (TextView) findViewById(R.id.player1);
        player2 = (TextView) findViewById(R.id.player2);
        player3 = (TextView) findViewById(R.id.player3);
        player4 = (TextView) findViewById(R.id.player4);
        
    }
    
    public class MyOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent,
            View view, int pos, long id) {
        	
        	if((parent.getItemAtPosition(pos).toString()).equals("Two")){
        		player1.setVisibility(TextView.VISIBLE);
        		player2.setVisibility(TextView.VISIBLE);
        	}
        }
        
        public void onNothingSelected(AdapterView parent) {
          // Do nothing.
        }
    }

}
