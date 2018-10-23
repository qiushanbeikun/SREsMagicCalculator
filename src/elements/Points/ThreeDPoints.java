package elements.Points;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ThreeDPoints extends GraphicPoint {

    double x;
    double y;
    double z;

    private List twodpoints;
    private List colorindication;

    public void ThreeDPoints(){
        twodpoints = new ArrayList();
        twodpoints.add(x);
        twodpoints.add(y);
        twodpoints.add(z);
        colorindication = new ArrayList();
    }



    protected void colorIndicator() {

    }

    @Override
    protected Color getColor() {
        return null;
    }

    @Override
    protected boolean ApproximateTreatment(double theo, double actual) {
        return false;
    }


}
