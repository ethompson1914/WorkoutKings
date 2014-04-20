package lin.thompson.global;

import java.util.ArrayList;
import java.util.HashMap;

import android.graphics.Picture;

public class ConstantVariables {
	  public final static String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
	  public final static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
	  public static HashMap<String,Picture> map = new HashMap<String,Picture>();
	  public static ArrayList<String> exercises = new ArrayList<String>();
	  
	  public static void addExercise(String exercise){
		  exercises.add(exercise);
	  }
	  
	  //return boolean for successful/unsuccessful deletion?
	  public static void removeExercise(String exercise){
		  exercises.remove(exercise);
	  }
	  
}
