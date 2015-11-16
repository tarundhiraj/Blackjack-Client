package in.bits.blackjack.bean;

import java.io.Serializable;
import java.util.HashMap;

public class Message implements Serializable{
    
    public static final long serialVersionUID = 42L;
    
    private Card card;
    private String sender;
    private Type type;
    private String receiver;
    private int score;
    private HashMap<String, Result> result;
    
    public Message(Card card, String sender, Type type, String receiver, int score, HashMap<String, Result> result){
        this.card = card;
        this.sender = sender;
        this.type = type;
        this.receiver = receiver;
        this.score = score;
        this.result = result;
    }

    @Override
    public String toString() {
        return "Message{" + "card=" + card + ", sender=" + sender + ", type=" + type + ", receiver=" + receiver + ", score=" + score + ", result=" + result + '}';
    }
    
    

    /**
     * @return the card
     */
    public Card getCard() {
        return card;
    }

    /**
     * @param card the card to set
     */
    public void setCard(Card card) {
        this.card = card;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return the receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * @param receiver the receiver to set
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the result
     */
    public HashMap<String, Result> getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(HashMap<String, Result> result) {
        this.result = result;
    }
    
    
}
