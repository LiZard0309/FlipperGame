package elements;

public class BallDrain extends FlipperElement{
    @Override
    public int hit(){
        return -1; //Platzhalter-Return
    }

    @Override
    public void accept(ResetVisitor resetVisitor) {
        resetVisitor.visit(this);
    }

}
