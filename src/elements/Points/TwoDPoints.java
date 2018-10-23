package elements.Points;


import elements.ColorIndicator;
import elements.ListsOfCoefficients;

import java.awt.*;


public class TwoDPoints extends GraphicPoint {

    private double x;
    private double y;
    private double curveValue;
    private ColorIndicator color;
    private ListsOfCoefficients loc;
    private double resolutionSize =0.01;
    //private Canvas canvas;

    public TwoDPoints(ListsOfCoefficients loc, double x, double y ) {
        this.x = x;
        this.y = y;
        this.loc = loc;
        calculatePoint(x);
        //this.canvas = canvas;
    }


    public boolean pointOnTheGraph() {
        return ApproximateTreatment(y, curveValue);
    }

    @Override
    public Color getColor() {
        if (pointOnTheGraph()) {
            color = new ColorIndicator(0, 0, 0);
        } else {
            color = new ColorIndicator(255, 255, 255);
        }
        return color;
    }

    @Override
    protected boolean ApproximateTreatment(double t, double a) {
        return (t-a) <= resolutionSize || (a-t) <= resolutionSize;
    }

    private void calculatePoint(double x){
        curveValue = loc.getOne()*x*x+loc.getTwo()*x+loc.getThree();
    }

    public double getX(){
        return x;
    }
}
