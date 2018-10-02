package elements;


import model.Lists;

import java.util.ArrayList;
import java.util.Scanner;

public class listOfCoefficients implements Lists{

    private ArrayList<Coefficient> items = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    Coefficient value = new Coefficient(0);
    private String operation;
    private int valueToChange;

    //REQUIRES: nothing
    //MODIFIES: this
    //EFFECTS: add Coefficient to the list items from user input
    public void gatherInput(){
        System.out.println("Please enter the first value as the quadratic coefficient.");
        addElement(scanner.nextDouble());
        System.out.println("Please enter the second value as the monomial coefficient.");
        addElement(scanner.nextDouble());
        System.out.println("Please enter the third value as the constant.");
        addElement(scanner.nextDouble());
        changes();
    }

    //REQUIRES: theoretically the list items should not be empty, but it can work with an empty list
    //MODIFIES: this
    //EFFECTS: change values in the list items
    //         it can only change one value at this moment, but can change more when updated.
    @Override
    public void changes() {
        System.out.println("Do you want to change the value you just put in?");
        System.out.println("Please enter Y for yes and N for no.");

        operation = scanner.nextLine();
        if (operation.equals("Y")) {
            System.out.println("Please select the coefficient you want to change");
            System.out.println("1 for the first value, 2 for the second value and 3 for the third value");
            valueToChange = scanner.nextInt();
            if (valueToChange == 1) {
                System.out.println("Please enter the new value.");
                items.get(0).coefficient = scanner.nextDouble();
            } else if (valueToChange == 2) {
                System.out.println("Please enter the new value.");
                items.get(1).coefficient = scanner.nextDouble();
            } else if (valueToChange == 3) {
                System.out.println("Please enter the new value.");
                items.get(2).coefficient = scanner.nextDouble();
            } else {
                System.out.println("INVALID POSITION");
            }
        } else if (operation.equals("N")) {
            System.out.println("You chose NO, go ahead.");
        } else {
            System.out.println("INVALID COMMAND");
        }
    }

    //REQUIRES: double
    //MODIFIES: this
    //EFFECTS: add Coefficient in the list items.
    @Override
    public void addElement(double scannedDouble){
        Coefficient coefficient = new Coefficient(scannedDouble);
        items.add(coefficient);
    }


    @Override
    public void removeElement(){
        ////////////////////////////////
    }

    //helper method
    public double getOne(){
        return items.get(0).coefficient;
    }
    //helper method
    public double getTwo(){
        return items.get(1).coefficient;
    }
    //helper method
    public double getThree(){
        return items.get(2).coefficient;
    }


}
