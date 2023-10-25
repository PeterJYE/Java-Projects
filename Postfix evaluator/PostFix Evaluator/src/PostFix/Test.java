package PostFix;

import java.util.Arrays;
import java.util.Scanner;

import structures.LinkedList;
import structures.LinkedStack;
import support.StackUnderflowException;

public class Test {

	public static void main(String[] args) throws StackUnderflowException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter Your PostFix Equation ");
		String input = scan.nextLine();
		String[] arr = input.split(" ");
		LinkedStack<Double> intstack = new LinkedStack<Double>();
		int l = arr.length;
		for (int i = 0; i < l; i++) {
			if (isInt(arr[i])) {
				Double num = (double) Double.parseDouble(arr[i]);
				intstack.push(num);
			} else {
				if (arr[i].equals("+")) {
					Double num1 = intstack.pop();
					Double num2 = intstack.pop();
					num1 = num2 + num1;
					intstack.push(num1);
				} else if (arr[i].equals("-")) {
					Double num1 = intstack.pop();
					Double num2 = intstack.pop();
					num1 = num2 - num1;
					intstack.push(num1);
				} else if (arr[i].equals("*")) {
					Double num1 = intstack.pop();
					Double num2 = intstack.pop();
					num1 = num2 * num1;
					intstack.push(num1);
				} else if (arr[i].equals("/")){
					Double num1 = intstack.pop();
					Double num2 = intstack.pop();
					num1 = num2 / num1;
					intstack.push(num1);
				}
			}

		}
		System.out.println(intstack.toString());

	}

	public static boolean isInt(String s) {
		try {
			double i = Double.parseDouble(s);
			return true;
		} catch (NumberFormatException error) {
			return false;
		}
	}

	
}
