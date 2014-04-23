package lin.thompson.workout;


public class Workout {

	private String name;
	private SuitsAndExercise suitsAndExercise;

	public Workout(String name, SuitsAndExercise suitsAndExercise) {
		this.name = name;
		this.suitsAndExercise = suitsAndExercise;
	}

	public Workout(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExercise(String suits) {
		return suitsAndExercise.getExerciseFromSuit(suits);
	}
	
	public String exercisesAsString() {
		StringBuilder returnString = new StringBuilder();
		returnString.append(suitsAndExercise.getExerciseFromSuit("Clubs") + " ");
		returnString.append(suitsAndExercise.getExerciseFromSuit("Hearts") + " ");
		returnString.append(suitsAndExercise.getExerciseFromSuit("Spades") + " ");
		returnString.append(suitsAndExercise.getExerciseFromSuit("Diamonds"));
		
		return returnString.toString();
	}

	public String toString() {
		StringBuilder returnString = new StringBuilder();
		returnString.append(name + "\n");
		int count = 0;
		//while(!exercises.isEmpty() && count < exercises.size()) {
		//	returnString.append(", " + exercises.get(count));
		//}
		return returnString.toString();
	}
}
