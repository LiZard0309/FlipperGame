package elements;

import flipper.Flipper;
import util.Score;

import java.util.Random;

public class Bumper extends FlipperElement {

    private boolean lightOn;
    Flipper flipper;

    public Bumper() {
        this.lightOn = false;
    }

    @Override
    public int hit(int elementsSize) {
       if (!lightOn) {
           lightOn = true;
           System.out.println("Inaktiven Bumper getroffen. Licht geht an, 5 Punkte werden vergeben.");
           Score.getInstance().updateScore(5);
       } else {
           lightOn = false;
           System.out.println("Aktiven Bumper getroffen. Licht geht aus. 10 Punkte werden vergeben.");
           Score.getInstance().updateScore(10);
       }
       return triggerBallMovement(elementsSize);
    }

    @Override
    public void accept(ResetVisitor resetVisitor) {
        resetVisitor.visit(this);
    }

    public void reset() {
        lightOn = false;
    }

    private int triggerBallMovement(int elementsSize) {
        int nextIndex = new Random().nextInt(elementsSize);
        System.out.println("Triggering Ball Movement " + nextIndex);
        return nextIndex;
        //TODO hier bei nextInt schauen, dass hier der Wert dann auch mit dem Observer zusammenspielt
    }
}
