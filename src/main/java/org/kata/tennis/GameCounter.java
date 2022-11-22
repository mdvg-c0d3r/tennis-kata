package org.kata.tennis;

public class GameCounter {
    private Score player1Score;
    private Score player2Score;
    private boolean winnerPlayer1;
    private boolean winnerPlayer2;

    public GameCounter() {
        player1Score = Score.LOVE;
        player2Score = Score.LOVE;
    }

    public Score getPlayer1Score() {
        return player1Score;
    }

    public Score getPlayer2Score() {
        return player2Score;
    }

    public boolean isWinnerPlayer1() {
        return winnerPlayer1;
    }

    public boolean isWinnerPlayer2() {
        return winnerPlayer2;
    }

    public Score player1Scores() {
        var previousScore = player1Score;
        player1Score = playerScoreCalculator(player1Score);

        winnerPlayer1 = checkWinner(previousScore, player1Score);

        return player1Score;
    }

    public Score player2Scores() {
        var previousScore = player1Score;
        player2Score = playerScoreCalculator(player2Score);

        winnerPlayer2 = checkWinner(previousScore, player2Score);

        return player2Score;
    }

    private boolean checkWinner(Score previousScore, Score currentScore) {
        if((previousScore.value == Score.ADVANTAGE.value || previousScore.value == Score.FORTY.value)
            && currentScore.value == Score.LOVE.value) {
            return true;
        } else {
            return false;
        }
    }

    private Score playerScoreCalculator(Score playerScore) {
        var newScore = Score.LOVE;
        switch (playerScore.value) {
            case "advantage", "40" -> {
                this.player1Score = Score.LOVE;
                this.player2Score = Score.LOVE;
                newScore = Score.LOVE;
            }
            case "deuce" -> {
                if (this.player1Score.value == "advantage" || this.player2Score.value == "advantage") {
                    this.player1Score = Score.DEUCE;
                    this.player2Score = Score.DEUCE;
                    newScore = Score.DEUCE;
                } else {
                    newScore = Score.ADVANTAGE;
                }
            }
            case "30" -> {
                if (this.player1Score.value == "40" || this.player2Score.value == "40") {
                    this.player1Score = Score.DEUCE;
                    this.player2Score = Score.DEUCE;
                    newScore = Score.DEUCE;
                } else {
                    newScore = Score.FORTY;
                }
            }
            case "15" -> newScore = Score.THIRTY;
            case "love" -> newScore = Score.FIFTEEN;
        }

        return newScore;
    }
}
