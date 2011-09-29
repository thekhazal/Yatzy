package group5.yatzy;


import java.io.Serializable;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity implements Serializable {


	/** Called when the activity is first created.*/
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		ArrayList<Player> players = (ArrayList<Player>) getIntent().getSerializableExtra("NewGameActivity");
		
		TextView test = (TextView) findViewById(R.id.gameText);
		
		CharSequence as = (CharSequence) players.get(0).getName();
		test.setText(as);

		
		
	}

}
