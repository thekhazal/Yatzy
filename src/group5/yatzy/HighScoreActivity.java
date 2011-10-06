package group5.yatzy;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Emma Bogren
 * The Activity for showing a highscore list.
 */

public class HighScoreActivity extends Activity
{
	String[] highNames;
	int[] highScores;
	Dialog sure;

	
	 /** Displays the highscore list and creates a clear button
	  * with an action listener. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);
        
        Bundle extras = getIntent().getExtras();
        highNames = (String[]) extras.get("names");
        highScores = (int[]) extras.get("scores"); 
        
        Button scoreOne = (Button) findViewById(R.id.name1);
        Button scoreTwo = (Button) findViewById(R.id.name2);
        Button scoreThree = (Button) findViewById(R.id.name3);
        
        scoreOne.setText(highNames[0] + " " + highScores[0]);
        scoreTwo.setText(highNames[1] + " " + highScores[1]);
        scoreThree.setText(highNames[2] + " " + highScores[2]);
        
        
        /**
         * When the action listener gets an event, return
         * to YatzyActivity, where onActivityResult is called,
         * and the highscore list is cleared.
         */
        
        Button clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(new OnClickListener(){
        public void onClick(View v) {
        	
        	sure = new Dialog(HighScoreActivity.this);
        	sure.setContentView(R.layout.highdialog);
        	sure.setTitle("Warning!");
        	sure.setCancelable(false);
        
        	TextView text = (TextView) sure.findViewById(R.id.sureText);
        	
        	ImageView dice5 = (ImageView) sure.findViewById(R.id.five);
        	dice5.setImageResource(R.drawable.five);
        	
        	Button yes = (Button) sure.findViewById(R.id.yes);
        	yes.setOnClickListener(new OnClickListener(){
        	        public void onClick(View v) {
        	        	Intent resultIntent = getIntent();
        	        	setResult(Activity.RESULT_OK,resultIntent);
        	        	finish();
        	        }
        	});
        	
        	Button no = (Button) sure.findViewById(R.id.no);
        	no.setOnClickListener(new OnClickListener(){
        	        public void onClick(View v) {
        	        	sure.cancel();
        	        }
        	});
        	
        	sure.show();
 	
		}
        }); 
        
    }  
}
