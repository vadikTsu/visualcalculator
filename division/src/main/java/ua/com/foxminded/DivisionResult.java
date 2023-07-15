/*
 * @(#)DivisionResult.java
 * 
 * This file is a part of the VisualCalculator project.
 * It represents the result of an integer division operation in IntDivision class,
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

import java.util.List;

public class DivisionResult {

    List<Integer> reminder;
    List<Integer> multiple;
    List<Integer> exp;
    Integer divisor;
    Integer dividend;
    Integer fraction;
    Integer quotient;

    /**
     * Constructs a DivisionResult object.
     *
     * @param _quotient the quotient of the division
     * @param _result   the formatted result of the division algorithm
     * @param _dividend the dividend value used in the division
     * @param _divisor  the divisor value used in the division
     */
    public DivisionResult(List<Integer> reminder, List<Integer> multiple, List<Integer> exp, Integer divisor,
            Integer dividend, Integer fraction, Integer quotient) {
        this.reminder = reminder;
        this.multiple = multiple;
        this.exp = exp;
        this.divisor = divisor;
        this.dividend = dividend;
        this.fraction = fraction;
        this.quotient = quotient;
    }
}
