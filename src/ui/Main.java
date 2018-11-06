package ui;

import Exceptions.CanvasFieldException;
import Exceptions.CanvasSizeException;
import elements.Canvas.Canvas;
import elements.Canvas.TwoDCanvas;
import elements.Coefficient;
import elements.Points.TwoDPoints;
import elements.TwoDEquation;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Main main = new Main();

        TwoDEquation loc = main.getCoefficients();

        List<Double> answerlist = main.calculation(loc);

        main.printResult(loc, answerlist);

        main.saveResult(answerlist);

        try {
            main.draw2DGraph(loc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private TwoDEquation getCoefficients(){
        System.out.println("Welcome to the Quadratic equation solver.");
        boolean reloadStatus = true;
        Coefficient c1,c2,c3;

        if (reloadStatus) {

            System.out.println("Please enter the first value as the quadratic coefficient.");
            c1 = setCoefficient(1);
            System.out.println("Please enter the second value as the monomial coefficient.");
            c2 = setCoefficient(2);
            System.out.println("Please enter the third value as the constant.");
            c3 = setCoefficient(3);
        } else{
            List<String> lines = null;
            try {
                lines = Files.readAllLines(Paths.get("inputfile.txt"));
            } catch (IOException e) {
                e.printStackTrace();
            } /////////////////////////////////////////////////////////////////////////////////
            c1 = importCoefficient(lines, 1);
            c2 = importCoefficient(lines, 2);
            c3 = importCoefficient(lines, 3);
        }

        TwoDEquation loc = new TwoDEquation();

        loc.addElement(c1);
        loc.addElement(c2);
        loc.addElement(c3);

        System.out.println("Do you want to change your coefficients, enter true or false");
        boolean changeCoe = Boolean.parseBoolean(getUserResponse());

        if (changeCoe){
            loc = changeCoefficients(loc);
        }

        return loc;

    }

    private Coefficient importCoefficient(List<String> lines, int i) {
        Coefficient c1;
        c1 = new Coefficient(Double.valueOf(lines.get(0)), i);
        return c1;
    }

    private Coefficient setCoefficient(int i) {
        Coefficient c1;
        c1 = new Coefficient(Double.parseDouble(getUserResponse()), i);
        return c1;
    }

    private TwoDEquation changeCoefficients(TwoDEquation loc){
        int index;
        double newCoe;
        System.out.println("Please select the coefficient you want to change");
        System.out.println("1 for the first value, 2 for the second value and 3 for the third value");

        index = Integer.parseInt(getUserResponse())-1;

        System.out.println("Please enter the new value.");

        newCoe = Double.parseDouble(getUserResponse());

        try{loc.changes(index,newCoe);}
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("out of bound");
        }

        return loc;
    }

    private List<Double> calculation(TwoDEquation loc){
        List<Double> answerList = new ArrayList<>();
        double ans1 = calculateAnswerOne(loc.getOne(),loc.getTwo(),loc.getThree());
        double ans2 = calculateAnswerTwo(loc.getOne(),loc.getTwo(),loc.getThree());
        if (calculateDelta(loc.getOne(),loc.getTwo(),loc.getThree())>0){
            answerList.add(ans1);
            answerList.add(ans2);
        } else if (calculateDelta(loc.getOne(),loc.getTwo(),loc.getThree()) ==0){
            answerList.add(ans1);
        } else {
            answerList = null;
        }
        return answerList;
    }

    private void printResult(TwoDEquation loc, List<Double> list){
        System.out.println("Calculation result for "+loc.getOne()+"x^2+"+loc.getTwo()+"x+"+loc.getThree()+"=0");
        for (Double a: list
             ) {
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

    private String getUserResponse() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        try {
            line = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error trying to read a line of text.");
            System.exit(1);
        }
        return line;
    }

    private void draw2DGraph(TwoDEquation loc) throws IOException {
        Canvas ca = new TwoDCanvas(0,10,0,10,loc);
        ca.getPointsList();

        try{
            try {
                ca.checkCanvas();
            } catch (CanvasFieldException e) {
                System.out.println(e.getMessage());
            } catch (CanvasSizeException e) {
                System.out.println(e.getMessage());
            }
        } finally {
            ca.drawGraph();
            //ca.illustrate();


        }
    }

    private double calculateDelta(double a, double b, double c){
        return b*b-4*a*c;
    }

    private double calculateAnswerTwo(double a, double b, double c){
        return (-b-Math.sqrt(b*b-4*a*c))/(2*a);
    }

    private double calculateAnswerOne(double a, double b, double c){
        return (-b+Math.sqrt(b*b-4*a*c))/(2*a);
    }

}
