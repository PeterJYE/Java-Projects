package PostFix;

import java.util.Scanner;

import structures.LinkedList;
import structures.LinkedStack;
import support.StackUnderflowException;

public class Main {

	public static void main(String[] args) throws StackUnderflowException {
		Scanner scan=new Scanner(System.in);
		System.out.println("Please Enter Your PostFix Equation ");
		String input = scan.nextLine();
		String[] arr =input.split(" ");
		LinkedList<String> operator = new LinkedList<String>();
		LinkedStack<Integer> intstack = new LinkedStack<Integer>();
		int l= arr.length;
		for(int i=0;i<l;i++) {
			if(isInt(arr[i])) {
				int num = Integer.parseInt(arr[i]);
				intstack.push(num);
			}
			else {
				operator.add(arr[i]);
			}
		}
		System.out.println(operator.toString());
		System.out.println(intstack.toString());
		System.out.println(equation(intstack, operator));
		

	}
	public static boolean isInt(String s) { 
		try { 
		    int i = Integer.parseInt(s); 
		    return true; 
		} 
		catch(NumberFormatException error) { 
		    return false; 
		} 
		}
	public static int equation (LinkedStack<Integer> in,LinkedList o) throws StackUnderflowException {
		int num1=in.pop();
		int num2=in.pop();
		String result="";
		for (int i=0; i<=o.size()-1;i++) {
			if(o.get(i).equals("+")) {
				num1=num2+num1;
				if(! in.isEmpty()) {
				num2=in.pop();
				}
			}
			else if(o.get(i).equals("-")) {
				num1=num2-num1;
				if(! in.isEmpty()) {
					num2=in.pop();
					}
			}
			else if(o.get(i).equals("*")) {
				num1=num2*num1;
				if(! in.isEmpty()) {
					num2=in.pop();
					}
			}
			else if (o.get(i).equals("/")){
				num1=num2/num1;
				if(! in.isEmpty()) {
					num2=in.pop();
					}
			}
			
		}
		return num1;
	}
	public static String checkoperator(LinkedList o) {
		
		return null;
	}

}
