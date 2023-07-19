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

    List<Integer> reminderList;
    List<Integer> multipleList;
    List<Integer> pointerList;
    List<Integer> quotientList;
    Integer divisor;
    Integer dividend;
    Integer fraction;

    /**
     * Constructs a DivisionResult object.
     *
     * @param _quotient the quotient of the division
     * @param _result   the formatted result of the division algorithm
     * @param _dividend the dividend value used in the division
     * @param _divisor  the divisor value used in the division
     */
    public DivisionResult(List<Integer> reminderList, List<Integer> multipleList, List<Integer> pointerList,
            Integer divisor, Integer dividend, Integer fraction, List<Integer> quotientList) {
        this.reminderList = reminderList;
        this.multipleList = multipleList;
        this.pointerList = pointerList;
        this.divisor = divisor;
        this.dividend = dividend;
        this.fraction = fraction;
        this.quotientList = quotientList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DivisionResult other = (DivisionResult) obj;
        return reminderList.equals(other.reminderList) && multipleList.equals(other.multipleList)
                && pointerList.equals(other.pointerList) && divisor.equals(other.divisor)
                && dividend.equals(other.dividend) && fraction.equals(other.fraction)
                && quotientList.equals(other.quotientList);
    }
}
