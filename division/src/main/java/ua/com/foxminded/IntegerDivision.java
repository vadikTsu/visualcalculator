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
     * @return a well-formatted string representing the integer division algorithm
     * @author vadimtsudenko@gmail.com
     */
    public DivisionResult divide(int dividend, int divisor) {
        StringBuilder result = new StringBuilder();
        StringBuilder quotient = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        if (divisor == 0) {
            
            throw new IllegalArgumentException("Cannot divide by zero");
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        String[] digits = String.valueOf(dividend).split("");
        Integer bufferNum;
        Integer entire;
        Integer fraction;
        Integer divisorDigits = DivisionFormatter.calculateDigits(divisor);

        if (dividend < divisor) {
            quotient.append("0.");
        }

        for (int i = 0; i < digits.length; i++) {
            buffer.append(digits[i]);
            bufferNum = Integer.parseInt(buffer.toString());
            if (bufferNum >= divisor) {
                fraction = bufferNum % divisor;
                entire = bufferNum / divisor * divisor;
                String lastReminder = String.format("%" + (i + 2) + "s", "_" + bufferNum.toString());
                result.append(lastReminder).append("\n");

                String multiply = String.format("%" + (i + 2) + "d", entire);
                result.append(multiply).append("\n");

                Integer tab = lastReminder.length() - DivisionFormatter.calculateDigits(entire);
                result.append(DivisionFormatter.makeDivider(bufferNum, tab)).append("\n");

                quotient.append(bufferNum / divisor);

                buffer.replace(0, buffer.length(), fraction.toString());
                bufferNum = Integer.parseInt(buffer.toString());

            } else {
                if (i >= divisorDigits) {
                    quotient.append(0);
                }
            }

            if (i == digits.length - 1) {
                result.append(String.format("%" + (i + 2) + "s", bufferNum.toString())).append("\n");
            }
        }

        return new DivisionResult(quotient, result, dividend, divisor);
    }
}

