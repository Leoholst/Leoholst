import java.util.Scanner;
import java.util.Random;

public class Talspelet {
	public static Scanner input = new Scanner(System.in);
	public static int whatDifficulty = 0;
	public static int easyDifficulty = 0;
	public static int mediumDifficulty = 0;
	public static int hardDifficulty = 0;
	public static int yourGuesses = 0;
	public static boolean youWon = false;
	public static int goAgain = 0;
	public static boolean wantToPlayAgain = true;
	public static boolean quit = false;
	public static int wantToQuit = 0;
	
	public static void main(String[] args) {
		System.out.println(greetings());
		System.out.println(System.lineSeparator() + instructions());
		System.out.println(System.lineSeparator() + difficultyInformation());
		game();
		againOrQuit();
		
	}
	
	/**
	 * Detta �r egentligen den centrala metoden f�r spelet.
	 * Metoden b�rjar med att ange start-v�rdena till de globala variablarna som kommer �ndras s� sm�ningom.
	 * Sedan v�ljer man sv�righetsgrad genom att ange whatDifficulty ett v�rde som s�tter ig�ng en av tre sv�righetsgrads metoder l�ngre ner i koden.
	 * Efter det kommer en for-loop som kommer g�ra 3 iterationer d�r varje iteration �r en gissning, och om gissningen �r samma som  svaret bryts loopen.
	 * D�refter kommer en if med tv� satser som skriver ut om spelaren vann eller f�rlorade vilket best�ms med hj�lp av en variabel som best�ms i for-loopen.
	 */
	public static void game() {
		whatDifficulty = 0;
		easyDifficulty = 0;
		mediumDifficulty = 0;
		hardDifficulty = 0;
		yourGuesses = 0;
		youWon = false;
		
		System.out.println(System.lineSeparator() + chooseDifficulty());
		whatDifficulty = input.nextInt();
		for(int i = 0; i < 3; i++) {
			System.out.println(System.lineSeparator() + startGuessing());
			yourGuesses = input.nextInt();
			if((easyDifficulty == yourGuesses)||(mediumDifficulty == yourGuesses)||(hardDifficulty == yourGuesses)) {
				youWon = true;
				break;
			}
			else if((easyDifficulty != yourGuesses)||(mediumDifficulty != yourGuesses)||(hardDifficulty != yourGuesses)) {
				System.out.println(System.lineSeparator() + wrongAnswer());
				if(yourGuesses < easyDifficulty || yourGuesses < mediumDifficulty || yourGuesses < hardDifficulty) {
					System.out.println("Talet �r h�gre.");
				}
				else if(yourGuesses > easyDifficulty || yourGuesses > mediumDifficulty || yourGuesses > hardDifficulty) {
					System.out.println("Talet �r l�gre.");
				}
			}
		}
		if(youWon == false) {
			System.out.println(System.lineSeparator() + youLose());
		}
		else if(youWon == true) {
			System.out.println(System.lineSeparator() + congratulations());
		}
	}
	
	/**
	 * Denna metod styr �ver spela igen eller avsluta segmentet.
	 * Den b�rjar med att ge alla variablerna sina startv�rden.
	 * Sedan kommer en while-loop som itererar s� l�nge quit �r false.
	 * Loopen b�rjar med att anropa metoden playAgain() samt ta in ett v�rde till variabeln goAgain.
	 * Sedan kommer en if med tv� satser d�r beroende p� vad man svarade dvs. vilket v�rde goAgain har s� antingen anropas metoden game() och man spelar igen.
	 * Om man gav goAgain det andra v�rdet m�jligt, s� anropar man p� metoden goQuit() genom att wantToPlayAgain blir false och en if-sats, i denna if-sats f�r man �ven ange wantToQuit ett v�rde.
	 * Beroende p� vilket v�rde man angav till wantToQuit, s� kommer antingen spelet avslutas eller k�ras igen.
	 */
	public static void againOrQuit() {
		goAgain = 0;
		wantToPlayAgain = true;
		quit = false;
		wantToQuit = 0;
		
		while(quit == false) {
			System.out.println(System.lineSeparator() + playAgain());
			goAgain = input.nextInt();
			if(goAgain == 1) {
				game();
			}
			else if(goAgain == 2) {
				wantToPlayAgain = false;
			}
			if(wantToPlayAgain == false) {
				System.out.println(System.lineSeparator() + goQuit());
				wantToQuit = input.nextInt();
			}
			if(wantToQuit == 1) {
				System.out.println(exitMessage());
				quit = true;
			}
			else if(wantToQuit == 2) {
				game();
			}
		}
	}
	
