package dmitr.game.core.guess;

import dmitr.game.core.LetterState;

import java.util.HashMap;
import java.util.Map;

public class DefaultGuessChecker implements GuessChecker {

    @Override
    public Map<Integer, LetterState> check(String attempt, String guessable) {
        Map<Integer, LetterState> letterStates = new HashMap<>();

        for (int i = 0; i < attempt.length(); i++) {
            char c = attempt.charAt(i);
            LetterState state;

            if (c == guessable.charAt(i))
                state = LetterState.EXACTLY;
            else if (guessable.indexOf(c) != -1)
                state = LetterState.THERE_ARE_SUCH;
            else
                state = LetterState.NO_SUCH;

            letterStates.put(i, state);
        }

        return letterStates;
    }

}
