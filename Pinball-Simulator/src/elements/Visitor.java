package elements;

public interface Visitor {
    void visit (BallDrain ballDrain);
    void visit (Bumper bumper);
    void visit (Hole hole);
    void visit (Ramp ramp);
    void visit (Target target);
}
