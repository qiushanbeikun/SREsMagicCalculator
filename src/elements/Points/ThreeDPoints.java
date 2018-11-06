package elements.Points;

import elements.Canvas.ThreeDCanvas;
import elements.Canvas.TwoDCanvas;
import elements.ColorIndicator;
import elements.ListsOfCoefficients;

import java.awt.*;
import java.util.Objects;


public class ThreeDPoints extends GraphicPoint {

    private double x;
    private double y;
    private double z;

    private double max;
    private double min;
    private double range;

    public ColorIndicator color;
    private ListsOfCoefficients loc;
    //canvas will be needed to determine the min max and range
    public ThreeDCanvas canvas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreeDPoints that = (ThreeDPoints) o;
        return Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0 &&
                Double.compare(that.z, z) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, z);
    }

    public ThreeDPoints(ListsOfCoefficients loc, double x, double y, TwoDCanvas canvas){
        super(loc, x, y, canvas);
        //choose default settings for the min max and range
        max=10;
        min=0;
        range=10;

        calculatePoint(x, y);
    }

    @Override
    protected Color getColor() {
        if (z <= min+range/6){
            color = new ColorIndicator(255, getColorPara(z), 0);
        } else if (z>min+range/6 && z<= min+range/3){
            color = new ColorIndicator(255-getColorPara(z),255, 0);
        } else if (z>min+range/3 && z<=min+range/2){
            color = new ColorIndicator(0, 255, getColorPara(z));
        } else if (z>min+range/2 && z<= min+2*range/3){
            color = new ColorIndicator(0, 255-getColorPara(z), 255);
        } else if (z>min-2*range/3 && z<= min+5*range/6){
            color = new ColorIndicator(getColorPara(z), 0, 255);
        }else {
            color = new ColorIndicator(255, 0, 2555-getColorPara(z));
        }
        return color;
    }

    private int getColorPara(double z){
        return (int) Math.floor((z-min)/range*255);
    }

    private void calculatePoint(double x, double y) {
        // default setting, take value randomly from 0 to 10
        z = Math.random()*9+1;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getZ(){
        return z;
    }
}
