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
    public ArrayList<TwoDPoints> lop = new ArrayList<>();
    public GraphicsTool aTwoDGraph = new GraphicsTool();

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
            /*TwoDPoints tdpXCoor = new TwoDPoints(loc, thisX, 0, this);
            TwoDPoints tdpYCoor = new TwoDPoints(loc, 0, thisX, this);*/
            lop.add(tdp);
  /*          lop.add(tdpXCoor);
            lop.add(tdpYCoor);
*/
        }

        for (int i = 0; i < 500; i++) {
            double thisX = xLeftBound+i*resolutionSize;

            TwoDPoints tdpXCoor = new TwoDPoints(loc, thisX, 0, this);

            lop.add(tdpXCoor);
        }

        for (int i = 0; i < 500; i++) {
            double thisX = xLeftBound+i*resolutionSize;

            TwoDPoints tdpYCoor = new TwoDPoints(loc, 0, thisX, this);

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

            int count = 0;

            for (TwoDPoints tdp : lop) {

                count++;
                g.setColor(tdp.getterColor());
                g.fillRect(tdp.getX(), tdp.getY(), 1, 1);
                if ((count>1 && count<500) || (count >1003 && count<1500) ){
                    TwoDPoints previous = lop.get(count-2);
                    g.drawLine(previous.getX(),previous.getY(), tdp.getX(), tdp.getY());
                }


            }
        }
    }

}
