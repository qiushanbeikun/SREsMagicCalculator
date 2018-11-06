package elements.Canvas;

import Exceptions.CanvasFieldException;
import Exceptions.CanvasSizeException;
import elements.ListsOfCoefficients;
import elements.Points.GraphicPoint;

import java.util.HashMap;
import java.util.Map;

public abstract class Canvas {

    private double xLeftBound;
    private double xRightBound;
    private double yUpBound;
    private double yDownBound;
    private double resolutionSize;
    private Map<String,GraphicPoint> lop;

    private ListsOfCoefficients loc;

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

    public abstract void getPointsList();

    public void addPoint(String newKey, GraphicPoint newPoint){
        lop.put(newKey,newPoint);
    }

}
