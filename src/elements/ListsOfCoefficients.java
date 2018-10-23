package elements;


import model.Lists;
import java.util.ArrayList;
import java.util.Scanner;


public class ListsOfCoefficients implements Lists {

    private ArrayList<Coefficient> items ;
    private Scanner scanner = new Scanner(System.in);
    private String operation;
    private int valueToChange;

    // the list is an empty list
    public ListsOfCoefficients(){
        items = new ArrayList<>();
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
    public void addElement(Coefficient c){
        items.add(c);
    }

    public Coefficient get(int integer){
        return items.get(integer);
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
