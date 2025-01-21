package elements;

public abstract class FlipperElement {
    public abstract int hit(int elementsSize);
    public abstract void accept(ResetVisitor resetVisitor);
}
