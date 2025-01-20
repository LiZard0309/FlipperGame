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
            System.out.println("Inaktives Target getroffen, Licht geht an, 10 Punkte werden vergeben.");
            Score.getInstance().updateScore(10);
            mediator.notifyTargetHit(this);
        }else {
            System.out.println("Aktives Target nochmal getroffen, Licht bleibt an, keine Punkte zu vergeben.");
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
        int nextIndex = new Random().nextInt(6); // Random index from 0 to 6
        //TODO? Hier gibt es ein bisschen einen Flaw in der Logik, weil das Element theoretisch auch sich selbst als nächstes Element auswählen kann... Aber ich würde das jetzt so lassen.
        System.out.println("Nächster Hit: Ball bewegt sich zu Element " + nextIndex);
        return nextIndex;
        //TODO nextInt über Observer/ElementsList.size holen?
    }
}
