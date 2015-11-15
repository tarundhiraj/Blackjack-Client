/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.blackjack.main;

import in.bits.blackjackclient.controller.GameController;
import in.bits.blackjackclient.controller.View;

/**
 *
 * @author tarun
 */
public class Main {
    public static void main(String args[]){
        GameController gc = new GameController(new View());
        gc.startLoginPage();
    }
}
