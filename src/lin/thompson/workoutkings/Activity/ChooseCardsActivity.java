package lin.thompson.workoutkings.Activity;

import lin.thompson.workoutkings.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ChooseCardsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_cards);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choose_cards, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onClick(View v){

	    if(v.getId() == R.id.backbutton_choosecards) {
	    	// "Back" button was pressed
	        finish(); 
	    } else if (v.getId() == R.id.nextbutton_choosecards) {
	    	// "Submit" button was clicked    
			Intent intent = new Intent(v.getContext(), ChooseExercisesActivity.class);
			startActivity(intent);
	    }
	}

}
