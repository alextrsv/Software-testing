package code.funcs;

import code.funcs.log.Ln;
import code.funcs.log.Log;
import code.funcs.trig.Cos;
import code.funcs.trig.Sec;
import code.funcs.trig.Sin;

public class FinalFunction extends Function{
    private Ln ln;
    private Log log10;
    private Log log2;
    private Sin sin;
    private Cos cos;
    private Sec sec;

    public FinalFunction(Ln ln, Log log10, Log log2, Sin sin, Cos cos, Sec sec){
        this.ln = ln;
        this.log10 = log10;
        this.log2 = log2;
        this.sin = sin;
        this.cos = cos;
        this.sec = sec;
    }


    public Double calculate(double x) {
        Double res = 0.0;
        if (x < 0 || x == 0){
            if ( Math.abs((x / (Math.PI/2)) % 2) == 1 )
                res = Double.NaN;
            else
                res = (Math.pow(sin.calculate(x),3) * sin.calculate(x)) / ( (sec.calculate(x)/sin.calculate(x)) / (sec.calculate(x) * sec.calculate(x) ));
        }
        else if (x > 0){
            if (x == 1) res = Double.NaN;
            else
                res = ((((( Math.pow(log10.calculate(x),2)) * ln.calculate(x)) + log10.calculate(x)) + log10.calculate(x)) / (Math.pow(log2.calculate(x),3)));
        }
        return res;
    }
}
