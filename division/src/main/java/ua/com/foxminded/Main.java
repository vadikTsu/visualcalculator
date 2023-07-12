/*
 *  @(#)Main.java
 * 
 * This file is a part of the VisualCalculator project.
 * It contains the main method of project.
 *
 * Author: Vadym Tsudenko
 * 
 * Date: July 8, 2023
 * 
 * Copyright (c) 1994, 2023, Oracle and/or its affiliates.
 *  All rights reserved 
 */
package ua.com.foxminded;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) { 
        System.out.println("WELCOME TO COOL INTEGER CALCULATOR APP");
        System.out.println("Available commands:\n1 - Integer division");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter dividend and divisor:\n");
            int dividend = scanner.nextInt();
            int divisor = scanner.nextInt();
            
            IntegerDivision integerDivision = new IntegerDivision();
            DivisionResult result = integerDivision.divide(dividend, divisor);
            DivisionFormatterUA formatter = new DivisionFormatterUA();
            System.out.println(formatter.format(result));

        }finally {
            System.out.println("process terminated");
        }
    }
}
