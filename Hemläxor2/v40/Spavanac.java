import java.util.Scanner;

public class Spavanac {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int	h = input.nextInt();
		int	m = input.nextInt();
		int L = m-45;
		while(h<24 && m<61) {
			System.out.println(h+":"+ m);
			break;
		}
	}
}
