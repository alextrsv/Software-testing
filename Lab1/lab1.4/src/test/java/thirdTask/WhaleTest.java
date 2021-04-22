package thirdTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class WhaleTest {

    Sentient whale1;

    @BeforeEach
    public void initRBTree(){
        whale1 = new Whale();
    }


    @ParameterizedTest
    @CsvSource({
            "9, 48, 45",
            "-9, -53, 0",
            "-11, 48, 45",
            "12, 0, 0"
    })
    public void testChangePos(double x, double y, double z){
        whale1.changePosition(x, y, z); //ok
        assertEquals(x + " " + y+ " " + z, whale1.getCoordsAsString() );
    }

    @ParameterizedTest
    @ValueSource(strings = {  "whale", "not whale"})
    public void testChangeDetermination(String determination){
        whale1.changeDetermination(determination); //ok
        assertEquals(determination, whale1.getDetermination() );
    }


    @ParameterizedTest
    @CsvSource({
            "9, 48, 45, whale",
            "-9, -53, 0, not whale",
            "-11, 48, 45, not whale",
            "12, 0, 0, not whale"
    })
    public void testDet(double x, double y, double z, String det){
        whale1.changePosition(x, y, z); //ok
        assertEquals("I am "+det, whale1.whoAmI());
    }

    @ParameterizedTest
    @CsvSource({
            "9, 48, 45, 500",
            "-9, -53, 0, 250",
            "-3, 48, 45, 500",
            "12, 0, 0, 250"
    })
    public void testDetTime(double x, double y, double z, int detTime){
        whale1.changePosition(x, y, z); //ok
        assertEquals(detTime, whale1.getDeterminationTime());
    }
}