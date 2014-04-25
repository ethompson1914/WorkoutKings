package lin.thompson.workoutkings.Activity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lin.thompson.global.ConstantVariables;
import lin.thompson.workout.Exercise;
import lin.thompson.workoutkings.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
	private static ArrayList<String> checkedExercises = new ArrayList<String>();
	private ExerciseListAdapter exerciseListAdapter;
	private ListView exerciseListView;
	private ArrayAdapter<String> listAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_exercises);

		// Create and populate a List of workout names.
		final ArrayList<String> exercises = new ArrayList<String>();
		exercises.add("Pushups");
		exercises.add("Situps");
		exercises.add("Squats");
		exercises.add("Lunges");
		exercises.add("Bicycle Kicks");
		exercises.add("Crunches");
		exercises.add("Pick Pockets");
		exercises.add("Tricep Dips");
		exercises.add("Triangle Pushups");
		exercises.add("Pushup Claps");
		exercises.add("Jumping Jacks");
		exercises.add("High Knees");
		exercises.add("Heismans");
		exercises.add("Squat Thrusts");

		// Find the ListView resource. 
		exerciseListView = (ListView) findViewById( R.id.exercise_listview1 );

		SharedPreferences prefs = this.getSharedPreferences("master_exercise_list", Context.MODE_PRIVATE);
		
		ArrayList<String> master_exercise = new ArrayList<String>();

		Map<String,?> keys = prefs.getAll();
		for(Map.Entry<String, ?> entry: keys.entrySet()){
			if(!entry.getKey().equals("PreferenceExist")){
			master_exercise.add(entry.getKey());
			}
			
		}
		// Create ArrayAdapter using the workout list.
		listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, master_exercise);
		

		// Set the ArrayAdapter as the ListView's adapter.
		exerciseListView.setAdapter( listAdapter );
		exerciseListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		exerciseListView.setVerticalScrollBarEnabled(true);
		exerciseListView.setItemsCanFocus(false);
		
		checkedExercises.add("Pushups");
		checkedExercises.add("Squats");
		checkedExercises.add("Situps");
		checkedExercises.add("High Knees");

		exerciseListView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> arg0, View view, int position, long id) {
				if(view.isSelected()) {
					view.setSelected(false);
					view.refreshDrawableState();
				} else {
					view.setSelected(true);
					view.refreshDrawableState();
				}
			}
		});    

		// OnClick Listener for "Custom"
		Button back = (Button) findViewById(R.id.backbutton_chooseexercises);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		// OnClick Listener for "New Exercise"
		Button newExercise = (Button) findViewById(R.id.deletebutton_newexercise);
		newExercise.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), NewExerciseActivity.class);
				startActivity(intent);
				finish();
			}
		});

		// OnClick Listener for "Let's Do This!"
		Button ready = (Button) findViewById(R.id.readybutton_chooseexercises);
		ready.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(fourChecked()) {
					Bundle b = new Bundle();
					b.putStringArray("HL", new String[] { checkedExercises.get(0), checkedExercises.get(1), checkedExercises.get(2), checkedExercises.get(3) });
					Intent intent = new Intent(ChooseExercisesActivity.this, WorkoutActivity.class);
					intent.putExtras(b);
					startActivity(intent);
				}
			}
		});
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

	public ArrayList<String> getExercises() {
		return exercises;
	}

}
