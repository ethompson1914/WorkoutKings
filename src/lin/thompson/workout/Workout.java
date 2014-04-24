package lin.thompson.workout;

import java.io.Serializable;
import java.util.ArrayList;

public class Workout implements Serializable {

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
	
	public ArrayList<String> getAllExercises() {
		ArrayList<String> returnList = new ArrayList<String>();
		returnList.add(suitsAndExercise.getExerciseFromSuit("Clubs"));
		returnList.add(suitsAndExercise.getExerciseFromSuit("Hearts"));
		returnList.add(suitsAndExercise.getExerciseFromSuit("Spades"));
		returnList.add(suitsAndExercise.getExerciseFromSuit("Diamonds"));
		return returnList;
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
