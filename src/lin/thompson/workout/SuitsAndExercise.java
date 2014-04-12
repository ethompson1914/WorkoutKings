package lin.thompson.workout;

import java.util.HashMap;

public class SuitsAndExercise {
	private HashMap<String, String> map;

	//TODO: will probably delete this constructor and just use the other one.
	public SuitsAndExercise(String exerciseClubs, String exerciseHearts, String exerciseSpades, String exerciseDiamonds){
		map = new HashMap<String, String>();
	}
	
	/*
	 * This constructor allows the deck to have more or less than 4 suits with their exercises.
	 */
	public SuitsAndExercise(){
		map = new HashMap<String, String>();
	}
	
	public void addExerciseToSuit(String suit, String exercise){
		map.put(suit,exercise);
	}
	
	public String getExerciseFromSuit(String suit){
		return map.get(suit);
	}
	
}
