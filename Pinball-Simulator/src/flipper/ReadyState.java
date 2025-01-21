package flipper;

import util.Credit;
import util.Round;
import util.Score;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ReadyState extends State {
    private final Flipper flipper;


    public ReadyState(Flipper flipper) {
        this.flipper = flipper;
    }

    @Override
    public void insertCoin() {
        Credit.getInstance().setCredit(1);
        System.out.println("Münze eingeworfen! Aktueller Credit: " + Credit.getInstance().getCredit());

    }

    @Override
    public void pressStart() {
        Credit.getInstance().setCredit(-1);
        System.out.println("Spiel startet. Verbleibende Credits: " + (Credit.getInstance().getCredit()));
        flipper.setState(new PlayingState(flipper));
        startGameplay();
    }

    public void startGameplay() {
        Scanner scanner = new Scanner(System.in);

        //Start of 3 rounds
        for (int i = 0; i < 3; i++) {
            System.out.printf("Bitte geben Sie zum Starten eine Zahl zwischen 0 und %d ein. \n", flipper.elements.size() - 1);

            int currentIndex = -1;
            boolean validInput = false;


            while (!validInput) {
                if (scanner.hasNextInt()) {
                    currentIndex = scanner.nextInt();
                    // Validate initial input
                    if (currentIndex >= 0 && currentIndex < flipper.elements.size()) {
                        validInput = true;
                    } else {
                        System.out.printf("Ungültige Eingabe. Bitte geben Sie zum Starten eine Zahl zwischen 0 und %d ein. \n", flipper.elements.size() - 1);
                    }
                } else {
                    System.out.println("Ungültige Eingabe. Bitte geben Sie eine Zahl ein.");
                    scanner.next();
                }
            }


            System.out.println("Aktuelle Runde: " + Round.getInstance().getRound());


            // Game loop starts after initial input
            while (true) {
                // Trigger hit() on the current element
                int nextIndex = flipper.elements.getElement(currentIndex).hit(flipper.elements.size());

                // Check for end condition (e.g., BallDrain)
                if (nextIndex == -1) { // -1 indicates the ball drain was hit
                    System.out.println("Runde " + Round.getInstance().getRound() + " beendet. Aktueller Score: " + Score.getInstance().getScore() + ".");
                    Round.getInstance().updateRound();
                    break;
                }

                // Move to the next element
                //System.out.println("Ball bewegt sich zu Element " + nextIndex + "...");
                currentIndex = nextIndex;
            }
        }

        //after three rounds are played state changes again and Score and Rounds reset

        if (Credit.getInstance().getCredit() > 0) {
            //System.out.println("Flipper wechselt in den ReadyState");
            flipper.setState(new ReadyState(flipper));
        } else {
            //System.out.println("Flipper wechselt in den NoCreditState");
            flipper.setState(new NoCreditState(flipper));
        }
        Score.getInstance().resetScore();
        Round.getInstance().resetRound();
        flipper.resetGame();
    }

}
