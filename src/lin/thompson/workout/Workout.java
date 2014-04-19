package lin.thompson.workout;

import java.io.Serializable;
import java.util.ArrayList;

import lin.thompson.deck.Card;
import lin.thompson.deck.CardDeck;

public class Workout implements Serializable {

	private String name;
	private CardDeck deck;
	private SuitsAndExercise suitsAndExercise;

	public Workout(String name, CardDeck deck, SuitsAndExercise suitsAndExercise) {
		this.name = name;
		this.deck = deck;
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

	public ArrayList<Card> getCards() {
		return deck.getCards();
	}

	public void addCard(Card card) {
		deck.addCard(card);
	}

	public CardDeck getDeck() {
		return deck;
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
