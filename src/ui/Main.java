package ui;

import elements.Canvas.ThreeDCanvas;
import elements.Canvas.TwoDCanvas;
import equation.Coefficient;
import equation.ThreeDEquation;
import equation.TwoDEquation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private JFrame frame;
    private JButton buttonCalculate;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton buttonGraph1;
    private JButton buttonGraph2;
    private TextArea ta1;
    private TextArea ta2;
    private List<Double> answerList;
    private JPanel panel;
    private JPanel graphic = null;
    private JPanel graphic3d = null;
    private JPanel card1;
    private JPanel card2;
    private CardLayout cl;
    private JPanel cards;
    private final String TWOD = "Quadratic Equation Calculator";
    private final String THREED = "3D Plane Drawer";

    private Main(){
        frame = new JFrame("SRE's Magic Calculator");
        frame.setSize(520,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        panel = new JPanel();
        frame.add(panel);


        addComponentToPane(frame);

        frame.setVisible(true);
    }

    private void addComponentToPane(Container pane) {

        JPanel comboBoxPane = new JPanel();
        String comboBoxItems[] = { TWOD, THREED };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        ListenForItem iL = new ListenForItem();
        cb.addItemListener(iL);
        comboBoxPane.add(cb);

        //add component to card1
        card1 = new JPanel();
        textField1 = new JTextField("");
        textField1.setColumns(7);
        card1.add(textField1);
        JLabel label1 = new JLabel("x^2 +");
        card1.add(label1);
        textField2 = new JTextField(" ");
        textField2.setColumns(7);
        card1.add(textField2);
        JLabel label2= new JLabel("x +");
        card1.add(label2);
        textField3 = new JTextField(" ");
        textField3.setColumns(7);
        card1.add(textField3);
        JLabel label3 = new JLabel(" =0\n");
        card1.add(label3);
        ta1 = new TextArea();
        card1.add(ta1);
        ta1.append("Welcome to the quadratic equation calculator.\n");

        // buttons
        buttonCalculate = new JButton("Calculate");
        card1.add(buttonCalculate, BorderLayout.CENTER);

        ListenForButton lForButton = new ListenForButton();
        buttonCalculate.addActionListener(lForButton);

        buttonGraph1 = new JButton("Draw Graph");
        buttonGraph1.addActionListener(lForButton);


        card1.add(buttonGraph1, BorderLayout.AFTER_LAST_LINE);




        card2 = new JPanel();
        frame.add(card2);

        JLabel label4 = new JLabel("z = ");
        card2.add(label4);

        textField4 = new JTextField("");
        textField4.setColumns(7);
        card2.add(textField4);

        JLabel label5= new JLabel("x + ");
        card2.add(label5);
        textField5 = new JTextField(" ");
        textField5.setColumns(7);
        card2.add(textField5);

        JLabel label6 = new JLabel("y + ");
        card2.add(label6);
        textField6 = new JTextField(" ");
        textField6.setColumns(7);
        card2.add(textField6);


        ta2 = new TextArea();
        card2.add(ta2);
        ta2.append("Welcome to the plane drawer.\n");

        buttonGraph2 = new JButton("Draw Graph");
        card2.add(buttonGraph2, BorderLayout.AFTER_LAST_LINE);
        buttonGraph2.addActionListener(lForButton);

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, TWOD);
        cards.add(card2, THREED);

        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }

    private class ListenForButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonCalculate){
                ta1.append("Calculation result for "+textField1.getText()+"x^2+"+textField2.getText()+"x+"+textField1.getText()+"=0\n");
                doThingsWithTwoD();
                for (Double a: answerList) {
                    ta1.append("Answer:"+ a+"\n");
                }
            }else if(e.getSource() == buttonGraph1) {
                ta1.append("Drawing graph of "+textField1.getText()+"x^2+"+textField2.getText()+"x+"+textField1.getText()+"=0\n");
                TwoDCanvas twoDCanvas = new TwoDCanvas(-5,5,5,-5, getCoefficients());
                if (graphic == null) {
                    graphic = new GraphicTool();
                    graphic.setPreferredSize(new Dimension(1, 1));
                } else{
                    graphic = twoDCanvas.drawGraph();
                }
                card1.add(graphic);


                frame.setVisible(true);


            }else if (e.getSource() == buttonGraph2){
                ta2.append("Drawing graph of z = "+textField4.getText()+"x +"+textField5.getText()+"y+"+textField6.getText()+" =0\n");
                ThreeDCanvas threeDCanvas = new ThreeDCanvas(getVector());
                ta2.append(Integer.toString(threeDCanvas.lop.get(124000).getterColor().getRed()));
                if (graphic3d == null) {
                    graphic3d = new GraphicTool();
                    graphic3d.setPreferredSize(new Dimension(1, 1));
                } else{
                    graphic3d = threeDCanvas.drawGraph();
                }
                card2.add(graphic3d);

                frame.setVisible(true);
            }else{
                ta1.append("you have not entered the equation.");
            }
        }
    }


    private class ListenForItem implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent evt) {
            cl = (CardLayout)(cards.getLayout());
            cl.show(cards, (String)evt.getItem());
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    private void doThingsWithTwoD(){
        TwoDEquation loc = getCoefficients();
        List<Double> answerlist = twoDCalculation(loc);
        TwoDPrintResult(loc, answerlist);
        saveResult(answerlist);
    }

    private TwoDEquation getCoefficients(){
        Coefficient c1,c2,c3;
            c1 = new Coefficient(Double.valueOf(textField1.getText()),1);
            c2 = new Coefficient(Double.valueOf(textField2.getText()),1);
            c3 = new Coefficient(Double.valueOf(textField3.getText()),1);
        TwoDEquation loc = new TwoDEquation();
        loc.addElement(c1);
        loc.addElement(c2);
        loc.addElement(c3);
        return loc;
    }

    private ThreeDEquation getVector(){
        Coefficient c1,c2,c3;
        c1 = new Coefficient(Double.valueOf(textField4.getText()),1);
        c2 = new Coefficient(Double.valueOf(textField5.getText()),1);
        c3 = new Coefficient(Double.valueOf(textField6.getText()),1);
        ThreeDEquation loc = new ThreeDEquation();
        loc.addElement(c1);
        loc.addElement(c2);
        loc.addElement(c3);
        return loc;
    }

    private List<Double> twoDCalculation(TwoDEquation loc){
        answerList = new ArrayList<>();
        double ans1 = loc.calculateAnswerOne(loc.getOne(),loc.getTwo(),loc.getThree());
        double ans2 = loc.calculateAnswerTwo(loc.getOne(),loc.getTwo(),loc.getThree());
        if (loc.calculateDelta(loc.getOne(),loc.getTwo(),loc.getThree())>0){
            answerList.add(ans1);
            answerList.add(ans2);
        } else if (loc.calculateDelta(loc.getOne(),loc.getTwo(),loc.getThree()) ==0){
            answerList.add(ans1);
        } else {
            answerList = null;
        }
        return answerList;
    }

    private void TwoDPrintResult(TwoDEquation loc, List<Double> list){
        System.out.println("Calculation result for "+loc.getOne()+"x^2+"+loc.getTwo()+"x+"+loc.getThree()+"=0");
        for (Double a: list) {
            System.out.println(a);
        }
    }

    private void saveResult(List<Double> list){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("outputfile.txt","UTF-8");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (UnsupportedEncodingException e) {
            System.out.println("UnsupportedEncodingException");
        }
        for (Double a: list
             ) {
            writer.println(a);
        }
        writer.close();
    }

}
