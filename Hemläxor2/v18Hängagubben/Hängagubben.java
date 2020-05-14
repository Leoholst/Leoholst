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
	
	public static void main(String[] args) {
		game();
	}
	
	public static void game() {
		System.out.println(welcome());
		System.out.println(System.lineSeparator() + instructions());
		System.out.println(System.lineSeparator() + whatDifficulty());
		chooseDifficulty();
		setEasyDifficulty();
		setHardDifficulty();
		haveAGo();
		guess();
		rightGuessCheck();
		/*
		guessingLoop();
		*/
	}
	/*
	public static void guessingLoop() {
		for(int i=0; i<(secretWord.length()); i++) {
			System.out.println(haveAGo());
			guess();
			rightGuessCheck();
		}
	}
	*/
	public static void variabelReset() {
		
	}
	
	public static void againOrQuit() {
		
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
		int whichDifficulty = input.nextInt();
		
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
		hardWords.add("TAVLA");
		hardWords.add("FRISK");
		hardWords.add("TJOCK");
		hardWords.add("MATTA");
		hardWords.add("TOMAT");
		
		if(difficulty == false) {
			Random randomNumber = new Random();
			int chosenWord = randomNumber.nextInt(hardWords.size());
			secretWord = hardWords.get(chosenWord);
			System.out.println(secretWord);
		}
	}
	
	public static void haveAGo() {
		System.out.println("Your Guess:");
	}
	
	public static char guess() {
		guess = input.next().charAt(0);
		return guess;
	}
	
	public static void rightGuessCheck() {
		/*
		Character.isLetter('a'&'b'&'c'&'d'&'e'&'f'&'g'&'h'&'i'&'j'&'k'&'l'&'m'&'n'&'o'&'p'&'q'&'r'&'s'&'t'&'u'&'v'&'w'&'x'&'y'&'z'&'å'&'ä'&'ö');
		*/
		/*
		while(maxGuesses<11) {
		*/	
		char firstLetter = ' ';
		char secondLetter = ' ';
		char thirdLetter = ' ';
		char fourthLetter = ' ';
		char fifthLetter = ' ';
		
		if(difficulty == true) {
			for(int i=0; i<secretWord.length(); i++){
				if(guess == secretWord.charAt(i)){
					if(guess == secretWord.charAt(0)) {
						firstLetter = guess;
						if(secondLetter == secretWord.charAt(1) && thirdLetter == secretWord.charAt(2)) {
							System.out.println(firstLetter + " " + secondLetter + " " + thirdLetter);
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
				}
				else {
					System.out.println("Nej, Ascii konst på gubben");
					/*
					maxGuesses =+ 1;
					*/
				}
			haveAGo();
			guess();
			}
		}
		if(difficulty == false) {
			for(int i=0; i<secretWord.length(); i++){
				if(guess == secretWord.charAt(i)){
					if(guess == secretWord.charAt(0)) {
						firstLetter = guess;
						System.out.println(firstLetter);
					}
					if(guess == secretWord.charAt(1)) {
						secondLetter = guess;
						System.out.println(secondLetter);
					}
					if(guess == secretWord.charAt(2)) {
						thirdLetter = guess;
						System.out.println(thirdLetter);
					}
					if(guess == secretWord.charAt(3)) {
						fourthLetter = guess;
						System.out.println(fourthLetter);
					}
					if(guess == secretWord.charAt(4)) {
						fifthLetter = guess;
						System.out.println(fifthLetter);
					}
				}
				else {
					System.out.println("Nej, Ascii konst på gubben");
					maxGuesses =+ 1;
				}
			haveAGo();
			guess();
			}
		}
		/*	
		}
		*/
	}
	/*
	public static void winChecker() {
		
	}
	
	public static String youWin() {
		
	}
	
	public static String youLose() {
		
	}
	*/
}
