package elements.Canvas;

import observer.Subject;
import ui.GraphicTool;


public abstract class Canvas extends Subject{


    protected Canvas() {}



    public abstract void getPointsList();

    public abstract void colorCoordinates();





    public int getPos(int pos, String key){
        return Integer.parseInt(key.substring(pos,pos+1));
    }



    protected abstract GraphicTool drawGraph();


    /*public void makeDot(double x, double y){
        lop.get(Integer.toString(coordinateToPixel(x)+coordinateToPixel(y))).getColor() = black;
    }*/

    /*private int coordinateToPixel(double adouble){
        return (int) (Math.abs(adouble/resolutionSize));
    }*/

    public void colorPoint(){}





}
