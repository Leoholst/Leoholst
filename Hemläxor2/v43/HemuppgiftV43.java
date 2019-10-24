import java.util.Scanner;

public class HemuppgiftV43 {
	public static void main(String[] args) {
			System.out.println("Volymen på ett klot med ditt favoritnummer som radien är: " + volume(0));
			System.out.println("Visste du att ditt favoritord baklänges är: " + reverse(null));
			System.out.println("Du tänker på hur många s det finns i Ishockeymålvaktsskyddsförsäljare! " + "Det är: " + count("Ishockeymålvaktsskyddsförsäljare",'s'));
			System.out.println(sjorovare(null));
	}
	/**
	 * 
	 * @param radius Tar in ett värde på radius, vilket är hur stor radien kommer vara.
	 * @return Returnerar volymen på klotet med formeln för volym för klot. Math.PI är pi och Math.pow är här radien upphöjt till tre.
	 */
	public static double volume(double radius) {
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv ditt favoritnummer!");
		radius = input.nextInt();
		return 4*Math.PI*Math.pow(radius, 3)/3;
	}
	/**
	 * 
	 * @param str Tar in ordet som ska skrivas baklänges
	 * Sedan skapar jag variabeln word och använder mig av StringBuffer().reverse().toString() vilket är ett inbyggt redskap för att vända på ord i Java.
	 * @return Returnerar word, vilket är str baklänges.
	 */
	public static String reverse(String str) {
		Scanner input = new Scanner(System.in);
		System.out.println("-------------------------------------");
		System.out.println("Skriv ditt favoritord!");
		str = input.nextLine();
		String word = new StringBuffer(str).reverse().toString();
		return word;
	}
	/**
	 * 
	 * @param str Nu tar vi inte in värdet på str utan jag förbestämmer det själv i main metoden.
	 * @param c Samma sak här med c, jag förbestämmer den i main metoden.
	 * Jag skapar sedan variabeln num och sätter startvärdet 0, detta är värdet på hur många gånger c förekommer i str.
	 * Efter det skapar jag en for-loop där jag använder str.length() vilket är längden på ordet i str.
	 * I for-loopen har jag en if sats, här har jag str.charAt(), med den kan vi sikta in oss på specifika bokstäver i ordet i str. Jag använder i i str.charAt(i) eftersom då går vi i samma takt som loopen igenom bokstäverna i str.
	 * I if satsen har jag även str.charAt(i) == c följt med num++, så om en bokstav i str är lika med den valda bokstaven i c, då ökar num med ett. 
	 * @return Slutligen returnerar jag num med det resultatet på hur många gånger c förekommer i str.
	 */
	public static int count(String str,char c) {
		Scanner input = new Scanner(System.in);
			System.out.println("-------------------------------------");
			System.out.println("Jag vet vad du tänker på just nu!");
			System.out.println(" ");
			
			int num = 0;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == c) {
					num++;
				}
			}
			return num;
	}
	/**
	 * Det känns hopplöst
	 * @param str
	 * @return
	 */
	public static String sjorovare(String str) {
		Scanner input = new Scanner(System.in);
			System.out.println("-------------------------------------");
			System.out.println("Skriv en mening!");
			str = input.nextLine();
			
			int num = 0;
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 0) {
					System.out.println(str.replace("b", "bob"));
				}
			}	
			
			//System.out.println(str.replace(str, str));
		return str;
	}
}