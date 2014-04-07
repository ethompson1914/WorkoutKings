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

	private Button backButton;
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

	public void onClick(View v) {

		if(v.getId() == R.id.backbutton_workout){
			finish(); 
		} else if (v.getId() == R.id.nextbutton_workout) {
			//if(cardsList.size() != 0) {
				showNewCard();
//			} else {
//				// TODO Need a way to differentiate between half and full decks
//		    	// "Create New Workout" was clicked   
//		    	Intent intent = new Intent(v.getContext(), ChooseCardsActivity.class);
//		    	startActivity(intent);
//			}
		} 
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
		Card cardToShow = new Card(1, 5);
		String cardName = helpers.getNameFromCard(cardToShow);
		setImageResource(GlobalHelpers.NAMED_RESOURCES.get(cardName));

		cardsList.remove(cardToShow);
	}

	private void setImageResource(Integer integer) {
		// TODO Auto-generated method stub
		ImageView image = (ImageView) findViewById(R.id.imageView1);
		image.setImageDrawable(getResources().getDrawable(R.drawable.spades_five));
	}
}
