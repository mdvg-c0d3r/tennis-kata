package org.kata.tennis;

public enum Score {
    LOVE("love"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    DEUCE("deuce"),
    ADVANTAGE("advantage");

    public final String value;

    private Score(String value) {
        this.value = value;
    }

}
