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



    private List<DivisionStep> divisionSteps;
    private int quotient;
    private int divisor;
    private int dividend;
    private int fraction;

    /**
     * Constructs a DivisionResult object.
     *
     * 
     * @param quotient      the quotient of the division
     * @param divisionSteps the list of DivisionStep objects
     * @param fraction      of division
     * @param dividend      the dividend value used in the division
     * @param divisor       the divisor value used in the division
     * @see {@link IntegerDivision}
     * @see {@link DivisionFormatter}
     */
    public DivisionResult(List<DivisionStep> divisionSteps, Integer divisor, Integer dividend, Integer fraction,
            Integer quotient) {
        this.divisionSteps = divisionSteps;
        this.divisor = divisor;
        this.dividend = dividend;
        this.fraction = fraction;
        this.quotient = quotient;
    }

    public List<DivisionStep> getDivisionSteps() {
        return divisionSteps;
    }

    public Integer getQuotient() {
        return quotient;
    }

    public Integer getDivisor() {
        return divisor;
    }

    public Integer getDividend() {
        return dividend;
    }

    public Integer getFraction() {
        return fraction;
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
        return this.divisionSteps.equals(other.getDivisionSteps()) && divisor == other.divisor
                && dividend == other.dividend && fraction == other.fraction
                && quotient == other.quotient;
    }
}
