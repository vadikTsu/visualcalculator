package ua.com.foxminded;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DivisionFormatterTest {
    
    @Test
    void  format_shouldRReturnNullPointerException_whenNull() {
        assertThrows(NullPointerException.class, () -> {
            new DivisionFormatter().format(null);
        });
    }
    //TODO implement other tests 
}
