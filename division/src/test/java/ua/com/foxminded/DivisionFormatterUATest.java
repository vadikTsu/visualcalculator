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
        DivisionResult actualResult = new DivisionResult(Arrays.asList(987, 398, 292, 463),
                Arrays.asList(984, 369, 246, 369), Arrays.asList(3, 5, 6, 7), 123, 9879823, 94,
                Arrays.asList(8, 3, 2, 3));
        String expectedOutput = 
                    " 9879823│123"+SEPARATOR
                  + " 984    │----"+SEPARATOR
                  + " ---    │8323"+SEPARATOR
                  + "   398"+SEPARATOR
                  + "   369"+SEPARATOR
                  + "   ---  "+SEPARATOR
                  + "    292"+SEPARATOR
                  + "    246"+SEPARATOR
                  + "    --- "+SEPARATOR
                  + "     463"+SEPARATOR
                  + "     369"+SEPARATOR
                  + "     ---"+SEPARATOR
                  + "      94"+SEPARATOR
                  + "";
        assertEquals(expectedOutput, formatter.format(actualResult));
    }
    
    @Test
    void divideInt_shouldReturnFormattedString_WhenCasualDivisionResult_2() {
        DivisionResult actualResult = new DivisionResult(Arrays.asList(1234, 2085, 3367, 2898),
                Arrays.asList(1026, 2052, 3078, 2736), Arrays.asList(4, 5, 7, 8), 342, 12345678, 162,
                Arrays.asList(3, 6, 9, 8));
        String expectedOutput = 
                  " 12345678│342"+SEPARATOR
                + " 1026    │----"+SEPARATOR
                + " ----    │3698"+SEPARATOR
                + "  2085"+SEPARATOR
                + "  2052"+SEPARATOR
                + "  ----   "+SEPARATOR
                + "    3367"+SEPARATOR
                + "    3078"+SEPARATOR
                + "    ---- "+SEPARATOR
                + "     2898"+SEPARATOR
                + "     2736"+SEPARATOR
                + "     ----"+SEPARATOR
                + "      162"+SEPARATOR
                + "";
        assertEquals(expectedOutput, formatter.format(actualResult));
    }
    
    @Test
    void divideInt_shouldReturnFormattedString_WhenZeroDividend_3() {
        DivisionResult actualResult = new DivisionResult(Arrays.asList(0),
                Arrays.asList(0), Arrays.asList(1), 132, 0, 0,
                Arrays.asList(0));
        String expectedOutput = 
                  " 0│132"+SEPARATOR
                + " 0│-"+SEPARATOR
                + " -│0"+SEPARATOR
                + " 0"+SEPARATOR
                + "";
        assertEquals(expectedOutput, formatter.format(actualResult));
    }
}
