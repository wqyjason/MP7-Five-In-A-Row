import java.util.Scanner;

public class Calculator {
	
	public static void main(String[] args) {
		
		final int result = 0;
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Please write your equation: ");
		String input = reader.nextLine();
		
		
		System.out.println(OutputBack(input));
//		System.out.println(input.length());
		
	}
	
	public static int OutputBack(String input) {
		
		String word = input;
		
		if (input.contains("(")) {
			int start = input.indexOf("(");
			int end = input.indexOf(")");
			String parth = input.substring(start + 1, end);
			int parth_result = OutputBack(parth);
			word = String.valueOf(parth_result) + word.substring(end + 1);
			System.out.println(word);
			return OutputBack(word);
		}
		
		if (input.contains("*")) {
			int point = input.indexOf("*");
			int a = Integer.parseInt((input.substring(point - 1, point)));
			int b = Integer.parseInt((input.substring(point + 1, point + 1 + 1)));
			int times_result = a * b;
			word = word.substring(0, point) + String.valueOf(times_result) + word.substring(point + 1 + 1);
			return OutputBack(word);
		}
		
		if (input.contains("/")) {
			int point = input.indexOf("/");
			int a = Integer.parseInt((input.substring(point - 1, point)));
			int b = Integer.parseInt((input.substring(point + 1, point + 1 + 1)));
			int div_result = a / b;
			word = String.valueOf(div_result) + word.substring(point + 1 + 1);
			return OutputBack(word);
		}
		
		if (input.contains("+")) {
			int point = input.indexOf("+");
			int a = Integer.parseInt((input.substring(point - 1, point)));
			int b = Integer.parseInt((input.substring(point + 1, point + 1 + 1)));
			int plus_result = a + b;
			word = String.valueOf(plus_result) + word.substring(point + 1 + 1);
			System.out.println("a = " + a);
			System.out.println("b = " + b);
			return OutputBack(word);
		}
		
		if (input.contains("-")) {
			int point = input.indexOf("-");
			int a = Integer.parseInt((input.substring(point - 1, point)));
			int b = Integer.parseInt((input.substring(point + 1, point + 1 + 1)));
			int minus_result = a - b;
			word = String.valueOf(minus_result) + word.substring(point + 1 + 1);
			return OutputBack(word);
		}
		
		return Integer.parseInt(word);
		
	}

//	public static double firstprio(String input) {
//		double result = OutputBack(input);
//		return result;
//	}
	
	public static boolean isResult(String input) {
		if (input.contains("+") || input.contains("-") 
				|| input.contains("*") || input.contains("/")) {
			return false;
		}
		return true;
	}




}

