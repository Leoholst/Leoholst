import java.util.Scanner;

public class RepetitionsUppgifterV6 {
	public static void main(String[] args) {
		System.out.println(number());
	}
	
	public static int number() {
		Scanner input = new Scanner(System.in);
		int high = 0;
		System.out.println("Skriv ett heltal");
		int first = input.nextInt();
		System.out.println("Skriv ett till heltal");
		int second = input.nextInt();
		if(first >= second) {
			high = first;
		}
		else if(second >= first) {
			high = second;
		}
		return(high);
	}
}
