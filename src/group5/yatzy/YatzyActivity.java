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

public class YatzyActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    private OnClickListener mCorkyListener = new OnClickListener() {
        public void onClick(View v) {
          System.out.print("HEJ");
        }
    };
}