package in.bits.blackjack.bean;

import java.io.Serializable;
import java.util.Objects;

public class Card implements Serializable{
    
    private final Suit suit;
    public static final long serialVersionUID = 41L;
    private final int cardNumber;
    private final int value;

    public Card(Suit suit, int cardNumber, int value) {
        this.suit = suit;
        this.cardNumber = cardNumber;
        this.value = value;
    }
    
    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }
    /**
     * @return the cardNumber
     */
    public int getCardNumber() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return "Card{" + "suit=" + suit + ", cardNumber=" + cardNumber + ", value=" + value + "}\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.suit);
        hash = 89 * hash + this.cardNumber;
        hash = 89 * hash + this.value;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        Card other = (Card)obj;
        if(suit.equals(other.suit)){
            if(cardNumber == other.cardNumber){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    
    
}
