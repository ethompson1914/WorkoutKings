package lin.thompson.workoutkings.Activity;

import lin.thompson.deck.CardDeck;
import lin.thompson.workout.Workout;
import lin.thompson.workoutkings.R;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

public class WorkoutActivity extends ActionBarActivity {
	
	private Workout workout;
	private CardDeck deck;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workout);
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
	
	public WorkoutActivity() {
		super();
	}
	
	public WorkoutActivity(Workout workout) {
		this.workout = workout;
		this.deck = workout.getDeck();
	}
	
	public Workout getWorkout() {
		return workout;
	}

}
