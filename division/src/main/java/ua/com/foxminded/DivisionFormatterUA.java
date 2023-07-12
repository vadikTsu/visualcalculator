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

public class DivisionFormatterUA extends DivisionFormatter {
    
    /**
     * Formats the result of an integer division according to UA region.
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
}
