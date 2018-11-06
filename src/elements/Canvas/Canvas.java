package elements.Canvas;

import Exceptions.CanvasFieldException;
import Exceptions.CanvasSizeException;
import elements.ListsOfCoefficients;
import elements.Points.GraphicPoint;
import elements.Points.TwoDPoints;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Canvas {

    private double xLeftBound;
    private double xRightBound;
    private double yUpBound;
    private double yDownBound;
    public double resolutionSize;
    private Map<String,TwoDPoints> lop;

    private ListsOfCoefficients loc;

    // assume the canvas is square
    public Canvas(double xlb, double xrb, double yub, double ydb, ListsOfCoefficients loc){
        this.xLeftBound = xlb;
        this.xRightBound = xrb;
        this.yUpBound = yub;
        this.yDownBound = ydb;
        resolutionSize = (xlb+xrb+ydb+yub)/2000;
        this.loc = loc;
        lop = new HashMap<>();

    }

    public void checkCanvas() throws CanvasFieldException, CanvasSizeException {
        if (xLeftBound>xRightBound || yUpBound>yDownBound){
            throw new CanvasFieldException("Your canvas's field is not correct.");
        }
        if (Math.abs(xRightBound-xLeftBound) != Math.abs(yUpBound-yDownBound)){
            throw new CanvasSizeException("Your canvas is not square.");
        }
    }

    public Map getPointsList(){
        for (int y = 0; y <1000 ; y++) {
            for (int x = 0; x <1000 ; x++) {
                TwoDPoints tdp = new TwoDPoints(loc, x*resolutionSize,resolutionSize*y,this);
                addPoint("x"+String.valueOf(y),tdp);
            }
        }
        return lop;
    }


    public Map<String, TwoDPoints> getLop(){
        return lop;
    }


    public void addPoint(String newKey, TwoDPoints newPoint){
        if (!lop.containsKey(newKey)){
            lop.put(newKey,newPoint);
            newPoint.canvas = this;
        }
    }

    // this method is reserved for future designs
    /*public void drawGraph(List<GraphicPoint> lop){

    }*/


}
