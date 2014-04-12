package lin.thompson.deck;
import java.util.ArrayList;
import java.util.Random;

import lin.thompson.workout.SuitsAndExercise;
//Built-in java class.
//Built-in java class.


public class CardDeck {	
	  
	  private ArrayList<Card> deck;
	  
	  /* Initializes deck with 52 standard cards */
	  public CardDeck(){
	    deck= new ArrayList<Card>();
	    for(int x=0; x<4;x++){
	      for(int y=2; y<15; y++){
	        deck.add(new Card(x,y)); //Filling the ArrayList with Card objects.
	      }
	    }
	  }
	  
	  //
	  public CardDeck(int suitSize, int numOfSuits){
		  deck = new ArrayList<Card>();
		  for(int x = 0; x<numOfSuits; x++){
			  for(int y = 2; y < suitSize+2; y++){
				  deck.add(new Card(x,y));
			  }
		  }
	  }
	  
	  
	  /* Removes a Card from the top of the deck and returns it */
	  public Card getTopCard(){    
	    return deck.remove(0);
	  }
	  
	  /* Returns the number of cards in the deck */
	  public int getNumCards(){  
	    return deck.size();
	  }
	  
	  /* Shuffles the deck.
	   * Algorithm: Steps through the ArrayList, swapping every element 
	   * with another element at a randomly chosen index */
	  public void shuffle(){
	    
	    for(int x = 0; x < deck.size(); x++){
	      Random r= new Random(); //Using the built-in class Random.
	      int k = r.nextInt(deck.size()); 
	      Card temp = deck.get(k); //Need a temporary Card object as the original value will be replaced.
	      int p = r.nextInt(deck.size());
	      deck.set(k, deck.get(p)); //Swapping the elements
	      deck.set(p, temp);        //Swapping the elements
	    }
	  }
	  
	  /* Returns a string representation of the deck */
	  public String toString(){
	    return deck.toString();
	    
	  }
	  
	  /* Adds a card to the deck */
	  public void addCard(Card card) {
		  deck.add(card);
	  }
	  
	  /* Gets the cards */
	  public ArrayList<Card> getCards() {
		  return deck;
	  }
	  
	  public void bubbleSort(){
	    int k;
	    for( int x = 0; x<deck.size(); x++){
	      k=0;
	      for( int y=0; y<deck.size()-1;y++){
	        k=y+1;
	        if(deck.get(k).compareTo(deck.get(y))<0){
	          Card temp= new Card(deck.get(k).getSuit(),deck.get(k).getNumber());
	          deck.set(k,deck.get(y));
	          deck.set(y,temp);
	          k++;
	        }
	      }
	    }
	  }
	  public void bubbleSort2(){
	    int swap =1;
	    int k;
	    while(swap!=0){
	      swap=0;
	      for( int x = 0; x<deck.size(); x++){
	        k=0;
	        for( int y=0; y<deck.size()-1;y++){
	          k=y+1;
	          if(deck.get(k).compareTo(deck.get(y))<0){
	            Card temp= new Card(deck.get(k).getSuit(),deck.get(k).getNumber());
	            deck.set(k,deck.get(y));
	            deck.set(y,temp);
	            k++;
	            swap++;
	          }
	        }
	      }
	    }
	  }

}
