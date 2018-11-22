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

    public ThreeDEquation loc;

    public ThreeDCanvas(ThreeDEquation loc)  {
        this.xLeftBound = -5;
        this.xRightBound = 5;
        this.yUpBound = 5;
        this.yDownBound = -5;
        this.loc = loc;
        getPointsList();
        resolutionSize = 0.02;

    }

    @Override
    public void getPointsList() {
        for (int y = 0; y < 500; y++) {
            double thisY = yUpBound-y*0.02;
            for (int x = 0; x < 500; x++) {
                double thisX = xLeftBound+x*0.02;
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

}
