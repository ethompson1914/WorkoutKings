package lin.thompson.factory;

import lin.thompson.workout.SuitsAndExercise;
import lin.thompson.workout.Workout;

public interface WorkoutFactory {
	
	public Workout createHardcodedWorkout();
	
	public Workout createBlankWorkout();

	Workout createWorkout(String name, SuitsAndExercise suitsAndExercise);

	Workout createHardcodedWorkoutOne();

	Workout createHardcodedWorkoutTwo();

	Workout createHardcodedWorkoutThree();

	Workout createHardcodedWorkoutFour();
	
}