	/**
	 * String welcome �r ett v�lkomst meddelande.
	 * @return Skickar tillbaka welcome.
	 */
	public static String greetings() {
		String welcome = "Welcome to Talspelet!" + System.lineSeparator() + "This game is all about guessing numbers!";
		return welcome;
	}
	
	/**
	 * instructions �r ett meddelande med instruktioner om spelet
	 * @return Skickar tillbaka instructions
	 */
	public static String instructions() {
		String instructions = "Instructions" + System.lineSeparator() + "First off you are going to choose a difficulty. There are three different settings to choose from, ranging from easy to hard." + System.lineSeparator() + "After that comes the guessing part! Simply write one number from inside the difficulties range. If you write the wrong one you have to guess again." + System.lineSeparator() + "In order to win you just have to guess the right number, easy right? But watch out! You only have three tries before you run out of guesses and lose!";
		return instructions;
	}
	
	/**
	 * difficultyInformation �r information om sv�righetsgraderna.
	 * @return skickar tillbaka difficultyInformation.
	 */
	public static String difficultyInformation() {
		String difficultyInformation = "Difficulty Information" + System.lineSeparator() + "The Easy Difficulty setting is the easiest with numbers ranging from 0 to 5." + System.lineSeparator() + "The Medium Difficulty setting has numbers ranging from 0 to 10." + System.lineSeparator() + "The Hard Difficulty setting is the hardest with numbers ranging from 0 to 20.";
		return difficultyInformation;
	}
	
	/**
	 * chooseDifficulty s�ger att man ska v�lja sv�righetsgrad och vilka alternativ det finns.
	 * @return skickar tillbaka chooseDifficulty.
	 */
	public static String chooseDifficulty() {
		String chooseDifficulty = "Choose Difficulty" + System.lineSeparator() + "(1) To choose the Easy Difficulty" + System.lineSeparator() + "(2) To choose the Medium Difficulty" + System.lineSeparator() + "(3) To choose the Hard Difficulty";
		return chooseDifficulty;
	}
	
	/**
	 * rand genererar ett slumpm�ssigt heltal mellan 0 och 5.
	 * if-satsen s�ger att om man valde den enkla sv�righetsgraden genom att skriva 1 s� kommer det slumpm�ssiga heltalet slumpas.
	 * @return skickar tillbaka det slumpm�ssiga heltalet.
	 */
	public static int easyDifficulty() {
		Random rand = new Random();
		if(whatDifficulty==1) {
			easyDifficulty = rand.nextInt(5+1);
			return easyDifficulty;
		}
		return 0;
	}
	
	/**
	 * rand genererar ett slumpm�ssigt heltal mellan 0 och 10.
	 * if-satsen s�ger att om man valde den medium sv�righetsgraden genom att skriva 2 s� kommer det slumpm�ssiga heltalet slumpas.
	 * @return skickar tillbaka det slumpm�ssiga heltalet.
	 */
	public static int mediumDifficulty() {
		Random rand = new Random();
		if(whatDifficulty==2) {
			mediumDifficulty = rand.nextInt(10+1);
			return mediumDifficulty;
		}
		return 0;
	}
	
	/**
	 * rand genererar ett slumpm�ssigt heltal mellan 0 och 20.
	 * if-satsen s�ger att om man valde den sv�ra sv�righetsgraden genom att skriva 3 s� kommer det slumpm�ssiga heltalet slumpas.
	 * @return skickar tillbaka det slumpm�ssiga heltalet.
	 */
	public static int hardDifficulty() {
		Random rand = new Random();
		if(whatDifficulty==3) {
			hardDifficulty = rand.nextInt(20+1);
			return hardDifficulty;
		}
		return 0;
	}
	
	/**
	 * String startGuessing som bara �r en indikering s� att man vet att man ska skriva sin gissning.
	 * @return skickar tillbaka startGuessing.
	 */
	public static String startGuessing() {
		String startGuessing = "Your Guess:";
		return startGuessing;
	}
	
	/**
	 * String congratulations som skriver ut ett gratulations meddelande n�r man vinner.
	 * @return skickar tillbaka congratulations.
	 */
	public static String congratulations() {
		String congratulations = "Ding! Ding! Ding! Congratulations! You have guessed the right number!";
		return congratulations;
	}
	
