package lin.thompson.factory;

import java.util.ArrayList;

import lin.thompson.deck.CardDeck;
import lin.thompson.workout.SuitsAndExercise;
import lin.thompson.workout.Workout;

public class WorkoutFactoryImpl implements WorkoutFactory {
	
	@Override
	public Workout createWorkout(String name, CardDeck deck, ArrayList<String> exercises) {
		return new Workout(name, deck, exercises);
	}

	@Override
	public Workout createHardcodedWorkoutOne() {
		CardDeck deck = new CardDeck();
		ArrayList<String> exercises = new ArrayList<String>();
		exercises.add(new String("Pushups"));
		exercises.add(new String("Situps"));
		exercises.add(new String("Squats"));
		exercises.add(new String("Lunges"));
		Workout workout = new Workout("Workout 1", deck, exercises);
		
		return workout;
	}

	@Override
	public Workout createHardcodedWorkoutTwo() {
		CardDeck deck = new CardDeck();
		ArrayList<String> exercises = new ArrayList<String>();
		exercises.add(new String("Pushups"));
		exercises.add(new String("Situps"));
		exercises.add(new String("Squats"));
		exercises.add(new String("Lunges"));
		Workout workout = new Workout("Workout 2", deck, exercises);
		
		return workout;
	}

	@Override
	public Workout createHardcodedWorkoutThree() {
		CardDeck deck = new CardDeck();
		ArrayList<String> exercises = new ArrayList<String>();
		exercises.add(new String("Pushups"));
		exercises.add(new String("Situps"));
		exercises.add(new String("Squats"));
		exercises.add(new String("Lunges"));
		Workout workout = new Workout("Workout 3", deck, exercises);
		
		return workout;
	}

	@Override
	public Workout createHardcodedWorkoutFour() {
		CardDeck deck = new CardDeck();
		ArrayList<String> exercises = new ArrayList<String>();
		exercises.add(new String("Pushups"));
		exercises.add(new String("Situps"));
		exercises.add(new String("Squats"));
		exercises.add(new String("Lunges"));
		Workout workout = new Workout("Workout 4", deck, exercises);
		
		return workout;
	}

	@Override
	public Workout createBlankWorkout() {
		return new Workout("Blank");
	}

	@Override
	public Workout createHardcodedWorkout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardDeck createCardDeck(SuitsAndExercise reference) {
		// TODO Auto-generated method stub
		return null;
	}

}
