/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.blackjack.bean;

/**
 *
 * @author tarun
 */
public enum Suit {
    HEARTS("HEARTS"),CLUBS("CLUBS"),DIAMONDS("DIAMONDS"),SPADES("SPADES");
    
    private final String suitName;
       
    
    Suit(String suitName){
        this.suitName = suitName;
    }

    public String getSuitName() {
        return suitName;
    }

    
}
