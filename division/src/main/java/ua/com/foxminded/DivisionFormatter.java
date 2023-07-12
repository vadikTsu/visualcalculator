package ua.com.foxminded;

public abstract class DivisionFormatter {

    /**
     * Formats the result of an integer division.
     *
     * @param divRes the DivisionResult object containing the division result to format
     * @return a formatted string representing the division result
     */
    abstract public String format(DivisionResult divRes);
    
    /**
     * Calculates the number of digits in an integer.
     *
     * @param num the integer value to calculate the number of digits for
     * @return the number of digits in the given integer
     */
    static int calculateDigits(int num) {
        return (int) Math.log10(num) + 1;
    }

    /**
     * Creates a divider string with the specified number of characters and indentation.
     *
     * @param bufferNum (the number used to calculate the length of the divider)
     * @param tab (the number of spaces for indentation)
     * @return a string representing the divider
     */
    static String makeDivider(Integer bufferNum, Integer tab) {
        return assamblyString(tab, ' ') + assamblyString(calculateDigits(bufferNum), '-');
    }
    
    /**
     * Generates a string consisting of a specified number of the given character.
     *
     * @param num the number of characters in the string
     * @param c the character to repeat in the string
     * @return a string consisting of the specified number of characters
     */
    static String assamblyString(int num, char c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(c);
        }
        return sb.toString();
    }
}
