/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.blackjackclient.controller;

import in.bits.blackjackclient.comm.Client;

/**
 *
 * @author tarun
 */
public class GameController {
  
    private View view;
    
    public GameController(View view){
        this.view = view;
    }
    
    public void startLoginPage(){
        View.getLogin().setVisible(true);
    }
    
    
    
}
