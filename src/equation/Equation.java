package equation;

import java.util.ArrayList;

public abstract class Equation {

    protected ArrayList<Coefficient> items ;

    public Equation(){
        items = new ArrayList<>();
    }

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
