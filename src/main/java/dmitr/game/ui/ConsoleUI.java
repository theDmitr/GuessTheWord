package dmitr.game.ui;

import dmitr.game.core.GuessTheWordGame;
import dmitr.game.core.LetterState;

import java.util.Map;
import java.util.Scanner;

public class ConsoleUI {

    private final GuessTheWordGame game;

    public ConsoleUI(GuessTheWordGame game) {
        this.game = game;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print(">> ");
            String input = scanner.nextLine();

            switch (input) {
                case "/generate" -> {
                    game.generate();
                    System.out.printf("Word generated! Length: %d\n", game.getGuessWordLength());
                }
                case "/stop" -> running = false;
                default -> {
                    try {
                        Map<Integer, LetterState> guessResult = game.guess(input);
                        System.out.println(guessResult);
                    } catch (Exception e) {
                        System.out.printf("[ERROR] %s\n", e.getMessage());
                    }
                }
            }
        }
    }

}
