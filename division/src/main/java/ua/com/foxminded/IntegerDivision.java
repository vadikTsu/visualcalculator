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

    private StringBuilder result = new StringBuilder();
    private StringBuilder quotient = new StringBuilder();
    private StringBuilder buffer = new StringBuilder();

    /**
     * Returns a string with a formatted integer division algorithm.
     * <p>
     * This method takes a dividend, divisor, capacity as input, performs integer
     * division, displaying the steps of the division algorithm. Capacity allows you
     * to define count of digits after point, when quotient is not an integer
     *
     * @param dividend the dividend to be divided (an integer)
     * @param divisor  the divisor (an integer)
     * @param capacity the count of digits after point (an integer)
     * @throws IllegalArgumentException if the divisor is zero
     * @return a well-formatted string representing the integer division algorithm
     * @author vadimtsudenko@gmail.com
     */
    public String divideInt(Integer dividend, Integer divisor, Integer capacity) {

        if (divisor == 0) {
            throw new IllegalArgumentException();
        }

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        capacity = Math.abs(capacity);

        String[] digits = String.valueOf(dividend).split("");
        Integer bufferNum;
        Integer entire;
        Integer fraction;
        Integer divisorDigits = clculateDigits(divisor);

        if (dividend < divisor) {
            quotient.append("0.");
        }

        for (int i = 0; i < digits.length + capacity; i++) {
            if (i == digits.length && dividend > divisor) {
                quotient.append(".");
            }
            if (i < digits.length) {
                buffer.append(digits[i]);
            } else {
                buffer.append(0);
            }
            bufferNum = Integer.parseInt(buffer.toString());
            if (bufferNum >= divisor) {
                fraction = bufferNum % divisor;
                entire = bufferNum / divisor * divisor;
                String lastReminder = String.format("%" + (i + 2) + "s", "_" + bufferNum.toString());
                result.append(lastReminder).append("\n");

                String multiply = String.format("%" + (i + 2) + "d", entire);
                result.append(multiply).append("\n");

                Integer tab = lastReminder.length() - clculateDigits(entire);
                result.append(makeDivider(bufferNum, tab)).append("\n");

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
        modifyResultToView(dividend, divisor);
        return result.toString();
    }

    private void modifyResultToView(Integer dividend, Integer divisor) {
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

        int tab = clculateDigits(dividend) + 1 - index[0];
        result.insert(index[2], assamblyString(tab, ' ') + "│" + quotient.toString());
        result.insert(index[1], assamblyString(tab, ' ') + "│" + assamblyString(quotient.length(), '-'));
        result.insert(index[0], "│" + divisor);
        result.replace(1, index[0], dividend.toString());
    }

    private String makeDivider(Integer bufferNum, Integer tab) {
        return assamblyString(tab, ' ') + assamblyString(clculateDigits(bufferNum), '-');
    }

    private String assamblyString(Integer num, char c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private int clculateDigits(int num) {
        return (int) Math.log10(num) + 1;
    }
}
