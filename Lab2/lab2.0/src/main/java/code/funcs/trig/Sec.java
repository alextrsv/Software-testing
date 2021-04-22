package code.funcs.trig;

import code.funcs.Function;

public class Sec extends Function {
    Cos cos;

    public Sec(double accuracy){
        this.accuracy = accuracy;
        cos = new Cos(accuracy);
    }

    public Sec(double accuracy, Cos cos){
        this.accuracy = accuracy;
        this.cos = cos;
    }

    public Double calculate(double x) {
        if ((x-Math.PI/2) % Math.PI != 0){
            return 1 / cos.calculate(x);
        }
        else {
            return Double.NaN;
        }
    }

    @Override
    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
        this.cos.setAccuracy(accuracy);
    }

    public Cos getCos() {
        return cos;
    }

    public void setCos(Cos cos) {
        this.cos = cos;
    }
}
