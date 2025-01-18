import elements.FlipperElement;
import elements.Target;
import elements.TargetGroupMediator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<FlipperElement> elements = new ArrayList<>(); //Ich geb die mal hier in die Main, aber ich glaube das wäre wahrscheinlich besser eine Property von der Klasse Flipper?

        //Auch den Teil geb ich hier vorerst in die Main - die Funktionalität wird aber wahrscheinlich später an anderer Stelle und über .random-Integers aufgerufen
        // VORLÄUFIGES MANUELLES INSTANZIEREN UND AUFRUFEN VON TARGETS
        List<Target> targets = new ArrayList<>();
        TargetGroupMediator mediator = new TargetGroupMediator(targets);

        // Instantiate targets and associate them with the mediator
        for (int i = 0; i < 3; i++) {
            targets.add(new Target(mediator));
        }

        // Simulate hitting the targets
        System.out.println("Hitting target 1...");
        targets.get(0).hit();

        System.out.println("Hitting target 2...");
        targets.get(1).hit();

        System.out.println("Hitting target 3...");
        targets.get(2).hit(); // This triggers group behavior

        System.out.println("Hitting target 1 again...");
        targets.get(0).hit(); // No additional group behavior

    }
}
