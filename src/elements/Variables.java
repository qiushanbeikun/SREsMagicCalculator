package elements;

import model.Values;

public class Variables implements Values{
    double x;

    public Variables(double x){
        this.x = x;
    }

    //REQUIRES: a double input
    //MODIFIES: this
    //EFFECTS: change the value of the variable to the new input
    @Override
    public void changeValue(double newVariable) {
        x = newVariable;
    }

    @Override
    public void changeSign() {
        x = -x;
    }

    @Override
    public double getValue() {
        return x;
    }


}
