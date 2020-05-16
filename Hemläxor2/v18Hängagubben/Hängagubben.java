import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Hängagubben {
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
	
	/** Detta är main metoden
	 * Jag ville inte ha för mycket kod i main metoden, därför anropar jag endast två andra metoder från main.
	 * @param args
	 */
	public static void main(String[] args) {
		welcomeAndRules();
		game();
	}
	
	/** Detta är huvudmetoden och fungerar som startrutan i hela spelet.
	 * Denna metoden anropar metoderna som utgör spelet, i rätt ordning.
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
	 * Allt denna metoden gör är att skriva ut två andra metoder.
	 */
	public static void welcomeAndRules() {
		System.out.println(welcome());
		System.out.println(System.lineSeparator() + instructions());
	}
	
	/** Denna metoden utgör gissnings delen av spelet.
	 * Metoden består av en while loop som itererar så länge maxGuesses är lika med eller under 6, eller om wordGuessed är false.
	 * Den anropar även två andra metoder.
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
	 * Om wordGuessed är true anropas youWin metoden
	 * Medans om wordGuessed är false anropas youLose metoden.
	 */
	public static void winChecker() {
		if(wordGuessed == true) {
			System.out.println(youWin());
		}
		else if(wordGuessed == false) {
			System.out.println(youLose());
		}
	}

	/** Denna metoden är till för att återställa de väsentliga variablerna
	 * Detta är för att man ska kunna köra spelet igen flera gånger
	 * Eftersom om variablerna inte återställs kan de påverka resultaten på nästa omgång.
	 */
	public static void variabelReset() {
		maxGuesses = 0;
		wordGuessed = false;
		quit = false;
		goAgain = 0;
		wantToPlayAgain = true;
		wantToQuit = 0;
	}
	
	/** Denna metoden tar hand om delen där spelaren får välja om den vill köra igen.
	 * Den består av en while-loop som itererar så länge quit är false.
	 * Först anropas playAgain och sedan tas en int in från konsollen som m.h.a. en if-sats
	 * bestämmer om variabelReset och sedan game eller om goQuit ska anropas, goQuit följs av
	 * ytterligare en int som tas in, som bestämmer om quit ska bli true och while loopen bryts
	 * och spelet stängs av, eller om variabelReset och game ska anropas.
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
	
	/** welcome är en metod som hälsar spelaren välkommen
	 * String playerGreeting som välkommnar spelaren och förklarar vad spelet går ut på.
	 * @return String playerGreeting
	 */
	public static String welcome() {
		String playerGreeting = "Welcome to Hangman! In this game you will be guessing letters in an unknown word, sounds simple enough? " +
        System.lineSeparator()  + "Well watch out, with every letter you guess wrong one line will be drawn on the man until he is hanged and you lose!";
		return playerGreeting;
	}
	
	/** Denna metoden förklarar reglerna för spelaren
	 * String instructions som endast förklarar reglerna
	 * @return String instructions
	 */
	public static String instructions() {
		String instructions = "The rules are easy, simply write a letter and you will either see it pop up in the word or see a line being drawn." +
		System.lineSeparator() + "When the man is hanged you lose! But when you have guessed all the letters in the word you win!" + 
		System.lineSeparator() + "There is two difficulties to choose from, easy and hard. Easy is shorter words while hard is longer.";
		return instructions;
	}
	
	/** Denna metoden ger spelaren ett val om vilken svårighetsgrad den vill ha
	 * String whatDifficulty ställer frågan om vilken svårighetsgrad spelaren vill ha, antingen enkel eller svår
	 * @return String whatDifficulty
	 */
	public static String whatDifficulty() {
		String whatDifficulty = "Choose your desired difficulty!" + System.lineSeparator() + "(1) Easy" + System.lineSeparator() + "(2) Hard";
		return whatDifficulty;
	}
	
	/** Denna metod tar in spelarens svar från förra metoden och förverkligar det.
	 * int whichDifficulty tar in en int från konsollen
	 * Detta heltal bestämmer i sin tur om den globala variabeln difficulty ska bli true eller false.
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
	
	/** Denna metod slumpar det enkla ordet som spelaren ska gissa på
	 * Först lägger jag till fem ord som utgör den globala ArrayList<String> easyWords med enkla ord.
	 * Sedan beroende på om spelaren valde enkel svårighetsgrad, slumpar ett random heltal
	 * m.h.a. Random(), vilket i enkelhet generar ett slumpat nummer i intervallet i ArrayListen, dvs. från 0-4.
	 * Detta heltal tar sedan ut motsvarande index i ArrayList:en och
	 * sätter sedan globala String secretWord till detta nu slumpade ordet.
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
	
	/** Denna metod slumpar det svåra ordet som spelaren ska gissa på
	 * Först lägger jag till fem ord som utgör den globala ArrayList<String> hardWords med svåra ord.
	 * Sedan beroende på om spelaren valde svår svårighetsgrad, slumpar ett random heltal
	 * m.h.a. Random(), vilket i enkelhet generar ett slumpat nummer i intervallet i ArrayListen, dvs. från 0-4.
	 * Detta heltal tar sedan ut motsvarande index i ArrayListen och
	 * sätter sedan globala String secretWord till detta nu slumpade ordet.
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
	
	/** Denna metoden förklarar att spelaren ska gissa
	 * Det enda denna metoden gör är att förtydliga att spelaren ska gissa 
	 */
	public static void haveAGo() {
		System.out.println(System.lineSeparator() + "Your Guess:");
	}
	
	/** Denna metoden tar in spelarens gissning och gör den till stor bokstav.
	 * globala char Guess Tar in en bokstav från konsollen som är spelarens gissning
	 * m.h.a. .toUpperCase görs gissningen till stor bokstav 
	 * eftersom orden är skrivna i stora bokstäver och de ska jämföras i kommande metoder
	 * @return char Guess
	 */
	public static char guess() {
		guess = input.next().charAt(0);
		guess = Character.toUpperCase(guess);
		return guess;
	}
	
	/** Denna metoden jämför gissingen med rätt svar m.m.
	 * Denna metoden är här gissningen kollas om den är rätt eller fel
	 * Metoden består av en if-sats som är tröskeln för hela metoden och går att passera
	 * om spelaren valde enkel svårighetsgrad.
	 * Sedan kommer en while-loop som itererar medans maxguesses är lika med eller under 6, 
	 * dvs. medans spelaren fortfarande har gissningar kvar.
	 * Det som följer är en mängd av if-, else if- och else-satser, där vid varje sats jämförs gissningen 
	 * med antingen första, andra, tredje bokstaven i ordet. 
	 * Sedan dubbelkollar programmet även om de andra bokstäverna i ordet redan har gissats rätt på,
	 * om varken en eller alla har det skrivs den eller de ut på sina rätta platser.
	 * Sedan om hela ordet har skrivits ut sätts wordGuessed till true som bryter 
	 * while-loopen i metoden guessingLoop(), och bryter while-loopen.
	 * Om gissningen inte stämmer anropas hangMan metoden och maxGuesses adderas med 1 tills den blir 7 och while-loopen bryts, 
	 * även while-loopen i metoden guessingLoop(). 
	 * char firstLetter är första bokstaven i ordet.
	 * char secondLetter är andra bokstaven i ordet.
	 * char thirdLetter är trejde bokstaven i ordet.
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
	
	/** Denna metoden jämför gissningen med rätt svar m.m.
	 * Denna metoden är här gissningen kollas om den är rätt eller fel
	 * Metoden består av en if-sats som är tröskeln för hela metoden och går att passera
	 * om spelaren valde svår svårighetsgrad.
	 * Sedan kommer en while-loop som itererar medans maxguesses är lika med eller under 6, 
	 * dvs. medans spelaren fortfarande har gissningar kvar.
	 * Det som följer är en mängd av if-, else if- och else-satser, där vid varje sats jämförs gissningen 
	 * med antingen första, andra, tredje, fjärde eller femte bokstaven i ordet.
	 * Sedan dubbelkollar programmet även om de andra bokstäverna i ordet redan har gissats rätt på,
	 * om varken en eller alla har det skrivs den eller de ut på sina rätta platser.
	 * Sedan om hela ordet har skrivits ut sätts wordGuessed till true som bryter 
	 * while-loopen i metoden guessingLoop(), och bryter while-loopen.
	 * Om gissningen inte stämmer anropas hangMan metoden och maxGuesses adderas med 1 tills den blir 7 och while-loopen bryts, 
	 * även while-loopen i metoden guessingLoop().
	 * char firstLetter är första bokstaven i ordet.
	 * char secondLetter är andra bokstaven i ordet.
	 * char thirdLetter är trejde bokstaven i ordet.
	 * char fourthLetter är fjärde bokstaven i ordet.
	 * char fifthLetter är femte bokstaven i ordet.
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
	
	/** Denna metoden består av ascii konst som porträtterar gubben som hängs
	 * Denna metoden anropas om gissningen inte är rätt i de två förra metoderna
	 * För varje fel gissning skriver denna metod ut ny ascii konst, som
	 * får det att se ut som om ett streck ritas på gubben tills den är hängd.
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
	
	/** Denna metoden gratulerar spelaren när den vinner.
	 * Det enda denna metoden gör är att skriva ut ett grattis meddelande till spelaren efter att den har vunnit.
	 * String youWin är ett grattis meddelande
	 * @return String youWin
	 */
	public static String youWin() {
		String youWin = System.lineSeparator() + "Congratulations! You have succesfully guessed the right word!";
		return youWin;
	}
	
	/** Denna metoden berättar för spelaren att den har förlorat.
	 * Det enda denna metoden gör är att skriva ut ett meddelande som säger att spelaren förlorade
	 * String youLose är ett meddelande där det förklaras att spelaren förlorade.
	 * @return String youLose
	 */
	public static String youLose() {
		String youLose = System.lineSeparator() + "No! You didn't guess the word and the man was hanged!";
		return youLose;
	}
	
	/** Denna metoden frågar spelaren om den vill köra igen.
	 * Spelaren får frågan om den vill köra igen.
	 * String playAgain är en fråga som följs upp av två svarsalternativ.
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
