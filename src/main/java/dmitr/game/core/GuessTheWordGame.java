package dmitr.game.core;

import dmitr.game.core.generator.WordGenerator;
import dmitr.game.core.guess.GuessChecker;
import dmitr.game.core.validator.Validator;

import java.util.Map;

public class GuessTheWordGame {

    private final Validator validator;
    private final WordGenerator wordGenerator;
    private final GuessChecker guessChecker;
    private String guessWord;

    public GuessTheWordGame(Validator validator, WordGenerator wordGenerator, GuessChecker guessChecker) {
        this.validator = validator;
        this.wordGenerator = wordGenerator;
        this.guessChecker = guessChecker;
    }

    public void generate() {
        guessWord = wordGenerator.generate();
    }

    public int getGuessWordLength() {
        if (guessWord == null)
            throw new IllegalStateException("The word was not generated!");

        return guessWord.length();
    }

    public Map<Integer, LetterState> guess(String attempt) {
        if (guessWord == null)
            throw new IllegalStateException("The word was not generated!");

        if (!validator.validate(attempt))
            throw new IllegalArgumentException("Invalid input!");

        if (attempt.length() != guessWord.length())
            throw new IllegalArgumentException("Invalid input length!");

        return guessChecker.check(attempt, guessWord);
    }

}
