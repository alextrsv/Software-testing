package code;

import code.funcs.trig.Cos;
import code.funcs.trig.Sec;
import code.funcs.trig.Sin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigonometrTest {

    final double accuracy = 0.00001;

    static Sin sinStub = Mockito.mock(Sin.class);
    static Cos cosStub = Mockito.mock(Cos.class);
    static Sec secStub = Mockito.mock(Sec.class);


    @BeforeAll
    static void initStubs(){
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
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI, -Math.PI/2, -Math.PI/6, 0, Math.PI/6, Math.PI/2, Math.PI})
    void checkSimpleSinValues(double x) {
        Sin sin = new Sin(accuracy);
        assertEquals(sinStub.calculate(x), sin.calculate(x), accuracy);
    }
    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI, -Math.PI/2, -Math.PI/6, 0, Math.PI/6, Math.PI/2, Math.PI})
    void checkSimpleCosValues(double x) {
        Cos cos = new Cos(accuracy);
        assertEquals(cosStub.calculate(x), cos.calculate(x), accuracy);
    }
    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI, -2*Math.PI/3, -Math.PI/2, -Math.PI/3, 0, Math.PI/3, Math.PI/2, 2*Math.PI/3, Math.PI})
    void checkSimpleSecValues(double x) {
        Sec sec = new Sec(accuracy);
        assertEquals(secStub.calculate(x), sec.calculate(x), accuracy);
    }

}
