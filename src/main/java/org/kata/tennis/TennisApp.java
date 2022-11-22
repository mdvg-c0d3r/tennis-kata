package org.kata.tennis;

public class TennisApp {
    private static Game game;

    public static void main(String[] args) {
        System.out.println("-- Welcome to tennis kata --");
        TennisApp.start();
    }

    private static void start() {
        game = new Game("Player1", "Player2");
    }
}