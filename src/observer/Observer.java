package observer;

import elements.Points.GraphicPoint;

public abstract class Observer {
    public void update(GraphicPoint gp) {
        System.out.println("a new point ("+ gp.getX()+","+gp.getY()+") has been added to the canvas");
    }
}
