package lin.thompson.factory;

import java.util.ArrayList;

import lin.thompson.deck.CardDeck;
import lin.thompson.workout.Workout;

public interface WorkoutFactory {
	
	public Workout createHardcodedWorkout();
	
	public Workout createBlankWorkout();

	Workout createWorkout(String name, CardDeck deck,
			ArrayList<String> exercises);

	Workout createHardcodedWorkoutOne();

	Workout createHardcodedWorkoutTwo();

	Workout createHardcodedWorkoutThree();

	Workout createHardcodedWorkoutFour();
	
}
