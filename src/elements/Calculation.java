package elements;

public class Calculation {


    //REQUIRES: three integers as the three coefficients
    //EFFECTS: return a double, which is the delta value to justify how many roots this equation has
    public double calculateDelta(double a, double b, double c){
        return b*b-4*a*c;
    }

    //REQUIRES: three integers as the three coefficients
    //EFFECTS: returns a double which is the first root of the equation
    public double calculateAnswerTwo(double a, double b, double c){
        return (-b-Math.sqrt(b*b-4*a*c))/(2*a);
    }

    //REQUIRES: three integers as the three coefficients
    //EFFECTS: returns a double which is the second root of the equation
    public double calculateAnswerOne(double a, double b, double c){
        return (-b+Math.sqrt(b*b-4*a*c))/(2*a);
    }

}
