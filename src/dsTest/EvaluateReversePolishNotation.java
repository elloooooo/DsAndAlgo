package dsTest;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4", "13",
 * "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * 
 * 就是典型的计算后缀表达式的值
 * 
 * 方法就是依次将元素入栈，如果遇到操作符，则弹出两个元素，与操作符结合后，值入栈
 */
public class EvaluateReversePolishNotation {
	//将操作符字符串转化为操作符
	private int getValue(int b, int a, String op) {
		int res = 0;
		switch (op.toCharArray()[0]) {
		case 43:
			res = a + b;
			break;
		case 45:
			res = a - b;
			break;
		case 42:
			res = a * b;
			break;

		case 47:
			res = a / b;
			break;

		default:
			break;
		}
		return res;
	}
	//判断一个字符串是否是数字，可能出现负数
	private boolean isNumber(String str) {
		return str.matches("^[+-]?[0-9]+");
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < tokens.length; i++) {
			if (isNumber(tokens[i])) {
				stack.push(Integer.parseInt(tokens[i]));
			} else {
				int tmpRes = getValue(stack.pop(), stack.pop(), tokens[i]);
				stack.push(tmpRes);
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String[] data = {"3","-4","-"};
		EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();
		System.out.println(e.evalRPN(data));
	}

}
