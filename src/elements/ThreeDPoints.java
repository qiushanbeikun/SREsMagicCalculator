package elements;

import java.util.ArrayList;
import java.util.List;

public class ThreeDPoints extends GraphicPoint{

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


    @Override
    protected void colorIndicator() {

    }
}
