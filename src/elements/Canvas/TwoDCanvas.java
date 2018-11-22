package elements.Canvas;

import elements.Points.TwoDPoints;
import equation.TwoDEquation;
import ui.GraphicTool;

import java.awt.*;
import java.util.ArrayList;


public class TwoDCanvas extends Canvas {
    private double xLeftBound;
    private double xRightBound;
    private double yUpBound;
    private double yDownBound;
    public double resolutionSize;
    private ArrayList<TwoDPoints> lop = new ArrayList<>();

    public TwoDEquation loc;


    // REQUIRES: assume the canvas is square
    public TwoDCanvas(double xlb, double xrb, double yub, double ydb, TwoDEquation loc) {
        this.xLeftBound = xlb;
        this.xRightBound = xrb;
        this.yUpBound = yub;
        this.yDownBound = ydb;
        resolutionSize = (xrb-xlb)/500;
        this.loc = loc;
        getPointsList();
    }


    @Override
    public void getPointsList() {
        for (int i = 0; i<500 ; i++) {
            double thisX = xLeftBound+i*resolutionSize;
            double thisY = loc.calculateY(xLeftBound+i*resolutionSize);
            TwoDPoints tdp = new TwoDPoints(loc, thisX, thisY, this);
            TwoDPoints tdpXCoor = new TwoDPoints(loc, thisX, 0, this);
            TwoDPoints tdpYCoor = new TwoDPoints(loc, 0, thisX, this);
            lop.add(tdp);
            lop.add(tdpXCoor);
            lop.add(tdpYCoor);

        }

    }

    @Override
    public void colorCoordinates() {
        for (int x = 0; x < 500; x++) {
            colorPoint();
        }
    }

    @Override
    public GraphicsTool drawGraph() {
        GraphicsTool aTwoDGraph = new GraphicsTool();
        aTwoDGraph.setPreferredSize(new Dimension(500, 500));

        return aTwoDGraph;
    }

    public double getXLeftBound(){
        return xLeftBound;
    }
    public double getXRightBound(){
        return xRightBound;
    }
    public double getYUpBound(){
        return yUpBound;
    }
    public double getYDownBound(){
        return yDownBound;
    }


    private class GraphicsTool extends GraphicTool {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            this.setBackground(Color.WHITE);

            for (TwoDPoints tdp : lop) {
                g.setColor(tdp.getterColor());
                g.fillRect(tdp.getX(), tdp.getY(), 1, 1);
            }
        }
    }

}
