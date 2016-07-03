/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.rpn;

import java.io.PrintStream;
import java.math.BigDecimal;
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
	private final Map<String, Oper> opName = new HashMap<>();
	public Calculator(Scanner scanner, PrintStream output) {
		this.scanner = scanner;
		this.output = output;
		opName.put("+", (leftSide, rightSide) -> leftSide.add(rightSide));
		opName.put("-", (leftSide, rightSide) -> leftSide.subtract(rightSide));
		opName.put("*", (leftSide, rightSide) -> leftSide.multiply(rightSide));
		opName.put("/", (leftSide, rightSide) -> leftSide.divide(rightSide));
		opName.put("%", (leftSide, rightSide) -> leftSide.multiply(rightSide.divide(new BigDecimal(100))));
		opName.put("^", (leftSide, rightSide) -> leftSide.pow(Integer.parseInt(rightSide.toString())));
	}

	public void run() {
		output.println("Please enter values followed by operation symbols:\n(Press CTRL+Z to end the program):");
		ArrayList<String> inputs = new ArrayList<>();

		while (scanner.hasNextLine()) {
			String tokenString = scanner.next();
			if(!tokenString.matches("\\d+") && inputs.size()>1){
				BigDecimal b = new BigDecimal(inputs.remove(inputs.size()- 1));
				BigDecimal a = new BigDecimal(inputs.remove(inputs.size()- 1));
				tokenString = String.valueOf(opName.get(tokenString.trim()).compute(a, b));
//			}
			inputs.add(tokenString);
			for(String s : inputs){ output.print(s + " ");}
			output.print("\n");
		}
	}
}
