import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Hängagubben {
	public static Scanner input = new Scanner(System.in);
	public static boolean difficulty;
	public static ArrayList<String> easyWords = new ArrayList<String>();
	public static ArrayList<String> hardWords = new ArrayList<String>();
	public static int whatEasyWord = 0;
	public static int whatHardWord = 0;
	public static String secretWord;
	public static char guess;
	
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
		System.out.println(haveAGo());
		guess();
		rightGuess();
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
		easyWords.add("BRÖD");
		
		if(difficulty == true) {
			Random randomNumber = new Random();
			int n = randomNumber.nextInt(easyWords.size());
			secretWord = easyWords.get(n);
		}
	}
	
	public static void setHardDifficulty() {
		hardWords.add("TAKFÖNSTER");
		hardWords.add("GLÖDLAMPA");
		hardWords.add("TOALETTLOCK");
		hardWords.add("NYÅRSKYCKLING");
		hardWords.add("GAMMELFARFAR");
		
		if(difficulty == false) {
			Random randomNumber = new Random();
			int n = randomNumber.nextInt(hardWords.size());
			secretWord = hardWords.get(n);
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
	
	public static void rightGuess() {
		/*
		Character.isLetter('a'&'b'&'c'&'d'&'e'&'f'&'g'&'h'&'i'&'j'&'k'&'l'&'m'&'n'&'o'&'p'&'q'&'r'&'s'&'t'&'u'&'v'&'w'&'x'&'y'&'z'&'å'&'ä'&'ö');
		*/
		if(guess == secretWord.charAt(0)){
			char rightGuess = guess;
			System.out.println(rightGuess);
		}
		else {
			System.out.println("No");
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
