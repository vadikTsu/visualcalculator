package ua.com.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerDivisionTest {

    private IntegerDivision integerDivision;

    @BeforeEach
    void setup() {
        integerDivision = new IntegerDivision();
    }

    @Test
    void divideInt_shouldReturnIllegalArgumentException_WhenDivisorIsZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            integerDivision.divideInt(0, 0, 0);
        });
    }

    @Test
    void divideInt_shouldReturnNullPointerException_WhenNull() {
        assertThrows(NullPointerException.class, () -> {
            integerDivision.divideInt(null, null, null);
        });
    }

    @Test
    void divideInt_shouldReturnFormattedString_WhenCasualInput_1() {
        String expected = "_14789│20\n" + 
                          " 140  │---\n" + 
                          " ---  │739\n" + 
                         "  _78\n" + 
                         "   60\n" + 
                         "   --\n" + 
                         "  _189\n" + 
                         "   180\n" + 
                         "   ---\n" + 
                         "     9\n";

        assertEquals(expected, integerDivision.divideInt(14789, 20, 0));
    }

    @Test
    void divideInt_shouldReturnFormattedString_WhenCasualInput_2() {
        String expected = "_10000│1000\n" + 
                          " 1000 │--\n" + 
                          " ---- │10\n" + 
                          "     0\n";

        assertEquals(expected, integerDivision.divideInt(10000, 1000, 0));
    }
    
    @Test
    void divideInt_shouldReturnFormattedString_WhenNotZeroCapacity() {
        String expected = 
                  "_14│3\n"
                + " 12│------\n"
                + " --│4.6666\n"
                + "  2\n"
                + " _20\n"
                + "  18\n"
                + "  --\n"
                + "  _20\n"
                + "   18\n"
                + "   --\n"
                + "   _20\n"
                + "    18\n"
                + "    --\n"
                + "    _20\n"
                + "     18\n"
                + "     --\n"
                + "";
        
        assertEquals(expected, integerDivision.divideInt(14, 3, 4));
    }
    
}
