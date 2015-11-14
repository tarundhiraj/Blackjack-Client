package in.bits.blackjackclient.bean;

import java.util.Objects;

public class Card {
    
    private final Suit suit;
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
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.suit != other.suit) {
            return false;
        }
        if (this.cardNumber != other.cardNumber) {
            return false;
        }
        return true;
    }
    
    
    
}
