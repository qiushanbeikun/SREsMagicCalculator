import equation.Coefficient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestValues {

    @Test
    public void testChange(){
        Coefficient c = new Coefficient(1.0,1);
        assertTrue(c.getValue() == 1.0);
        c.changeValue(2.0);
        assertTrue(c.getValue()==2.0);
    }

    @Test
    public void testChangeSign(){
        Coefficient c = new Coefficient(1.0,1);
        assertTrue(c.getValue()==1.0);
        c.changeSign();
        assertTrue(c.getValue()==-1.0);
    }
}
