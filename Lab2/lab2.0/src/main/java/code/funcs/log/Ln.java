package code.funcs.log;

import code.funcs.Function;

import static java.lang.Math.abs;

public class Ln extends Function {

    public Ln(double accuracy){
        this.accuracy = accuracy;
    }

    public Double calculate(double x) {
        if (x < 0) return Double.NaN;
        if (x == 0) return Double.NEGATIVE_INFINITY;
        double result = Double.MAX_VALUE;
        double n = 1.0;
        double newResult = 0.0;

        while (abs(result - newResult) > accuracy) {
            result = newResult;
            newResult += (Math.pow((x - 1) / (x + 1), 2 * n - 1)) / (2 * n - 1);
            n++;
        }
        return 2 * newResult;
    }
}
