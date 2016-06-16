/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.rpn;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


/**
 * Implementation of a Reverse Polish Notation calculator.
 *
 * @author Dale "Ducky" Lotts
 * @since 10/27/15.
 */

final class Calculator {

	private Scanner scanner;
	private PrintStream output;

	public Calculator() {
	}

	public Calculator(Scanner scanner, PrintStream output) {
		this.scanner = scanner;
		this.output = output;
	}

	public void run() {

		output.println("Please enter values followed by operation symbols:");
		output.println("(Press CTRL+Z to end the program):");
		ArrayList<String> inputs = null;
		while (scanner.hasNext()) {
			final String tokenString = scanner.next();
			output.println(tokenString);
		}

	}
}
