/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.rpn;

import java.io.PrintStream;
import java.util.*;

/**
 * Implementation of a Reverse Polish Notation calculator.
 *
 * @author Dale "Ducky" Lotts
 * @since 10/27/15.8
 */

final class Calculator {
	private Scanner scanner;
	private PrintStream output;
	private final Map<String, Operation> opByName = new HashMap<>();

	public Calculator(Scanner scanner, PrintStream output) {
		this.scanner = scanner;
		this.output = output;
		opByName.put("+", (leftSide, rightSide) -> String.valueOf(Integer.parseInt(leftSide) + Integer.parseInt(rightSide)));
		opByName.put("-", (leftSide, rightSide) -> String.valueOf(Integer.parseInt(leftSide) - Integer.parseInt(rightSide)));
		opByName.put("*", (leftSide, rightSide) -> String.valueOf(Integer.parseInt(leftSide) * Integer.parseInt(rightSide)));
		opByName.put("/", (leftSide, rightSide) -> String.valueOf(Integer.parseInt(leftSide) / Integer.parseInt(rightSide)));
		opByName.put("%", (leftSide, rightSide) -> String.valueOf((Integer.parseInt(leftSide) * Integer.parseInt(rightSide))/100));
		opByName.put("^", (leftSide, rightSide) -> String.valueOf(Math.pow(Double.parseDouble(leftSide), Double.parseDouble(rightSide))));
	}

	public void run() {
		output.println("Please enter values followed by operation symbols:\n(Press CTRL+Z to end the program):");
		ArrayList<String> inputs = new ArrayList<>();

		while (scanner.hasNextLine()) {
			String tokenString = scanner.next();
			if(!tokenString.matches("\\d+") && inputs.size()>1){
				String numB = inputs.remove(inputs.size()- 1);
				tokenString = opByName.get(tokenString.trim()).calculate(inputs.remove(inputs.size()- 1), numB).split("\\.")[0];
			}
			inputs.add(tokenString);
			for(String s : inputs){ output.print(s + " ");}
			output.print("\n");
		}
	}
}
