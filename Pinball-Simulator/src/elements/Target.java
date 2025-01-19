package elements;
import score.Score;
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
            System.out.println("Inaktives Target getroffen, Licht geht an, 10 Punkte werden vergeben.");
            mediator.notifyTargetHit(this);
        }else {
            System.out.println("Aktives Target nochmal getroffen, Licht bleibt an, keine Punkte zu vergeben.");
        }

        return triggerBallMovement();
    }

    public boolean isLightOn() {
        return lightOn;
    }

    public void reset() {
        this.lightOn = false; // Reset light to off
    }

    private int triggerBallMovement() {
        int nextIndex = new Random().nextInt(6); // Random index from 0 to 6
        System.out.println("Ball bewegt sich zu Element: " + nextIndex);
        return nextIndex;
    }
}
