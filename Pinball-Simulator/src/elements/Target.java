package elements;
import util.Score;
import java.util.Random;

public class Target extends FlipperElement{
    private boolean lightOn;
    private Mediator mediator;

    public Target(Mediator mediator) {
        this.lightOn = false;
        this.mediator = mediator;
    }

    @Override
    public int hit(){
        if(!lightOn) {
            lightOn = true;
            Score.getInstance().updateScore(10);
            mediator.notifyTargetHit(this);
        }else {
            System.out.println("Target hit again, light remains on.");
        }

        return triggerBallMovement();
    }

    @Override
    public void accept(ResetVisitor resetVisitor) {

    }

    public boolean isLightOn() {
        return lightOn;
    }

    public void reset() {
        this.lightOn = false; // Reset light to off
    }

    private int triggerBallMovement() {
        int nextIndex = new Random().nextInt(9); // Random index from 0 to 8
        System.out.println("Ball shot to next element! Element index no: " + nextIndex);
        return nextIndex;
        //TODO nextInt über Observer/ElementsList.size holen?
    }
}
