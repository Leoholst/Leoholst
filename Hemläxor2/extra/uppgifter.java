import java.util.Scanner;

public class uppgifter {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Hur gammal är du?");
		int age = input.nextInt();
		if(age>=18) {
			System.out.println("Du får köra moppe och bil.");
		}
		else if(age>=15) {
			System.out.println("Du får köra moppe.");
		}
		
		else {
			System.out.println("Du är för liten...");
		}
	}
}