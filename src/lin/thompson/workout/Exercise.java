package lin.thompson.workout;

public class Exercise {
	private String exerciseName;
	private String exerciseDescription;
	
	public Exercise(String exerciseName, String exerciseDescription){
		this.setExerciseName(exerciseName);
		this.setExerciseDescription(exerciseDescription);
	}

	public String getExerciseDescription() {
		return exerciseDescription;
	}

	public void setExerciseDescription(String exerciseDescription) {
		this.exerciseDescription = exerciseDescription;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

}
