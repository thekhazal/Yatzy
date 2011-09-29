package group5.yatzy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;
import java.util.*;
import android.content.Intent;

public class HighScoreActivity extends Activity
{
	String[] highNames;
	int[] highScores;

	
	 /** Called when the activity is first created. */
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
        
        
        
        Button clear = (Button) findViewById(R.id.clear);
        clear.setOnClickListener(new OnClickListener(){
        public void onClick(View v) {
        	
        	Intent resultIntent = getIntent();
        	resultIntent.putExtra("cleared", true);
        	setResult(Activity.RESULT_OK,resultIntent);
        	finish();
		}
        });
        
    }
    
    
	
}
