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
        
        for (int i = 0; i < divisionResult.getDivisionSteps().size(); i++) {

            multipleSize = divisionResult.getDivisionSteps().get(i).getMultiple().toString().length();
            result.append(String.format(" %s%s%s",
                    repeatChar(divisionResult.getDivisionSteps().get(i).getPointer() - multipleSize, ' '),
                    divisionResult.getDivisionSteps().get(i).getReminder(),
                    repeatChar(dividentSize - divisionResult.getDivisionSteps().get(i).getPointer(), ' '))).append(NEW_LINE);
            result.append(String.format(" %s%s%s",
                    repeatChar(divisionResult.getDivisionSteps().get(i).getPointer() - multipleSize, ' '),
                    divisionResult.getDivisionSteps().get(i).getMultiple(),
                    repeatChar(dividentSize - divisionResult.getDivisionSteps().get(i).getPointer(), ' '))).append(NEW_LINE);
            result.append(String.format(" %s%s%s",
                    repeatChar(divisionResult.getDivisionSteps().get(i).getPointer() - multipleSize, ' '),
                    repeatChar(multipleSize, '-'),
                    repeatChar(dividentSize - divisionResult.getDivisionSteps().get(i).getPointer(), ' '))).append(NEW_LINE);
        }

        result.append(String.format(" %" + dividentSize + "s", divisionResult.getFraction())).append(NEW_LINE);
        
        return formatDivisionAlgorithmWithHead(result.toString() , divisionResult);
    }

    private String formatDivisionAlgorithmWithHead(String algorithmResult, DivisionResult divisionResult){
        String[] algorithmResultRows = algorithmResult.split(NEW_LINE);
        algorithmResultRows[0] = " "+divisionResult.getDividend()+"│"+ divisionResult.getDivisor();
        algorithmResultRows[1]+="│"
                + repeatChar(divisionResult.getQuotient().toString().length(), '-');
        algorithmResultRows[2]+="│" + divisionResult.getQuotient().toString();
        return String.join(NEW_LINE, algorithmResultRows);
    }
}
