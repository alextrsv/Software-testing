package code;


import code.funcs.log.Ln;
import code.funcs.log.Log;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogTest {

    final double accuracy = 0.00001;
    static Ln lnStub = Mockito.mock(Ln.class);
    static Log log2Stub = Mockito.mock(Log.class);
    static Log log10Stub = Mockito.mock(Log.class);

    @BeforeAll
    static void initStubs(){
        log2Stub.setBase(2);
        log10Stub.setBase(10);
        Mockito.when(lnStub.calculate(Mockito.anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]));
        Mockito.when(log2Stub.calculate(Mockito.anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]) / Math.log(2));
        Mockito.when(log10Stub.calculate(Mockito.anyDouble())).thenAnswer(i -> Math.log((Double) i.getArguments()[0]) / Math.log(10));
    }


    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.1, 0.4, 1.1, 2.0, 2.5, 3, 3.5})
    void checkSimpleLnValues(double x) {
        Ln ln = new Ln(accuracy);
        assertEquals(lnStub.calculate(x), ln.calculate(x), 0.001);
    }
    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.1, 0.4, 1.1, 2.0, 2.5, 3, 3.5})
    void checkSimpleLog2Values(double x) {
        Log log2 = new Log(2,accuracy);
        assertEquals(log2Stub.calculate(x), log2.calculate(x), 0.001);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, 0.1, 0.4, 1.1, 2.0, 2.5, 3, 3.5})
    void checkSimpleLog10Values(double x) {
        Log log10 = new Log(10, accuracy);
        assertEquals(log10Stub.calculate(x), log10.calculate(x), 0.001);
    }
}

