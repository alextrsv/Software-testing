package code.funcs.log;

import code.funcs.Function;

public class Log extends Function {
    private Ln ln;
    private double base;

    public Log(double base, double accuracy){
        this.accuracy = accuracy;
        this.ln = new Ln(accuracy);
        this.base = base;
    }
    public Log(double base, double accuracy, Ln ln){
        this.accuracy = accuracy;
        this.ln = ln;
        this.base = base;
    }

    public Double calculate(double x){
        if (this.base <= 0 || this.base == 1) return Double.NaN;
        return ln.calculate(x) / ln.calculate(base);
    }

    @Override
    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
        this.ln.setAccuracy(accuracy);

    }

    public Ln getLn() {
        return ln;
    }

    public void setLn(Ln ln) {
        this.ln = ln;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }
}
