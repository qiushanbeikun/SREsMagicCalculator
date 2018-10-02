package ui;

import elements.Calculation;
import elements.listOfCoefficients;

public class Main {

    private Main(){
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.gatherInfo();
    }

    private void gatherInfo() {
        Calculation Calculation = new Calculation();
        listOfCoefficients Coefficients = new listOfCoefficients();
        Coefficients.gatherInput();
        //Coefficients.changes();
        if (Calculation.calculateDelta(Coefficients.getOne(), Coefficients.getTwo(),Coefficients.getThree())>=0){
            System.out.println("Roots for:  " + Coefficients.getOne() + "x^2+"+ Coefficients.getTwo() + "x+"+ Coefficients.getThree()+"=0.0");

            if (Calculation.calculateDelta(Coefficients.getOne(), Coefficients.getTwo(),Coefficients.getThree())==0){
                System.out.println("This function only have one root");
                System.out.println("Root is "+Calculation.calculateAnswerOne(Coefficients.getOne(), Coefficients.getTwo(),Coefficients.getThree()));

            } else {
                System.out.println("Rout 1 is"+Calculation.calculateAnswerOne(Coefficients.getOne(), Coefficients.getTwo(),Coefficients.getThree()));
                System.out.println("Root 2 is"+Calculation.calculateAnswerTwo(Coefficients.getOne(), Coefficients.getTwo(),Coefficients.getThree()));

            }
        } else {
            System.out.println("This function has no root. ");
            System.out.println("Please enter a new function.");
        }
        /*// this loop is just for test, will be deleted in the future.
        System.out.println("A new function starts here!!!");
        gatherInfo();*/
    }

}
