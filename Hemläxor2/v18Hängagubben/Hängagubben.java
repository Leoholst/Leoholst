import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class H�ngagubben {
	public static Scanner input = new Scanner(System.in);
	public static boolean difficulty;
	public static ArrayList<String> easyWords = new ArrayList<String>();
	public static ArrayList<String> hardWords = new ArrayList<String>();
	public static String secretWord;
	public static char guess;
	public static int maxGuesses;
	public static boolean wordGuessed = false;
	public static int goAgain = 0;
	public static boolean wantToPlayAgain = true;
	public static boolean quit = false;
	public static int wantToQuit = 0;
	
	/** Detta �r main metoden
	 * Jag ville inte ha f�r mycket kod i main metoden, d�rf�r anropar jag endast tv� andra metoder fr�n main.
	 * @param args
	 */
	public static void main(String[] args) {
		welcomeAndRules();
		game();
	}
	
	/** Detta �r huvudmetoden och fungerar som startrutan i hela spelet.
	 * Denna metoden anropar metoderna som utg�r spelet, i r�tt ordning.
	 */
	public static void game() {
		System.out.println(System.lineSeparator() + whatDifficulty());
		chooseDifficulty();
		setEasyDifficulty();
		setHardDifficulty();
		haveAGo();
		guess();
		guessingLoop();
		winChecker();
		againOrQuit();
	}
	
	/** Denna metoden fungerar som en mellanhand.
	 * Allt denna metoden g�r �r att skriva ut tv� andra metoder.
	 */
	public static void welcomeAndRules() {
		System.out.println(welcome());
		System.out.println(System.lineSeparator() + instructions());
	}
	
	/** Denna metoden utg�r gissnings delen av spelet.
	 * Metoden best�r av en while loop som itererar s� l�nge maxGuesses �r lika med eller under 6, eller om wordGuessed �r false.
	 * Den anropar �ven tv� andra metoder.
	 */
	public static void guessingLoop() {
		while(maxGuesses <= 6) {
			rightGuessEasyWordsCheck();
			if(wordGuessed == true) {
				break;
			}
			rightGuessHardWordsCheck();
			if(wordGuessed == true) {
				break;
			}
		}
	}
	
	/** Som namnet antyder kollar denna metoden om man har vunnit.
	 * Om wordGuessed �r true anropas youWin metoden
	 * Medans om wordGuessed �r false anropas youLose metoden.
	 */
	public static void winChecker() {
		if(wordGuessed == true) {
			System.out.println(youWin());
		}
		else if(wordGuessed == false) {
			System.out.println(youLose());
		}
	}

	/** Denna metoden �r till f�r att �terst�lla de v�sentliga variablerna
	 * Detta �r f�r att man ska kunna k�ra spelet igen flera g�nger
	 * Eftersom om variablerna inte �terst�lls kan de p�verka resultaten p� n�sta omg�ng.
	 */
	public static void variabelReset() {
		maxGuesses = 0;
		wordGuessed = false;
		quit = false;
		goAgain = 0;
		wantToPlayAgain = true;
		wantToQuit = 0;
	}
	
	/** Denna metoden tar hand om delen d�r spelaren f�r v�lja om den vill k�ra igen.
	 * Den best�r av en while-loop som itererar s� l�nge quit �r false.
	 * F�rst anropas playAgain och sedan tas en int in fr�n konsollen som m.h.a. en if-sats
	 * best�mmer om variabelReset och sedan game eller om goQuit ska anropas, goQuit f�ljs av
	 * ytterligare en int som tas in, som best�mmer om quit ska bli true och while loopen bryts
	 * och spelet st�ngs av, eller om variabelReset och game ska anropas.
	 */
	public static void againOrQuit() {
		while(quit == false) {
			System.out.println(System.lineSeparator() + playAgain());
			goAgain = input.nextInt();
			if(goAgain == 1) {
				variabelReset();
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
				System.out.println(System.lineSeparator() + exitMessage());
				quit = true;
			}
			else if(wantToQuit == 2) {
				variabelReset();
				game();
			}
		}
	}
	
	/** welcome �r en metod som h�lsar spelaren v�lkommen
	 * String playerGreeting som v�lkommnar spelaren och f�rklarar vad spelet g�r ut p�.
	 * @return String playerGreeting
	 */
	public static String welcome() {
		String playerGreeting = "Welcome to Hangman! In this game you will be guessing letters in an unknown word, sounds simple enough? " +
        System.lineSeparator()  + "Well watch out, with every letter you guess wrong one line will be drawn on the man until he is hanged and you lose!";
		return playerGreeting;
	}
	
	/** Denna metoden f�rklarar reglerna f�r spelaren
	 * String instructions som endast f�rklarar reglerna
	 * @return String instructions
	 */
	public static String instructions() {
		String instructions = "The rules are easy, simply write a letter and you will either see it pop up in the word or see a line being drawn." +
		System.lineSeparator() + "When the man is hanged you lose! But when you have guessed all the letters in the word you win!" + 
		System.lineSeparator() + "There is two difficulties to choose from, easy and hard. Easy is shorter words while hard is longer.";
		return instructions;
	}
	
	/** Denna metoden ger spelaren ett val om vilken sv�righetsgrad den vill ha
	 * String whatDifficulty st�ller fr�gan om vilken sv�righetsgrad spelaren vill ha, antingen enkel eller sv�r
	 * @return String whatDifficulty
	 */
	public static String whatDifficulty() {
		String whatDifficulty = "Choose your desired difficulty!" + System.lineSeparator() + "(1) Easy" + System.lineSeparator() + "(2) Hard";
		return whatDifficulty;
	}
	
	/** Denna metod tar in spelarens svar fr�n f�rra metoden och f�rverkligar det.
	 * int whichDifficulty tar in en int fr�n konsollen
	 * Detta heltal best�mmer i sin tur om den globala variabeln difficulty ska bli true eller false.
	 */
	public static void chooseDifficulty() {
		int whichDifficulty = 0;
		whichDifficulty = input.nextInt();
		
		if (whichDifficulty == 1) {
			difficulty = true;
		}
		else if (whichDifficulty == 2) {
			difficulty = false;
		}
		
	}
	
	/** Denna metod slumpar det enkla ordet som spelaren ska gissa p�
	 * F�rst l�gger jag till fem ord som utg�r den globala ArrayList<String> easyWords med enkla ord.
	 * Sedan beroende p� om spelaren valde enkel sv�righetsgrad, slumpar ett random heltal
	 * m.h.a. Random(), vilket i enkelhet generar ett slumpat nummer i intervallet i ArrayListen, dvs. fr�n 0-4.
	 * Detta heltal tar sedan ut motsvarande index i ArrayList:en och
	 * s�tter sedan globala String secretWord till detta nu slumpade ordet.
	 */
	public static void setEasyDifficulty() {
		easyWords.add("BIL");
		easyWords.add("HUS");
		easyWords.add("BAD");
		easyWords.add("MAT");
		easyWords.add("BRA");
		
		if(difficulty == true) {
			Random randomNumber = new Random();
			int chosenWord = randomNumber.nextInt(easyWords.size());
			secretWord = easyWords.get(chosenWord);
		}
	}
	
	/** Denna metod slumpar det sv�ra ordet som spelaren ska gissa p�
	 * F�rst l�gger jag till fem ord som utg�r den globala ArrayList<String> hardWords med sv�ra ord.
	 * Sedan beroende p� om spelaren valde sv�r sv�righetsgrad, slumpar ett random heltal
	 * m.h.a. Random(), vilket i enkelhet generar ett slumpat nummer i intervallet i ArrayListen, dvs. fr�n 0-4.
	 * Detta heltal tar sedan ut motsvarande index i ArrayListen och
	 * s�tter sedan globala String secretWord till detta nu slumpade ordet.
	 */
	public static void setHardDifficulty() {
		hardWords.add("PIANO");
		hardWords.add("FRISK");
		hardWords.add("TJOCK");
		hardWords.add("TJENA");
		hardWords.add("BYXOR");
		
		if(difficulty == false) {
			Random randomNumber = new Random();
			int chosenWord = randomNumber.nextInt(hardWords.size());
			secretWord = hardWords.get(chosenWord);
		}
	}
	
	/** Denna metoden f�rklarar att spelaren ska gissa
	 * Det enda denna metoden g�r �r att f�rtydliga att spelaren ska gissa 
	 */
	public static void haveAGo() {
		System.out.println(System.lineSeparator() + "Your Guess:");
	}
	
	/** Denna metoden tar in spelarens gissning och g�r den till stor bokstav.
	 * globala char Guess Tar in en bokstav fr�n konsollen som �r spelarens gissning
	 * m.h.a. .toUpperCase g�rs gissningen till stor bokstav 
	 * eftersom orden �r skrivna i stora bokst�ver och de ska j�mf�ras i kommande metoder
	 * @return char Guess
	 */
	public static char guess() {
		guess = input.next().charAt(0);
		guess = Character.toUpperCase(guess);
		return guess;
	}
	
	/** Denna metoden j�mf�r gissingen med r�tt svar m.m.
	 * Denna metoden �r h�r gissningen kollas om den �r r�tt eller fel
	 * Metoden best�r av en if-sats som �r tr�skeln f�r hela metoden och g�r att passera
	 * om spelaren valde enkel sv�righetsgrad.
	 * Sedan kommer en while-loop som itererar medans maxguesses �r lika med eller under 6, 
	 * dvs. medans spelaren fortfarande har gissningar kvar.
	 * Det som f�ljer �r en m�ngd av if-, else if- och else-satser, d�r vid varje sats j�mf�rs gissningen 
	 * med antingen f�rsta, andra, tredje bokstaven i ordet. 
	 * Sedan dubbelkollar programmet �ven om de andra bokst�verna i ordet redan har gissats r�tt p�,
	 * om varken en eller alla har det skrivs den eller de ut p� sina r�tta platser.
	 * Sedan om hela ordet har skrivits ut s�tts wordGuessed till true som bryter 
	 * while-loopen i metoden guessingLoop(), och bryter while-loopen.
	 * Om gissningen inte st�mmer anropas hangMan metoden och maxGuesses adderas med 1 tills den blir 7 och while-loopen bryts, 
	 * �ven while-loopen i metoden guessingLoop(). 
	 * char firstLetter �r f�rsta bokstaven i ordet.
	 * char secondLetter �r andra bokstaven i ordet.
	 * char thirdLetter �r trejde bokstaven i ordet.
	 */
	public static void rightGuessEasyWordsCheck() {
		char firstLetter = ' ';
		char secondLetter = ' ';
		char thirdLetter = ' ';
	
		if(difficulty == true) {
			while(maxGuesses <= 6) {
					if(guess == secretWord.charAt(0)) {
						firstLetter = guess;
						if(secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2)) {
							System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter);
							wordGuessed = true;
							break;
						}
						else if(secondLetter == secretWord.charAt(1)) {
							System.out.println(firstLetter + " " + secondLetter + " _");
						}
						else if(thirdLetter == secretWord.charAt(2)) {
							System.out.println(firstLetter + " _ " + thirdLetter);
						}
						else {
							System.out.println(firstLetter + " _ " + " _");
						}
					}
					else if(guess == secretWord.charAt(1)) {
						secondLetter = guess;
						if(firstLetter == secretWord.charAt(0) && thirdLetter == secretWord.charAt(2)) {
							System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter);
							wordGuessed = true;
							break;
						}
						else if(firstLetter == secretWord.charAt(0)) {
							System.out.println(firstLetter + " " + secondLetter + " _");
						}
						else if(thirdLetter == secretWord.charAt(2)) {
							System.out.println("_ " + secondLetter + " " + thirdLetter);
						}
						else {
							System.out.println("_ " + secondLetter + " _");
						}
					}
					else if(guess == secretWord.charAt(2)) {
						thirdLetter = guess;
						if(firstLetter == secretWord.charAt(0) && secondLetter == secretWord.charAt(1)) {
							System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter);
							wordGuessed = true;
							break;
						}
						else if(firstLetter == secretWord.charAt(0)) {
							System.out.println(firstLetter + " _ " + thirdLetter);
						}
						else if(secondLetter == secretWord.charAt(1)) {
							System.out.println("_ " + secondLetter + " " + thirdLetter);
						}
						else {
							System.out.println("_ " + " _ " + thirdLetter);
						}
					}
					else {
						hangman();
						maxGuesses += 1;
					}
				if(maxGuesses <= 6) {
				haveAGo();
				guess();
				}
				}
			}
		}			
	
	/** Denna metoden j�mf�r gissningen med r�tt svar m.m.
	 * Denna metoden �r h�r gissningen kollas om den �r r�tt eller fel
	 * Metoden best�r av en if-sats som �r tr�skeln f�r hela metoden och g�r att passera
	 * om spelaren valde sv�r sv�righetsgrad.
	 * Sedan kommer en while-loop som itererar medans maxguesses �r lika med eller under 6, 
	 * dvs. medans spelaren fortfarande har gissningar kvar.
	 * Det som f�ljer �r en m�ngd av if-, else if- och else-satser, d�r vid varje sats j�mf�rs gissningen 
	 * med antingen f�rsta, andra, tredje, fj�rde eller femte bokstaven i ordet.
	 * Sedan dubbelkollar programmet �ven om de andra bokst�verna i ordet redan har gissats r�tt p�,
	 * om varken en eller alla har det skrivs den eller de ut p� sina r�tta platser.
	 * Sedan om hela ordet har skrivits ut s�tts wordGuessed till true som bryter 
	 * while-loopen i metoden guessingLoop(), och bryter while-loopen.
	 * Om gissningen inte st�mmer anropas hangMan metoden och maxGuesses adderas med 1 tills den blir 7 och while-loopen bryts, 
	 * �ven while-loopen i metoden guessingLoop().
	 * char firstLetter �r f�rsta bokstaven i ordet.
	 * char secondLetter �r andra bokstaven i ordet.
	 * char thirdLetter �r trejde bokstaven i ordet.
	 * char fourthLetter �r fj�rde bokstaven i ordet.
	 * char fifthLetter �r femte bokstaven i ordet.
	 */
	public static void rightGuessHardWordsCheck() {
		char firstLetter = ' ';
		char secondLetter = ' ';
		char thirdLetter = ' ';
		char fourthLetter = ' ';
		char fifthLetter = ' ';
		
		if(difficulty == false) {
			while(maxGuesses <= 6) {
				if(guess == secretWord.charAt(0)) {
					firstLetter = guess;
					if(secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2) && fourthLetter == secretWord.charAt(3) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
						wordGuessed = true;
						break;
					}
					else if(secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2) && fourthLetter == secretWord.charAt(3)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " " + fourthLetter + " _");
					}
					else if(secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " _ " + fifthLetter);
					}
					else if(secondLetter == secretWord.charAt(1) && fourthLetter == secretWord.charAt(3) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " " + secondLetter + " _ " + fourthLetter + " " + fifthLetter);
					}
					else if(thirdLetter == secretWord.charAt(2) && fourthLetter == secretWord.charAt(3) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " _ " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
					}
					else if(secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " _ " + " _");
					}
					else if(secondLetter == secretWord.charAt(1) && fourthLetter == secretWord.charAt(3)) {
						System.out.println(firstLetter + " " + secondLetter + " _ " + fourthLetter + " _");
					}
					else if(secondLetter == secretWord.charAt(1) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " " + secondLetter + " _ " + " _ " + fifthLetter);
					}
					else if(thirdLetter == secretWord.charAt(2) && fourthLetter == secretWord.charAt(3)) {
						System.out.println(firstLetter + " _ " + thirdLetter + " " + fourthLetter + " _");
					}
					else if(thirdLetter == secretWord.charAt(2) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " _ " + thirdLetter + " _ " + fifthLetter);
					}
					else if(fourthLetter == secretWord.charAt(3) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " _ " + " _ " + fourthLetter + " " + fifthLetter);
					}
					else if(secondLetter == secretWord.charAt(1)) {
						System.out.println(firstLetter + " " + secondLetter + " _ " + " _ " + " _");
					}
					else if(thirdLetter == secretWord.charAt(2)) {
						System.out.println(firstLetter + " _ " + thirdLetter + " _ " + " _");
					}
					else if(fourthLetter == secretWord.charAt(3)) {
						System.out.println(firstLetter + " _ " + " _ " + fourthLetter + " _");
					}
					else if(fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " _ " + " _ " + " _ " + fifthLetter);
					}
					else {
						System.out.println(firstLetter + " _ " + " _ " + " _ " + " _");
					}
				}
				else if(guess == secretWord.charAt(1)) {
					secondLetter = guess;
					if(firstLetter == secretWord.charAt(0) && thirdLetter == secretWord.charAt(2) && fourthLetter == secretWord.charAt(3) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
						wordGuessed = true;
						break;
					}
					else if(firstLetter == secretWord.charAt(0) && thirdLetter == secretWord.charAt(2) && fourthLetter == secretWord.charAt(3)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " " + fourthLetter + " _");
					}
					else if(firstLetter == secretWord.charAt(0) && thirdLetter == secretWord.charAt(2) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " _ " + fifthLetter);
					}
					else if(firstLetter == secretWord.charAt(0) && fourthLetter == secretWord.charAt(3) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " " + secondLetter + " _ " + fourthLetter + " " + fifthLetter);
					}
					else if(thirdLetter == secretWord.charAt(2) && fourthLetter == secretWord.charAt(3) && fifthLetter == secretWord.charAt(4)) {
						System.out.println("_ " + secondLetter + " " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
					}
					else if(firstLetter == secretWord.charAt(0) && thirdLetter == secretWord.charAt(2)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " _ " + " _");
					}
					else if(firstLetter == secretWord.charAt(0) && fourthLetter == secretWord.charAt(3)) {
						System.out.println(firstLetter + " " + secondLetter + " _ " + fourthLetter + " _");
					}
					else if(firstLetter == secretWord.charAt(0) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " " + secondLetter + " _ " + " _ " + fifthLetter);
					}
					else if(thirdLetter == secretWord.charAt(2) && fourthLetter == secretWord.charAt(3)) {
						System.out.println("_ " + secondLetter + " " + thirdLetter + " " + fourthLetter + " _");
					}
					else if(thirdLetter == secretWord.charAt(2) && fifthLetter == secretWord.charAt(4)) {
						System.out.println("_ " + secondLetter + " " + thirdLetter + " _ " + fifthLetter);
					}
					else if(fourthLetter == secretWord.charAt(3) && fifthLetter == secretWord.charAt(4)) {
						System.out.println("_ " + secondLetter + " _ " + fourthLetter + " " + fifthLetter);
					}
					else if(firstLetter == secretWord.charAt(0)) {
						System.out.println(firstLetter + " " + secondLetter + " _ " + " _ " + " _");
					}
					else if(thirdLetter == secretWord.charAt(2)) {
						System.out.println("_ " + secondLetter + " " + thirdLetter + " _ " + " _");
					}
					else if(fourthLetter == secretWord.charAt(3)) {
						System.out.println("_ " + secondLetter + " _ " + fourthLetter + " _");
					}
					else if(fifthLetter == secretWord.charAt(4)) {
						System.out.println("_ " + secondLetter + " _ " + " _ " + fifthLetter);
					}
					else {
						System.out.println("_ " + secondLetter + " _ " + " _ " + " _");
					}
				}
				else if(guess == secretWord.charAt(2)) {
					thirdLetter = guess;
					if(firstLetter == secretWord.charAt(0) && secondLetter == secretWord.charAt(1) && fourthLetter == secretWord.charAt(3) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
						wordGuessed = true;
						break;
					}
					else if(firstLetter == secretWord.charAt(0) && secondLetter == secretWord.charAt(1) && fourthLetter == secretWord.charAt(3)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " " + fourthLetter + " _");
					}
					else if(firstLetter == secretWord.charAt(0) && secondLetter == secretWord.charAt(1) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " _ " + fifthLetter);
					}
					else if(firstLetter == secretWord.charAt(0) && fourthLetter == secretWord.charAt(3) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " _ " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
					}
					else if(secondLetter == secretWord.charAt(1) && fourthLetter == secretWord.charAt(3) && fifthLetter == secretWord.charAt(4)) {
						System.out.println("_ " + secondLetter + " " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
					}
					else if(firstLetter == secretWord.charAt(0) && secondLetter == secretWord.charAt(1)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " _ " + " _");
					}
					else if(firstLetter == secretWord.charAt(0) && fourthLetter == secretWord.charAt(3)) {
						System.out.println(firstLetter + " _ " + thirdLetter + " " + fourthLetter + " _");
					}
					else if(firstLetter == secretWord.charAt(0) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " _ " + thirdLetter + " _ " + fifthLetter);
					}
					else if(secondLetter == secretWord.charAt(1) && fourthLetter == secretWord.charAt(3)) {
						System.out.println("_ " + secondLetter + " " + thirdLetter + " " + fourthLetter + " _");
					}
					else if(secondLetter == secretWord.charAt(1) && fifthLetter == secretWord.charAt(4)) {
						System.out.println("_ " + secondLetter + " " + thirdLetter + " _ " + fifthLetter);
					}
					else if(fourthLetter == secretWord.charAt(3) && fifthLetter == secretWord.charAt(4)) {
						System.out.println("_ " + " _ " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
					}
					else if(firstLetter == secretWord.charAt(0)) {
						System.out.println(firstLetter + " _ " + thirdLetter + " _ " + " _");
					}
					else if(secondLetter == secretWord.charAt(1)) {
						System.out.println("_ " + secondLetter + " " + thirdLetter + " _ " + " _");
					}
					else if(fourthLetter == secretWord.charAt(3)) {
						System.out.println("_ " + " _ " + thirdLetter + " " + fourthLetter + " _");
					}
					else if(fifthLetter == secretWord.charAt(4)) {
						System.out.println("_ " + " _ " + thirdLetter + " _ " + fifthLetter);
					}					
					else {
						System.out.println("_ " + " _ " + thirdLetter + " _ " + " _");
					}
				}
				else if(guess == secretWord.charAt(3)) {
					fourthLetter = guess;
					if(firstLetter == secretWord.charAt(0) && secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
						wordGuessed = true;
						break;
					}
					else if(firstLetter == secretWord.charAt(0) && secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " " + fourthLetter + " _");
					}
					else if(firstLetter == secretWord.charAt(0) && secondLetter == secretWord.charAt(1) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " " + secondLetter + " _ " + fourthLetter + " " + fifthLetter);
					}
					else if(firstLetter == secretWord.charAt(0) && thirdLetter == secretWord.charAt(2) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " _ " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
					}
					else if(secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2) && fifthLetter == secretWord.charAt(4)) {
						System.out.println("_ " + secondLetter + " " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
					}
					else if(firstLetter == secretWord.charAt(0) && secondLetter == secretWord.charAt(1)) {
						System.out.println(firstLetter + " " + secondLetter + " _ " + fourthLetter + " _");
					}
					else if(firstLetter == secretWord.charAt(0) && thirdLetter == secretWord.charAt(2)) {
						System.out.println(firstLetter + " _ " + thirdLetter + " " + fourthLetter + " _");
					}
					else if(firstLetter == secretWord.charAt(0) && fifthLetter == secretWord.charAt(4)) {
						System.out.println(firstLetter + " _ " + " _ " + fourthLetter + " " + fifthLetter);
					}
					else if(secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2)) {
						System.out.println("_ " + secondLetter + " " + thirdLetter + " " + fourthLetter + " _");
					}
					else if(secondLetter == secretWord.charAt(1) && fifthLetter == secretWord.charAt(4)) {
						System.out.println("_ " + secondLetter + " _ " + fourthLetter + " " + fifthLetter);
					}
					else if(thirdLetter == secretWord.charAt(2) && fifthLetter == secretWord.charAt(4)) {
						System.out.println("_ " + " _ " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
					}					
					else if(firstLetter == secretWord.charAt(0)) {
						System.out.println(firstLetter + " _ " + " _ " + fourthLetter + " _");
					}
					else if(secondLetter == secretWord.charAt(1)) {
						System.out.println("_ " + secondLetter + " _ " + fourthLetter + " _");
					}
					else if(thirdLetter == secretWord.charAt(2)) {
						System.out.println("_ " + " _ " + thirdLetter + " " + fourthLetter + " _");
					}
					else if(fifthLetter == secretWord.charAt(4)) {
						System.out.println("_ " + " _ " + " _ " + fourthLetter + " " + fifthLetter);
					}
					else {
						System.out.println("_ " + " _ " + " _ " + fourthLetter + " _");
					}
				}
				else if(guess == secretWord.charAt(4)) {
					fifthLetter = guess;
					if(firstLetter == secretWord.charAt(0) && secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2) && fourthLetter == secretWord.charAt(3)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
						wordGuessed = true;
						break;
					}
					else if(firstLetter == secretWord.charAt(0) && secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2)) {
						System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter + " _ " + fifthLetter);
					}
					else if(firstLetter == secretWord.charAt(0) && secondLetter == secretWord.charAt(1) && fourthLetter == secretWord.charAt(3)) {
						System.out.println(firstLetter + " " + secondLetter + " _ " + fourthLetter + " " + fifthLetter);
					}
					else if(firstLetter == secretWord.charAt(0) && thirdLetter == secretWord.charAt(2) && fourthLetter == secretWord.charAt(3)) {
						System.out.println(firstLetter + " _ " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
					}
					else if(secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2) && fourthLetter == secretWord.charAt(3)) {
						System.out.println("_ " + secondLetter + " " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
					}
					else if(firstLetter == secretWord.charAt(0) && secondLetter == secretWord.charAt(1)) {
						System.out.println(firstLetter + " " + secondLetter + " _ " + " _ " + fifthLetter);
					}
					else if(firstLetter == secretWord.charAt(0) && thirdLetter == secretWord.charAt(2)) {
						System.out.println(firstLetter + " _ " + thirdLetter + " _ " + fifthLetter);
					}
					else if(firstLetter == secretWord.charAt(0) && fourthLetter == secretWord.charAt(3)) {
						System.out.println(firstLetter + " _ " + " _ " + fourthLetter + " " + fifthLetter);
					}
					else if(secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2)) {
						System.out.println("_ " + secondLetter + " " + thirdLetter + " _ " + fifthLetter);
					}
					else if(secondLetter == secretWord.charAt(1) && fourthLetter == secretWord.charAt(3)) {
						System.out.println("_ " + secondLetter + " _ " + fourthLetter + " " + fifthLetter);
					}
					else if(thirdLetter == secretWord.charAt(2) && fourthLetter == secretWord.charAt(3)) {
						System.out.println("_ " + " _ " + thirdLetter + " " + fourthLetter + " " + fifthLetter);
					}					
					else if(firstLetter == secretWord.charAt(0)) {
						System.out.println(firstLetter + " _ " + " _ " + " _ " + fifthLetter);
					}
					else if(secondLetter == secretWord.charAt(1)) {
						System.out.println("_ " + secondLetter + " _ " + " _ " + fifthLetter);
					}
					else if(thirdLetter == secretWord.charAt(2)) {
						System.out.println("_ " + " _ " + thirdLetter + " _ " + fifthLetter);
					}
					else if(fourthLetter == secretWord.charAt(3)) {
						System.out.println("_ " + " _ " + " _ " + fourthLetter + " " + fifthLetter);
					}
					else {
						System.out.println("_ " + " _ " + " _ " + " _ " + fifthLetter);
					}
				}
				else {
					hangman();
					maxGuesses += 1;
				}
			if(maxGuesses <= 6) {
				haveAGo();
				guess();
			}
			}
		}	
	}
	
	/** Denna metoden best�r av ascii konst som portr�tterar gubben som h�ngs
	 * Denna metoden anropas om gissningen inte �r r�tt i de tv� f�rra metoderna
	 * F�r varje fel gissning skriver denna metod ut ny ascii konst, som
	 * f�r det att se ut som om ett streck ritas p� gubben tills den �r h�ngd.
	 */
	public static void hangman() {
		if(maxGuesses == 0) {
			System.out.println(System.lineSeparator() + "  +---+\r\n" + 
					"  |   |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"=========");
		}
		else if(maxGuesses == 1) {
			System.out.println(System.lineSeparator() + "  +---+\r\n" + 
					"  |   |\r\n" + 
					"  O   |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"=========");
		}
		else if(maxGuesses == 2) {
			System.out.println(System.lineSeparator() + "  +---+\r\n" + 
					"  |   |\r\n" + 
					"  O   |\r\n" + 
					"  |   |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"=========");
		}
		else if(maxGuesses == 3) {
			System.out.println(System.lineSeparator() + "  +---+\r\n" + 
					"  |   |\r\n" + 
					"  O   |\r\n" + 
					" /|   |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"=========");
		}
		else if(maxGuesses == 4) {
			System.out.println(System.lineSeparator() + "  +---+\r\n" + 
					"  |   |\r\n" + 
					"  O   |\r\n" + 
					" /|\\  |\r\n" + 
					"      |\r\n" + 
					"      |\r\n" + 
					"=========");
		}
		else if(maxGuesses == 5) {
			System.out.println(System.lineSeparator() + "  +---+\r\n" + 
					"  |   |\r\n" + 
					"  O   |\r\n" + 
					" /|\\  |\r\n" + 
					" /    |\r\n" + 
					"      |\r\n" + 
					"=========");
		}
		else if(maxGuesses == 6) {
			System.out.println(System.lineSeparator() + "  +---+\r\n" + 
					"  |   |\r\n" + 
					"  O   |\r\n" + 
					" /|\\  |\r\n" + 
					" / \\  |\r\n" + 
					"      |\r\n" + 
					"=========");
		}
	}
	
	/** Denna metoden gratulerar spelaren n�r den vinner.
	 * Det enda denna metoden g�r �r att skriva ut ett grattis meddelande till spelaren efter att den har vunnit.
	 * String youWin �r ett grattis meddelande
	 * @return String youWin
	 */
	public static String youWin() {
		String youWin = System.lineSeparator() + "Congratulations! You have succesfully guessed the right word!";
		return youWin;
	}
	
	/** Denna metoden ber�ttar f�r spelaren att den har f�rlorat.
	 * Det enda denna metoden g�r �r att skriva ut ett meddelande som s�ger att spelaren f�rlorade
	 * String youLose �r ett meddelande d�r det f�rklaras att spelaren f�rlorade.
	 * @return String youLose
	 */
	public static String youLose() {
		String youLose = System.lineSeparator() + "No! You didn't guess the word and the man was hanged!";
		return youLose;
	}
	
	/** Denna metoden fr�gar spelaren om den vill k�ra igen.
	 * Spelaren f�r fr�gan om den vill k�ra igen.
	 * String playAgain �r en fr�ga som f�ljs upp av tv� svarsalternativ.
	 * @return String playAgain
	 */
	public static String playAgain() {
		String playAgain = System.lineSeparator() + "Do want to play again?" + System.lineSeparator() + "(1) Yes" + System.lineSeparator() + "(2) No";
		return playAgain;
	}
	
	public static String goQuit() {
		String goQuit = System.lineSeparator() + "Do you want to quit?" + System.lineSeparator() + "(1) Yes" + System.lineSeparator() + "(2) No";
		return goQuit;
	}
	
	public static String exitMessage() {
		String exitMessage = System.lineSeparator() + "Please hold, game shutting down...";
		return exitMessage;
	}
}
