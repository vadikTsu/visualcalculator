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
            integerDivision.divide(0, 0);
        });
    }

    @Test
    void divideInt_shouldReturnFormattedQuotientAndResult_WhenCasualInput_1() {
        String expectedResult = 
                  "_147\n"
                  + " 140\n"
                  + " ---\n"
                  + "  _78\n"
                  + "   60\n"
                  + "   --\n"
                  + "  _189\n"
                  + "   180\n"
                  + "   ---\n"
                  + "     9\n"
                  + "";

        String expectedQuotient = "739";

        assertEquals(expectedResult, integerDivision.divide(14789, 20).result.toString());
        assertEquals(expectedQuotient, integerDivision.divide(14789, 20).quotient.toString());
    }

    @Test
    void divideInt_shouldReturnFormattedString_WhenCasualInputUAFormatting_2() {
        String expected = "_10000│1000\n" + 
                          " 1000 │--\n" + 
                          " ---- │10\n" + 
                          "     0\n";

        assertEquals(expected, new DivisionFormatterUA().format(integerDivision.divide(10000, 1000)));
    }
}
