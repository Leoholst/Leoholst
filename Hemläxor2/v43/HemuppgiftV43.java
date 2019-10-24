import java.util.Scanner;

public class HemuppgiftV43 {
	public static void main(String[] args) {
			System.out.println("Volymen på ett klot med ditt favoritnummer som radien är: " + volume(0));
			System.out.println("Visste du att ditt favoritord baklänges är: " + reverse(null));
			System.out.println("Du tänker på hur många s det finns i Ishockeymålvaktsskyddsförsäljare! " + "Det är: " + count("Ishockeymålvaktsskyddsförsäljare",'s'));
	}
	public static double volume(double radius) {
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv ditt favoritnummer!");
		radius = input.nextInt();
		return 4*Math.PI*Math.pow(radius, 3)/3;
	}
	public static String reverse(String str) {
		Scanner input = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("Skriv ditt favoritord!");
		str = input.nextLine();
		String word = new StringBuffer(str).reverse().toString();
		return word;
	}
	public static int count(String str,char c) {
		Scanner input = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("Jag vet vad du tänker på just nu!");
		System.out.println(" ");
		int num = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == c) {
				num++;
			}
		}
		return num;
	}
}