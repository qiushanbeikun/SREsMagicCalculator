package elements;


import java.util.ArrayList;
import java.util.Scanner;

public class listOfCoefficients {

    private ArrayList<Coefficient> items = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Coefficient value = new Coefficient(0);
    private String operation;
    private int valueToChange;

    public void gatherInput(){
        System.out.println("Please enter the first value as the quadratic coefficient.");
        addCoe(scanner.nextDouble());
        System.out.println("Please enter the second value as the monomial coefficient.");
        addCoe(scanner.nextDouble());
        System.out.println("Please enter the third value as the constant.");
        addCoe(scanner.nextDouble());
        changes();
    }

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

    public void addCoe(double scanedDouble){
        Coefficient coefficient = new Coefficient(scanedDouble);
        items.add(coefficient);
    }

    //REQUIRES: item should be double
    //MODIFIES: the list items
    //EFFECTS: Add a new item, which is a double into the list item


    public double getOne(){
        return items.get(0).coefficient;
    }

    public double getTwo(){
        return items.get(1).coefficient;
    }

    public double getThree(){
        return items.get(2).coefficient;
    }















}
