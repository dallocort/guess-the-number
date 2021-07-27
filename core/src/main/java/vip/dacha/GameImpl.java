package vip.dacha;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import vip.dacha.config.GameConfig;

import javax.annotation.PostConstruct;

@Component
@Getter
@Slf4j
public class GameImpl implements Game {

    // == fields ==
    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;
    private final int guessCount;
    private int number;
    @Setter
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;


    //== Constructor ==

    GameImpl(NumberGenerator numberGenerator, GameConfig gameConfig) {
        this.numberGenerator = numberGenerator;
        this.guessCount = gameConfig.getGuessCount();
    }

    // == public methods ==
    @Override
    @PostConstruct
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
    }

    @Override
    public void check() {

        checkValidNumberRange();

        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }

            if (guess < number) {
                smallest = guess + 1;
            }
        }

        remainingGuesses--;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==
    private void checkValidNumberRange() {

        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
