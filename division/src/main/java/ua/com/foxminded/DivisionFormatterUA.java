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

import java.util.stream.Collectors;

public class DivisionFormatterUA extends DivisionFormatter {

    private final String NEW_LINE = System.lineSeparator();

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
        int mulLen;

        for (int i = 0; i < divisionRes.reminderList.size(); i++) {
            mulLen = divisionRes.multipleList.get(i).toString().length();
            result.append(
                    String.format(" %" + (divisionRes.pointerList.get(i)) + "s", divisionRes.reminderList.get(i)))
                    .append(NEW_LINE);
            result.append(
                    String.format(" %" + (divisionRes.pointerList.get(i)) + "s", divisionRes.multipleList.get(i)))
                    .append(NEW_LINE);
            result.append(String.format(" %s%s%s", createString(divisionRes.pointerList.get(i) - mulLen, ' '),
                    createString(mulLen, '-'), createString(len - divisionRes.pointerList.get(i), ' ')))
                    .append(NEW_LINE);

        }
        result.append(String.format(" %" + len + "s", divisionRes.fraction)).append(NEW_LINE);

        int[] index = new int[3];
        for (int i = 0, j = 0; i < result.length(); i++) {
            if (result.indexOf(NEW_LINE, i) == i) {
                index[j] = i;
                j++;
            }
            if (j == 3) {
                break;
            }
        }

        result.insert(index[2],
                "│" + divisionRes.quotientList.stream().map(Object::toString).collect(Collectors.joining()));

        result.insert(index[1], createString(len - divisionRes.pointerList.get(0), ' ') + "│"
                + createString(divisionRes.quotientList.size(), '-'));
        result.insert(index[0], "│" + divisionRes.divisor);
        result.replace(1, index[0], divisionRes.dividend.toString());

        return result.toString();
    }
}
