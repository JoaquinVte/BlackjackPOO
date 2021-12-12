package blackjack;

import blackjack.controller.Game;
import blackjack.controller.Input;
import blackjack.controller.i2ascii;
import blackjack.model.Color;


public class App {
    public static void main(String[] args) {

        System.out.println((new i2ascii("black.jpg")).ConvertToAscii());
        int players = Input.getInt( "How many players are going to play?");

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Game game = new Game(players);
        game.start();
    }
}
