package elements;

import flipper.Flipper;
import util.Score;

import java.util.Random;
import java.util.Scanner;

public class Hole extends FlipperElement {

    Flipper flipper;

    public Hole() {

    }

    private int generateRandomNumber() {
        return new Random().nextInt(5) + 1;
        //for generating a random number between 1 and 5
    }

    private int getUserInput() {

        Scanner scanner = new Scanner(System.in);
        int userInput = 0;

        //Loop until valid input is entered
        while (true) {
            System.out.println("Bitte geben Sie eine Nummer von 1 bis 5 ein: ");
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                if (userInput <=5 && userInput >=1) {
                    break;
                } else {
                    System.out.println("Die Nummer muss zwischen 1 und 5 liegen.");
                }
            } else {
                System.out.println("Bitte geben Sie eine gültige Nummer ein.");
                scanner.next();
            }
        }

        return userInput;
    }

    @Override
    public int hit() {
        int userInput = getUserInput();
        int randomInt = generateRandomNumber();
        if (userInput == randomInt) {
            System.out.printf(
                    "Eingegebene Nummer: %d. Generierte Nummer: %d. Die Nummern stimmen überein! Sie erhalten 50 Punkte!",
                    userInput,
                    randomInt
            );
            Score.getInstance().updateScore(50);
        } else {
            System.out.printf(
                    "Eingegebene Nummer: %d. Generierte Nummer: %d. Die Nummern stimmen leider nicht überein. Sie erhalten 10 Punkte!",
                    userInput,
                    randomInt
            );
            Score.getInstance().updateScore(10);
        }
        return triggerBallMovement();
    }

    @Override
    public void accept(ResetVisitor resetVisitor) {

    }

    private int triggerBallMovement() {
        int nextIndex = new Random().nextInt(flipper.getTotalAmountOfElements());
        System.out.println("Triggering Ball Movement " + nextIndex);
        return nextIndex;
    }
}
