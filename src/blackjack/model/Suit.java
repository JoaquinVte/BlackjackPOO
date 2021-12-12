package blackjack.model;

import static blackjack.model.CardColor.*;

public enum Suit {

    HEART('♥',RED),
    CLUBS('♣',BLACK),
    SPADES('♠',BLACK),
    DIAMONDS('♦',RED);

    private final char palo;
    private final CardColor color;

    Suit(char palo, CardColor color){
        this.palo=palo;
        this.color=color;
    }
    public String toString(){
        return color.toString() + palo + Color.RESET;
    }
}
