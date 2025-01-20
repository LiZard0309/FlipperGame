package elements;

public class BallDrain extends FlipperElement{
    @Override
    public int hit(int elementsSize){
        System.out.println("Ball Drain getroffen. Ball geht verloren und aktuelle Runde wird beendet.");
        return -1; //Platzhalter-Return
    }

    @Override
    public void accept(ResetVisitor resetVisitor) {
        resetVisitor.visit(this);
    }

}
