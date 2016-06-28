/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.rpn;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Implementation of a Reverse Polish Notation calculator.
 *
 * @author Dale "Ducky" Lotts
 * @since 10/27/15.
 */

final class Calculator {

	private Scanner scanner;
	private PrintStream output;

	public Calculator(Scanner scanner, PrintStream output) {
		this.scanner = scanner;
		this.output = output;
	}

	public void run() {
		final String standardOperators = "+,-,*,/";
		output.println("Please enter values followed by operation symbols:\n(Press CTRL+Z to end the program):");
		ArrayList<String> inputs = new ArrayList<>();
		ArrayList<String> inputnew = new ArrayList<>();
		List<String> strings = Arrays.asList("one", "two", "three");
		while (scanner.hasNextLine()) {
			final String tokenString = scanner.next();
			//////
			if(!tokenString.matches("\\d+")){
				inputnew.add(tokenString);
			}
//			String[] myArray = { "this", "is", "a", "sentence" };
//			String result = Arrays.stream(myArray)
//					.reduce("", (a,b) -> a + b);
//			System.out.print("Result Stream = " + result);
			//for(String s : result){ System.out.println(s + " ");}

			//////
			if(tokenString.matches("\\d+")){
				inputs.add(tokenString);
			}else{
				if(inputs.size() > 1 || tokenString.contains("%")) {
					try {
						String numB = inputs.remove(inputs.size() - 1);
						if(standardOperators.contains(tokenString)){
							inputs.add(Calculate(inputs.remove(inputs.size() - 1) + tokenString + numB));
						}else{
							if(tokenString.contains("^")){
								inputs.add(String.valueOf(Math.pow(Double.parseDouble(inputs.remove(inputs.size()- 1)), Double.parseDouble(numB))));
							}else if(tokenString.equals("%")) {
								inputs.add(Calculate(inputs.remove(inputs.size() - 1) +"*" + numB +" / 100"));
							} else {
								inputs.add(Calculate(numB + "*" +tokenString.replace("%", " / 100")));
							}
						}
					} catch (ScriptException e) {
						e.printStackTrace();
					}
				}else{
					System.out.print("You have to add at least "+ (2 - inputs.size()) + " number(s) before adding an operator");
				}
			}
			for(String s : inputs){ output.print(s + " ");}
			output.print("\n");
			for(String s : inputnew){
				System.out.print(s + " ");}
			output.print("\n");
		}
	}
	public String Calculate(String evalString) throws ScriptException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
		return engine.eval(evalString).toString();
	}
}
