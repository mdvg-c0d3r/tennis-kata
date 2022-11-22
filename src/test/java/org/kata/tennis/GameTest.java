package org.kata.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        // Given
        game = new Game("Player1", "Player2");
    }


    @Test
    void shouldReturnBothPlayerNamesWhenIsANewGame() {
        assertEquals("Player1", game.getPlayer1().getName());
        assertEquals("Player2", game.getPlayer2().getName());
    }

    @Test
    void shouldReturnLoveInBothPlayersWhenIsANewGame() {
        // When
        var counter = game.getCounter();

        //Then
        assertEquals(Score.LOVE, counter.getPlayer1Score());
        assertEquals(Score.LOVE, counter.getPlayer2Score());
    }

    @Test
    void shouldGetTheValuesInCounterWithPlayerScores() {
        // When
        game.getCounter().player1Scores();
        game.getCounter().player1Scores();
        game.getCounter().player2Scores();
        var counter = game.getCounter();

        //Then
        assertEquals(Score.THIRTY, counter.getPlayer1Score());
        assertEquals(Score.FIFTEEN, counter.getPlayer2Score());
    }
}