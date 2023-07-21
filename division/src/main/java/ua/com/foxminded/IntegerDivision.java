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
import java.util.Iterator;
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
        if (divisor == 0) {
            throw new IllegalArgumentException("Illegal argument! Division by Zero.");
        }
        int dividendSize =(int) Math.log10(Math.abs(dividend)) + 1;
        int divisorSize = (int) Math.log10(Math.abs(divisor)) + 1;
        int[] dividendDigits = this.toArray(dividend);
        int rightIndex = 0;
        int reminder = dividendDigits[rightIndex];
        int fraction;

        List<Integer> reminderList = new ArrayList<>();
        List<Integer> multipleList = new ArrayList<>();
        List<Integer> pointerList = new ArrayList<>();
//        List<Integer> quotient = new ArrayList<>();
        Integer quotient = 0;

        while (rightIndex < dividendSize - 1) {  


            if (reminder >= divisor) {
                quotient += reminder / divisor;
                reminderList.add(reminder);
                multipleList.add(reminder / divisor * divisor);
                pointerList.add(rightIndex + 1);
                reminder = reminder % divisor;
            }
            
            rightIndex++;

            reminder = reminder * 10 + dividendDigits[rightIndex];
            quotient *= 10;

        }
   
        quotient+=reminder / divisor;
        reminderList.add(reminder);
        multipleList.add(reminder / divisor * divisor);
        pointerList.add(rightIndex + 1);

        fraction = reminder % divisor;
        return new DivisionResult(reminderList, multipleList, pointerList, divisor, dividend, fraction, quotient);
    }
    

    private int[] toArray(int number) {
        String numberString = String.valueOf(number);
        int[] digits = new int[numberString.length()];
        for (int i = 0; i < numberString.length(); i++) {
            char digitChar = numberString.charAt(i);
            digits[i] = Character.getNumericValue(digitChar);
        }
        return digits;
    }

}

