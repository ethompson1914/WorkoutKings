package Deck;
import org.junit.Test;

import junit.framework.TestCase;
import lin.thompson.deck.Card;


public class TestCard extends TestCase {
	private Card card;
	
	//@Test
	public void testShouldReturnFive(){
		card = new Card(0, 5);
		assertEquals(card.getNumber(),5);
	}
	
	//@Test
	public void testShouldReturnClubs(){
		card = new Card(1, 5);
		assertEquals(card.getSuit(), 1);
	}
	
	//@Test
	public void testShouldReturnStringClubs(){
		card = new Card(0, 5);
		assertEquals(card.getSuitName(), "Clubs");
	}
}
