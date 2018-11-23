package elements.Canvas;

import elements.Points.TwoDPoints;
import equation.TwoDEquation;
import ui.GraphicTool;

import java.awt.*;
import java.util.ArrayList;


public class TwoDCanvas extends Canvas {
    public double xLeftBound;
    private double xRightBound;
    public double yUpBound;
    private double yDownBound;
    public double resolutionSize;
    public ArrayList<TwoDPoints> lop = new ArrayList<>();
    private GraphicsTool aTwoDGraph = new GraphicsTool();
    private TwoDEquation loc;


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
            lop.add(tdp);
        }

        for (int i = 0; i < 500; i++) {
            double thisX = xLeftBound+i*resolutionSize;
            TwoDPoints tdpXCoor = new TwoDPoints(loc, thisX, 0, this);
            lop.add(tdpXCoor);
        }

        for (int i = 0; i < 500; i++) {
            double thisY = yDownBound+i*resolutionSize;
            TwoDPoints tdpYCoor = new TwoDPoints(loc, 0, thisY, this);
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
        aTwoDGraph.setPreferredSize(new Dimension(500, 500));
        return aTwoDGraph;
    }


    private class GraphicsTool extends GraphicTool {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            this.setBackground(Color.WHITE);
            int count = 0;
            for (TwoDPoints tdp : lop) {
                count++;
                g.setColor(tdp.getterColor());
                g.fillRect(tdp.getX(), tdp.getY(), 1, 1);
                if ((count>1 && count<500) || (count >501 && count<1000) || (count > 1001 && count <1500) ){
                    TwoDPoints previous = lop.get(count-2);
                    g.drawLine(previous.getX(),previous.getY(), tdp.getX(), tdp.getY());
                }
            }
        }
    }

}
