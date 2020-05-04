import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

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
		setEasyDifficulty();
		setHardDifficulty();
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
		ArrayList<String> easyWords = new ArrayList<String>();
		easyWords.add("BILAR");
		easyWords.add("HUS");
		easyWords.add("BORD");
		easyWords.add("MATTA");
		easyWords.add("BRÖD");
		
		Random randomNumber = new Random();
		if(difficulty == true) {
			int whatWord = randomNumber.nextInt(5);
			if(whatWord == 0) {
				System.out.println(easyWords.get(0));
				System.out.println("Your word has now been randomly generated, let the guessing begin!");
			}
			else if(whatWord == 1) {
				System.out.println(easyWords.get(1));
				System.out.println("Your word has now been randomly generated, let the guessing begin!");
			}
			else if(whatWord == 2) {
				System.out.println(easyWords.get(2));
				System.out.println("Your word has now been randomly generated, let the guessing begin!");
			}
			else if(whatWord == 3) {
				System.out.println(easyWords.get(3));
				System.out.println("Your word has now been randomly generated, let the guessing begin!");
			}
			else if(whatWord == 4) {
				System.out.println(easyWords.get(4));
				System.out.println("Your word has now been randomly generated, let the guessing begin!");
			}
		}
	}
	
	public static void setHardDifficulty() {
		ArrayList<String> hardWords = new ArrayList<String>();
		hardWords.add("TAKFÖNSTER");
		hardWords.add("GLÖDLAMPA");
		hardWords.add("TOALETTLOCK");
		hardWords.add("NYÅRSKYCKLING");
		hardWords.add("GAMMELFARFAR");
		
		Random randomNumber = new Random();
		if(difficulty == false) {
			int whatWord = randomNumber.nextInt(5);
			if(whatWord == 0) {
				System.out.println(hardWords.get(0));
				System.out.println("Your word has now been randomly generated, let the guessing begin!");
			}
			else if(whatWord == 1) {
				System.out.println(hardWords.get(1));
				System.out.println("Your word has now been randomly generated, let the guessing begin!");
			}
			else if(whatWord == 2) {
				System.out.println(hardWords.get(2));
				System.out.println("Your word has now been randomly generated, let the guessing begin!");
			}
			else if(whatWord == 3) {
				System.out.println(hardWords.get(3));
				System.out.println("Your word has now been randomly generated, let the guessing begin!");
			}
			else if(whatWord == 4) {
				System.out.println(hardWords.get(4));
				System.out.println("Your word has now been randomly generated, let the guessing begin!");
			}
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
