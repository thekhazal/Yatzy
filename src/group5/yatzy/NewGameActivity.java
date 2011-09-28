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
 *
 * Controller class for starting a new game
 */
public class NewGameActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newgame);
        
        /**
         * Drop down menu with number of players
         */
        Spinner nrOfPlayers = (Spinner) findViewById(R.id.nrOfPlayers);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.players_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nrOfPlayers.setAdapter(adapter);
        
        nrOfPlayers.setOnItemSelectedListener(new MyOnItemSelectedListener());
    }
    
    public class MyOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent,
            View view, int pos, long id) {
         // Toast.makeText(parent.getContext(), "You chose " +
         //     parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
          
        }

        public void onNothingSelected(AdapterView parent) {
          // Do nothing.
        }
    }
}
