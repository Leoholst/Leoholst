import java.util.Scanner;

public class Basics {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Vad heter du?");
		String name = input.nextLine();
		System.out.println("Hur gammal är du?");
		String age = input.nextLine();
	}
}
