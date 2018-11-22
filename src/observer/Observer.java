package observer;

import elements.Points.GraphicPoint;

public abstract class Observer {
    public void updateNewDot(GraphicPoint gp) {
        System.out.println("a new point () has been added to the canvas");
    }

}
