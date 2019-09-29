import java.util.Scanner;

public class V39Timeloop {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Give me a number");
		int N = 1;
		int num = input.nextInt();
		for (int i = 0; i < num; i++) {
		System.out.println(N++ + " Abracadabra");
		}
	}
}