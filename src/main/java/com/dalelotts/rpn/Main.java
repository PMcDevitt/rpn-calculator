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

    public static void main(final String... args) {
        new Calculator(new Scanner(System.in), System.out).run();
    }

}
