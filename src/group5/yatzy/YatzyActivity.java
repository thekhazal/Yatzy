package group5.yatzy;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class YatzyActivity extends Activity {
	

	private Button resgButton;
	private Button newgButton;
	private Button highButton;
	private HighScore hs;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	
		/**
		 * Highscore list.
		 */
		hs = new HighScore(this);

		/**
		 * Resume game, New game high score buttons
		 */

		resgButton = (Button) findViewById(R.id.resumegame);
		newgButton = (Button) findViewById(R.id.newgame);
		highButton = (Button) findViewById(R.id.highscore);

		
		/**
		 * Hide the resume game button if no game is saved.
		 */
		if (RWState.fileExists())
			resgButton.setVisibility(TextView.INVISIBLE);
		
		/**
		 * Actionlistener for resume game button, terminates application so far
		 * on event of clicked button
		 */
		resgButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
        		Intent gameIntent = new Intent(YatzyActivity.this,GameActivity.class);
        		gameIntent.putExtra("Resume", true);
        		startActivityForResult(gameIntent,0);
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
		
		/**
		 * Actionlistener for highscore button, starts highscore activity
		 * on event of clicked button, and passes possible saved highscore to it.
		 */
        highButton.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		Intent gameIntent = new Intent(YatzyActivity.this,HighScoreActivity.class);
        		gameIntent.putExtra("names", hs.getWinnerNames());
        		gameIntent.putExtra("scores", hs.getWinnerScores());
        		startActivityForResult(gameIntent,0);
        	}
        }); 
       
	}
	
	/**
	 * Method to hide the resume game button if no such game is available.
	 */
	public void onResume() {
		if (!RWState.fileExists())
			resgButton.setVisibility(TextView.INVISIBLE);
	}
	
	
	/**
	 * Called when pushing the clear-button in HighscoreActivity.
	 */
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
    	super.onActivityResult(requestCode, resultCode, data);
    	if(requestCode == 0){
    		if(resultCode == Activity.RESULT_OK)
    			hs.clear();
    	}
    }
	
}