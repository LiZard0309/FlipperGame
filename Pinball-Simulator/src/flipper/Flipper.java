package flipper;

import elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Flipper {
    private State state;
    List<FlipperElement> elements = new ArrayList<>(); //Ich geb die mal hier in die Main, aber ich glaube das wäre wahrscheinlich besser eine Property von der Klasse Flipper?
    TargetGroupMediator mediator = new TargetGroupMediator(elements);
    ResetVisitor resetVisitor = new ResetVisitor();

    public Flipper() {
        state = new NoCreditState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void instantiateFlipperElements() {
        //Instantiating the FlipperElements (Components?)
        BallDrain balldrain = new BallDrain();
        Target target1 = new Target(mediator);
        Target target2 = new Target(mediator);
        Target target3 = new Target(mediator);
        Ramp ramp1 = new Ramp();
        Ramp ramp2 = new Ramp();
        Bumper bumper1 = new Bumper();
        Bumper bumper2 = new Bumper();
        Bumper bumper3 = new Bumper();
        Hole hole = new Hole();

        //Adding all the elements to the ArrayList of FlipperElements
        elements.add(balldrain); //index=0
        elements.add(target1); //index=1
        elements.add(target2); //index=2
        elements.add(target3); //index=3
        elements.add(ramp1); //index=4
        elements.add(ramp2);//index=5
        elements.add(bumper1); //index=6
        elements.add(bumper2); //index=7
        elements.add(bumper3); //index=8
        elements.add(hole);
    }

    public int getTotalAmountOfElements() {
        return elements.size();
    }

    public void resetGame(){
        elements.forEach(element -> element.accept(resetVisitor));
    }


    public void testGame() {
        //nur für uns zum Testen, können wir dann wieder rauslöschen

        int randomNumber = new Random().nextInt(6);
        System.out.println("Random number is " + randomNumber);
    }

    public void playGameOne() {
        //TODO: ganz am Ende: tatsächlichen Spielablauf implementieren (mit drei Runden und Anfang (Credit-Einwurf etc.)
    }

    public void playGameTwo() {
        //TODO: ganz am Ende: tatsächlichen Spielablauf implementieren
    }
}
