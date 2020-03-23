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
	 * Detta är egentligen den centrala metoden för spelet.
	 * Metoden börjar med att ange start-värdena till de globala variablarna som kommer ändras så småningom.
	 * Sedan väljer man svårighetsgrad genom att ange whatDifficulty ett värde som sätter igång en av tre svårighetsgrads metoder längre ner i koden.
	 * Efter det kommer en for-loop som kommer göra 3 iterationer där varje iteration är en gissning, och om gissningen är samma som  svaret bryts loopen.
	 * Därefter kommer en if med två satser som skriver ut om spelaren vann eller förlorade vilket bestäms med hjälp av en variabel som bestäms i for-loopen.
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
					System.out.println("Talet är högre.");
				}
				else if(yourGuesses > easyDifficulty || yourGuesses > mediumDifficulty || yourGuesses > hardDifficulty) {
					System.out.println("Talet är lägre.");
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
	 * Denna metod styr över spela igen eller avsluta segmentet.
	 * Den börjar med att ge alla variablerna sina startvärden.
	 * Sedan kommer en while-loop som itererar så länge quit är false.
	 * Loopen börjar med att anropa metoden playAgain() samt ta in ett värde till variabeln goAgain.
	 * Sedan kommer en if med två satser där beroende på vad man svarade dvs. vilket värde goAgain har så antingen anropas metoden game() och man spelar igen.
	 * Om man gav goAgain det andra värdet möjligt, så anropar man på metoden goQuit() genom att wantToPlayAgain blir false och en if-sats, i denna if-sats får man även ange wantToQuit ett värde.
	 * Beroende på vilket värde man angav till wantToQuit, så kommer antingen spelet avslutas eller köras igen.
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
	 * String welcome är ett välkomst meddelande.
	 * @return Skickar tillbaka welcome.
	 */
	public static String greetings() {
		String welcome = "Welcome to Talspelet!" + System.lineSeparator() + "This game is all about guessing numbers!";
		return welcome;
	}
	
	/**
	 * instructions är ett meddelande med instruktioner om spelet
	 * @return Skickar tillbaka instructions
	 */
	public static String instructions() {
		String instructions = "Instructions" + System.lineSeparator() + "First off you are going to choose a difficulty. There are three different settings to choose from, ranging from easy to hard." + System.lineSeparator() + "After that comes the guessing part! Simply write one number from inside the difficulties range. If you write the wrong one you have to guess again." + System.lineSeparator() + "In order to win you just have to guess the right number, easy right? But watch out! You only have three tries before you run out of guesses and lose!";
		return instructions;
	}
	
	/**
	 * difficultyInformation är information om svårighetsgraderna.
	 * @return skickar tillbaka difficultyInformation.
	 */
	public static String difficultyInformation() {
		String difficultyInformation = "Difficulty Information" + System.lineSeparator() + "The Easy Difficulty setting is the easiest with numbers ranging from 0 to 5." + System.lineSeparator() + "The Medium Difficulty setting has numbers ranging from 0 to 10." + System.lineSeparator() + "The Hard Difficulty setting is the hardest with numbers ranging from 0 to 20.";
		return difficultyInformation;
	}
	
	/**
	 * chooseDifficulty säger att man ska välja svårighetsgrad och vilka alternativ det finns.
	 * @return skickar tillbaka chooseDifficulty.
	 */
	public static String chooseDifficulty() {
		String chooseDifficulty = "Choose Difficulty" + System.lineSeparator() + "(1) To choose the Easy Difficulty" + System.lineSeparator() + "(2) To choose the Medium Difficulty" + System.lineSeparator() + "(3) To choose the Hard Difficulty";
		return chooseDifficulty;
	}
	
	/**
	 * rand genererar ett slumpmässigt heltal mellan 0 och 5.
	 * if-satsen säger att om man valde den enkla svårighetsgraden genom att skriva 1 så kommer det slumpmässiga heltalet slumpas.
	 * @return skickar tillbaka det slumpmässiga heltalet.
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
	 * rand genererar ett slumpmässigt heltal mellan 0 och 10.
	 * if-satsen säger att om man valde den medium svårighetsgraden genom att skriva 2 så kommer det slumpmässiga heltalet slumpas.
	 * @return skickar tillbaka det slumpmässiga heltalet.
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
	 * rand genererar ett slumpmässigt heltal mellan 0 och 20.
	 * if-satsen säger att om man valde den svåra svårighetsgraden genom att skriva 3 så kommer det slumpmässiga heltalet slumpas.
	 * @return skickar tillbaka det slumpmässiga heltalet.
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
	 * String startGuessing som bara är en indikering så att man vet att man ska skriva sin gissning.
	 * @return skickar tillbaka startGuessing.
	 */
	public static String startGuessing() {
		String startGuessing = "Your Guess:";
		return startGuessing;
	}
	
	/**
	 * String congratulations som skriver ut ett gratulations meddelande när man vinner.
	 * @return skickar tillbaka congratulations.
	 */
	public static String congratulations() {
		String congratulations = "Ding! Ding! Ding! Congratulations! You have guessed the right number!";
		return congratulations;
	}
	
	/**
	 * String wrongAnswer som skriver ut att svaret inte är rätt.
	 * @return skickar tillbaka wrongAnswer.
	 */
	public static String wrongAnswer() {
		String wrongAnswer = "That is not right...";
		return wrongAnswer;
	}
	
	/**
	 * String youLose som skriver ut att du har förlorat.
	 * @return skickar tillbaka youLose.
	 */
	public static String youLose() {
		String youLose = "Oh no... It seems you have run out of guesses and lost!";
		return youLose;
	}
	
	/**
	 * String playAgain som frågar om man vill köra igen och ger alternativen.
	 * @return skickar tillbaka playAgain.
	 */
	public static String playAgain() {
		String playAgain = "Do want to play again?" + System.lineSeparator() + "(1) Yes" + System.lineSeparator() + "(2) No";
		return playAgain;
	}
	
	/**
	 * String wantToQuit som frågar om man vill avsluta och ger alternativen.
	 * @return skickar tillbaka wantToQuit.
	 */
	public static String goQuit() {
		String wantToQuit = "Do you want to Quit?" + System.lineSeparator() + "(1) Yes" + System.lineSeparator() + "(2) No";
		return wantToQuit;
	}
	
	/**
	 * String exitMessage berättar för spelaren att spelet avslutas.
	 * @return skickar tillbaka exitMessage.
	 */
	public static String exitMessage() {
		String exitMessage = "Please hold, game exiting...";
		return exitMessage;
	}
	
	/**
	 * Jag tänkte göra en metod som helt enkelt kommer in istället för error meddelandet som konsolen ger.
	 * Jag använde if-satser och skrev ifall int variablarna mottar en input som inte är ett godtagbart svar.
	 * Tyvärr fungerade inte detta som jag tänkte, istället adderar den ihop det eftersom jag använde plustecken.
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
		else if(whatDifficulty == 'a' + 'b' + 'c' + 'd' + 'e' + 'f' + 'g' + 'h' + 'i' + 'j' + 'k' + 'l' + 'm' + 'n' + 'o' + 'p' + 'q' + 'r' + 's' + 't' + 'u' + 'v' + 'w' + 'z' + 'y' + 'x' + 'å' + 'ä' + 'ö') {
			System.out.println(errorMessage());
			againOrQuit();
		}
		else if(yourGuesses == 'a' + 'b' + 'c' + 'd' + 'e' + 'f' + 'g' + 'h' + 'i' + 'j' + 'k' + 'l' + 'm' + 'n' + 'o' + 'p' + 'q' + 'r' + 's' + 't' + 'u' + 'v' + 'w' + 'z' + 'y' + 'x' + 'å' + 'ä' + 'ö') {
			System.out.println(errorMessage());
			againOrQuit();
		}
		else if(goAgain == 'a' + 'b' + 'c' + 'd' + 'e' + 'f' + 'g' + 'h' + 'i' + 'j' + 'k' + 'l' + 'm' + 'n' + 'o' + 'p' + 'q' + 'r' + 's' + 't' + 'u' + 'v' + 'w' + 'z' + 'y' + 'x' + 'å' + 'ä' + 'ö') {
			System.out.println(errorMessage());
			againOrQuit();
		}
		else if(wantToQuit == 'a' + 'b' + 'c' + 'd' + 'e' + 'f' + 'g' + 'h' + 'i' + 'j' + 'k' + 'l' + 'm' + 'n' + 'o' + 'p' + 'q' + 'r' + 's' + 't' + 'u' + 'v' + 'w' + 'z' + 'y' + 'x' + 'å' + 'ä' + 'ö') {
			System.out.println(errorMessage());
			againOrQuit();
		}
	}
	
	/**
	 * String errorMessage som säger till spelaren att det inte går.
	 * @return Skickar tillbaka String errorMessage.
	 */
	public static String errorMessage() {
		String errorMessage = "I'm sorry I can't accept that answer, you're gonna have to try again.";
		return errorMessage;
	}
}
	