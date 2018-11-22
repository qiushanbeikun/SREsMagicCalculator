package elements.Points;


import elements.Canvas.TwoDCanvas;
import equation.TwoDEquation;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class TwoDPoints extends GraphicPoint {


    private double x;
    private double y;
    private Color color;
    private TwoDEquation loc;
    private TwoDCanvas canvas;


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

    public TwoDPoints(TwoDEquation loc, double x, double y, TwoDCanvas canvas) {
        this.loc = loc;
        this.x = x;
        this.y =y;
        this.canvas = canvas;
        color = new Color(0,0,0);
    }

    private boolean pointOnTheGraph() {
        return ApproximateTreatment(y, calculatePoint(x));
    }




    public Color getterColor(){
        return this.color;
    }

    private boolean ApproximateTreatment(double t, double a) {
        return (t-a) < canvas.resolutionSize || (a-t) < canvas.resolutionSize;
    }

    private double calculatePoint(double x){
        return loc.getOne()*x*x+loc.getTwo()*x+loc.getThree();
    }

    @Override
    public String getCor(){
        return "("+x+","+y+")";
    }

    public int getX(){
        return (int) Math.floor(this.x/canvas.resolutionSize+250);
    }

    public int getY(){
        return (int) Math.floor(-this.y/canvas.resolutionSize+250) ;
    }

    public boolean pointOnCoordinate(){
        return (x == 0 || y == 0);
    }

    /*public Graphics drawPoint(){
        Dot dot = new Dot();


    }*/

    private class Dot extends JPanel{

    }
}
