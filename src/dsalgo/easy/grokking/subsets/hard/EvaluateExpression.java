package dsalgo.easy.grokking.subsets.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class EvaluateExpression {

	public static Set<Integer> evaluateExpression1(String expression) {
		Queue<String> queue = new LinkedList<>();
		queue.add(expression);
		Set<Integer> set = new HashSet<>();
		while (!queue.isEmpty()) {
			String exp = queue.poll();
			int startIndex = 0;
			int opratorCount = 0;
			int firstDigit = Integer.MIN_VALUE;
			int secondDigit = Integer.MIN_VALUE;
			char operator = 0;
			char firstOperator = 0;
			char secondOperator = 0;

			int firstOperatorIndex = -1;
			int secondOperatorIndex = -1;

			for (int i = 0; i < exp.length(); i++) {
				if (!Character.isDigit(exp.charAt(i))) {
					operator = exp.charAt(i);
					if (i - firstOperatorIndex > 1) {
						opratorCount++;
					}
				}

				if (opratorCount == 1 && firstDigit == Integer.MIN_VALUE) {
					firstOperatorIndex = i;
					firstOperator = operator;
					firstDigit = Integer.parseInt(exp.substring(startIndex, i));
				} else if (opratorCount == 2 && secondDigit == Integer.MIN_VALUE && i - firstOperatorIndex > 1) {
					secondOperatorIndex = i;
					secondOperator = operator;
					secondDigit = Integer.parseInt(exp.substring(firstOperatorIndex + 1, i));
				}
				if (opratorCount == 1 && secondDigit == Integer.MIN_VALUE && i == exp.length() - 1) {
					secondDigit = Integer.parseInt(exp.substring(firstOperatorIndex + 1, exp.length()));
				}
				if (i == exp.length() - 1 && secondDigit == Integer.MIN_VALUE) {
					set.add(Integer.parseInt(exp));
				}
				if (firstDigit != Integer.MIN_VALUE && secondDigit != Integer.MIN_VALUE) {
					Integer evaluteExpression = evaluteExpression(firstDigit, secondDigit, firstOperator);
					String newExpression = exp
							.replace(firstDigit + "" + firstOperator + secondDigit, String.valueOf(evaluteExpression))
							.replace("--", "+");
					queue.add(newExpression);
					firstOperator = secondOperator;
					firstOperatorIndex = secondOperatorIndex;
					firstDigit = secondDigit;
					opratorCount--;
					secondOperator = 0;
					secondOperatorIndex = -1;
					secondDigit = Integer.MIN_VALUE;
				}
			}
		}
		return set;
	}

	private static Integer evaluteExpression(Integer firstOperand, Integer secondOperand, Character character) {
		Integer result = null;
		switch (character) {
		case '+':
			result = firstOperand + secondOperand;
			break;
		case '-':
			result = firstOperand - secondOperand;
			break;
		case '*':
			result = firstOperand * secondOperand;
			break;
		default:
			break;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(evaluateExpression1("1+2*3"));
	}

}
