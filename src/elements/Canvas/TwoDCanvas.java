package elements.Canvas;

import Exceptions.CanvasFieldException;
import Exceptions.CanvasSizeException;
import elements.ListsOfCoefficients;
import elements.Points.GraphicPoint;
import elements.Points.TwoDPoints;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TwoDCanvas extends Canvas{

    public double resolutionSize;

    private ListsOfCoefficients loc;

    // REQUIRES: assume the canvas is square
    public TwoDCanvas(double xlb, double xrb, double yub, double ydb, ListsOfCoefficients loc){
        super(xlb, xrb, yub, ydb, loc);
    }

    @Override
    public void getPointsList(){
        for (int y = 0; y <1000 ; y++) {
            for (int x = 0; x <1000 ; x++) {
                GraphicPoint tdp = new TwoDPoints(loc, x*resolutionSize,resolutionSize*y,this);
                addPoint("x"+String.valueOf(y),tdp);
            }
        }
    }




}
