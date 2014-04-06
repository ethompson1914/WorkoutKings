package lin.thompson.workout;

import java.util.ArrayList;

import lin.thompson.deck.Card;
import lin.thompson.deck.CardDeck;

public class Workout {
	
	private String name;
	private CardDeck deck;
	private ArrayList<String> exercises;
	
	public Workout(String name, CardDeck deck, ArrayList<String> exercises) {
		this.name = name;
		this.deck = deck;
		this.exercises = exercises;
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

	public ArrayList<String> getExercises() {
		return exercises;
	}

	public void addExercise(String e) {
		exercises.add(e);
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
		while(!exercises.isEmpty() && count < exercises.size()) {
			returnString.append(", " + exercises.get(count));
		}
		return returnString.toString();
	}
}
