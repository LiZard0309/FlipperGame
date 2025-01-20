package flipper;

import elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public int getTotalAmountOfElements() {
        return elements.size();
    }

    public void resetGame(){
        elements.getElements().forEach(element -> element.accept(resetVisitor));
    }


    public void testGame() {
        //nur für uns zum Testen, können wir dann wieder rauslöschen

        int randomNumber = new Random().nextInt(6);
        System.out.println("Random number is " + randomNumber);
    }

    public void playGame() {
        //TODO: ganz am Ende: tatsächlichen Spielablauf implementieren (mit drei Runden und Anfang (Credit-Einwurf etc.)
        state.pressStart();
    }

    public void playGameTwo() {
        //TODO: ganz am Ende: tatsächlichen Spielablauf implementieren
    }
}