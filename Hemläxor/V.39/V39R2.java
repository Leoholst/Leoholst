import java.util.Scanner;

public class V39R2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int R1 = 0;
		int R2 = 0;
		int S = 0;
		
		R1 = input.nextInt();
		S = input.nextInt();
		
		if (-1000 < R1 && R1 < 1000 && -1000 < S && S < 1000) {
			R2 = S * 2 - R1;
			System.out.println(R2);
		}
	}
}