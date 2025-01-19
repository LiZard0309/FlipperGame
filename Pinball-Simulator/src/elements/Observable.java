package elements;

public interface Observable {
    void addObserver(Observer observer);
    void notifyObservers(FlipperElement element);
}
