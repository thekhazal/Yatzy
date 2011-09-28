
package group5.yatzy;

/**
 * @author Anmar Khazal
 * This activity class will display the main menu
 * with three buttons, resume game, new game and high score
 **/
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class YatzyActivity extends Activity {


	private OnClickListener mCorkyListener = new OnClickListener() {
		public void onClick(View v) {
			System.out.println("HEJ");
		}
	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button button1 = (Button)findViewById(R.id.resumegame);
		Button button2 = (Button)findViewById(R.id.newgame);
		Button button3 = (Button)findViewById(R.id.highscore);
		button1.setClickable(true);
		button1.setOnClickListener(mCorkyListener);
		button2.setOnClickListener(mCorkyListener);
		button3.setOnClickListener(mCorkyListener);
	}


}