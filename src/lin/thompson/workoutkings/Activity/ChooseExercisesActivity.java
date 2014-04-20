package lin.thompson.workoutkings.Activity;

import java.util.ArrayList;
import java.util.List;

import lin.thompson.global.ConstantVariables;
import lin.thompson.workout.Exercise;
import lin.thompson.workoutkings.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

public class ChooseExercisesActivity extends Activity {

	static ArrayList<String> exercises = new ArrayList<String>();
	ArrayList<CheckBox> boxes = new ArrayList<CheckBox>();
	ExerciseListAdapter exerciseListAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_exercises);
		
		exerciseListAdapter = new ExerciseListAdapter();
		ListView exerciseList = (ListView)findViewById(R.id.exercise_listview1);
		exerciseList.setAdapter(exerciseListAdapter);
		
		//TODO add listeners to adapter.
		
		
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
	
	public class ExerciseListAdapter extends BaseAdapter {
		List<Exercise> exerciseList = ConstantVariables.getDefaultExerciseData();

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return exerciseList.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return exerciseList.get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			if(arg1==null){
				LayoutInflater inflater = (LayoutInflater) ChooseExercisesActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				arg1 = inflater.inflate(R.layout.list_checkboxes, arg2,false);
			}
			
			CheckBox exerciseName = (CheckBox)arg1.findViewById(R.id.checkBox1);
			
			Exercise exercise = exerciseList.get(arg0);
			
			exerciseName.setText(exercise.getExerciseName());
			
			return arg1;
		}
		
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
