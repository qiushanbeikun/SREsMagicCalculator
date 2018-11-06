package elements.Points;


import elements.Canvas.TwoDCanvas;
import elements.ColorIndicator;
import elements.ListsOfCoefficients;

import java.awt.*;


public abstract class GraphicPoint {

    private double x;
    private double y;
    public ColorIndicator color;
    private ListsOfCoefficients loc;
    private TwoDCanvas canvas;


    public GraphicPoint(ListsOfCoefficients loc, double x, double y, TwoDCanvas canvas){
        this.x = x;
        this.y = y;
        this.loc = loc;
        this.canvas = canvas;
    }

    protected abstract Color getColor();

    protected boolean pointOnCoordinate(){
        return (x == 0 || y == 0);
    }

}
