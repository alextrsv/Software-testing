import firstTask.Calc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalcTest {

    @BeforeEach
    public void start(){
    }

    @ParameterizedTest
    @ValueSource(doubles = {  1.1, -1.1})
    void isOdz(double x){
        Calc calc = new Calc();
        assertEquals(Double.NaN, calc.arcsin(x));
    }

    @Test
    void isZero(){
        Calc calc = new Calc();
        assertEquals(0, calc.arcsin(0));
    }

    @Test
    void isNaN(){
        Calc calc = new Calc();
        assertEquals(Double.NaN, calc.arcsin(Double.NaN));
    }

    //value testing

    @ParameterizedTest
    @CsvSource({
            "1, 1.57",
            "0.1, 0.1",
            "0.31, 0.32",
            "0.52, 0.55",
            "0.73, 0.82",
            "-1, -1.57"
    })
    public void testValue(double x, double ex){
        Calc calc = new Calc(0.01);
        assertEquals(ex, calc.arcsin(x), 0.01);
    }


}