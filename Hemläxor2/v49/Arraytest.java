
public class Arraytest {
	public static void main(String[] args) {
		//int[] femmans = {5, 10, 15, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100};
		
		int[] sevens = new int[11];
		
		for(int i = 0; i <= 10; i++) {
			sevens[i] = i*7;
		}
		
		for (int seven : sevens) {
			System.out.println(seven);
		}
	
		double[] darr = {1.5, 1.6};
		
		String[] sarr = {"Are", "Fabian", "Jeff", "Hugo"};
		for (String name : sarr) {
			if(name == "Hugo") {
				System.out.println("Där är du!");
			}
			else {
				System.out.println("Inte Hugo");
			}
		}
		
		String[] haha = new String[1];
		System.out.println(haha + "san");
		
	}
}