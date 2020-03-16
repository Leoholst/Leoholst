import java.util.Scanner;

public class RepetitionsUppgift4 {
	
	
	public static void main(String[] args) {
		System.out.println(heltal());
	}
	
	public static int heltal() {
		Scanner input = new Scanner(System.in);
		
		int product = input.nextInt();
		
		for (int i = 1; i < 10; i++) {
			int newNumber = product*input.nextInt();
			
			if(newNumber < 100000) {
				product = newNumber;
			}
			else {
				break;
			}
			
		}
		
		return product;
	}
}