	/**
	 * String wrongAnswer som skriver ut att svaret inte �r r�tt.
	 * @return skickar tillbaka wrongAnswer.
	 */
	public static String wrongAnswer() {
		String wrongAnswer = "That is not right...";
		return wrongAnswer;
	}
	
	/**
	 * String youLose som skriver ut att du har f�rlorat.
	 * @return skickar tillbaka youLose.
	 */
	public static String youLose() {
		String youLose = "Oh no... It seems you have run out of guesses and lost!";
		return youLose;
	}
	
	/**
	 * String playAgain som fr�gar om man vill k�ra igen och ger alternativen.
	 * @return skickar tillbaka playAgain.
	 */
	public static String playAgain() {
		String playAgain = "Do want to play again?" + System.lineSeparator() + "(1) Yes" + System.lineSeparator() + "(2) No";
		return playAgain;
	}
	
	/**
	 * String wantToQuit som fr�gar om man vill avsluta och ger alternativen.
	 * @return skickar tillbaka wantToQuit.
	 */
	public static String goQuit() {
		String wantToQuit = "Do you want to Quit?" + System.lineSeparator() + "(1) Yes" + System.lineSeparator() + "(2) No";
		return wantToQuit;
	}
	
	/**
	 * String exitMessage ber�ttar f�r spelaren att spelet avslutas.
	 * @return skickar tillbaka exitMessage.
	 */
	public static String exitMessage() {
		String exitMessage = "Please hold, game exiting...";
		return exitMessage;
	}
	
	/**
	 * Jag t�nkte g�ra en metod som helt enkelt kommer in ist�llet f�r error meddelandet som konsolen ger.
	 * Jag anv�nde if-satser och skrev ifall int variablarna mottar en input som inte �r ett godtagbart svar.
	 * Tyv�rr fungerade inte detta som jag t�nkte, ist�llet adderar den ihop det eftersom jag anv�nde plustecken.
	 */
	public static void errorChecker() {
		if(whatDifficulty != 1 + 2 + 3) {
			System.out.println(errorMessage());
			againOrQuit();
		}
		else if(yourGuesses != 0 + 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11 + 12 + 13 + 14 + 15 + 16 + 17 + 18 + 19 + 20) {
			System.out.println(errorMessage());
			againOrQuit();
		}
		else if(goAgain != 1 + 2) {
			System.out.println(errorMessage());
			againOrQuit();
		}
		else if(wantToQuit != 1 + 2) {
			System.out.println(errorMessage());
			againOrQuit();
		}
		else if(whatDifficulty == 'a' + 'b' + 'c' + 'd' + 'e' + 'f' + 'g' + 'h' + 'i' + 'j' + 'k' + 'l' + 'm' + 'n' + 'o' + 'p' + 'q' + 'r' + 's' + 't' + 'u' + 'v' + 'w' + 'z' + 'y' + 'x' + '�' + '�' + '�') {
			System.out.println(errorMessage());
			againOrQuit();
		}
		else if(yourGuesses == 'a' + 'b' + 'c' + 'd' + 'e' + 'f' + 'g' + 'h' + 'i' + 'j' + 'k' + 'l' + 'm' + 'n' + 'o' + 'p' + 'q' + 'r' + 's' + 't' + 'u' + 'v' + 'w' + 'z' + 'y' + 'x' + '�' + '�' + '�') {
			System.out.println(errorMessage());
			againOrQuit();
		}
		else if(goAgain == 'a' + 'b' + 'c' + 'd' + 'e' + 'f' + 'g' + 'h' + 'i' + 'j' + 'k' + 'l' + 'm' + 'n' + 'o' + 'p' + 'q' + 'r' + 's' + 't' + 'u' + 'v' + 'w' + 'z' + 'y' + 'x' + '�' + '�' + '�') {
			System.out.println(errorMessage());
			againOrQuit();
		}
		else if(wantToQuit == 'a' + 'b' + 'c' + 'd' + 'e' + 'f' + 'g' + 'h' + 'i' + 'j' + 'k' + 'l' + 'm' + 'n' + 'o' + 'p' + 'q' + 'r' + 's' + 't' + 'u' + 'v' + 'w' + 'z' + 'y' + 'x' + '�' + '�' + '�') {
			System.out.println(errorMessage());
			againOrQuit();
		}
	}
	
	/**
	 * String errorMessage som s�ger till spelaren att det inte g�r.
	 * @return Skickar tillbaka String errorMessage.
	 */
	public static String errorMessage() {
		String errorMessage = "I'm sorry I can't accept that answer, you're gonna have to try again.";
		return errorMessage;
	}
}
	