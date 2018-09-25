package elements;


import java.util.ArrayList;
import java.util.Scanner;

public class listOfCoefficients {

    private ArrayList<Coefficient> items = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Coefficient value = new Coefficient(0);
    private String operation;
    private int valueToChange;

    //REQUIRES: nothing
    //MODIFIES: this
    //EFFECTS: add Coefficient to the list items from user input
    public void gatherInput(){
        System.out.println("Please enter the first value as the quadratic coefficient.");
        addCoe(scanner.nextDouble());
        System.out.println("Please enter the second value as the monomial coefficient.");
        addCoe(scanner.nextDouble());
        System.out.println("Please enter the third value as the constant.");
        addCoe(scanner.nextDouble());
        changes();
    }

    //REQUIRES: theoratically the list items should not be empty, but it can work with an empty list
    //MODIFIES: this
    //EFFECTS: change values in the list items
    //         it can only change one value at this moment, but can change more when updated.
    public void changes(){
        System.out.println("Do you want to change the value you just put in?");
        System.out.println("Please enter Y for yes and N for no.");
        operation = scanner.nextLine();
        System.out.println("You selected "+operation);
        if (scanner.nextLine().equals("Y")){
            System.out.println("Please select the coefficient you want to change");
            System.out.println("1 for the first value, 2 for the second value and 3 for the third value");
            valueToChange = scanner.nextInt();
            if (valueToChange == 1){
                System.out.println("Please enter the new value.");
                items.get(0).coefficient = scanner.nextDouble();
            } else if (valueToChange == 2) {
                System.out.println("Please enter the new value.");
                items.get(1).coefficient = scanner.nextDouble();
            }else if (valueToChange == 3) {
                System.out.println("Please enter the new value.");
                items.get(2).coefficient = scanner.nextDouble();
            }else{
                System.out.println("INVALID POSITION");
            }
        }
    }

    //REQUIRES: double
    //MODIFIES: this
    //EFFECTS: add Coefficient in the list items.
    public void addCoe(double scanedDouble){
        Coefficient coefficient = new Coefficient(scanedDouble);
        items.add(coefficient);
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
