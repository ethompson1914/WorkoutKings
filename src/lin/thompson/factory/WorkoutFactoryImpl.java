package lin.thompson.factory;

import lin.thompson.global.ConstantVariables;
import lin.thompson.workout.SuitsAndExercise;
import lin.thompson.workout.Workout;

public class WorkoutFactoryImpl implements WorkoutFactory {
	
	@Override
	public Workout createWorkout(String name, SuitsAndExercise suitsAndExercise) {
		return new Workout(name, suitsAndExercise);
	}

	@Override
	public Workout createHardcodedWorkoutOne() {
		SuitsAndExercise assign = new SuitsAndExercise();
		assign.addExerciseToSuit(ConstantVariables.suits[0], "Pushups");
		assign.addExerciseToSuit(ConstantVariables.suits[1], "Situps");
		assign.addExerciseToSuit(ConstantVariables.suits[2], "Squats");
		assign.addExerciseToSuit(ConstantVariables.suits[3], "Lunges");
		Workout workout = new Workout("Workout 1", assign);
		
		return workout;
	}

	@Override
	public Workout createHardcodedWorkoutTwo() {
		SuitsAndExercise assign = new SuitsAndExercise();
		assign.addExerciseToSuit(ConstantVariables.suits[0], "Pushups");
		assign.addExerciseToSuit(ConstantVariables.suits[1], "Situps");
		assign.addExerciseToSuit(ConstantVariables.suits[2], "Squats");
		assign.addExerciseToSuit(ConstantVariables.suits[3], "Lunges");
		Workout workout = new Workout("Workout 2", assign);
		
		return workout;
	}

	@Override
	public Workout createHardcodedWorkoutThree() {
		SuitsAndExercise assign = new SuitsAndExercise();
		assign.addExerciseToSuit(ConstantVariables.suits[0], "Pushups");
		assign.addExerciseToSuit(ConstantVariables.suits[1], "Situps");
		assign.addExerciseToSuit(ConstantVariables.suits[2], "Squats");
		assign.addExerciseToSuit(ConstantVariables.suits[3], "Lunges");
		Workout workout = new Workout("Workout 3", assign);
		
		return workout;
	}

	@Override
	public Workout createHardcodedWorkoutFour() {
		SuitsAndExercise assign = new SuitsAndExercise();
		assign.addExerciseToSuit(ConstantVariables.suits[0], "Pushups");
		assign.addExerciseToSuit(ConstantVariables.suits[1], "Situps");
		assign.addExerciseToSuit(ConstantVariables.suits[2], "Squats");
		assign.addExerciseToSuit(ConstantVariables.suits[3], "Lunges");
		Workout workout = new Workout("Workout 4", assign);
		
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
