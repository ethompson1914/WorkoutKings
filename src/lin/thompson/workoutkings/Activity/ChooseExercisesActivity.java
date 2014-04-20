package lin.thompson.workoutkings.Activity;

import java.util.ArrayList;

import lin.thompson.workoutkings.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;

public class ChooseExercisesActivity extends Activity {

	static ArrayList<String> exercises = new ArrayList<String>();
	ArrayList<CheckBox> boxes = new ArrayList<CheckBox>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_exercises);

		// OnClick Listener for "Custom"
		Button back = (Button) findViewById(R.id.backbutton_chooseexercises);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		// OnClick Listener for "New Exercise"
		Button newExercise = (Button) findViewById(R.id.newexercise_chooseexercises);
		newExercise.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), NewExerciseActivity.class);
				startActivity(intent);
			}
		});

		// OnClick Listener for "Let's Do This!"
		Button ready = (Button) findViewById(R.id.readybutton_chooseexercises);
		ready.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(fourChecked()) {
					Intent intent = new Intent(v.getContext(), WorkoutActivity.class);
					intent.putExtra("Exercises", exercises);
					startActivity(intent);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.choose_exercises, menu);
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

	public boolean fourChecked() {
		int count = 0;
		for(CheckBox box : boxes) {
			if(box.isChecked()) {
				count++;
			}
		}
		if(count == 4) { return true; }
		else { return false; }
	}
	
	public void populateExercises() {
	
	}
	
	public ArrayList<String> getExercises() {
		return exercises;
	}

}
