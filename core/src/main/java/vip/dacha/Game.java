package vip.dacha;

public interface Game {
    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getBiggest();

    int getRemainingGuesses();

    void reset();

    void check();

    boolean isValidNumberRange();

    int getGuessCount();

    boolean isGameWon();

    boolean isGameLost();
}
