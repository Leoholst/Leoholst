import java.util.Scanner;

public class Basics {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Vad heter du?");
		String name = input.nextLine();
		System.out.println("Hur gammal �r du?");
		String age = input.nextLine();
		System.out.println("Vad �r din adress?");
		String address = input.nextLine();
		System.out.println("Vad �r ditt postnummer?");
		String postcode = input.nextLine();
		System.out.println("Vilken stad bor du i?");
		String city = input.nextLine();
		System.out.println("Vad �r ditt telefonnummer?");
		String phone = input.nextLine();
	}
}
