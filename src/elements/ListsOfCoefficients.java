package elements;


import model.Lists;
import java.util.ArrayList;


public class ListsOfCoefficients implements Lists {

    private ArrayList<Coefficient> items ;


    // create an empty list
    public ListsOfCoefficients(){
        items = new ArrayList<>();
    }


    //REQUIRES: an integer indicates the position of the element in the list; a double for the new value
    //MODIFIES: this
    //EFFECTS: change values in the list items
    //         it can only change one value at this moment, but can change more when updated.
    @Override
    public void changes(int position, double newValue) {
        if (position >2){
            throw new ArrayIndexOutOfBoundsException("POSITION OUT OF LIST SIZE");
        }
        items.get(position).changeValue(newValue);
    }


    //REQUIRES: double
    //MODIFIES: this
    //EFFECTS: add Coefficient in the list items.
    public void addElement(Coefficient c){
        items.add(c);
    }


    /*public void checkEquation(){
        if (getOne() == 0){
            throw new ArithmeticException("the first coefficient cannot be zero");
        }
    }*/




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
