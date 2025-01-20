package elements;

public class ResetVisitor implements Visitor {
    public void visit (Ramp ramp) {
        ramp.reset();
        System.out.println("Rampe zurückgesetzt.");
    }

    @Override
    public void visit(BallDrain ballDrain) {
        System.out.println("BallDrain zurückgesetzt.");
    }

    public void visit (Bumper bumper) {
        bumper.reset();
        System.out.println("Bumper zurückgesetzt.");
    }

    @Override
    public void visit(Hole hole) {
        System.out.println("Hole zurückgesetzt.");
    }

    public void visit (Target target) {
        target.reset();
        System.out.println("Target zurückgesetzt.");
    }

}
