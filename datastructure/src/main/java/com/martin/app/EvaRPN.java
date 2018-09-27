package com.martin.app;

import java.util.*;

public class EvaRPN {

	public static void main(String[] args) {
		EvaRPN evaRPN = new EvaRPN();
		long result = evaRPN.calculate(new String[] { "2", "1", "+", "3", "*" });
		System.out.println(result);

		result = evaRPN.calculate(new String[] { "4", "13", "5", "/", "+" });
		System.out.println(result);

		result = evaRPN.calculate(new String[] { "1", "2", "3", "*", "+", "4", "+" });
		System.out.println(result);


		result = evaRPN.evalRPNStack(new String[] { "1", "2", "3", "*", "+", "4", "+" });
		System.out.println(result);


	}

	public long calculate(String[] tokens) {

		List<String> tokenList = new ArrayList(Arrays.asList(tokens));
		Collections.reverse(tokenList);
		return evaluate(new LinkedList(tokenList));
	}

	public long evaluate(Queue<String> queue) {

		String currentItem = queue.poll();
		if (isOperation(currentItem)) {
			return calculate(evaluate(queue),
					evaluate(queue),
					currentItem);
		} else {
			return Long.parseLong(currentItem);
		}
	}

	public int evalRPNStack(String[] tokens) {

		int returnValue;

		Stack<String> stack = new Stack<>();

		for (String t : tokens) {
			if (!isOperation(t)) {
				stack.push(t);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());

				stack.push(calculate(b, a , t) + "");
			}
		}

		returnValue = Integer.valueOf(stack.pop());

		return returnValue;

	}

	private boolean isOperation(String item) {
		final String operators = "+-*/";

		return operators.indexOf(item) >= 0;
	}

	private long calculate(long first, long second, String operation) {
		switch (operation) {
			case "+":
				return first + second;
			case "-":
				return first - second;
			case "*":
				return first * second;
			case "/":
				return first / second;
			default:
				throw new IllegalArgumentException("Unrecognized operation" + operation);
		}
	}

}
