package elements.Canvas;

import elements.Points.ThreeDPoints;
import equation.ThreeDEquation;
import ui.GraphicTool;

import java.awt.*;
import java.util.ArrayList;

public class ThreeDCanvas extends Canvas{

    private double xLeftBound;
    private double xRightBound;
    private double yUpBound;
    private double yDownBound;
    public double resolutionSize ;
    public ArrayList<ThreeDPoints> lop = new ArrayList();

    public double max;
    public double min;
    public double range;

    public ThreeDEquation loc;

    public ThreeDCanvas(ThreeDEquation loc)  {
        this.xLeftBound = -5;
        this.xRightBound = 5;
        this.yUpBound = 5;
        this.yDownBound = -5;
        this.loc = loc;
        resolutionSize = 0.02;
        getMaxMinAndRange();
        getPointsList();



    }

    @Override
    public void getPointsList() {
        for (int y = 0; y < 500; y++) {
            double thisY = yUpBound-y*resolutionSize;
            for (int x = 0; x < 500; x++) {
                double thisX = xLeftBound+x*resolutionSize;
                ThreeDPoints tdp = new ThreeDPoints(loc, thisX, thisY, this);
                lop.add(tdp);
            }
            ThreeDPoints tdpXCoor = new ThreeDPoints(loc, thisY, 0, this);
            ThreeDPoints tdpYCoor = new ThreeDPoints(loc, 0, thisY, this);
            lop.add(tdpXCoor);
            lop.add(tdpYCoor);
        }
    }

    @Override
    public void colorCoordinates() {

    }

    @Override
    public GraphicTool drawGraph() {
        GraphicsTool aThreeDGraph = new GraphicsTool();
        aThreeDGraph.setPreferredSize(new Dimension(500, 500));

        return aThreeDGraph;
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


            for (ThreeDPoints tdp : lop) {
                g.setColor(tdp.getterColor());
                g.fillRect(tdp.getX(), tdp.getY(), 1, 1);
            }
        }
    }

    public void getMaxMinAndRange() {

        double pointOne = returnPointValue(getXLeftBound(), getYDownBound());
        double pointTwo = returnPointValue(getXLeftBound(),getYUpBound());
        double pointThree = returnPointValue(getXRightBound(),getYDownBound());
        double pointFour = returnPointValue(getXRightBound(),getYUpBound());

        max = Math.max(pointOne, Math.max(pointTwo, Math.max(pointThree, pointFour)));
        min = Math.min(pointOne, Math.min(pointTwo, Math.min(pointThree, pointFour)));
        range = max-min;
    }

    private double returnPointValue(double x, double y) {
        return loc.getOne()*x+loc.getTwo()*y+loc.getThree();
    }

}
