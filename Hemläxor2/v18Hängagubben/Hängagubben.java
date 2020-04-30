import java.util.Scanner;
import java.util.ArrayList;

public class Hängagubben {
	public static Scanner input = new Scanner(System.in);
	public static boolean difficulty = true;
	
	
	public static void main(String[] args) {
		game();
	}
	
	public static void game() {
		System.out.println(welcome());
		System.out.println(System.lineSeparator() + instructions());
		System.out.println(System.lineSeparator() + whatDifficulty());
		chooseDifficulty();
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
	
	public static String setEasyDifficulty() {
		ArrayList<String> easyWords = new ArrayList<String>();
		easyWords.add("BILAR");
		easyWords.add("HUS");
		easyWords.add("BORD");
		easyWords.add("MATTA");
		easyWords.add("BRÖD");
		
		if(difficulty == true) {
			
		}
	}
	
	public static String setHardDifficulty() {
		ArrayList<String> hardWords = new ArrayList<String>();
		hardWords.add("TAKFÖNSTER");
		hardWords.add("GLÖDLAMPA");
		hardWords.add("TOALETTLOCK");
		hardWords.add("NYÅRSKYCKLING");
		hardWords.add("GAMMELFARFAR");
		
		if(difficulty == false) {
			
		}
	}
	/*
	public static char guess() {
		
	}
	
	public static char rightGuess() {
		Character.isLetter('c');
		Character.isLetter('5');
	}
	
	public static char wrongGuess() {
		
	}
	
	public static String youWin() {
		
	}
	
	public static String youLose() {
		
	}
	*/
}
