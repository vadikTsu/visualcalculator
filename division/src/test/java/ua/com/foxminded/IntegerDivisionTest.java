package ua.com.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

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
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            integerDivision.divide(0, 0);
        });

        assertEquals("Illegal argument! Division by Zero.", exception.getMessage());
    }

    @Test
    void divide_shouldReturnFormattedQuotientAndResult_WhenCasualInput() {
        DivisionResult expected = new DivisionResult(
                Arrays.asList(new DivisionStep(123, 123, 3), new DivisionStep(456, 369, 6)), 123, 123456, 87, 1003);

        assertEquals(expected, integerDivision.divide(123456, 123));
    }

    @Test
    void divide_shouldReturnFormattedQuotientAndResult_WhenTenIsDivisor() {
        DivisionResult expected = new DivisionResult(
                Arrays.asList(new DivisionStep(10, 10, 2), new DivisionStep(10, 10, 6)), 10, 100010001, 1, 10001000);

        assertEquals(expected, integerDivision.divide(100010001, 10));
    }

    @Test
    void divide_shouldReturnFormattedQuotientAndResult_WhenZeroDividendInput() {
        DivisionResult expected = new DivisionResult(Arrays.asList(new DivisionStep(0, 0, 1)), 12, 0, 0, 0);

        assertEquals(expected, integerDivision.divide(0, 12));
    }
}
