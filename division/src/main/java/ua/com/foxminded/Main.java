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
        System.out.println("Available commands:\n1 - (integer)/(integer)");
        try (Scanner scanner = new Scanner(System.in)) {
            IntegerDivision integerDivision = new IntegerDivision();
            String command = scanner.nextLine();
            
            if(command.contains("/")) {
                String[] nums = command.split("/");
                System.out.println(integerDivision.divideInt(Integer.parseInt(nums[0]), 
                        Integer.parseInt(nums[1]), 0));
            } else {
                System.out.println("Illegal input");
            }
        }finally {
            System.out.println("process terminated");
        }
    }
}
