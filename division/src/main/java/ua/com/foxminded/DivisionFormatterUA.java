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
     * @param divisionResult the DivisionResult object containing the division
     *                       result to format
     * @return a formatted string representing the division result
     */
    public String format(DivisionResult divisionResult) {
        StringBuilder result = new StringBuilder();

        int dividentSize = String.valueOf(divisionResult.getDividend()).length();
        int multipleSize;

        for (int i = 0; i < divisionResult.divisionSteps.size(); i++) {
            multipleSize = divisionResult.divisionSteps.get(i).getMultiple().toString().length();
            result.append(String.format(" %" + (divisionResult.divisionSteps.get(i).getPointer()) + "s",
                    divisionResult.divisionSteps.get(i).getReminder())).append(NEW_LINE);
            result.append(String.format(" %" + (divisionResult.divisionSteps.get(i).getPointer()) + "s",
                    divisionResult.divisionSteps.get(i).getMultiple())).append(NEW_LINE);
            result.append(String.format(" %s%s%s",
                    repeatString(divisionResult.divisionSteps.get(i).getPointer() - multipleSize, ' '),
                    repeatString(multipleSize, '-'),
                    repeatString(dividentSize - divisionResult.divisionSteps.get(i).getPointer(), ' ')))
                    .append(NEW_LINE);
        }

        result.append(String.format(" %" + dividentSize + "s", divisionResult.getFraction())).append(NEW_LINE);

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

        result.insert(index[2], "│" + divisionResult.getQuotient().toString());
        result.insert(index[1], repeatString(dividentSize - divisionResult.divisionSteps.get(0).getPointer(), ' ') + "│"
                + repeatString(divisionResult.getQuotient().toString().length(), '-'));
        result.insert(index[0], "│" + divisionResult.getDivisor());
        result.replace(1, index[0], divisionResult.getDividend().toString());

        return result.toString();
    }
}
