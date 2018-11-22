package equation;


public class TwoDEquation extends Equation {

    //private ArrayList<Coefficient> items ;


    // create an empty list
    public TwoDEquation(){
        super();
    }


    public double calculateDelta(double a, double b, double c){
        return b*b-4*a*c;
    }

    public double calculateAnswerTwo(double a, double b, double c){
        return (-b-Math.sqrt(b*b-4*a*c))/(2*a);
    }

    public double calculateAnswerOne(double a, double b, double c){
        return (-b+Math.sqrt(b*b-4*a*c))/(2*a);
    }

    public double calculateY(double x){
        return this.getOne()*x*x+this.getTwo()*x+this.getThree();
    }

}
