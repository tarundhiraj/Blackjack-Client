package in.bits.blackjackclient.game;

import in.bits.blackjack.bean.Card;
import in.bits.blackjack.bean.Hand;
import in.bits.blackjack.bean.Message;
import in.bits.blackjack.bean.Type;
import in.bits.blackjackclient.comm.Client;
import in.bits.blackjackclient.controller.View;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game {
    
    private Client client;
    private Hand hand;
    private boolean playing = false;
    
    public Game(Client client, Hand hand){
        this.client = client;
        this.hand = hand;
    }

    public Hand getHand() {
        return hand;
    }
    
    public void setPlayingStatus(boolean playing){
        this.playing = playing;
    }
    
    public boolean getPlayingStatus(){
        return playing;
    }
    
    public void getTwoCards(){
        client.sendMessage(new Message(null, client.getUserName(), Type.HIT, null, 0, null));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        client.sendMessage(new Message(null, client.getUserName(), Type.HIT, null, 0, null));
    }
    
    public void hit(){
        client.sendMessage(new Message(null, client.getUserName(), Type.HIT, null, 0, null));
    }
    
    public void fold(){
        client.sendMessage(new Message(null, client.getUserName(), Type.FOLD, null, 0, null));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        client.sendMessage(new Message(null, client.getUserName(), Type.FOREVAL, null, hand.getValueOfHand(), null));
    }
    
    public void dealWithCard(Card card){
        hand.incrementCards();
        hand.setValueOfHand(card.getValue());
        hand.putInHand(hand.getCardsInHand(), card);
        
        if(hand.getValueOfHand() >= 17){
            fold();
        }
    }
    
    public void quitGame(){
        if(playing == true){
            fold();
        }
        client.sendMessage(new Message(null, client.getUserName(), Type.EXIT, null, 0, null));
    }
    
    public void resetGame(){
        hand.resetHand();
        playing = false;
    }
}
