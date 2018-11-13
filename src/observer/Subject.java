package observer;

import elements.Coefficient;
import elements.Points.GraphicPoint;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        if (!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void notifyObservers(GraphicPoint gp){
        for (Observer obs: observers) {
            obs.update(gp);
        }

    }
}
