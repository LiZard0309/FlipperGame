package elements;

import score.Score;

import java.util.Random;

public class Ramp extends FlipperElement {
    private boolean isUp;

    public Ramp() {
        this.isUp = false;
    }

    @Override
    public int hit() {
        return triggerBallMovement();
    }

    private int triggerBallMovement() {
        int nextIndex;
        if (isUp) {
            System.out.println("Rampe ist zu. Nächster Hit: Ball fällt in Ball Drain.");
            nextIndex = 0; //TODO: sicherstellen, dass hier Index vom BallDrain steht
        } else {
            System.out.println("Rampe ist offen. Nächster Hit: Ball wird zu Target #3 geleitet.");
            nextIndex = 3; //TODO: sicherstellen, dass hier Index vom gewünschten Ziel steht.
        }

        return nextIndex;
    }

    public void setRamp() {
        if(isUp){
            isUp = false;
            System.out.println("Rampe geht auf.");
        }else{
            isUp = true;
            System.out.println("Rampe geht zu.");
        }
    }
}
