package ua.com.foxminded;

public abstract class DivisionFormatter {

    /**
     * Formats the result of an integer division.
     *
     * @param divisionResult the DivisionResult object containing the division
     *                       result to format
     * @return a formatted string representing the division result
     */
    abstract String format(DivisionResult divisionResult);

    /**
     * Generates a string consisting of a specified number of the given character.
     *
     * @param number     the number of characters in the string
     * @param chararcter the character to repeat in the string
     * @return a string consisting of the specified number of characters
     */
    String repeatChar(int number, char character) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < number; i++) {
            repeated.append(character);
        }
        return repeated.toString();
    }

    /**
     * Calculates a number of integer characters.
     *
     * @param {@code number} integer
     * @return a number of characters
     */
    int claculateLengthOfInt(int number) {
        return (int) Math.log10(number) + 1;
    }
}
