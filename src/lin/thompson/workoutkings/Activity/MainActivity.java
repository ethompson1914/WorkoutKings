package lin.thompson.workoutkings.Activity;

import java.util.ArrayList;
import java.util.Map;

import lin.thompson.factory.WorkoutFactoryImpl;
import lin.thompson.workout.Workout;
import lin.thompson.workoutkings.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView mainListView ;
	private ArrayAdapter<String> listAdapter ;
	private WorkoutFactoryImpl factory = new WorkoutFactoryImpl();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Find the ListView resource. 
		mainListView = (ListView) findViewById( R.id.mainListView );
		
		//XML
		PreferenceManager.setDefaultValues(this, R.layout.preference_initial_exercise_data, false);
		SharedPreferences prefs = this.getSharedPreferences("master_exercise_list", Context.MODE_PRIVATE);
		String check = prefs.getString("PreferenceExist", "notExist");
		if(check.equals("notExist")){
			SharedPreferences.Editor editor = prefs.edit();
			Map<String,?> keys = PreferenceManager.getDefaultSharedPreferences(this).getAll();
			for(Map.Entry<String, ?> entry: keys.entrySet()){
				editor.putString(entry.getKey(),(String)entry.getValue());
			}
			editor.commit();
		}
			
		// TODO Add workouts from saved info
		// Hardcoded workouts for now
		final ArrayList<Workout> workoutsList = new ArrayList<Workout>();
		workoutsList.add(factory.createBlankWorkout());
		workoutsList.add(factory.createHardcodedWorkoutOne());
		workoutsList.add(factory.createHardcodedWorkoutTwo());
		workoutsList.add(factory.createHardcodedWorkoutThree());
		workoutsList.add(factory.createHardcodedWorkoutFour());

		// Create and populate a List of workout names.
		final ArrayList<String> workoutNames = new ArrayList<String>();
		workoutNames.add("Create new workout...");
		workoutNames.add(factory.createHardcodedWorkoutOne().getName());
		workoutNames.add(factory.createHardcodedWorkoutTwo().getName());
		workoutNames.add(factory.createHardcodedWorkoutThree().getName());
		workoutNames.add(factory.createHardcodedWorkoutFour().getName());

		// Create ArrayAdapter using the workout list.
		listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, workoutNames);

		// Set the ArrayAdapter as the ListView's adapter.
		mainListView.setAdapter( listAdapter );
		mainListView.setVerticalScrollBarEnabled(true);

		mainListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
				if(position == 0) {
					// "Create New Workout" was clicked   
					Intent intent = new Intent(view.getContext(), ChooseExercisesActivity.class);
					startActivity(intent);
				} else {
					// Anything else was clicked
					Bundle b = new Bundle();
					ArrayList<String> exercises = new ArrayList<String>();
					exercises = workoutsList.get(position).getAllExercises();
					b.putStringArray("HL", new String[] { exercises.get(0), exercises.get(1), exercises.get(2), exercises.get(3) });
					Intent intent = new Intent(MainActivity.this, WorkoutActivity.class);
					intent.putExtras(b);
					startActivity(intent);
				}                 
			}
		});     
	}
}
