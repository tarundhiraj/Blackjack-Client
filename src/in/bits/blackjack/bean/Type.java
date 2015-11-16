package in.bits.blackjack.bean;

public enum Type {
    HIT("HIT"),
    FOLD("FOLD"),
    CARD("CARD"),
    CARDREQ("CARDREQ"),
    GAMEBEGIN("GAMEBEGIN"),
    ISDEALER("ISDEALER"),
    WAIT("WAIT"),
    RESTART("RESTART"),
    READY("READY"),
    ACCEPT("ACCEPT"),
    REJECT("REJECT"),
    JOIN("JOIN"),
    DISCONNECT("DISCONNECT"),
    EXIT("EXIT"),
    FOREVAL("FOREVAL"),
    RESULT("RESULT"),
    LIST("LIST");
    
    private String typeOfMessage;
    
    Type(String typeOfMessage){
        this.typeOfMessage = typeOfMessage;
    }
    
    public String getTypeOfMessage(){
       return typeOfMessage;
    }
}
    
