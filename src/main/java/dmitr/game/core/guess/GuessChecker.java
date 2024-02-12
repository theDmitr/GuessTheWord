package dmitr.game.core.guess;

import dmitr.game.core.LetterState;

import java.util.Map;

public interface GuessChecker {

    Map<Integer, LetterState> check(String attempt, String guessable);

}
