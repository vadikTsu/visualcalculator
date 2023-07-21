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

    private final String NEW_LINE = System.lineSeparator();

    /**
     * Formats the result of an integer division according to UA region.
     *
     * @param divisionResult the DivisionResult object containing the division result to
     *               format
     * @return a formatted string representing the division result
     */
    public String format(DivisionResult divisionResult) {
        StringBuilder result = new StringBuilder();

        int len = String.valueOf(divisionResult.dividend).length();
        int mulLen;

        for (int i = 0; i < divisionResult.divisionSteps.size(); i++) {
            mulLen = divisionResult.divisionSteps.get(i).multiple.toString().length();
            result.append(String.format(" %" + (divisionResult.divisionSteps.get(i).pointer) + "s",
                    divisionResult.divisionSteps.get(i).reminder)).append(NEW_LINE);
            result.append(String.format(" %" + (divisionResult.divisionSteps.get(i).pointer) + "s",
                    divisionResult.divisionSteps.get(i).multiple)).append(NEW_LINE);
            result.append(String.format(" %s%s%s", createString(divisionResult.divisionSteps.get(i).pointer - mulLen, ' '),
                    createString(mulLen, '-'), createString(len - divisionResult.divisionSteps.get(i).pointer, ' ')))
                    .append(NEW_LINE);
        }

        result.append(String.format(" %" + len + "s", divisionResult.fraction)).append(NEW_LINE);

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

        result.insert(index[2], "│" + divisionResult.quotient.toString());
        result.insert(index[1], createString(len - divisionResult.divisionSteps.get(0).pointer, ' ') + "│"
                + createString(divisionResult.quotient.toString().length(), '-'));
        result.insert(index[0], "│" + divisionResult.divisor);
        result.replace(1, index[0], divisionResult.dividend.toString());

        return result.toString();
    }
}
