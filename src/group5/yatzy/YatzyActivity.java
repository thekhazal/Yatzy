package group5.yatzy;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class YatzyActivity extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /////highscore
        HighScore hs = new HighScore();
        Button hsButton = (Button) findViewById(R.id.highscore);
        hsButton.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		
        		Intent gameIntent = new Intent(YatzyActivity.this,HighScoreActivity.class);
        		startActivity(gameIntent);
        	}
        }); 
        //////
    }
}