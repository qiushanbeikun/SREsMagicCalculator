package elements.Canvas;

import elements.TwoDEquation;
import elements.Points.GraphicPoint;
import elements.Points.TwoDPoints;

import java.io.IOException;


public class TwoDCanvas extends Canvas {


    public double resolutionSize;

    // REQUIRES: assume the canvas is square
    public TwoDCanvas(double xlb, double xrb, double yub, double ydb, TwoDEquation loc) throws IOException {
        super(xlb, xrb, yub, ydb, loc);
        this.resolutionSize = Canvas.resolutionSize;
    }

    @Override
    public void getPointsList() {
        //reduce size to 100 for convenience
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                GraphicPoint tdp = new TwoDPoints(loc, x * resolutionSize, resolutionSize * y, this);
                addPoint(String.valueOf(x) + String.valueOf(y), tdp);
                notifyObservers(tdp);
            }
        }
    }

}