package blackjack.model;

public enum Value {
    ACE("A", 1, 11),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 10),
    QUEEN("Q", 10),
    KING("K", 10);

    private final int[] values;
    private final String shape;

    Value(String shape, Integer... values) {
        this.values = new int[values.length];
        for (int i = 0; i < values.length; i++)
            this.values[i] = values[i];
        this.shape = shape;
    }
    public int[] getValues(){
        return values;
    }
    public String toString(){
        return shape;
    }

}
