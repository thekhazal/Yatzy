package group5.yatzy;


import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {

	ArrayList<String> playerNames;

	/** Called when the activity is first created.*/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		
		/**
		 * List with names of players to start game withf
		 */
		playerNames = getIntent().getStringArrayListExtra("NewGameActivity");
		
		TextView test = (TextView) findViewById(R.id.gameText);
		
		CharSequence as = (CharSequence) playerNames.get(0);
		test.setText(as);

		
		
	}

}
