package elements;
import score.Score;

public class Target extends FlipperElement{
    private boolean lightOn;
    private Mediator mediator;

    public Target(Mediator mediator) {
        this.lightOn = false;
        this.mediator = mediator;
    }

    @Override
    public void hit(){
        if(!lightOn) {
            lightOn = true;
            Score.getInstance().updateScore(10);
            mediator.notifyTargetHit(this);
        }
        triggerBallMovement();
    }

    public boolean isLightOn() {
        return lightOn;
    }

    public void reset() {
        this.lightOn = false; // Reset light to off
    }

    private void triggerBallMovement() {
        System.out.println("Ball shot to next element!");
        // TODO: .random Funktion für Ball implementieren
    }
}
