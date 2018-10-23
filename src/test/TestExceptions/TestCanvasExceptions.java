package TestExceptions;

import Exceptions.CanvasFieldException;
import Exceptions.CanvasSizeException;
import elements.Canvas.Canvas;
import elements.Coefficient;
import elements.ListsOfCoefficients;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;


public class TestCanvasExceptions {


    Coefficient c1;
    Coefficient c2;
    Coefficient c3;
    ListsOfCoefficients loc;
    Canvas canvas;

    @BeforeEach
    public void runBefore() {
        c1 = new Coefficient(1,1);
        c2 = new Coefficient(2,2);
        c3 = new Coefficient(1, 3);

        ListsOfCoefficients loc = new ListsOfCoefficients();
        loc.addElement(c1);
        loc.addElement(c2);
        loc.addElement(c3);
    }


    @Test
    public void testCanvasExceptionsXField(){
        canvas = new Canvas(10,0,10,0,loc);
        try {
            canvas.checkCanvas();
        } catch (CanvasFieldException e) {
            System.out.println("Caught exception");
        } catch (CanvasSizeException e) {
            fail("The size of the canvas is square");
        }
    }

    @Test
    public void testCanvasExceptionsYField(){
        canvas = new Canvas(0,10,0,10,loc);
        try {
            canvas.checkCanvas();
        } catch (CanvasFieldException e) {
            System.out.println("Caught exception");
        } catch (CanvasSizeException e) {
            fail("The size of the canvas is square");
        }
    }

    @Test
    public void testCanvasExceptionsXTooLong(){
        canvas = new Canvas(0,100,10,0,loc);
        try {
            canvas.checkCanvas();
        } catch (CanvasFieldException e) {
            fail("the canvas field is okay.");
        } catch (CanvasSizeException e) {
            System.out.println("the x-axis is longer");
        }
    }

    @Test
    public void testCanvasExceptionsYTooLong(){
        canvas = new Canvas(0,100,10,0,loc);
        try {
            canvas.checkCanvas();
        } catch (CanvasFieldException e) {
            fail("the canvas field is okay.");
        } catch (CanvasSizeException e) {
            System.out.println("the y-axis is longer");
        }
    }

    @Test
    public void testCanvasExceptionsBoth(){
        canvas = new Canvas(100,0,0,10,loc);
        try {
            canvas.checkCanvas();
        } catch (CanvasFieldException e) {
            System.out.println("the canvas field is weird");
        } catch (CanvasSizeException e) {
            System.out.println("the y-axis is longer");
        }
    }

}
