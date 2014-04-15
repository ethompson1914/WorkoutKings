package lin.thompson.workoutkings.Activity;

import lin.thompson.workoutkings.CustomCardsActivity;
import lin.thompson.workoutkings.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NewWorkoutActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_workout);

		// OnClick Listener for "Custom"
		Button custom = (Button) findViewById(R.id.custombutton);
		custom.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(NewWorkoutActivity.this, CustomCardsActivity.class);
				startActivity(intent);
			}
		});

		// OnClick Listener for "Full Deck"
		Button full = (Button) findViewById(R.id.fulldeckbutton);
		full.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), ChooseCardsActivity.class);
				startActivity(intent);
			}
		});

		// OnClick Listener for "Half Deck"
		Button half = (Button) findViewById(R.id.halfdeckbutton);
		half.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), ChooseCardsActivity.class);
				startActivity(intent);
			}
		});

		// OnClickListener for "Back"
		Button back = (Button) findViewById(R.id.backbutton_newworkout);
		back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_workout, menu);
		return true;
	}

}
