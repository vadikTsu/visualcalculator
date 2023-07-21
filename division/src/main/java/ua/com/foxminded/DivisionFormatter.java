package ua.com.foxminded;

public abstract class DivisionFormatter {

    /**
     * Formats the result of an integer division.
     *
     * @param divRes the DivisionResult object containing the division result to
     *               format
     * @return a formatted string representing the division result
     */
    abstract public String format(DivisionResult divRes);


    /**
     * Generates a string consisting of a specified number of the given character.
     *
     * @param number the number of characters in the string
     * @param chararcter the character to repeat in the string
     * @return a string consisting of the specified number of characters
     */
    String repeatString(int number, char chararcter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(chararcter);
        }
        return sb.toString();
    }
}
