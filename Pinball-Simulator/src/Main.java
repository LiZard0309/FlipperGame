import elements.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<FlipperElement> elements = new ArrayList<>(); //Ich geb die mal hier in die Main, aber ich glaube das wäre wahrscheinlich besser eine Property von der Klasse Flipper?
        TargetGroupMediator mediator = new TargetGroupMediator(elements);

        //Instantiating the FlipperElements (Components?)
        BallDrain balldrain = new BallDrain();
        Target target1 = new Target(mediator);
        Target target2 = new Target(mediator);
        Target target3 = new Target(mediator);
        Ramp ramp1 = new Ramp();
        Ramp ramp2 = new Ramp();

        //Adding all the elements to the ArrayList of FlipperElements
        elements.add(balldrain); //index=0
        elements.add(target1); //index=1
        elements.add(target2); //index=2
        elements.add(target3); //index=3
        elements.add(ramp1); //index=4
        elements.add(ramp2); //index=5

        //Start Game Play
        System.out.println("Bitte geben Sie zum Starten eine Zahl zwischen 0 und 5 ein.");
        int currentIndex = scanner.nextInt();

        // Validate initial input
        if (currentIndex < 0 || currentIndex >= elements.size()) {
            System.out.println("Ungültige Eingabe. Spiel beendet.");
        } else {
            // Game loop starts after initial input
            while (true) {
                // Trigger hit() on the current element
                int nextIndex = elements.get(currentIndex).hit();

                // Check for end condition (e.g., BallDrain)
                if (nextIndex == -1) { // -1 indicates the ball drain was hit
                    System.out.println("Spiel beendet. Danke fürs Spielen!");
                    break;
                }

                // Move to the next element
                System.out.println("Ball bewegt sich zu Element " + nextIndex + "...");
                currentIndex = nextIndex;
            }
        }

        scanner.close();
    }
}
