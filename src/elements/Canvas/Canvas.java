package elements.Canvas;

import Exceptions.CanvasFieldException;
import Exceptions.CanvasSizeException;
import elements.Points.GraphicPoint;
import elements.TwoDEquation;
import observer.Subject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public abstract class Canvas extends Subject{

    private double xLeftBound;
    private double xRightBound;
    private double yUpBound;
    private double yDownBound;
    public static double resolutionSize;
    protected Map<String, GraphicPoint> lop;
    private Set<String> keys;
    private Color color;

    private Image img;
    private int count = 0;

    private Graphics background;

    private Color black = new Color(0,0,0);

    TwoDEquation loc;


    //REQUIRES: assume the canvas is square

    public Canvas(double xlb, double xrb, double yub, double ydb, TwoDEquation loc) throws IOException {
        this.xLeftBound = xlb;
        this.xRightBound = xrb;
        this.yUpBound = yub;
        this.yDownBound = ydb;
        resolutionSize = (xlb+xrb)/1000;
        this.loc = loc;
        lop = new HashMap<>();
        keys = new HashSet<>();
        img = ImageIO.read(new File("background.jpg"));
        color = new Color(0,0,0);
        keys = lop.keySet();
    }

    public void checkCanvas() throws CanvasFieldException, CanvasSizeException {
        if (xLeftBound>xRightBound || yUpBound>yDownBound){
            throw new CanvasFieldException("Your canvas's field is not correct.");
        }
        if (Math.abs(xRightBound-xLeftBound) != Math.abs(yUpBound-yDownBound)){
            throw new CanvasSizeException("Your canvas is not square.");
        }
    }

    public abstract void getPointsList();

    protected void addPoint(String newKey, GraphicPoint newPoint){

        if (!lop.containsKey(newKey)){
            lop.put(newKey,newPoint);
            addObserver(newPoint);
            count++;
            System.out.println(count);
        }
    }

    public void drawGraph(){

        for (String key: keys) {
            color = getColorOfPoint(key);
            //System.out.println(color.getRed());
            //background.fillRect(getPos(0,key), getPos(1,key),1,1);
        }

    }

    public int getPos(int pos, String key){
        return Integer.parseInt(key.substring(pos,pos+1));
    }

    private Color getColorOfPoint(String key){
        return lop.get(key).getColor();
    }

    public Map getMap(){
        return lop;
    }

    public void illustrate(){
        for (GraphicPoint gp: lop.values()) {
            System.out.println(gp.getCor());
        }
    }

    /*public void makeDot(double x, double y){
        lop.get(Integer.toString(coordinateToPixel(x)+coordinateToPixel(y))).getColor() = black;
    }*/

    /*private int coordinateToPixel(double adouble){
        return (int) (Math.abs(adouble/resolutionSize));
    }*/




}
