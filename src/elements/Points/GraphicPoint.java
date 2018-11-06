package elements.Points;


import elements.Canvas.TwoDCanvas;
import elements.ColorIndicator;
import elements.TwoDEquation;

import java.awt.*;


public abstract class GraphicPoint {

    private double x;
    private double y;
    public ColorIndicator color;
    private TwoDEquation loc;
    private TwoDCanvas canvas;


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





    public String getCor(){
        return "("+x+","+y+")";
    }

}
