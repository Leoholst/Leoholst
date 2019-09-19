import java.util.Scanner;

public class Basics {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Vad heter du ?");
		String name = input.nextLine();
		System.out.println("Hur gammal är du ?");
		String age = input.nextLine();
		System.out.println("Vad är din adress ?");
		String address = input.nextLine();
		System.out.println("Vad är ditt postnummer ?");
		String postcode = input.nextLine();
		System.out.println("Vilken stad bor du i ?");
		String city = input.nextLine();
		System.out.println("Vad är ditt telefonnummer ?");
		String phone = input.nextLine();
		System.out.println("");
		System.out.println("Information:");
		System.out.println("Namn:    " + name);
		System.out.println("Ålder:   " + age + " år");
		System.out.println("Adress:  " + address);
		System.out.println("         " + postcode + " " + city);
		System.out.println("Telefon: " + phone);
	}
}