/*
 * @(#)IntDivision.java
 * 
 * This file is a part of the VisualCalculator project.
 * It contains the definition of the IntDivision class,
 * which is used to divide integers.
 *
 * Author: Vadym Tsudenko
 * 
 * Date: July 8, 2023
 * 
 * Copyright (c) 1994, 2023, Oracle and/or its affiliates. 
 * All rights reserved 
 */
package ua.com.foxminded;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivision {

    /**
     * Returns a DivisionResult object with a integer division algorithm.
     * <p>
     * This method takes a dividend, divisor as input, performs integer division,
     * displaying the steps of the division algorithm. *
     * 
     * @param dividend the dividend to be divided (an integer)
     * @param divisor  the divisor (an integer)
     * @throws IllegalArgumentException if the divisor is zero
     * @return a DivisionResult object representing the integer division algorithm
     * @author vadimtsudenko@gmail.com
     * @see {@link DivisionFormatter}
     * @see {@link DivisionResult}
     * @see {@link DivisionStep}
     */
    public DivisionResult divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Illegal argument! Division by Zero.");
        }
    
        int dividendSize = (int) Math.log10(Math.abs(dividend)) + 1;
        int[] dividendDigits = this.spliToDigits(dividend);
        int rightIndex = 0;
        int reminder = dividendDigits[rightIndex];
        List<DivisionStep> divisionSteps = new ArrayList<>();
        Integer quotient = 0;
        
        if (dividend == 0) {
            divisionSteps.add(new DivisionStep(reminder, reminder / divisor * divisor, rightIndex + 1));
        }
        while (rightIndex < dividendSize - 1) {

            if (reminder >= divisor) {
                quotient += reminder / divisor;
                divisionSteps.add(new DivisionStep(reminder, reminder / divisor * divisor, rightIndex + 1));
                reminder = reminder % divisor;
            }

            rightIndex++;

            reminder = reminder * 10 + dividendDigits[rightIndex];
            quotient *= 10;

        }

        quotient += reminder / divisor;
        if (reminder >= divisor) {
            divisionSteps.add(new DivisionStep(reminder, reminder / divisor * divisor, rightIndex + 1));
        }

        int lastReminder = reminder % divisor;
        return new DivisionResult(divisionSteps, divisor, dividend, lastReminder, quotient);
    }

    private int[] spliToDigits(int number) {
        String numberString = String.valueOf(number);
        int[] digits = new int[numberString.length()];
        for (int i = 0; i < numberString.length(); i++) {
            char digitChar = numberString.charAt(i);
            digits[i] = Character.getNumericValue(digitChar);
        }
        return digits;
    }

}
