package elements.Points;


import elements.Canvas.TwoDCanvas;
import elements.ColorIndicator;
import elements.TwoDEquation;
import observer.Observer;
import observer.Subject;

import java.awt.*;


public abstract class GraphicPoint extends Observer{

    protected double x;
    protected double y;
    public ColorIndicator color;
    protected TwoDEquation loc;
    TwoDCanvas canvas;


    public GraphicPoint(TwoDEquation loc, double x, double y, TwoDCanvas canvas){
        this.x = x;
        this.y = y;
        this.loc = loc;
        this.canvas = canvas;

    }

    public abstract Color getColor();

    protected boolean pointOnCoordinate(){
        return (x == 0 || y == 0);
    }

    public abstract String getCor();

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }


}
