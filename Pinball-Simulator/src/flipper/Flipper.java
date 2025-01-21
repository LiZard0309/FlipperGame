package flipper;

import elements.*;

import java.util.Scanner;

public class Flipper {
    private State state;
    ElementsList elements = new ElementsList();
    TargetGroupMediator mediator = new TargetGroupMediator();
    ResetVisitor resetVisitor = new ResetVisitor();

    public Flipper() {
        state = new NoCreditState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void instantiateFlipperElements() {

        elements.addObserver(mediator);

        // Create and add elements to the list
        elements.addElement(new BallDrain()); //index 0
        elements.addElement(new Target(mediator)); //index 1
        elements.addElement(new Target(mediator)); //index 2
        elements.addElement(new Target(mediator)); //index 3
        elements.addElement(new Ramp()); //index 4
        elements.addElement(new Ramp()); //index 5
        elements.addElement(new Bumper()); //index=6
        elements.addElement(new Bumper()); //index=7
        elements.addElement(new Bumper()); //index=8
        elements.addElement(new Hole()); //index=9
    }


    public void resetGame() {
        elements.getElements().forEach(element -> element.accept(resetVisitor));
    }


    public void testGame() {
        //tests the states of the flipper game
        state.pressStart();
        state.insertCoin();
        state.insertCoin();
        state.pressStart();
        state.pressStart();
        state.insertCoin();
    }

    public void playGame() {
        //the actual gameplay with user interaction in the beginning
        Scanner scanner = new Scanner(System.in);

        System.out.println("Herzlich Willkommen zu Flipper, einem interaktiven Spiel entworfen von Maria Feher-Lehrner und Lisa Hofbauer!");
        System.out.println("Um zu spielen, müssen Sie eine Münze einwerfen. Was möchten Sie tun?");


        for (int i = 0; i < 20; i++) {

            System.out.println("Drücken Sie '1' um ein Spiel zu starten, drücken Sie '2' um eine Münze einzuwerfen.");

            if (scanner.hasNextInt()) {
                int userChoice = scanner.nextInt();

                if (userChoice == 1) {
                    state.pressStart();
                } else if (userChoice == 2) {
                    state.insertCoin();

                } else {
                    System.out.println("Ungültige Eingabe! Bitte geben Sie 1 oder 2 ein.");
                }
            } else {
                System.out.println("Ungültige Eingabe! Bitte geben Sie eine Zahl ein.");
                scanner.next();
            }

        }
        scanner.close();
    }

}