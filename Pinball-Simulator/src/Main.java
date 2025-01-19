import elements.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Observable list of elements
        ElementsList elements = new ElementsList();
        //Mediator - registered as an observer
        TargetGroupMediator mediator = new TargetGroupMediator();
        elements.addObserver(mediator);

        // Create and add elements to the list
        elements.addElement(new BallDrain()); //index 0
        elements.addElement(new Target(mediator)); //index 1
        elements.addElement(new Target(mediator)); //index 2
        elements.addElement(new Target(mediator)); //index 3
        elements.addElement(new Ramp()); //index 4
        elements.addElement(new Ramp()); //index 5

        System.out.println("elements.size: " + elements.size());

        //Start Game Play
        System.out.printf("Bitte geben Sie zum Starten eine Zahl zwischen 0 und %d ein. \n", elements.size()-1);
        int currentIndex = scanner.nextInt();

        // Validate initial input
        if (currentIndex < 0 || currentIndex >= elements.size()) {
            System.out.println("Ungültige Eingabe. Spiel beendet.");
        } else {
            // Game loop starts after initial input
            while (true) {
                // Trigger hit() on the current element
                int nextIndex = elements.getElement(currentIndex).hit();

                // Check for end condition (e.g., BallDrain)
                if (nextIndex == -1) { // -1 indicates the ball drain was hit
                    System.out.println("Spiel beendet. Danke fürs Spielen!");
                    break;
                }

                // Move to the next element
                //System.out.println("Ball bewegt sich zu Element " + nextIndex + "...");
                currentIndex = nextIndex;
            }
        }

        scanner.close();
    }
}
