package blackjack.model;

public enum Color {

    BLINK("\u001B[5m"),
    RAPID_BLINK("\u001B[6m"),
    BLACK("\u001b[1;90m"),
    RED("\u001b[1;91m"),
    GREEN("\u001b[1;92m"),
    YELLOW("\u001b[1;93m"),
    BLUE("\u001b[1;94m"),
    MAGENTA("\u001b[1;95m"),
    CYAN("\u001b[1;96m"),
    RESET("\u001b[0m");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String toString() {
        return color;
    }
}
