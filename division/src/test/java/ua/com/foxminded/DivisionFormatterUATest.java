package ua.com.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DivisionFormatterUATest {
    
       private static String SEPARATOR = System.lineSeparator(); 
       private DivisionFormatterUA formatter;
        
       @BeforeEach
       void setup() {
           formatter = new DivisionFormatterUA();
       }


    
    @Test
    void  format_shouldRReturnNullPointerException_whenNull() {
        assertThrows(NullPointerException.class, () -> {
            formatter.format(null);
        });
    }
    
    @Test
    void divideInt_shouldReturnFormattedString_WhenCasualDivisionResult_1() {
        DivisionResult actual = new DivisionResult(
                Arrays.asList(new DivisionStep(123, 123, 3), new DivisionStep(456, 369, 6)), 123, 123456, 87, 1003);

        String expected = 
                      " 123456│123"+SEPARATOR
                    + " 123   │----"+SEPARATOR
                    + " ---   │1003"+SEPARATOR
                    + "    456"+SEPARATOR
                    + "    369"+SEPARATOR
                    + "    ---"+SEPARATOR
                    + "     87"+SEPARATOR;
        assertEquals(expected, formatter.format(actual));
    }
    
    @Test
    void divideInt_shouldReturnFormattedString_WhenCasualDivisionResult_2() {
        
            DivisionResult actual = new DivisionResult(
                    Arrays.asList(new DivisionStep(10, 10, 2),
                            new DivisionStep(10, 10, 6)),10,100010001,1 ,10001000 );
        
        String expected = 
                    " 100010001│10"      +SEPARATOR
                  + " 10       │--------"+SEPARATOR
                  + " --       │10001000"+SEPARATOR
                  + "     10"            +SEPARATOR
                  + "     10"            +SEPARATOR
                  + "     --   "         +SEPARATOR
                  + "         1"         +SEPARATOR;
        assertEquals(expected, formatter.format(actual));
    }
    
    @Test
    void divideInt_shouldReturnFormattedString_WhenZeroDividend_3() {
        DivisionResult actual = new DivisionResult(Arrays.asList(new DivisionStep(0,0,1)), 132, 0, 0, 0);
        String expected = 
                  " 0│132"+SEPARATOR
                + " 0│-"+SEPARATOR
                + " -│0"+SEPARATOR
                + " 0"+SEPARATOR
                + "";
        assertEquals(expected, formatter.format(actual));
    }
}
