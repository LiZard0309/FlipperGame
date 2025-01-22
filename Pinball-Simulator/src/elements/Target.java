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
    public int hit(int elementsSize){
        if(!lightOn) {
            lightOn = true;
            System.out.println("Inaktives Target getroffen, Licht geht an, 10 Punkte werden vergeben.");
            Score.getInstance().updateScore(10);
            mediator.notifyTargetHit(this);
        }else {
            System.out.println("Aktives Target nochmal getroffen, Licht bleibt an, keine Punkte zu vergeben.");
        }

        return triggerBallMovement(elementsSize);
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

    private int triggerBallMovement(int elementsSize) {
        int nextIndex = new Random().nextInt(elementsSize); // Random index from 0 to 6
        System.out.println("Nächster Hit: Ball bewegt sich zu Element " + nextIndex);
        return nextIndex;
    }
}
