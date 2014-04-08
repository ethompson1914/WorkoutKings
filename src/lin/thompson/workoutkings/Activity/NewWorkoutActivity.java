package lin.thompson.workoutkings.Activity;

import lin.thompson.workoutkings.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class NewWorkoutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_workout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_workout, menu);
		return true;
	}
	
	public void onClick(View v){

	    if(v.getId() == R.id.backbutton){
	        finish(); 
	    } else if (v.getId() == R.id.custombutton || v.getId() == R.id.fulldeckbutton) {
	    	// TODO
			// "Create New Workout" was clicked   
			Intent intent = new Intent(v.getContext(), ChooseCardsActivity.class);
			startActivity(intent);
	    } else if (v.getId() == R.id.halfdeckbutton) {
	    	// TODO Need a way to differentiate between half and full decks
	    	// "Create New Workout" was clicked   
	    	Intent intent = new Intent(v.getContext(), ChooseCardsActivity.class);
	    	startActivity(intent);
	    }
	}

}
