package code;

import code.funcs.*;
import code.funcs.log.Ln;
import code.funcs.log.Log;
import code.funcs.trig.Cos;
import code.funcs.trig.Sec;
import code.funcs.trig.Sin;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Sin sin = new Sin(0.1);
        Ln ln = new Ln(0.001);
        Log log10 = new Log(10, 0.0001);
        Log log2 = new Log(2, 0.0001);
        Cos cos = new Cos(0.001);
        Sec sec = new Sec(0.001);

        try {
            CsvWriter.write(ln, -10.0, 3.0, 0.5);
        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        FinalFunction finalFunction = new FinalFunction(ln, log10, log2, sin, cos, sec);
//        System.out.println(
//                finalFunction.calculate(2));

    }
}
