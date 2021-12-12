package blackjack.model;

public class Card {

    private final Suit palo;
    private final Value value;

    public Card(Value value, Suit palo){
        this.value = value;
        this.palo = palo;
    }
    public Value getValue(){
        return value;
    }
    public String toString(){
        return value.toString() + palo;
    }

}
