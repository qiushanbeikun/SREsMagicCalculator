package elements;

public class Coefficient {
    double coefficient;

    //REQUIRES: the input should be double
    // MODIFIES: this
    // EFFECTS: initialize the coefficient with the value in input
    public Coefficient(double input){
        coefficient = input;
    }

    //REQUIRES: the input should be double
    //MODIFIES: this
    //EFFECTS: change the value of coefficient ot the new input
    public void changeValue(double newInput){
        coefficient = newInput;
    }

    //help method
    //REQUIRES: nothing
    //MODIFIES； nothing
    //EFFECTS: return the value of coefficient
    public double getCoevalue(){
        return coefficient;
    }
}
