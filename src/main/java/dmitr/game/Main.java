package dmitr.game;

import dmitr.game.core.GuessTheWordGame;
import dmitr.game.core.generator.DefaultWordGenerator;
import dmitr.game.core.guess.DefaultGuessChecker;
import dmitr.game.core.validator.DefaultValidator;
import dmitr.game.ui.ConsoleUI;

public class Main {

    public static void main(String[] args) {
        GuessTheWordGame game = new GuessTheWordGame(
                new DefaultValidator(),
                new DefaultWordGenerator(),
                new DefaultGuessChecker()
        );

        ConsoleUI consoleUI = new ConsoleUI(game);
        consoleUI.run();
    }

}