package group5.yatzy;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class YatzyActivity extends Activity {
	private Button resgButton;
	private Button newgButton;
	private Button highButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/**
		 * Resume game, New game high score buttons
		 */

		resgButton = (Button) findViewById(R.id.resumegame);
		newgButton = (Button) findViewById(R.id.newgame);
		highButton = (Button) findViewById(R.id.highscore);


		/**
		 * Actionlistener for resume game button, terminates application so far
		 * on event of clicked button
		 */
		
		resgButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				finish();
			}
		}); 
		
		/**
		 * Actionlistener for new game button, starts new game activity
		 * on event of clicked button
		 */

		newgButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				Intent gameIntent = new Intent(YatzyActivity.this,NewGameActivity.class);
				startActivity(gameIntent);
			}
		}); 

		/* 
        /////highscore
        HighScore hs = new HighScore();
        Button hsButton = (Button) findViewById(R.id.highscore);
        hsButton.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {

        		Intent gameIntent = new Intent(YatzyActivity.this,NewGameActivity.class);
        		startActivity(gameIntent);
        	}
        }); 
        //////*/
	}
}