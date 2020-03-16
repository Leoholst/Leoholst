public class ArrayLäxa {
	public static void main(String[] args) {
		String[] names = {"Tomas", "Tomas", "Tomas", "Are", "Tomas", "Are", "Tomas", "Are", "Tomas", "Niklas"};
		int years = 0;
		for (String string : names) {
			if(string == "Are") {
				years++;
			}
		}
		System.out.println("Are har jobbat på skolan i " + years + " år!");
	}
}