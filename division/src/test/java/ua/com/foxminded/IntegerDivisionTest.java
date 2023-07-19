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
        assertThrows(IllegalArgumentException.class, () -> {
            integerDivision.divide(0, 0);
        });
    }

    @Test
    void divideInt_shouldReturnFormattedQuotientAndResult_WhenCasualInput_1() {
        DivisionResult expectedResult = new DivisionResult(Arrays.asList(123, 456), 
                Arrays.asList(123, 369), Arrays.asList(3,6), 123, 123456, 87, Arrays.asList(1,3));


        assertEquals(expectedResult, integerDivision.divide(123456, 123));
    }

    @Test
    void divideInt_shouldReturnFormattedQuotientAndResult_WhenCasualInput_2() {
        DivisionResult expectedResult = new DivisionResult(Arrays.asList(1234, 2085,3367,2898), Arrays.asList(1026, 2052,3078,2736),
                Arrays.asList(4, 5,7 , 8), 342, 12345678, 162, Arrays.asList(3,6,9,8));

        assertEquals(expectedResult, integerDivision.divide(12345678, 342));
    }
    
    @Test
    void divideInt_shouldReturnFormattedQuotientAndResult_WhenCasualInput_3() {
        DivisionResult expectedResult = new DivisionResult(Arrays.asList(987, 398,292,463), Arrays.asList(984, 369,246,369),
                Arrays.asList(3, 5,6 , 7), 123, 9879823, 94, Arrays.asList(8,3,2,3));
        
        assertEquals(expectedResult, integerDivision.divide(9879823, 123));
    }
}


