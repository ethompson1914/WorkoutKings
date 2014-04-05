package lin.thompson.factory;

import java.util.ArrayList;

import lin.thompson.deck.CardDeck;
import lin.thompson.workout.Workout;

public class WorkoutFactoryImpl implements WorkoutFactory {
	
	@Override
	public Workout createWorkout(String name, CardDeck deck, ArrayList<String> exercises) {
		return new Workout(name, deck, exercises);
	}

	@Override
	public Workout createHardcodedWorkout() {
		CardDeck deck = new CardDeck();
		ArrayList<String> exercises = new ArrayList<String>();
		exercises.add(new String("Pushups"));
		exercises.add(new String("Situps"));
		exercises.add(new String("Squats"));
		exercises.add(new String("Lunges"));
		Workout workout = new Workout("Hardcode", deck, exercises);
		
		return workout;
	}

	@Override
	public Workout createBlankWorkout() {
		return new Workout("Blank");
	}

}
