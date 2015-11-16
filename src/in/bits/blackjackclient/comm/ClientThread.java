/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.bits.blackjackclient.comm;

import in.bits.blackjack.bean.Message;
import in.bits.blackjack.bean.Type;
import in.bits.blackjackclient.controller.View;
import in.bits.blackjackclient.game.Game;
import java.awt.Frame;
import java.awt.Window;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 * <strong>ClientThread</strong> handles the connection of one client
 * connection. Client Thread is responsible for all the communication between
 * Server and the Client that it is handling.
 *
 */
public class ClientThread implements Runnable {

    private final Client client;
    private Message message;
    private Thread thread;
    private Game game;

    /**
     * Creates a client thread for a particular client
     *
     * @param client : Client that has established successful connection
     */
    public ClientThread(Client client, Game game) {
        this.client = client;
        this.game = game;
        client.sendMessage(new Message(null, client.getUserName(), Type.JOIN, null, 0, null));
        thread = new Thread(this);
        thread.start();
    }

    public Message getMessage() {
        return message;
    }

    private void closeOtherFrames() {
         System.gc();
         for(Window window : Window.getWindows()){
             window.dispose();
         }
    }

    /**
     * Handles the messages as they are received from the server. ClientThread
     * receives and processes the messages depending upon the type of the
     * message.
     *
     * @see Message
     * @see Type
     */
    @Override
    public void run() {
        Message message;
        while (true) {
            try {

                message = (Message) client.getIn().readObject();
                System.out.println("Message Received:" + message);
                if (message.getType().getTypeOfMessage().equalsIgnoreCase("GAMEBEGIN")) {

                    closeOtherFrames();
                    View.getGameplay().setVisible(true);

                    game.setPlayingStatus(true);
                    game.getTwoCards();
                } else if (message.getType().getTypeOfMessage().equalsIgnoreCase("CARD")) {
                    game.dealWithCard(message.getCard());
                    View.getGameplay().setCardStat(message.getCard());
                    View.getGameplay().setTotal(game.getHand().getValueOfHand());
                } else if (message.getType().getTypeOfMessage().equalsIgnoreCase("RESULT")) {
                    //Code to publish result, and that's all the messages the client has to handle really
                    //assume the result comes in the format
                    //name->score,WIN/LOSE
                    game.resetGame();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    closeOtherFrames();
                    View.getResult().setVisible(true);
                    View.getResult().setResult(message.getResult());

                } else if (message.getType().getTypeOfMessage().equalsIgnoreCase("LIST")) {
                    View.getGameplay().setUsersList(message.getSender());
                    //Make sure that server sends the list in the sender field of the message
                    //separated by commas
                } else if (message.getType().getTypeOfMessage().equalsIgnoreCase("WAIT")) {
                    View.getWait().setVisible(true);
                } else if (message.getType().getTypeOfMessage().equalsIgnoreCase("RESTART")) {
                    if (View.getWait().isActive()) {
                        client.sendMessage(new Message(null, client.getUserName(), Type.ACCEPT, null, 0, null));
                        View.getLoading().setVisible(true);
                    }   
                }

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
