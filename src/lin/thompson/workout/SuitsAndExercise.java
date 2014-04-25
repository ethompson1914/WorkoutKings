package lin.thompson.workout;

import java.util.HashMap;

import lin.thompson.global.ConstantVariables;

public class SuitsAndExercise {
	private HashMap<String, String> map;

	//TODO: will probably delete this constructor and just use the other one.
	public SuitsAndExercise(String exerciseClubs, String exerciseHearts, String exerciseSpades, String exerciseDiamonds){
		map = new HashMap<String, String>();
		map.put(ConstantVariables.suits[0], exerciseClubs);
		map.put(ConstantVariables.suits[1], exerciseHearts);
		map.put(ConstantVariables.suits[2], exerciseSpades);
		map.put(ConstantVariables.suits[3], exerciseDiamonds);
	}
	
	/*
	 * This constructor allows the deck to have more or less than 4 suits with their exercises.
	 */
	public SuitsAndExercise(){
		map = new HashMap<String, String>();
	}
	
	public void addExerciseToSuit(String suit, String exercise){
		map.put(suit, exercise);
	}
	
	public String getExerciseFromSuit(String suit) {
		return map.get(suit);
	}
	
}
