public class InputReader {
	
	String word;
	
	public InputReader(String input) {
		
		word = input;
		
	}
	
	public double OutputBack(String input) {
		
		String word = input;
		double result = 0;
		
		if (input.contains("(")) {
			int start = input.indexOf("(");
			int end = input.indexOf(")");
			String parth = input.substring(start + 1, end);
			double parth_result = firstprio(parth);
			word = (String) (parth) + word.substring(end + 1);
		}
		
		if (input.contains("*")) {
			int point = input.indexOf("*");
			double a = Double.parseDouble((input.substring(point - 1, point)));
			double b = Double.parseDouble((input.substring(point, point + 1)));
			double times_result = a * b;
		}
		
		if (input.contains("/")) {
			int point = input.indexOf("/");
			double a = Double.parseDouble((input.substring(point - 1, point)));
			double b = Double.parseDouble((input.substring(point, point + 1)));
			double div_result = a / b;
		}
		
		if (input.contains("+")) {
			int point = input.indexOf("+");
			double a = Double.parseDouble((input.substring(point - 1, point)));
			double b = Double.parseDouble((input.substring(point, point + 1)));
			double plus_result = a + b;
		}
		
		if (input.contains("-")) {
			int point = input.indexOf("-");
			double a = Double.parseDouble((input.substring(point - 1, point)));
			double b = Double.parseDouble((input.substring(point, point + 1)));
			double minus_result = a - b;
		}
		
		return result;
		
	}
	
	public double firstprio(String input) {
		double result = OutputBack(input);
		return result;
	}

}
