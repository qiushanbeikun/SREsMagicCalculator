package elements.Points;


import elements.Canvas.Canvas;
import elements.ColorIndicator;
import elements.ListsOfCoefficients;

import java.awt.*;
import java.util.Objects;


public class TwoDPoints extends GraphicPoint {

    private double x;
    private double y;
    public ColorIndicator color;
    private ListsOfCoefficients loc;
    private elements.Canvas.Canvas canvas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoDPoints that = (TwoDPoints) o;
        return Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0 &&
                Objects.equals(loc, that.loc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, loc);
    }



    public TwoDPoints(ListsOfCoefficients loc, double x, double y, Canvas canvas) {
        this.x = x;
        this.y = y;
        this.loc = loc;
        this.canvas = canvas;
    }


    private boolean pointOnTheGraph() {
        return ApproximateTreatment(y, calculatePoint(x));
    }

    private boolean pointOnCoordinate(){
        return (x == 0 || y == 0);
    }


    @Override
    public Color getColor() {
        if (pointOnCoordinate() || pointOnTheGraph()) {
            color = new ColorIndicator(0, 0, 0);
        } else {
            color = new ColorIndicator(255, 255, 255);
        }
        return color;
    }

    @Override
    protected boolean ApproximateTreatment(double t, double a) {
        return (t-a) <= canvas.resolutionSize || (a-t) <= canvas.resolutionSize;
    }

    private double calculatePoint(double x){
        return loc.getOne()*x*x+loc.getTwo()*x+loc.getThree();
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }
}
