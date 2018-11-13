package elements.Points;


import elements.Canvas.TwoDCanvas;
import elements.ColorIndicator;
import elements.TwoDEquation;
import java.awt.*;
import java.util.Objects;


public class TwoDPoints extends GraphicPoint {

    private ColorIndicator color;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TwoDPoints that = (TwoDPoints) o;
        return Double.compare(that.x, x) == 0 &&
                Double.compare(that.y, y) == 0 &&
                Objects.equals(loc, that.loc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(x, y, loc);
    }

    public TwoDPoints(TwoDEquation loc, double x, double y, TwoDCanvas canvas) {
        super(loc, x, y, canvas);

    }

    private boolean pointOnTheGraph() {
        return ApproximateTreatment(y, calculatePoint(x));
    }

    @Override
    public Color getColor() {
        if (pointOnCoordinate() || pointOnTheGraph()) {
            color = new ColorIndicator(0, 0, 0);
        } else {
            color = new ColorIndicator(255, 255, 255);
        }
        return color;
    }

    private boolean ApproximateTreatment(double t, double a) {
        return (t-a) < canvas.resolutionSize || (a-t) < canvas.resolutionSize;
    }

    private double calculatePoint(double x){
        return loc.getOne()*x*x+loc.getTwo()*x+loc.getThree();
    }

    @Override
    public String getCor(){
        return "("+x+","+y+")";
    }


}
