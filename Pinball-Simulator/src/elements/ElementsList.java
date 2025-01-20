package elements;

import java.util.ArrayList;
import java.util.List;

public class ElementsList implements Observable{
    private final List<FlipperElement> elements = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers(FlipperElement element) {
        for (Observer observer : observers) {
            observer.update(element);
        }
    }

    public void addElement(FlipperElement element) {
        elements.add(element);
        notifyObservers(element); // Notify observers when a new element is added
    }

    public FlipperElement getElement(int index) {
        return elements.get(index);
    }

    public List<FlipperElement> getElements(){
        return elements;
    }

    public int size() {
        return elements.size();
    }
}
