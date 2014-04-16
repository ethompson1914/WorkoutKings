package lin.thompson.global;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import lin.thompson.deck.Card;
import lin.thompson.workoutkings.R;

public class GlobalHelpers {
	
	public static Map<String, Integer> NAMED_RESOURCES;
	
	public GlobalHelpers() {
	  Map<String, Integer> m = new HashMap<String, Integer>();
	  
	  // Puts all spades into the map
	  m.put("ace_spades", R.drawable.ace_spades);
	  m.put("spades_two", R.drawable.spades_two);
	  m.put("spades_three", R.drawable.spades_three);
	  m.put("spades_four", R.drawable.spades_four);
	  m.put("spades_five", R.drawable.spades_five);
	  m.put("spades_six", R.drawable.spades_six);
	  m.put("spades_seven", R.drawable.spades_seven);
	  m.put("spades_eight", R.drawable.spades_eight);
	  m.put("spades_nine", R.drawable.spades_nine);
	  m.put("spades_ten", R.drawable.spades_ten);
	  m.put("jack_spades", R.drawable.jack_spades);
	  m.put("queen_spades", R.drawable.queen_spades);
	  m.put("king_spades", R.drawable.king_spades);
	  
	  // Puts all hearts into the map
	  m.put("ace_hearts", R.drawable.ace_spades);
	  m.put("hearts_two", R.drawable.hearts_two);
	  m.put("hearts_three", R.drawable.hearts_three);
	  m.put("hearts_four", R.drawable.hearts_four);
	  m.put("hearts_five", R.drawable.hearts_five);
	  m.put("hearts_six", R.drawable.hearts_six);
	  m.put("hearts_seven", R.drawable.hearts_seven);
	  m.put("hearts_eight", R.drawable.hearts_eight);
	  m.put("hearts_nine", R.drawable.hearts_nine);
	  m.put("hearts_ten", R.drawable.hearts_ten);
	  m.put("jack_hearts", R.drawable.hearts_eight); // TODO
	  m.put("queen_hearts", R.drawable.queen_hearts);
	  m.put("king_hearts", R.drawable.king_hearts);
	  
	  // Puts all clubs into the map
	  m.put("ace_clubs", R.drawable.ace_clubs);
	  m.put("clubs_two", R.drawable.clubs_two);
	  m.put("clubs_three", R.drawable.clubs_three);
	  m.put("clubs_four", R.drawable.clubs_four);
	  m.put("clubs_five", R.drawable.clubs_five);
	  m.put("clubs_six", R.drawable.clubs_six);
	  m.put("clubs_seven", R.drawable.clubs_seven);
	  m.put("clubs_eight", R.drawable.clubs_eight);
	  m.put("clubs_nine", R.drawable.clubs_nine);
	  m.put("clubs_ten", R.drawable.clubs_ten);
	  m.put("jack_clubs", R.drawable.jack_clubs);
	  m.put("queen_clubs", R.drawable.queen_clubs);
	  m.put("king_clubs", R.drawable.king_clubs);
	  
	  // Puts all diamonds into the map
	  m.put("ace_diamonds", R.drawable.ace_diamonds);
	  m.put("diamonds_two", R.drawable.diamonds_two);
	  m.put("diamonds_three", R.drawable.diamonds_three);
	  m.put("diamonds_four", R.drawable.diamonds_four);
	  m.put("diamonds_five", R.drawable.diamonds_five);
	  m.put("diamonds_six", R.drawable.diamonds_six);
	  m.put("diamonds_seven", R.drawable.diamonds_seven);
	  m.put("diamonds_eight", R.drawable.diamonds_eight);
	  m.put("diamonds_nine", R.drawable.diamonds_nine);
	  m.put("diamonds_ten", R.drawable.diamonds_ten);
	  m.put("jack_diamonds", R.drawable.jack_diamonds);
	  m.put("queen_diamonds", R.drawable.queen_diamonds);
	  m.put("king_diamonds", R.drawable.king_diamonds);
	  
	  
	  NAMED_RESOURCES = Collections.unmodifiableMap(m);
	}
	
