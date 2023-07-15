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
     */
    public DivisionResult divide(int dividend, int divisor) {
        if (divisor < dividend || divisor == 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }
        
        int answer = dividend / divisor;
        List<Integer> reminderArr = new ArrayList<>();
        List<Integer> multipleArr = new ArrayList<>();
        List<Integer> expArr = new ArrayList<>();

        int remainder = dividend;
        while (remainder != dividend % divisor) {
            String test = Integer.toString(remainder);
            int sub = Integer.parseInt(test.substring(0, 1));
            test = test.substring(1);
            int exp = (int) Math.log10(remainder);
            while (sub < divisor) {
                sub = sub * 10 + Integer.parseInt(test.substring(0, 1));
                test = test.substring(1);
                exp--;
            }

            reminderArr.add(sub);
            expArr.add(exp);

            int multiple = sub - (sub % divisor);
            multipleArr.add(multiple);

            remainder -= multiple * Math.pow(10, exp);
        }
        return new DivisionResult(reminderArr, multipleArr, expArr, divisor, dividend, dividend % divisor, answer);
    }
}

