import java.util.Scanner;

public class V39Quadrantselection {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int x = input.nextInt();
		int y = input.nextInt();
		
		if (x > 0 && y > 0) {
			System.out.println("Quadrant 1");
		}
		else if (x < 0 && y > 0) {
			System.out.println("Quadrant 2");
		}
		else if (x < 0 && y < 0) {
			System.out.println("Quadrant 3");
		}
		else if (x > 0 && y < 0) {
			System.out.println("Quadrant 4");
		}
	}
}