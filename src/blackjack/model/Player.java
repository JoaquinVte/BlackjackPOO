package blackjack.model;

public class Player {
    private Card[] hand;
    private final String name;

    public Player(String name) {
        hand = new Card[0];
        this.name = name;
    }

    public void add(Card card) {
        Card[] aux = new Card[hand.length + 1];
        int i = 0;
        for (Card c : hand)
            aux[i++] = c;
        aux[i] = card;
        hand = aux;
    }

    public int score() {
        return score(0, 0);
    }

    private int score(int index, int sum) {

        int aux1, aux0;

        if (sum > 21) return -1;
        if (index >= hand.length) return sum;

        if (hand[index].getValue().getValues().length > 1) {

            aux0 = score(index + 1, sum + hand[index].getValue().getValues()[0]);
            aux1 = score(index + 1, sum + hand[index].getValue().getValues()[1]);

            if (aux0 > 21 && aux1 > 21) return -1;
            if (aux0 > 21) return aux1;
            if (aux1 > 21) return aux0;

            return Math.max(aux0, aux1);
        }

        return score(index + 1, sum + hand[index].getValue().getValues()[0]);
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(Color.BLUE + "Score: " + Color.YELLOW).append(score()).append(Color.RESET).append("\n");
        for (Card c : hand)
            output.append(c).append(" ");

        return output.toString();
    }
}
