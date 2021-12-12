package blackjack.model;

public enum CardColor {
    RED(Color.RED),
    BLACK(Color.BLACK);
    private final Color color;

    CardColor(Color color) {
        this.color = color;
    }

    public String toString() {
        return color.toString();
    }
}
