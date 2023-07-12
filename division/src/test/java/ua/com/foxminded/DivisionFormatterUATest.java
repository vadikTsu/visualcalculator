package ua.com.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivisionFormatterUATest {
    
    @Test
    void  format_shouldRReturnNullPointerException_whenNull() {
        assertThrows(NullPointerException.class, () -> {
            new DivisionFormatterUA().format(null);
        });
    }
    //TODO implement other tests 
}
