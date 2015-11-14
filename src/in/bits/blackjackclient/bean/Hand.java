package in.bits.blackjackclient.bean;

import java.util.HashMap;

public class Hand {
    
    private int cardsInHand = 0;
    private HashMap<Integer, Card> cards;
    private int valueOfHand = 0;
    
    public Hand(){
        cards = new HashMap<>();
    }
    
    public void incrementCards(){
        cardsInHand += 1;
    }
    
    public int getCardsInHand(){
        return cardsInHand;
    }
    
    public void setValueOfHand(int value){
        valueOfHand += value;
    }
    
    public int getValueOfHand(){
        return valueOfHand;
    }
    
    public void putInHand(int cardNo, Card card) {
        cards.put(cardNo, card);
    }
    
    public HashMap<Integer, Card> getCards(){
        return cards;
    }
    
    public void resetHand(){
        cards.clear();
        cardsInHand = 0;
        valueOfHand = 0;
    }
    
    public void handleResult(){
        
    }
}