	public String getNameFromCard(Card card) {
		if(card.getSuit() == 0 && card.getNumber() == 2) { return "spades_two"; }
		else if(card.getSuit() == 0 && card.getNumber() == 3) { return "spades_three"; }
		else if(card.getSuit() == 0 && card.getNumber() == 4) { return "spades_four"; }
		else if(card.getSuit() == 0 && card.getNumber() == 5) { return "spades_five"; }
		else if(card.getSuit() == 0 && card.getNumber() == 6) { return "spades_six"; }
		else if(card.getSuit() == 0 && card.getNumber() == 7) { return "spades_seven"; }
		else if(card.getSuit() == 0 && card.getNumber() == 8) { return "spades_eight"; }
		else if(card.getSuit() == 0 && card.getNumber() == 9) { return "spades_nine"; }
		else if(card.getSuit() == 0 && card.getNumber() == 10) { return "spades_ten"; }
		else if(card.getSuit() == 0 && card.getNumber() == 11) { return "jack_spades"; }
		else if(card.getSuit() == 0 && card.getNumber() == 12) { return "queen_spades"; }
		else if(card.getSuit() == 0 && card.getNumber() == 13) { return "king_spades"; }
		else if(card.getSuit() == 0 && card.getNumber() == 14) { return "ace_spades"; }

		else if(card.getSuit() == 1 && card.getNumber() == 2) { return "hearts_two"; }
		else if(card.getSuit() == 1 && card.getNumber() == 3) { return "hearts_three"; }
		else if(card.getSuit() == 1 && card.getNumber() == 4) { return "hearts_four"; }
		else if(card.getSuit() == 1 && card.getNumber() == 5) { return "hearts_five"; }
		else if(card.getSuit() == 1 && card.getNumber() == 6) { return "hearts_six"; }
		else if(card.getSuit() == 1 && card.getNumber() == 7) { return "hearts_seven"; }
		else if(card.getSuit() == 1 && card.getNumber() == 8) { return "hearts_eight"; }
		else if(card.getSuit() == 1 && card.getNumber() == 9) { return "hearts_nine"; }
		else if(card.getSuit() == 1 && card.getNumber() == 10) { return "hearts_ten"; }
		else if(card.getSuit() == 1 && card.getNumber() == 11) { return "jack_hearts"; }
		else if(card.getSuit() == 1 && card.getNumber() == 12) { return "queen_hearts"; }
		else if(card.getSuit() == 1 && card.getNumber() == 13) { return "king_hearts"; }
		else if(card.getSuit() == 1 && card.getNumber() == 14) { return "ace_hearts"; }
		
		else if(card.getSuit() == 2 && card.getNumber() == 2) { return "clubs_two"; }
		else if(card.getSuit() == 2 && card.getNumber() == 3) { return "clubs_three"; }
		else if(card.getSuit() == 2 && card.getNumber() == 4) { return "clubs_four"; }
		else if(card.getSuit() == 2 && card.getNumber() == 5) { return "clubs_five"; }
		else if(card.getSuit() == 2 && card.getNumber() == 6) { return "clubs_six"; }
		else if(card.getSuit() == 2 && card.getNumber() == 7) { return "clubs_seven"; }
		else if(card.getSuit() == 2 && card.getNumber() == 8) { return "clubs_eight"; }
		else if(card.getSuit() == 2 && card.getNumber() == 9) { return "clubs_nine"; }
		else if(card.getSuit() == 2 && card.getNumber() == 10) { return "clubs_ten"; }
		else if(card.getSuit() == 2 && card.getNumber() == 11) { return "jack_clubs"; }
		else if(card.getSuit() == 2 && card.getNumber() == 12) { return "queen_clubs"; }
		else if(card.getSuit() == 2 && card.getNumber() == 13) { return "king_clubs"; }
		else if(card.getSuit() == 2 && card.getNumber() == 14) { return "ace_clubs"; }

		else if(card.getSuit() == 3 && card.getNumber() == 2) { return "diamonds_two"; }
		else if(card.getSuit() == 3 && card.getNumber() == 3) { return "diamonds_three"; }
		else if(card.getSuit() == 3 && card.getNumber() == 4) { return "diamonds_four"; }
		else if(card.getSuit() == 3 && card.getNumber() == 5) { return "diamonds_five"; }
		else if(card.getSuit() == 3 && card.getNumber() == 6) { return "diamonds_six"; }
		else if(card.getSuit() == 3 && card.getNumber() == 7) { return "diamonds_seven"; }
		else if(card.getSuit() == 3 && card.getNumber() == 8) { return "diamonds_eight"; }
		else if(card.getSuit() == 3 && card.getNumber() == 9) { return "diamonds_nine"; }
		else if(card.getSuit() == 3 && card.getNumber() == 10) { return "diamonds_ten"; }
		else if(card.getSuit() == 3 && card.getNumber() == 11) { return "jack_diamonds"; }
		else if(card.getSuit() == 3 && card.getNumber() == 12) { return "queen_diamonds"; }
		else if(card.getSuit() == 3 && card.getNumber() == 13) { return "king_diamonds"; }
		else if(card.getSuit() == 3 && card.getNumber() == 14) { return "ace_diamonds"; }
		
		return "";
	}
	
	public void saveWorkoutDeckData(String name, String suitsAndExercise, String cardDeck ){
		
	}
	
}
