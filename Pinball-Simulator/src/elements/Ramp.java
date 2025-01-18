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
            nextIndex = 0; //TODO: sicherstellen, dass hier Index vom BallDrain steht
        } else {
            nextIndex = 3; //TODO: sicherstellen, dass hier Index vom gewünschten Ziel steht.
        }

        return nextIndex;
    }

    public void setRamp() {
        if(isUp){
            isUp = false;
        }else{
            isUp = true;
        }
    }
}
