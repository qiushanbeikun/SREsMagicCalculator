package elements.Points;

import elements.Canvas.ThreeDCanvas;
import equation.ThreeDEquation;

import java.awt.*;


public class ThreeDPoints extends GraphicPoint {

    private double x;
    private double y;
    private double z;

    private double max;
    private double min;
    private double range;

    private Color color;
    private ThreeDEquation loc;
    private ThreeDCanvas canvas;



    public ThreeDPoints(ThreeDEquation loc, double x, double y, ThreeDCanvas canvas){
        this.loc = loc;
        this.x = x;
        this.y = y;
        this.canvas = canvas;
        calculatePoint(x, y);
        getMaxMinAndRange();
        getColor();
    }

    @Override
    public void getColor() {
        if (x==0 || y == 0) {
            color = new Color(0, 0, 0);
        /*} else {
            color = new Color(255, getColorPara(z), 0);
        }*/
        } else if (z <= min+range/6){
            color = new Color(255,getColorPara(z,min) , 0);
        } else if (z>min+range/6 && z<= min+range/3){
            color = new Color(255-getColorPara(z, min+range/6),255, 0);
        } else if (z>min+range/3 && z<=min+range/2){
            color = new Color(0, 255, getColorPara(z, min+range/3));
        } else if (z>min+range/2 && z<= min+2*range/3){
            color = new Color(0, 255-getColorPara(z, min+range/2), 255);
        } else if (z>min+2*range/3 && z<= min+5*range/6){
            color = new Color(getColorPara(z, min+2*range/3), 0, 255);
        }else {
            color = new Color(255, 0, 255-getColorPara(z, min+5*range/6));
        }



    }

    @Override
    public String getCor() {
        return "("+x+","+y+","+z+")";
    }

    private int getColorPara(double z, double lowerLimit){
        return (int) Math.floor(255*(z-lowerLimit)/(range/6));
        //return (int) Math.floor(Math.random()*255);
    }

    private void calculatePoint(double x, double y) {
        z = loc.getOne()*x+loc.getTwo()*y+loc.getThree();
    }

    private double returnPointValue(double x, double y) {
        return loc.getOne()*x+loc.getTwo()*y+loc.getThree();
    }

    public int getX(){
        return (int) Math.floor(this.x/canvas.resolutionSize+250);
    }

    public int getY(){
        return (int) Math.floor(-this.y/canvas.resolutionSize+250) ;
    }

    public double getMax(){
        return max;
    }

    public double getMin(){
        return min;
    }

    public double getZ(){
        return z;
    }


    public void getMaxMinAndRange() {

        double pointOne = returnPointValue(canvas.getXLeftBound(), canvas.getYDownBound());
        double pointTwo = returnPointValue(canvas.getXLeftBound(),canvas.getYUpBound());
        double pointThree = returnPointValue(canvas.getXRightBound(),canvas.getYDownBound());
        double pointFour = returnPointValue(canvas.getXRightBound(),canvas.getYUpBound());

        max = Math.max(pointOne, Math.max(pointTwo, Math.max(pointThree, pointFour)));
        min = Math.min(pointOne, Math.min(pointTwo, Math.min(pointThree, pointFour)));
        range = max-min;
    }

    public boolean pointOnCoordinate(){
        return (x == 0 || y == 0);
    }

    public Color getterColor(){
        return this.color;
    }
}
