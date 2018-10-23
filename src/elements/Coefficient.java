package elements;

import model.Values;

public class Coefficient implements Values {
    double coefficient;
    int index;

    //REQUIRES: the input should be double
    // MODIFIES: this
    // EFFECTS: initialize the coefficient with the value in input
    public Coefficient(double input, int index) throws NumberFormatException{
        coefficient = input;
        this.index = index;
    }

    @Override
    //REQUIRES: the input should be double
    //MODIFIES: this
    //EFFECTS: change the value of coefficient ot the new input
    public void changeValue(double newInput){
        coefficient = newInput;
    }

    @Override
    //REQUIRES: double input
    //MODIFIES: this
    //EFFECTS: a quick access to change the value of Coe to its negative
    public void changeSign(){
        coefficient = -coefficient;
    }

    //EFFECTS: return the value itself
    public double getValue(){
        return coefficient;
    }



}
