package equation;



public class Coefficient {
    double coefficient;
    int index;

    //REQUIRES: the input should be double
    // MODIFIES: this
    // EFFECTS: initialize the coefficient with the value in input
    public Coefficient(double input, int index) {
        coefficient = input;
        this.index = index;
    }

    //REQUIRES: the input should be double
    //MODIFIES: this
    //EFFECTS: change the value of coefficient ot the new input
    public void changeValue(double newInput){
        coefficient = newInput;
    }

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
