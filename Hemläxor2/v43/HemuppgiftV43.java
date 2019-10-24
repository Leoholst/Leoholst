import java.util.Scanner;

public class HemuppgiftV43 {
	public static void main(String[] args) {
			System.out.println(volume(0));
			System.out.println(reverse(null));
	}
	public static double volume(double radius) {
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv ditt favorit nummer!");
		radius = input.nextInt();
		return 4*Math.PI*Math.pow(radius, 3)/3;
	}
	public static String reverse(String str) {
		Scanner input = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("Skriv ditt favorit ord!");
		str = input.nextLine();
		String word = new StringBuffer(str).reverse().toString();
		return word;
	}
}