package firstTask;

import static java.lang.Math.abs;
import static java.lang.Math.pow;



public class Calc {

    public double accuracy;


    public Calc(){}

    public Calc(double accuracy){
        this.accuracy = accuracy;
    }
//    public double arcsin(double x){
//        if(x == 0) return 0.0;
//        if(Double.isNaN(x)) return Double.NaN;
//        if (x > 1 || x < -1) return Double.NaN;
//         double res = 0;
//        for(int n = 0; n < 100; n++){
//            double step = (factorial(2 * n) / (pow(2, 2 * n) * pow(factorial(n), 2))) * (pow(x, 2 * n + 1)) / (2 * n + 1);
//            res = res + step;
//        }
//        return res;
//    }

    public double arcsin(double x){
        if(x == 0) return 0.0;
        if(Double.isNaN(x)) return Double.NaN;
        if (x > 1 || x < -1) return Double.NaN;
        if (x == 1) return 1.57;
        if (x == -1) return -1.57;
        double res = 0;
        double step = 0;
        int n = 0;
        do {
            step = (factorial(2*n) *(pow(x, 2*n+1)))/(pow(4,n) * pow(factorial(n), 2) * (2*n + 1));
//            step = (factorial(2 * n) / (pow(2, 2 * n) * pow(factorial(n), 2))) * (pow(x, 2 * n + 1)) / (2 * n + 1);
            res = res + step;
            n++;
        } while (step > accuracy);
        System.out.println(n);
        return res;
    }


    public int factorial(int a){
        int res = 1;
        for(int i = 1; i <= a; i++){
            res = res * i;
        }
        return res;
    }

}
