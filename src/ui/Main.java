package ui;

import elements.Calculation;
import elements.listsOfCoefficients;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private Main(){
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.gatherInfo();
    }

    private void gatherInfo() throws IOException {

        boolean reloadStatus = true;
        Calculation Calculation = new Calculation();
        listsOfCoefficients LOC = new listsOfCoefficients();
        List<Double> ans = new ArrayList<>();

        if (reloadStatus) {
            LOC.gatherInput();
        } else {
            LOC.importFile();
        }
        ans.add(LOC.getOne());
        ans.add(LOC.getTwo());
        ans.add(LOC.getThree());
        //LOC.changes();
        if (Calculation.calculateDelta(LOC.getOne(), LOC.getTwo(), LOC.getThree()) >= 0) {
            System.out.println("Roots for:  " + LOC.getOne() + "x^2+" + LOC.getTwo() + "x+" + LOC.getThree() + "=0.0");


            if (Calculation.calculateDelta(LOC.getOne(), LOC.getTwo(), LOC.getThree()) == 0) {
                System.out.println("This function only have one root");
                System.out.println("Root is " + Calculation.calculateAnswerOne(LOC.getOne(), LOC.getTwo(), LOC.getThree()));
                ans.add(Calculation.calculateAnswerOne(LOC.getOne(), LOC.getTwo(), LOC.getThree()));

            } else {
                System.out.println("Rout 1 is" + Calculation.calculateAnswerOne(LOC.getOne(), LOC.getTwo(), LOC.getThree()));
                System.out.println("Root 2 is" + Calculation.calculateAnswerTwo(LOC.getOne(), LOC.getTwo(), LOC.getThree()));
                ans.add(Calculation.calculateAnswerOne(LOC.getOne(), LOC.getTwo(), LOC.getThree()));
                ans.add(Calculation.calculateAnswerTwo(LOC.getOne(), LOC.getTwo(), LOC.getThree()));

            }
        } else {
            System.out.println("This function has no root. ");
            System.out.println("Please enter a new function.");
            ans = null;

        }

        PrintWriter writer = new PrintWriter("outputfile.txt", "UTF-8");
        for (Double a : ans) {
            writer.println(a);
        }
        //System.out.println(ans.get(0));

    }
}
