package org.kata.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameCounterTest {

    private GameCounter gameCounter;

    @BeforeEach
    void setUp() {
        gameCounter = new GameCounter();
    }

    @Test
    void shouldInitializeScoresAtLove() {
        assertEquals(Score.LOVE, gameCounter.getPlayer1Score());
        assertEquals(Score.LOVE, gameCounter.getPlayer2Score());
    }

    @Test
    void shouldIncreasePlayerPointsWhenPlayerScores() {
        gameCounter.player1Scores();

        assertEquals(Score.FIFTEEN, gameCounter.getPlayer1Score());
    }

    @Test
    void shouldIncreasePlayerPointsTwiceWhenPlayerScoresTwice() {
        gameCounter.player2Scores();
        gameCounter.player2Scores();

        assertEquals(Score.THIRTY, gameCounter.getPlayer2Score());
    }

    @Test
    void shouldWinTheMatchWhenScoresMoreThanFortyAndTheOtherPlayerIsUnderForty() {
        // Given
        gameCounter.player1Scores();
        gameCounter.player1Scores();
        gameCounter.player2Scores();
        gameCounter.player2Scores();
        gameCounter.player1Scores();
        gameCounter.player1Scores();

        assertTrue(gameCounter.isWinnerPlayer1());
        assertFalse(gameCounter.isWinnerPlayer2());
    }

    @Test
    void shouldWinTheMatchWhenDeuceThenScoreTwice() {
        // Given
        gameCounter.player1Scores();
        gameCounter.player1Scores();
        gameCounter.player1Scores();
        gameCounter.player2Scores();
        gameCounter.player2Scores();
        gameCounter.player2Scores();
        assertFalse(gameCounter.isWinnerPlayer1());
        assertFalse(gameCounter.isWinnerPlayer2());
        assertEquals(Score.DEUCE, gameCounter.getPlayer1Score());
        assertEquals(Score.DEUCE, gameCounter.getPlayer2Score());

        // When
        gameCounter.player1Scores();
        assertEquals(Score.ADVANTAGE, gameCounter.getPlayer1Score());
        gameCounter.player1Scores();
        assertEquals(Score.LOVE, gameCounter.getPlayer1Score());

        // Then
        assertTrue(gameCounter.isWinnerPlayer1());
        assertFalse(gameCounter.isWinnerPlayer2());
    }

    @Test
    void shouldWinTheMatchWhenPlayerIsInAdvantageAndWinsThePoint() {
        // Given
        gameCounter.player1Scores();
        gameCounter.player1Scores();
        gameCounter.player2Scores();
        gameCounter.player2Scores();
        gameCounter.player1Scores();
        gameCounter.player2Scores();
        gameCounter.player1Scores();
        gameCounter.player1Scores();

        assertTrue(gameCounter.isWinnerPlayer1());
        assertFalse(gameCounter.isWinnerPlayer2());
    }

    @Test
    void shouldResetTheCounterWhenAnyPlayerWins() {
        // Given
        gameCounter.player1Scores();
        gameCounter.player1Scores();
        gameCounter.player2Scores();
        gameCounter.player2Scores();
        gameCounter.player1Scores();
        gameCounter.player2Scores();
        gameCounter.player1Scores();
        assertEquals(Score.ADVANTAGE, gameCounter.getPlayer1Score());
        assertEquals(Score.DEUCE, gameCounter.getPlayer2Score());
        // When
        gameCounter.player1Scores();

        assertTrue(gameCounter.isWinnerPlayer1());
        assertFalse(gameCounter.isWinnerPlayer2());
        assertEquals(Score.LOVE, gameCounter.getPlayer1Score());
        assertEquals(Score.LOVE, gameCounter.getPlayer2Score());
    }

    @Test
    void shouldBeDeuceAgainWhenThereIsAdvantageAndTheOtherPlayerCatchTheAdvantagedOne() {
        // Given
        gameCounter.player1Scores();
        gameCounter.player1Scores();
        gameCounter.player1Scores();
        gameCounter.player2Scores();
        gameCounter.player2Scores();
        gameCounter.player2Scores();
        gameCounter.player1Scores();
        assertEquals(Score.ADVANTAGE, gameCounter.getPlayer1Score());
        assertEquals(Score.DEUCE, gameCounter.getPlayer2Score());
        // When
        gameCounter.player2Scores();
        // Then
        assertFalse(gameCounter.isWinnerPlayer1());
        assertFalse(gameCounter.isWinnerPlayer2());
        assertEquals(Score.DEUCE, gameCounter.getPlayer1Score());
        assertEquals(Score.DEUCE, gameCounter.getPlayer2Score());
    }
}