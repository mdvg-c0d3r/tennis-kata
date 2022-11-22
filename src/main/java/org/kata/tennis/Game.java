package org.kata.tennis;

public class Game {
    private Player player1;
    private Player player2;
     private GameCounter counter;

    public Game(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
         this.counter = new GameCounter();
    }

    public GameCounter getCounter() {
        return counter;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
