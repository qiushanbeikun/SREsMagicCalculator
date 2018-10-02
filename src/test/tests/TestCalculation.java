import elements.Calculation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;



// this test will fail due to unknow reason.


    public class TestCalculation {
        double result;
        Calculation c = new Calculation();
        @Test
        public void testCalculateDelta(){
            result = c.calculateDelta(1,2,1);
            assertEquals(0,result);
        }

    @Test
    public void restCalculateRoot1(){
        result = c.calculateAnswerOne(1,-3,2);
        assertEquals(2,result);
    }

    @Test
    public void restCalculateRoot2(){
        result = c.calculateAnswerTwo(1,-3,2);
        assertEquals(1,result);
    }


}
