package elements.Points;


import elements.ColorIndicator;
import elements.ListsOfCoefficients;

import java.awt.*;


public abstract class GraphicPoint {


    public GraphicPoint(){}

    protected abstract Color getColor();

    protected abstract boolean ApproximateTreatment(double theo, double actual);

    //protected abstract

}
