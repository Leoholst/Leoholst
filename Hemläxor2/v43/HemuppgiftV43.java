import java.util.Scanner;

public class HemuppgiftV43 {
	public static void main(String[] args) {
			System.out.println("Volymen p� ett klot med ditt favoritnummer som radien �r: " + volume(0));
			System.out.println("Visste du att ditt favoritord bakl�nges �r: " + reverse(null));
			System.out.println("Du t�nker p� hur m�nga s det finns i Ishockeym�lvaktsskyddsf�rs�ljare! " + "Det �r: " + count("Ishockeym�lvaktsskyddsf�rs�ljare",'s'));
			System.out.println(sjorovare(null));
	}
	/**
	 * 
	 * @param radius Tar in ett v�rde p� radius, vilket �r hur stor radien kommer vara.
	 * @return Returnerar volymen p� klotet med formeln f�r volym f�r klot. Math.PI �r pi och Math.pow �r h�r radien upph�jt till tre.
	 */
	public static double volume(double radius) {
		Scanner input = new Scanner(System.in);
		System.out.println("Skriv ditt favoritnummer!");
		radius = input.nextInt();
		return 4*Math.PI*Math.pow(radius, 3)/3;
	}
	/**
	 * 
	 * @param str Tar in ordet som ska skrivas bakl�nges
	 * Sedan skapar jag variabeln word och anv�nder mig av StringBuffer().reverse().toString() vilket �r ett inbyggt redskap f�r att v�nda p� ord i Java.
	 * @return Returnerar word, vilket �r str bakl�nges.
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
	 * @param str Nu tar vi inte in v�rdet p� str utan jag f�rbest�mmer det sj�lv i main metoden.
	 * @param c Samma sak h�r med c, jag f�rbest�mmer den i main metoden.
	 * Jag skapar sedan variabeln num och s�tter startv�rdet 0, detta �r v�rdet p� hur m�nga g�nger c f�rekommer i str.
	 * Efter det skapar jag en for-loop d�r jag anv�nder str.length() vilket �r l�ngden p� ordet i str.
	 * I for-loopen har jag en if sats, h�r har jag str.charAt(), med den kan vi sikta in oss p� specifika bokst�ver i ordet i str. Jag anv�nder i i str.charAt(i) eftersom d� g�r vi i samma takt som loopen igenom bokst�verna i str.
	 * I if satsen har jag �ven str.charAt(i) == c f�ljt med num++, s� om en bokstav i str �r lika med den valda bokstaven i c, d� �kar num med ett. 
	 * @return Slutligen returnerar jag num med det resultatet p� hur m�nga g�nger c f�rekommer i str.
	 */
	public static int count(String str,char c) {
		Scanner input = new Scanner(System.in);
			System.out.println("-------------------------------------");
			System.out.println("Jag vet vad du t�nker p� just nu!");
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
	 * Denna metoden tar in ett ord p� svenska och skriver ut det p� r�varspr�ket.
	 * F�rst tar jag in ett svenskt ord, str. Sedan har jag en variabel word vilket kommer vara det svenska ordet i r�varspr�k.
	 * Jag har sedan en for-loop i samma stil som i count metoden. I for-loopen har jag en if-sats d�r jag kollar om bokstaven i ordet �r n�gon av alla konsonanter i det svenska alfabetet, med hj�lp av eller-tecknet.
	 * Om det �r sant �ndrar jag word till "bokstaven o bokstaven" t.ex. b blir bob.
	 * Jag avslutar for-loopen med else d�r word bara blir bokstaven allts� �ndras inte bokstaven.
	 * @param str
	 * @return returnerar word som efter for-loopen �r det fullst�ndiga r�varspr�k ordet.
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