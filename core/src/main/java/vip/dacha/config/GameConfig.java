package vip.dacha.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config/game.properties")
public class GameConfig {


    @Value("${game.minNumber:0}")
    private int minNumber;
    @Value("${game.maxNumber:100}")
    private int maxNumber;
    @Value("${game.guessCount:10}")
    private int guessCount;


    public int getMaxNumber() {
        return maxNumber;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public int getMinNumber() {
        return minNumber;
    }
}
