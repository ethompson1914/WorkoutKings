package lin.thompson.workoutkings.Activity;

import java.util.ArrayList;
import java.util.Random;

import lin.thompson.deck.Card;
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

public class WorkoutActivity extends Activity {

	private Button startButton;
	private ImageView cardImage;
	WorkoutFactoryImpl factory = new WorkoutFactoryImpl();
	Workout testWorkout = factory.createHardcodedWorkoutOne();
	ArrayList<Card> cardsList = testWorkout.getCards();
	GlobalHelpers helpers = new GlobalHelpers();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_workout);
		
		cardImage = (ImageView) findViewById(R.id.imageView1);
		cardImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showNewCard();
			}
			
		});
		
		startButton = (Button) findViewById(R.id.startbutton_workout);
		startButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showNewCard();
				Button startButton = (Button) v;
				startButton.setVisibility(View.INVISIBLE);
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

	// TODO
	public Card randomCardFromDeck() {
		Random rand = new Random();
		int random = rand.nextInt(cardsList.size());
		Card card = cardsList.get(random);
		cardsList.remove(card);

		return card;
	}

	// TODO
	public void showNewCard() {
		Card cardToShow = randomCardFromDeck();
		String cardName = helpers.getNameFromCard(cardToShow);
		setImageResource(GlobalHelpers.NAMED_RESOURCES.get(cardName));

		cardsList.remove(cardToShow);
	}

	private void setImageResource(Integer integer) {
		ImageView image = (ImageView) findViewById(R.id.imageView1);
		image.setImageDrawable(getResources().getDrawable(integer));
	}
}
