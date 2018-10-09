package elements;

import java.util.ArrayList;
import java.util.List;

public class TwoDPoints extends GraphicPoint{

    private double x;
    private double y;
    private List twodpoints;
    private List colorindication;

    public void TwoDPoints(){
        twodpoints = new ArrayList();
        twodpoints.add(x);
        twodpoints.add(y);
        colorindication = new ArrayList();
    }


    @Override
    protected void colorIndicator() {
        if (pointOnTheGraph()){
            colorindication.add(0);
            colorindication.add(0);
            colorindication.add(0);
        } else{
            colorindication.add(255);
            colorindication.add(255);
            colorindication.add(255);
        }
    }


    public boolean pointOnTheGraph(){
        Calculation Calculation = new Calculation();
        return y == Calculation.calculatepoint(1,2,3,4);
    }


}
