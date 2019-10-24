import java.util.Scanner;

public class HemuppgiftV43 {
	public static void main(String[] args) {
		System.out.println(myMethod(2));
	}
	public static double myMethod(int radius) {
		double pi = 3.14;
		return 4*pi*radius*radius*radius/3;
	}
}