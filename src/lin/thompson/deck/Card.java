package lin.thompson.deck;

import lin.thompson.global.ConstantVariables;

public class Card {
	
	
	  private final int suit;  // between 0 and 3
	  private final int number;  // between 2 and 14
	  
	  /* Constructor */
	  public Card(int s, int n) {
	    suit = s;
	    number = n;
	  }
	  
	  /* Accessor methods */
	  
	  //Return the suit of the card.
	  public int getSuit(){
	    return suit;
	  }
	  
	  public String getSuitName(){
		  return ConstantVariables.suits[suit];
	  }
	  //Return the number of the card.
	  public int getNumber(){
	    return number;
	  }
	  
	  /* Returns string representation of a card */
	  public String toString(){
	    return ConstantVariables.faces[number-2]+" of "+ConstantVariables.suits[suit];
	  }
	  
	  public int compareTo(Object obj){
	    int otherNum = ((Card) obj).getNumber();
	    int otherSuit = ((Card) obj).getSuit();
	    if(otherNum>number){
	      return -1;
	    }
	    else if(otherNum<number){
	      return 1;
	    }
	    else{
	      if(suit>otherSuit){
	        return 1;
	      }
	      else if(suit<otherSuit){
	        return -1;
	      }
	      else{
	        return 0;
	      }
	    }
	  }

}
