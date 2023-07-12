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

public class DivisionResult {

    Integer dividend;
    Integer divisor;
    StringBuilder quotient;
    StringBuilder result;

    /**
     * Constructs a DivisionResult object.
     *
     * @param _quotient the quotient of the division
     * @param _result   the formatted result of the division algorithm
     * @param _dividend the dividend value used in the division
     * @param _divisor  the divisor value used in the division
     */
    public DivisionResult(StringBuilder _quotient, StringBuilder _result, int _dividend, int _divisor) {
        this.quotient = _quotient;
        this.result = _result;
        this.dividend = _dividend;
        this.divisor = _divisor;
    }
}
