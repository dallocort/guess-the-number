package vip.dacha;

import lombok.Getter;
import org.springframework.stereotype.Component;
import vip.dacha.config.GameConfig;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {


    //fields
    private final Random random = new Random();
    @Getter
    private final int maxNumber;
    @Getter
    private final int minNumber;

    //Constructors
    public NumberGeneratorImpl(GameConfig gameConfig) {
        this.maxNumber = gameConfig.getMaxNumber();
        this.minNumber = gameConfig.getMinNumber();
    }

    //methods
    @Override
    public int next() {

        return random.nextInt(maxNumber-minNumber) + minNumber;
    }


}
