/**
 * @author KNKedge
 * 2012年5月
 */

package jp.knkedge;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class KaneKaneActivity extends Activity implements OnClickListener {
	final static String KANE = "KaneKane";
	final static String CARD = "ic_cards";
	final static String ATM = "atm_from";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

       Button b = (Button) findViewById(R.id.draw);
       b.setText("引き出し");
    }

    @Override
    public void onResume() {
    	TextView draw = (TextView) findViewById(R.id.withdraw);
    	String text = "今月の引き出し\t";
    	text = text + getSharedPreference(KANE, ATM) + "円";
    	draw.setText(text);

    	super.onResume();
    }

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.draw) {

		}
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add("テスト");
    	// Preferencesからリストで取ってくる
    	return super.onCreateOptionsMenu(menu);
    }

    int getSharedPreference(String table, String key) {
    	SharedPreferences pref = getSharedPreferences(table, MODE_WORLD_READABLE|MODE_WORLD_WRITEABLE);
    	return pref.getInt(key, 0);
    }

    void withDraw(int amount) {
    	SharedPreferences pref = getSharedPreferences(KANE, MODE_WORLD_READABLE|MODE_WORLD_WRITEABLE);
    	Editor e = pref.edit();
    	e.putInt(ATM, getSharedPreference(KANE, ATM)+amount);
    	e.commit();
    }
}