/*
 * @(#)DivisionFormatter.java
 * 
 * Provides formatting operations for the result of an integer division in IntDivision class,
 * which is used to divide integers.
 * Can be inherited to provide new formatting styles.
 *
 * Author: Vadym Tsudenko
 * 
 * Date: July 8, 2023
 * 
 * Copyright (c) 1994, 2023, Oracle and/or its affiliates. 
 * All rights reserved 
 */
package ua.com.foxminded;

public class DivisionFormatter {
    
    /**
     * Formats the result of an integer division.
     *
     * @param divRes the DivisionResult object containing the division result to format
     * @return a formatted string representing the division result
     */
    public String format(DivisionResult divRes) {
        int[] index = new int[3];
        for (int i = 0, j = 0; i < divRes.result.length(); i++) {
            if (divRes.result.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }
            if (j == 3) {
                break;
            }
        }

        int tab = calculateDigits(divRes.dividend) + 1 - index[0];
        divRes.result.insert(index[2], assamblyString(tab, ' ') + "│" + divRes.quotient.toString());
        divRes.result.insert(index[1], assamblyString(tab, ' ') + "│" + assamblyString(divRes.quotient.length(), '-'));
        divRes.result.insert(index[0], "│" + divRes.divisor);
        divRes.result.replace(1, index[0], divRes.dividend.toString());

        return divRes.result.toString();
    }
    
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
