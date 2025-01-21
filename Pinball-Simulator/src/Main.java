import elements.*;
import flipper.Flipper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Flipper flipper = new Flipper();
        flipper.instantiateFlipperElements();
        flipper.playGame();

       //flipper.testGame();






        // Observable list of elements
        ElementsList elements = new ElementsList();
        //Mediator - registered as an observer
        /*TargetGroupMediator mediator = new TargetGroupMediator();
        elements.addObserver(mediator);

        // Create and add elements to the list
        elements.addElement(new BallDrain()); //index 0
        elements.addElement(new Target(mediator)); //index 1
        elements.addElement(new Target(mediator)); //index 2
        elements.addElement(new Target(mediator)); //index 3
        elements.addElement(new Ramp()); //index 4
        elements.addElement(new Ramp()); //index 5*/


    }
}
