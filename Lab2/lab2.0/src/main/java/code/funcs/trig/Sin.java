package code.funcs.trig;

import code.funcs.Function;

import static java.lang.Math.*;


public class Sin extends Function {

    public Sin(double accuracy){
        this.accuracy = accuracy;
    }

    public Double calculate(double x){
        double result= Double.MAX_VALUE;
        double n = 1.0;
        double topFact= 1.0;
        double botFact= 1.0;
        double newResult= x;

        while (abs(result - newResult) > accuracy) {
            result = newResult;
            topFact = Math.pow(-1.0, n) * pow(x, 2*n + 1);
            botFact *= (2 * n) * (2 * n + 1);
            newResult += topFact / botFact;
            n++;
        }
        return newResult;
    }

}
