package blackjack.controller;

import blackjack.model.Color;
import blackjack.model.Deck;
import blackjack.model.Player;

public class Game {
    private final Player[] players;
    private final Player pc;
    private final Deck deck;

    public Game(int numPlayers){
        this.players = new Player[numPlayers];
        this.deck = new Deck();
        this.pc = new Player("PC");
    }

    public void start(){

        initializePlayers();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        deck.shuffle();
        char option;

        for(Player player : players){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("It's the turn for " + player.getName());
            do{
                Audio.playSound("acierto.wav");
                player.add(deck.up());
                System.out.println(player);

                if(player.score()==-1) {
                    Audio.playSound("fallo.wav");
                    System.out.println(Color.YELLOW + "Uppss!!" + Color.RESET);
                    sleep(3);
                    break;
                }

                option = Input.getYesNoOption(player.getName() +", do you want another card? ");
            } while (player.score()!=-1 && option!='N');
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Now I play !!!");
        sleep(1);
        do{
            pc.add(deck.up());
            if(pc.score()==-1)
                Audio.playSound("fallo.wav");
            else
                Audio.playSound("acierto.wav");
            System.out.println(pc);
            sleep(2);

        } while (pc.score()!=-1 && pc.score()<getMaxPlayerScore());

        showWinMessage();
    }
    private void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void showWinMessage() {

        if(pc.score()!=-1)
            System.out.println(Color.GREEN + "PC Win !!!" + Color.RESET);
        else{
            int playerScore=getMaxPlayerScore();
            for(Player player : players)
                if(player.score()==playerScore)
                    System.out.println( Color.RAPID_BLINK.toString() + Color.GREEN + player.getName() + " Win !!!" + Color.RESET);
        }
        System.out.println(Color.BLINK + Color.MAGENTA.toString() + (new i2ascii("gameover.jpg")).ConvertToAscii() + Color.RESET);
        Audio.playSound("fallo.wav");
        sleep(9);
    }

    private int getMaxPlayerScore() {
        int playerScore=0;
        for(Player player : players)
            playerScore = Math.max(playerScore,player.score());

        return playerScore;
    }


    private void initializePlayers() {

        for(int i=0;i<players.length;i++)
            players[i]=new Player(Input.getString("Name for player " + (i+1)));

    }


}
