package blackjack.model;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private Card[] cartas;
    private int arriba;
    private int abajo;

    public Deck() {
        cartas = new Card[Value.values().length * Suit.values().length];
        reiniciar();
    }

    private void reiniciar() {
        int i = 0;
        for (Suit p : Suit.values()) {
            for (Value v : Value.values()) {
                cartas[i++] = new Card( v,p);
            }
        }
        abajo = 0;
        arriba = cartas.length - 1;
    }

    public Card up() {
        return (hayCarta()) ? cartas[arriba--] : null;
    }

//    public Card down() {
//        return (hayCarta()) ? cartas[abajo++] : null;
//    }

    private boolean hayCarta() {
        return abajo <= arriba;
    }

    public void shuffle() {

        if (abajo == 0 && arriba == cartas.length - 1) {
            List<Card> c = Arrays.asList(cartas);
            Collections.shuffle(c);
            cartas = c.toArray(new Card[0]);
        }
    }


    public String toString() {
        StringBuilder salida;
        salida = new StringBuilder("Arriba: " + arriba + "\n");
        salida.append("Abajo: ").append(abajo).append("\n");

        for (Card carta : cartas)
            salida.append(carta).append("\n");

        return salida.toString();
    }

}
