/* See the file "LICENSE" for the full license governing this code. */
package com.dalelotts.rpn;

import com.sun.javafx.fxml.expression.Expression;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import com.sun.tools.example.debug.expr.ExpressionParser;
import jdk.internal.org.objectweb.asm.tree.analysis.Interpreter;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

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
		String operators = "+,-,*,/";
		output.println("Please enter values followed by operation symbols:");
		output.println("(Press CTRL+Z to end the program):");

		Stack<String> stack = new Stack<>();
		while (scanner.hasNextLine()) {
			final String tokenString = scanner.next();

			if(operators.contains(tokenString)){
				try {
				ScriptEngineManager manager = new ScriptEngineManager();
				ScriptEngine engine = manager.getEngineByName("js");
				String b = stack.pop();
				String a = stack.pop();
				Object result = engine.eval(a + tokenString + b);
				output.println(result);
				} catch (ScriptException e) {
					e.printStackTrace();
				}
			}else{
				stack.push(tokenString);
			}

		}
	}
}
