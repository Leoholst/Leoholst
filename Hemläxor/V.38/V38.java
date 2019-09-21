import java.util.Scanner;

public class V38 {
	public static void main(String[] args) {

		Scanner  input = new Scanner(System.in);
		System.out.println("Skriv 10 heltal:");
		int nr1 = input.nextInt();
		int nr2 = input.nextInt();
		int nr3 = input.nextInt();
		int nr4 = input.nextInt();
		int nr5 = input.nextInt();
		int nr6 = input.nextInt();
		int nr7 = input.nextInt();
		int nr8 = input.nextInt();
		int nr9 = input.nextInt();
		int nr10 = input.nextInt();
		
		
		System.out.print("Medelvärde: " + (nr1 + nr2 + nr3 + nr4 + nr5 + nr6 + nr7 +nr8 + nr9 + nr10) /10f);
	}
}