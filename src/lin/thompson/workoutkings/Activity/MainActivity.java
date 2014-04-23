package lin.thompson.workoutkings.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import lin.thompson.factory.WorkoutFactoryImpl;
import lin.thompson.workout.SuitsAndExercise;
import lin.thompson.workout.Workout;
import lin.thompson.workoutkings.R;
import android.app.Activity;
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
	private HashMap<String, Workout> savedWorkouts = new HashMap<String, Workout>();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		loadWorkouts();

		// Find the ListView resource. 
		mainListView = (ListView) findViewById( R.id.mainListView );

		// TODO Add workouts from saved info
		// Hardcoded workouts for now
		ArrayList<Workout> workoutsList = new ArrayList<Workout>();
		workoutsList.add(factory.createBlankWorkout());
		workoutsList.add(factory.createHardcodedWorkoutOne());
		workoutsList.add(factory.createHardcodedWorkoutTwo());
		workoutsList.add(factory.createHardcodedWorkoutThree());
		workoutsList.add(factory.createHardcodedWorkoutFour());

		// Create and populate a List of workout names.
		ArrayList<String> workoutNames = new ArrayList<String>();
		workoutNames.add("Create new workout...");
		for(Workout workout : savedWorkouts.values()) {
			workoutsList.add(workout);
			workoutNames.add(workout.getName());
		}

		// Create ArrayAdapter using the workout list.
		listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow);

		// Set the ArrayAdapter as the ListView's adapter.
		mainListView.setAdapter( listAdapter );

		mainListView.setOnItemClickListener(new OnItemClickListener() {
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
	}
	
	public void loadWorkouts() {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
		HashMap<String, String> savedValues = (HashMap<String, String>) preferences.getAll();
		for(String workout : savedValues.keySet()) {
			StringTokenizer st = new StringTokenizer(workout);
			String name = st.nextToken();
			savedWorkouts.put(name, new Workout(name, new SuitsAndExercise(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken())));
		}
	}
}
