package elements;

public class Coefficient {
    double coefficient;

    public Coefficient(double input){
        coefficient = input;
    }

    public void changeValue(double newInput){
        coefficient = newInput;
    }

    public double getCoevalue(){
        return coefficient;
    }
}
