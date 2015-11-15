/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.blackjackclient.controller;

import in.bits.blackjackclient.comm.Client;
import in.bits.blackjackclient.ui.FetchingResultPage;
import in.bits.blackjackclient.ui.GameplayPage;
import in.bits.blackjackclient.ui.LoadingPage;
import in.bits.blackjackclient.ui.LoginPage;
import in.bits.blackjackclient.ui.ResultPage;
import in.bits.blackjackclient.ui.WaitPage;

/**
 *
 * @author tarun
 */
public class View {
    
    private static Client client;
    private static LoginPage login;
    private static LoadingPage loading;
    private static GameplayPage gameplay;
    private static ResultPage result;
    private static FetchingResultPage fetchingResult;
    private static WaitPage wait;
    
    public View(){
        login = new LoginPage();
        loading = new LoadingPage();
        gameplay = new GameplayPage();
        result = new ResultPage();
        fetchingResult = new FetchingResultPage();
        wait = new WaitPage();         
    }
    
    public static void setClient(Client client){
        View.client = client;
    }

    public static Client getClient() {
        return client;
    }

    public static LoginPage getLogin() {
        return login;
    }

    public static LoadingPage getLoading() {
        return loading;
    }

    public static GameplayPage getGameplay() {
        return gameplay;
    }

    public static ResultPage getResult() {
        return result;
    }

    public static FetchingResultPage getFetchingResult() {
        return fetchingResult;
    }

    public static WaitPage getWait() {
        return wait;
    }
    
    
    
    
    
        
    
}
