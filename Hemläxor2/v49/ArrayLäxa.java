public class ArrayL�xa {
	public static void main(String[] args) {
		String[] names = {"Tomas", "Tomas", "Tomas", "Are", "Tomas", "Are", "Tomas", "Are", "Tomas", "Niklas"};
		int years = 0;
		for (String string : names) {
			if(string == "Are") {
				years++;
			}
		}
		System.out.println("Are har jobbat p� skolan i " + years + " �r!");
	}
}