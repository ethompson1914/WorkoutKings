package lin.thompson.workoutkings.Activity;

import lin.thompson.deck.Card;
import lin.thompson.deck.CardDeck;
import lin.thompson.factory.WorkoutFactoryImpl;
import lin.thompson.global.GlobalHelpers;
import lin.thompson.workout.Workout;
import lin.thompson.workoutkings.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WorkoutActivity extends Activity {

	private Button stopButton;
	private Button backButton;
	private Button startButton;
	private ImageView cardImage;
	private WorkoutFactoryImpl factory = new WorkoutFactoryImpl();
	private Workout testWorkout = factory.createHardcodedWorkoutFour();
	private Workout workout;
	private CardDeck deck = new CardDeck();
	private GlobalHelpers helpers = new GlobalHelpers();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workout);
		workout = (Workout) getIntent().getSerializableExtra("New Workout");
		deck.shuffle();

		// Get the message from the intent
//			    Intent intent = getIntent();
//			    String message = intent.getStringArrayExtra(name));

		backButton = (Button) findViewById(R.id.backbutton_workout);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		cardImage = (ImageView) findViewById(R.id.imageView1);
		cardImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showNewCard();
				Button startButton = (Button) findViewById(R.id.startbutton_workout);
				startButton.setVisibility(View.INVISIBLE);
			}

		});

		startButton = (Button) findViewById(R.id.startbutton_workout);
		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showNewCard();
			}
		});

		stopButton = (Button) findViewById(R.id.startbutton_workout);
		stopButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(showNewCard()) {
					Button startButton = (Button) v;
					startButton.setVisibility(View.INVISIBLE);
				} else if(findViewById(R.id.imageView1).getResources().equals(findViewById(R.drawable.finish))) {
					ImageView image = (ImageView) findViewById(R.id.imageView1);
					image.setImageDrawable(getResources().getDrawable(R.drawable.finish));
				} else { return; }
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.workout, menu);
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

	public boolean showNewCard() {
		if(deck.getCards().size() > 0) {
			Card cardToShow = deck.getTopCard();
			showExercise(cardToShow);
			String cardName = helpers.getNameFromCard(cardToShow);
			setImageResource(GlobalHelpers.NAMED_RESOURCES.get(cardName));
			return true;
		} else { return false; }
	}

	private void setImageResource(Integer integer) {
		ImageView image = (ImageView) findViewById(R.id.imageView1);
		image.setImageDrawable(getResources().getDrawable(integer));
	}

	public void showExercise(Card card) {
		String suit = card.getSuitName();
		String exercise = testWorkout.getExercise(suit);
		TextView exerciseAsStringView = (TextView) findViewById(R.id.exercisesummary_workoutactivity);
		exerciseAsStringView.setText(exercise);
	}
}
