import elements.Calculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


// this test will fail due to unknow reason.


public class TestCalculation {
    double result;
    Calculation c = new Calculation();
    @Test
    public void testCalculateDelta(){
        result = c.calculateDelta(1,2,4);
        assertEquals(0,result);
    }



}
