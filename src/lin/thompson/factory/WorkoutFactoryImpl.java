package lin.thompson.factory;

import java.util.ArrayList;

import lin.thompson.deck.CardDeck;
import lin.thompson.global.ConstantVariables;
import lin.thompson.workout.SuitsAndExercise;
import lin.thompson.workout.Workout;

public class WorkoutFactoryImpl implements WorkoutFactory {
	
	@Override
	public Workout createWorkout(String name, CardDeck deck, SuitsAndExercise suitsAndExercise) {
		return new Workout(name, deck, suitsAndExercise);
	}

	@Override
	public Workout createHardcodedWorkoutOne() {
		CardDeck deck = new CardDeck();
		SuitsAndExercise assign = new SuitsAndExercise();
		assign.addExerciseToSuit(ConstantVariables.suits[0], "Pushups");
		assign.addExerciseToSuit(ConstantVariables.suits[1], "Situps");
		assign.addExerciseToSuit(ConstantVariables.suits[2], "Squats");
		assign.addExerciseToSuit(ConstantVariables.suits[3], "Lunges");
		Workout workout = new Workout("Workout 1", deck, assign);
		
		return workout;
	}

	@Override
	public Workout createHardcodedWorkoutTwo() {
		CardDeck deck = new CardDeck();
		SuitsAndExercise assign = new SuitsAndExercise();
		assign.addExerciseToSuit(ConstantVariables.suits[0], "Pushups");
		assign.addExerciseToSuit(ConstantVariables.suits[1], "Situps");
		assign.addExerciseToSuit(ConstantVariables.suits[2], "Squats");
		assign.addExerciseToSuit(ConstantVariables.suits[3], "Lunges");
		Workout workout = new Workout("Workout 2", deck, assign);
		
		return workout;
	}

	@Override
	public Workout createHardcodedWorkoutThree() {
		CardDeck deck = new CardDeck();
		SuitsAndExercise assign = new SuitsAndExercise();
		assign.addExerciseToSuit(ConstantVariables.suits[0], "Pushups");
		assign.addExerciseToSuit(ConstantVariables.suits[1], "Situps");
		assign.addExerciseToSuit(ConstantVariables.suits[2], "Squats");
		assign.addExerciseToSuit(ConstantVariables.suits[3], "Lunges");
		Workout workout = new Workout("Workout 3", deck, assign);
		
		return workout;
	}

	@Override
	public Workout createHardcodedWorkoutFour() {
		CardDeck deck = new CardDeck();
		SuitsAndExercise assign = new SuitsAndExercise();
		assign.addExerciseToSuit(ConstantVariables.suits[0], "Pushups");
		assign.addExerciseToSuit(ConstantVariables.suits[1], "Situps");
		assign.addExerciseToSuit(ConstantVariables.suits[2], "Squats");
		assign.addExerciseToSuit(ConstantVariables.suits[3], "Lunges");
		Workout workout = new Workout("Workout 4", deck, assign);
		
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

}
