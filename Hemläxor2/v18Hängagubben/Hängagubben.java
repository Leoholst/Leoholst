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
	 * Detta är för att man ska kunna köra spelet igen flera gånger.
	 */
	public static void variabelReset() {
		maxGuesses = 0;
		wordGuessed = false;
		quit = false;
		goAgain = 0;
		wantToPlayAgain = true;
		wantToQuit = 0;
	}
	
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
	
	public static String welcome() {
		String playerGreeting = "Welcome to Hangman! In this game you will be guessing letters in an unknown word, sounds simple enough? " +
        System.lineSeparator()  + "Well watch out, with every letter you guess wrong one line will be drawn on the man until he is hanged and you lose!";
		return playerGreeting;
	}
	
	public static String instructions() {
		String instructions = "The rules are easy, simply write a letter and you will either see it pop up in the word or see a line being drawn." +
		System.lineSeparator() + "When the man is hanged you lose! But when you have guessed all the letters in the word you win!" + 
		System.lineSeparator() + "There is two difficulties to choose from, easy and hard. Easy is shorter words while hard is longer.";
		return instructions;
	}
	
	public static String whatDifficulty() {
		String whatDifficulty = "Choose your desired difficulty!" + System.lineSeparator() + "(1) Easy" + System.lineSeparator() + "(2) Hard";
		return whatDifficulty;
	}
	
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
			System.out.println(secretWord);
		}
	}
	
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
			System.out.println(secretWord);
		}
	}
	
	public static void haveAGo() {
		System.out.println(System.lineSeparator() + "Your Guess:");
	}
	
	public static char guess() {
		guess = input.next().charAt(0);
		guess = Character.toUpperCase(guess);
		return guess;
	}
	
	public static void rightGuessEasyWordsCheck() {
		/*
		Character.isLetter('a'&'b'&'c'&'d'&'e'&'f'&'g'&'h'&'i'&'j'&'k'&'l'&'m'&'n'&'o'&'p'&'q'&'r'&'s'&'t'&'u'&'v'&'w'&'x'&'y'&'z'&'å'&'ä'&'ö');
		*/
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
		//Anropa youWin eller youLose
		}	
	}
	
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
	
	public static String youWin() {
		String youWin = System.lineSeparator() + "Congratulations! You have succesfully guessed the right word!";
		return youWin;
	}
	
	public static String youLose() {
		String youLose = System.lineSeparator() + "No! You didn't guess the word and the man was hanged!";
		return youLose;
	}
	
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
