/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.rpn;


import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;

/**
 * Main class and entry point for the RPN Calculator.
 *
 * @author Dale "Ducky" Lotts
 * @since 10/28/15.
 */

public final class Main {

    private Main() {

    }


    public static void main(final String... args) {
        //new Calculator(new Scanner(System.in), System.out).run();
        int res = opByName.get("+").calculate(12, 14);
        System.out.println(res);
        int res1 = opByName.get("*").calculate(12, 14);
        System.out.println(res1);
    }

    static final Map<String, Operation> opByName = new HashMap<>();

    static {
        opByName.put("+", (leftSide, rhs) -> leftSide + rhs);
        opByName.put("-", (a, b) -> a - b);
        opByName.put("*", (a, b) -> a * b);
        opByName.put("/", (a, b) -> a / b);
    }
}
