package lin.thompson.workoutkings.Activity;

import java.util.ArrayList;
import java.util.List;

import lin.thompson.global.ConstantVariables;
import lin.thompson.workout.Exercise;
import lin.thompson.workout.Workout;
import lin.thompson.workoutkings.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

public class ChooseExercisesActivity extends Activity {

	private static ArrayList<String> exercises = new ArrayList<String>();
	private ArrayList<CheckBox> boxes = new ArrayList<CheckBox>();
	private ExerciseListAdapter exerciseListAdapter;
	private Workout workout;
	private ListView exerciseListView;
	private ArrayAdapter<String> listAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_exercises);

		// Find the ListView resource. 
		exerciseListView = (ListView) findViewById( R.id.mainListView );
		exerciseListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		exerciseListView.setSelected(true);
		exerciseListView.setSelection(0);
		
//		exerciseListAdapter = new ExerciseListAdapter();
//		ListView exerciseList = (ListView) findViewById(R.id.exercise_listview1);
//		exerciseList.setAdapter(exerciseListAdapter);

		// Create and populate a List of workout names.
		ArrayList<String> exercises = new ArrayList<String>();
		exercises.add("Pushups");
		exercises.add("Situps");
		exercises.add("Squats");
		exercises.add("Lunges");
//		for(Workout workout : savedWorkouts.values()) {
//			workoutsList.add(workout);
//		}

		// Create ArrayAdapter using the workout list.
		listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, exercises);

		// Set the ArrayAdapter as the ListView's adapter.
		exerciseListView.setAdapter( listAdapter );

		exerciseListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
				if(position == 0) {
					// "Create New Workout" was clicked   
					Intent intent = new Intent(view.getContext(), ChooseExercisesActivity.class);
					startActivity(intent);
				} else {
					// Anything else was clicked    
					Intent intent = new Intent(view.getContext(), WorkoutActivity.class);
					startActivity(intent);
				}                 
			}
		});    
		
		//TODO add listeners to adapter.
		
		
		// OnClick Listener for "Custom"
		Button back = (Button) findViewById(R.id.backbutton_chooseexercises);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				exerciseListAdapter.clear();
				//exerciseListAdapter.notifyDataSetChanged();
				finish();
			}
		});

		// OnClick Listener for "New Exercise"
		Button newExercise = (Button) findViewById(R.id.newexercise_chooseexercises);
		newExercise.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), NewExerciseActivity.class);
				startActivityForResult(intent,1);
			}
		});

		// OnClick Listener for "Let's Do This!"
		Button ready = (Button) findViewById(R.id.readybutton_chooseexercises);
		ready.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(fourChecked()) {
					saveWorkout(workout);
					Intent intent = new Intent(v.getContext(), WorkoutActivity.class);
					startActivity(intent);
				}
			}
		});
	}
	
	private void saveWorkout(Workout workout) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString(workout.getName(), workout.exercisesAsString());
		editor.commit();
	}
	
	public class ExerciseListAdapter extends BaseAdapter {
		List<Exercise> exerciseList = ConstantVariables.getExerciseData();

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
			if(arg1 == null){
				LayoutInflater inflater = (LayoutInflater) ChooseExercisesActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				arg1 = inflater.inflate(R.layout.list_checkboxes, arg2,false);
			}
			
			CheckBox exerciseName = (CheckBox)arg1.findViewById(R.id.checkBox1);
			
			Exercise exercise = exerciseList.get(arg0);
			
			exerciseName.setText(exercise.getExerciseName());
			
			return arg1;
		}
		
		public void clear(){
			exerciseList.clear();
		}
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == 1){
			if(resultCode == RESULT_OK){
				String exerciseName = data.getStringExtra("New Exercise");
				ConstantVariables.exerciseList.add(new Exercise(exerciseName,""));
				refresh();
			}
			if(resultCode == RESULT_CANCELED){
				
			}
		}
	}
	
	private void refresh(){
		exerciseListAdapter.clear();
		exerciseListAdapter = new ExerciseListAdapter();
		exerciseListAdapter.notifyDataSetChanged();
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
		int count = exerciseListView.getCheckedItemCount();
		if(count == 4) { return true; }
		else { return false; }
	}
	
	public void populateExercises() {
	
	}
	
	public ArrayList<String> getExercises() {
		return exercises;
	}

}
