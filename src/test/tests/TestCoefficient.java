import elements.Coefficient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


// this test will fail due to unknown reason

public class TestCoefficient {

    Coefficient c = new Coefficient(0);
    @Test
    public void testChangeValue(){
        assertTrue(c.getCoevalue()==1);
        c.changeValue(2);
        assertTrue(c.getCoevalue()==2);
    }
}
