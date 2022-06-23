package edu.virginia.cs.mcburney;

public class Functions {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("ERROR: This program takes in two rational numbers (floats)");
			System.exit(0);
		}
		double x, y;
		try {
			x = Double.parseDouble(args[0]);
			y = Double.parseDouble(args[1]);
		} catch (NumberFormatException e) {
			x = 0.0;
			y = 0.0;
			System.err.println("ERROR: Your arguments must be numbers. Please try again!");
			System.exit(0);
		}
	}
	
	public static double sum(double x, double y) {
		return x + y;
	}
	
	public static double product(double x, double y) {
		return x * y;
	}
	
	public static double average(double x, double y) {
		return sum(x, y)/2.0;
	}
	
	public static double geometricMean(double x, double y) {
		return product(x, y)/2.0;
	}
	
	public static double harmonicMean(double x, double y) {
		return product(2.0, product(x, y)) / sum(x,y);
	}

}
