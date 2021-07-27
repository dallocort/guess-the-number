package vip.dacha.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vip.dacha.service.GameService;
import vip.dacha.util.AttributeNames;
import vip.dacha.util.GameMappings;
import vip.dacha.util.ViewNames;

@Slf4j
@Controller
public class GameController {
    public final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(GameMappings.HOME)
    public String home() {
        return ViewNames.HOME;
    }

    @GetMapping(GameMappings.GAME_OVER)
    public String gameOver(Model model) {
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        return ViewNames.GAME_OVER;
    }

    @GetMapping(GameMappings.RESET)
    public String gameReset() {
        gameService.reset();
        return GameMappings.REDIRECT_PLAY;
    }


    @GetMapping(GameMappings.PLAY)
    public String play(Model model) {
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.debug("model = {}", model);

        if (gameService.isGameOver()) {
            return ViewNames.GAME_OVER;
        }
        return ViewNames.PLAY;
    }


    @PostMapping(GameMappings.PLAY)
    public String processForm(@RequestParam int guess) {
        gameService.checkGuess(guess);

        return GameMappings.REDIRECT_PLAY;
    }
}
