package lin.thompson.workoutkings.Activity;

import lin.thompson.workoutkings.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class NewExerciseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_exercise);

		Button add = (Button) findViewById(R.id.addbutton_newexercise);
		add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText exerciseName = (EditText) findViewById(R.id.nameexercise_newexercise);
				String name = exerciseName.getText().toString();
				//System.out.println("New exercise " + name);
			
				//setResult(RESULT_OK);
				SharedPreferences prefs = getSharedPreferences("master_exercise_list", Context.MODE_PRIVATE);
				String check = prefs.getString(name, "notExist");
				if(check.equals("notExist")){
					SharedPreferences.Editor editor = prefs.edit();
					editor.putString(name, name);
					editor.commit();
				}
				Intent intent = new Intent(v.getContext(), ChooseExercisesActivity.class);
				startActivity(intent);
				finish();
			}
		});

		Button cancel = (Button) findViewById(R.id.cancelbutton_newexercise);
		cancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//setResult(RESULT_CANCELED);
				Intent intent = new Intent(v.getContext(), ChooseExercisesActivity.class);
				startActivity(intent);
				finish();
			}
		});
			Button delete = (Button) findViewById(R.id.deletebutton_newexercise);
			delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText exerciseName = (EditText) findViewById(R.id.nameexercise_newexercise);
				String name = exerciseName.getText().toString();
				//System.out.println("New exercise " + name);
			
				//setResult(RESULT_OK);
				SharedPreferences prefs = getSharedPreferences("master_exercise_list", Context.MODE_PRIVATE);
				String check = prefs.getString(name, "notExist");
				if(!check.equals("notExist")){
					SharedPreferences.Editor editor = prefs.edit();
					editor.remove(name);
					editor.commit();
				}
				Intent intent = new Intent(v.getContext(), ChooseExercisesActivity.class);
				startActivity(intent);
				finish();
			}
		});
	
	
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_exercise, menu);
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



}
