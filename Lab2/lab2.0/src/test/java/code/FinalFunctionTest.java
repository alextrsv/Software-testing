package code;

import static org.junit.Assert.*;


import code.funcs.*;
import code.funcs.log.Ln;
import code.funcs.log.Log;
import code.funcs.trig.Cos;
import code.funcs.trig.Sec;
import code.funcs.trig.Sin;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class FinalFunctionTest {
    final double accuracy = 0.00001;

    static Sin sinStub = Mockito.mock(Sin.class);
    static Cos cosStub = Mockito.mock(Cos.class);
    static Sec secStub = Mockito.mock(Sec.class);
    static Ln lnStub = Mockito.mock(Ln.class);
    static Log log2Stub = Mockito.mock(Log.class);
    static Log log10Stub = Mockito.mock(Log.class);


    @BeforeClass
    public static void setupStubs(){
        log2Stub.setBase(2);
        log10Stub.setBase(10);
        Mockito.when(sinStub.calculate(Mockito.anyDouble())).thenAnswer(i -> Math.sin((Double) i.getArguments()[0]));
        Mockito.when(cosStub.calculate(Mockito.anyDouble())).thenAnswer(i -> Math.cos((Double) i.getArguments()[0]));

        Mockito.when(secStub.calculate(Mockito.anyDouble())).thenAnswer(i -> {
            if (((Double) i.getArguments()[0]-Math.PI/2) % Math.PI != 0){
                return 1/Math.cos((Double) i.getArguments()[0]);
            }
            else {
                return Double.NaN;
            }
        });

        Mockito.when(lnStub.calculate(Mockito.anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]));
        Mockito.when(log2Stub.calculate(Mockito.anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]) / Math.log(2));
        Mockito.when(log10Stub.calculate(Mockito.anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]) / Math.log(10));
    }

    @Test
    public void testWithAllStubs(){
        FinalFunction finalFunction = new FinalFunction(lnStub, log10Stub, log2Stub, sinStub, cosStub, secStub);
        assertEquals(1.4937682, finalFunction.calculate(-2), accuracy);
        assertEquals(-3.1050446, finalFunction.calculate(-1.3), accuracy);
        assertEquals(-0.0056716106, finalFunction.calculate(-3.5), accuracy);
        assertEquals(0, finalFunction.calculate(0), accuracy);
        //rightPart
        assertEquals(0.068874357, finalFunction.calculate(0.001), accuracy);
        assertEquals(0.66487234, finalFunction.calculate(0.5), accuracy);
        assertEquals(26.120442, finalFunction.calculate(0.9), accuracy);
        assertEquals(31.905676, finalFunction.calculate(1.1), accuracy);
        assertEquals(1.8222898, finalFunction.calculate(1.5), accuracy);
        assertEquals(0.66487234, finalFunction.calculate(2.0), accuracy);
        assertEquals(0.076451872, finalFunction.calculate(100.0), accuracy);

    }
    @Test
    public void testWithSinCosLnLogStubs(){
        Sec sec = new Sec(accuracy, cosStub);
        FinalFunction finalFunction = new FinalFunction(lnStub, log10Stub, log2Stub, sinStub, cosStub, sec);
        assertEquals(1.4937682, finalFunction.calculate(-2), accuracy);
        assertEquals(-3.1050446, finalFunction.calculate(-1.3), accuracy);
        assertEquals(-0.0056716106, finalFunction.calculate(-3.5), accuracy);
        assertEquals(0, finalFunction.calculate(0), accuracy);
        //rightPart
        assertEquals(0.068874357, finalFunction.calculate(0.001), accuracy);
        assertEquals(0.66487234, finalFunction.calculate(0.5), accuracy);
        assertEquals(26.120442, finalFunction.calculate(0.9), accuracy);
        assertEquals(31.905676, finalFunction.calculate(1.1), accuracy);
        assertEquals(1.8222898, finalFunction.calculate(1.5), accuracy);
        assertEquals(0.66487234, finalFunction.calculate(2.0), accuracy);
        assertEquals(0.076451872, finalFunction.calculate(100.0), accuracy);
    }


    @Test
    public void testWithSinLnLogStubs(){
        Cos cos = new Cos(accuracy, sinStub);
        Sec sec = new Sec(accuracy);

        FinalFunction finalFunction = new FinalFunction(lnStub, log10Stub, log2Stub, sinStub, cos, sec);
        assertEquals(1.4937682, finalFunction.calculate(-2), accuracy);
        assertEquals(-3.1050446, finalFunction.calculate(-1.3), accuracy);
        assertEquals(-0.0056716106, finalFunction.calculate(-3.5), accuracy);
        assertEquals(0, finalFunction.calculate(0), accuracy);
        //rightPart
        assertEquals(0.068874357, finalFunction.calculate(0.001), accuracy);
        assertEquals(0.66487234, finalFunction.calculate(0.5), accuracy);
        assertEquals(26.120442, finalFunction.calculate(0.9), accuracy);
        assertEquals(31.905676, finalFunction.calculate(1.1), accuracy);
        assertEquals(1.8222898, finalFunction.calculate(1.5), accuracy);
        assertEquals(0.66487234, finalFunction.calculate(2.0), accuracy);
        assertEquals(0.076451872, finalFunction.calculate(100.0), accuracy);
    }

    @Test
    public void testWithLnLogStubs(){
        Sin sin = new Sin(accuracy);
        Cos cos = new Cos(accuracy);
        Sec sec = new Sec(accuracy);

        FinalFunction finalFunction = new FinalFunction(lnStub, log10Stub, log2Stub, sin, cos, sec);
        assertEquals(1.4937682, finalFunction.calculate(-2), accuracy);
        assertEquals(-3.1050446, finalFunction.calculate(-1.3), accuracy);
        assertEquals(-0.0056716106, finalFunction.calculate(-3.5), accuracy);
        assertEquals(0, finalFunction.calculate(0), accuracy);
        //rightPart
        assertEquals(0.068874357, finalFunction.calculate(0.001), accuracy);
        assertEquals(0.66487234, finalFunction.calculate(0.5), accuracy);
        assertEquals(26.120442, finalFunction.calculate(0.9), accuracy);
        assertEquals(31.905676, finalFunction.calculate(1.1), accuracy);
        assertEquals(1.8222898, finalFunction.calculate(1.5), accuracy);
        assertEquals(0.66487234, finalFunction.calculate(2.0), accuracy);
        assertEquals(0.076451872, finalFunction.calculate(100.0), accuracy);
    }

    @Test
    public void testWithLnStubs(){
        Sin sin = new Sin(accuracy);
        Cos cos = new Cos(accuracy);
        Sec sec = new Sec(accuracy);
        Log log2 = new Log(2,accuracy,lnStub);
        Log log10 = new Log(10,accuracy,lnStub);

        FinalFunction finalFunction = new FinalFunction(lnStub, log10, log2, sin, cos, sec);
        assertEquals(1.4937682, finalFunction.calculate(-2), accuracy);
        assertEquals(-3.1050446, finalFunction.calculate(-1.3), accuracy);
        assertEquals(-0.0056716106, finalFunction.calculate(-3.5), accuracy);
        assertEquals(0, finalFunction.calculate(0), accuracy);
        //rightPart
        assertEquals(0.068874357, finalFunction.calculate(0.001), accuracy);
        assertEquals(0.66487234, finalFunction.calculate(0.5), accuracy);
        assertEquals(26.120442, finalFunction.calculate(0.9), accuracy);
        assertEquals(31.905676, finalFunction.calculate(1.1), accuracy);
        assertEquals(1.8222898, finalFunction.calculate(1.5), accuracy);
        assertEquals(0.66487234, finalFunction.calculate(2.0), accuracy);
        assertEquals(0.076451872, finalFunction.calculate(100.0), accuracy);
    }

    @Test
    public void testWithNoStubs(){
        Sin sin = new Sin(accuracy);
        Cos cos = new Cos(accuracy);
        Sec sec = new Sec(accuracy);
        Ln ln = new Ln(accuracy);
        Log log2 = new Log(2,accuracy);
        Log log10 = new Log(10,accuracy);

        FinalFunction finalFunction = new FinalFunction(ln, log10, log2, sin, cos, sec);
        assertEquals(1.4937682, finalFunction.calculate(-2), accuracy);
        assertEquals(-3.1050446, finalFunction.calculate(-1.3), accuracy);
        assertEquals(-0.0056716106, finalFunction.calculate(-3.5), accuracy);
        assertEquals(0, finalFunction.calculate(0), accuracy);
        //rightPart
        assertEquals(0.068874357, finalFunction.calculate(0.001), accuracy);
        assertEquals(0.66487234, finalFunction.calculate(0.5), accuracy);
        assertEquals(31.905676, finalFunction.calculate(1.1), 0.01);
        assertEquals(1.8222898, finalFunction.calculate(1.5), 0.01);
        assertEquals(0.66487234, finalFunction.calculate(2.0), 0.01);
        assertEquals(0.076451872, finalFunction.calculate(100.0), 0.01);

    }



    @Test
    public void testCos(){
        Cos cos = new Cos(accuracy, sinStub);
        assertEquals(cosStub.calculate(Math.PI), cos.calculate(Math.PI),accuracy);
        assertEquals(cosStub.calculate(Math.PI/2), cos.calculate(Math.PI/2),accuracy);
        assertEquals(cosStub.calculate(Math.PI/4), cos.calculate(Math.PI/4),accuracy);
    }

    @Test
    public void testSec(){
        Sec sec = new Sec(accuracy, cosStub);
        assertEquals(secStub.calculate(Math.PI), sec.calculate(Math.PI),accuracy);
        assertEquals(secStub.calculate(Math.PI/2), sec.calculate(Math.PI/2),accuracy);
        assertEquals(secStub.calculate(Math.PI/4), sec.calculate(Math.PI/4),accuracy);
    }

    @Test
    public void testLogWithLn(){
        Log log2 = new Log(2,accuracy, lnStub);
        Log log10 = new Log(10,accuracy, lnStub);
        assertEquals(log2Stub.calculate(Math.PI), log2.calculate(Math.PI),accuracy);
        assertEquals(log2Stub.calculate(Math.PI/2), log2.calculate(Math.PI/2),accuracy);
        assertEquals(log2Stub.calculate(Math.PI/4), log2.calculate(Math.PI/4),accuracy);
        assertEquals(log10Stub.calculate(Math.PI), log10.calculate(Math.PI),accuracy);
        assertEquals(log10Stub.calculate(Math.PI/2), log10.calculate(Math.PI/2),accuracy);
        assertEquals(log10Stub.calculate(Math.PI/4), log10.calculate(Math.PI/4),accuracy);
    }
}