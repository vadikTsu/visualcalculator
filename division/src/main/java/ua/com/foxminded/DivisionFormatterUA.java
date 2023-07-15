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

import java.util.List;

public class DivisionFormatterUA extends DivisionFormatter {

    /**
     * Formats the result of an integer division according to UA region.
     *
     * @param divRes the DivisionResult object containing the division result to
     *               format
     * @return a formatted string representing the division result
     */
    public String format(DivisionResult divisionRes) {
        StringBuilder result = new StringBuilder();

        int len = String.valueOf(divisionRes.dividend).length();
        int lenDiv = String.valueOf(divisionRes.divisor).length();

        String reminderLine;
        String multipleLine;

        for (int i = 0; i < divisionRes.reminder.size(); i++) {
            if (i == 0) {
                reminderLine = String.format(" %" + (2 + i) + "d", divisionRes.dividend);
                multipleLine = String.format("-%d", divisionRes.multiple.get(i));
            } else {
                reminderLine = String.format(" %" + (len - divisionRes.exp.get(i)) + "s", divisionRes.reminder.get(i));
                multipleLine = String.format(" %" + (len - divisionRes.exp.get(i)) + "s", -divisionRes.multiple.get(i));
            }

            result.append(reminderLine).append("\n");

            result.append(multipleLine).append("\n");
            String separator = String.format(" %s%" + (lenDiv) + "s",
                    DivisionFormatter.assamblyString(len - divisionRes.exp.get(i) - lenDiv, ' '),
                    DivisionFormatter.assamblyString(lenDiv, '-'));
            result.append(separator).append("\n");

        }
        result.append(String.format(" %" + len + "s", divisionRes.fraction));

        int[] index = new int[3];
        for (int i = 0, j = 0; i < result.length(); i++) {
            if (result.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }
            if (j == 3) {
                break;
            }
        }

        int tab = DivisionFormatter.calculateDigits(divisionRes.dividend) + 1 - index[0];
        result.insert(index[2],
                DivisionFormatter.assamblyString(len - lenDiv - 1, ' ') + "│" + divisionRes.quotient.toString());
        result.insert(index[1], DivisionFormatter.assamblyString(len - lenDiv - 1, ' ') + "│"
                + DivisionFormatter.assamblyString(divisionRes.quotient.toString().length(), '-'));
        result.insert(index[0], "│" + divisionRes.divisor);
        result.replace(1, index[0], divisionRes.dividend.toString());

        return result.toString();
    }
}
