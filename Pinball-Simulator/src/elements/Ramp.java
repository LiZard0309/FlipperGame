package elements;

public class Ramp extends FlipperElement {
    private boolean isUp;

    public Ramp() {
        this.isUp = false;
    }

    @Override
    public int hit(int elementsSize) {
        return triggerBallMovement();
    }

    @Override
    public void accept(ResetVisitor resetVisitor) {
        resetVisitor.visit(this);
    }

    private int triggerBallMovement() {
        int nextIndex;
        if (isUp) {
            System.out.println("Rampe ist zu. Nächster Hit: Ball fällt in Ball Drain.");
            nextIndex = 0;
        } else {
            System.out.println("Rampe ist offen. Nächster Hit: Ball wird zu Target #3 geleitet.");
            nextIndex = 3;
        }

        return nextIndex;
    }

    public void reset(){
        isUp = false;
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
