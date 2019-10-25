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
	 * Denna metoden tar in ett ord på svenska och skriver ut det på rövarspråket.
	 * Först tar jag in ett svenskt ord, str. Sedan har jag en variabel word vilket kommer vara det svenska ordet i rövarspråk.
	 * Jag har sedan en for-loop i samma stil som i count metoden. I for-loopen har jag en if-sats där jag kollar om bokstaven i ordet är någon av alla konsonanter i det svenska alfabetet, med hjälp av eller-tecknet.
	 * Om det är sant ändrar jag word till "bokstaven o bokstaven" t.ex. b blir bob.
	 * Jag avslutar for-loopen med else där word bara blir bokstaven alltså ändras inte bokstaven.
	 * @param str
	 * @return returnerar word som efter for-loopen är det fullständiga rövarspråk ordet.
	 */
	public static String sjorovare(String str) {
		Scanner input = new Scanner(System.in);
			System.out.println("-------------------------------------");
			System.out.println("Skriv en mening!");
			
			str = input.nextLine().toLowerCase();
			String word = "";
			
			for(int i = 0; i < str.length(); i++) {
				if(str.charAt(i) == 'b' || str.charAt(i) == 'c' || str.charAt(i) == 'd' || str.charAt(i) == 'f' || str.charAt(i) == 'g' || str.charAt(i) == 'h' || str.charAt(i) == 'j' || str.charAt(i) == 'k' || str.charAt(i) == 'l' || str.charAt(i) == 'm' || str.charAt(i) == 'n' || str.charAt(i) == 'p' || str.charAt(i) == 'q' || str.charAt(i) == 'r' || str.charAt(i) == 's' || str.charAt(i) == 't' || str.charAt(i) == 'v' || str.charAt(i) == 'w' || str.charAt(i) == 'x' || str.charAt(i) == 'y' || str.charAt(i) == 'z') {
					word = word + str.charAt(i) + "o" + str.charAt(i);
				}
				else {
					word = word + str.charAt(i);
				}
			}	
		return word;
	}
}