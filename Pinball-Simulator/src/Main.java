import elements.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

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




    }
}
