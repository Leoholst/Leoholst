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
		guessingLoop();
	}
	
	public static void guessingLoop() {
		for(int i=0; i<(secretWord.length()); i++) {
			System.out.println(haveAGo());
			guess();
			rightGuessCheck();
		}
	}
	
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
		easyWords.add("BILAR");
		easyWords.add("HUS");
		easyWords.add("BORD");
		easyWords.add("MATTA");
		easyWords.add("BR�D");
		
		if(difficulty == true) {
			Random randomNumber = new Random();
			int chosenWord = randomNumber.nextInt(easyWords.size());
			secretWord = easyWords.get(chosenWord);
		}
	}
	
	public static void setHardDifficulty() {
		hardWords.add("TAKF�NSTER");
		hardWords.add("GL�DLAMPA");
		hardWords.add("TOALETTLOCK");
		hardWords.add("NY�RSKYCKLING");
		hardWords.add("GAMMELFARFAR");
		
		if(difficulty == false) {
			Random randomNumber = new Random();
			int chosenWord = randomNumber.nextInt(hardWords.size());
			secretWord = hardWords.get(chosenWord);
		}
	}
	
	public static String haveAGo() {
		String HaveAGo = "Your Guess:";
		return HaveAGo;
	}
	
	public static char guess() {
		guess = input.next().charAt(0);
		return guess;
	}
	
	public static void rightGuessCheck() {
		/*
		Character.isLetter('a'&'b'&'c'&'d'&'e'&'f'&'g'&'h'&'i'&'j'&'k'&'l'&'m'&'n'&'o'&'p'&'q'&'r'&'s'&'t'&'u'&'v'&'w'&'x'&'y'&'z'&'�'&'�'&'�');
		*/
		while(maxGuesses<11) {
			for(int limit=0; limit<12; limit++){
				if(guess == secretWord.charAt(limit)){
					char rightGuess = guess;
					System.out.println(rightGuess);
					guessingLoop();
				}
				else {
					System.out.println("Not quite right");
					maxGuesses =+ 1;
					guessingLoop();
				}
			}
		}
	}
	/*
	public static char wrongGuess() {
		
	}
	
	public static String youWin() {
		
	}
	
	public static String youLose() {
		
	}
	*/
}
