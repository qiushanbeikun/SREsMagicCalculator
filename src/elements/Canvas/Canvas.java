package elements.Canvas;

import elements.ListsOfCoefficients;
import elements.Points.TwoDPoints;


import java.util.List;

public class Canvas {

    public double xLeftBound;
    public double xRightBound;
    public double yUpBound;
    public double yDownBound;
    public double resolutionSize;
    //public Canvas ca;
    private List<TwoDPoints> lop ;

    ListsOfCoefficients loc;

    // assume the canvas is square
    public Canvas(double xlb, double xrb, double yub, double ydb, ListsOfCoefficients loc){
        this.xLeftBound = xlb;
        this.xRightBound = xrb;
        this.yUpBound = yub;
        this.yDownBound = ydb;
        resolutionSize = (xlb+xrb+ydb+yub)/2000;
        this.loc = loc;
        //this.ca = this;

    }


    public List<TwoDPoints> getList(){
        for (int i = 0; i < 10 ; i++) {
            for (int j = 0; j < 10 ; j++) {
                TwoDPoints tdp = new TwoDPoints(loc, i,0+resolutionSize*j);
                lop.add(tdp);
            }
        }
        return lop;
    }


}
