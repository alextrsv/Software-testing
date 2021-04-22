package code.funcs.trig;

import code.funcs.Function;

public class Cos extends Function {
    Sin sin;

    public Cos(double accuracy){
        this.accuracy = accuracy;
        this.sin = new Sin(accuracy);
    }

    public Cos(double accuracy, Sin sin){
        this.accuracy = accuracy;
        this.sin = sin;
    }

    public Double calculate(double x) {
        return  1 - 2 * Math.pow(sin.calculate(x / 2),2); //формула половинного угла
    }

    @Override
    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
        this.sin.setAccuracy(accuracy);
    }

    public Sin getSin() {
        return sin;
    }

    public void setSin(Sin sin) {
        this.sin = sin;
    }
}
