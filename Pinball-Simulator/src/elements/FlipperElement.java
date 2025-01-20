package elements;

public abstract class FlipperElement { //KÖNNTE DIE GESAMTHEIT ALLER FLIPPER-ELEMENTE EVTL. AUCH ALS KOMPOSITUM AUSGEFÜHRT WERDEN???
    public abstract int hit();
    public abstract void accept(ResetVisitor resetVisitor);
}
