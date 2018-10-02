package elements;


import model.Lists;
import model.Values;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class listsOfCoefficients implements Lists {

    private ArrayList<Coefficient> items ;
    private Scanner scanner = new Scanner(System.in);
    Values value = new Coefficient(0);
    private String operation;
    private int valueToChange;

    // the list is an empty list
    public listsOfCoefficients(){
        items = new ArrayList<>();
    }

    public void importFile() throws IOException{
        List<String> lines = Files.readAllLines(Paths.get("inputfile.txt"));
        addElement(Double.valueOf(lines.get(0)));
        addElement(Double.valueOf(lines.get(1)));
        addElement(Double.valueOf(lines.get(2)));
    }

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
        System.out.println("Do you want to change the value you just put in?");
        System.out.println("Please enter Y for yes and N for no.");
        operation = scanner.nextLine();
        if (operation.equals("Y")) {
            System.out.println("Please select the coefficient you want to change");
            System.out.println("1 for the first value, 2 for the second value and 3 for the third value");
            valueToChange = scanner.nextInt();
            if (valueToChange == 1) {
                System.out.println("Please enter the new value.");
                changes(0, scanner.nextDouble());
            } else if (valueToChange == 2) {
                System.out.println("Please enter the new value.");
                changes(1, scanner.nextDouble());
            } else if (valueToChange == 3) {
                System.out.println("Please enter the new value.");
                changes(2, scanner.nextDouble());
            } else {
                System.out.println("INVALID POSITION");
            }
        } else if (operation.equals("N")) {
            System.out.println("You chose NO, go ahead.");
        } else {
            System.out.println("INVALID COMMAND");
        }
    }

    //REQUIRES: an integer indicates the position of the element in the list; a double for the new value
    //MODIFIES: this
    //EFFECTS: change values in the list items
    //         it can only change one value at this moment, but can change more when updated.
    @Override
    public void changes(int position, double newValue) {
        items.get(position).coefficient = newValue;
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
    public void removeElement(int position){
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
