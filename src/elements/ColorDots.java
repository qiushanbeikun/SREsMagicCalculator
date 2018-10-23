package elements;


import elements.Points.GraphicPoint;
import elements.Points.TwoDPoints;

import javax.swing.*;
import java.awt.*;

public class ColorDots extends JPanel {

    private int squareX ;
    private int squareY ;
    private int squareW ;
    private int squareH ;

    protected void paintComponent(Graphics g, TwoDPoints p) {
        super.paintComponent(g); // do your superclass's painting routine first, and then paint on top of it.
        g.setColor(p.getColor());
        g.fillRect(squareX,squareY,squareW,squareH);
    }
}

