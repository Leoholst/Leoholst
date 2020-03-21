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
	
	public static void main(String[] args) {
		System.out.println(greetings());
		System.out.println(System.lineSeparator() + instructions());
		System.out.println(System.lineSeparator() + difficultyInformation());
		System.out.println(System.lineSeparator() + chooseDifficulty());
		whatDifficulty = input.nextInt();
		
		if(whatDifficulty==1) {
			System.out.println(System.lineSeparator() + easyDifficulty());
		}
		else if(whatDifficulty==2) {
			System.out.println(System.lineSeparator() + mediumDifficulty());
		}
		else if(whatDifficulty==3){
			System.out.println(System.lineSeparator() + hardDifficulty());
		}
		
		for(int i = 0; i < 3; i++) {
			System.out.println(System.lineSeparator() + startGuessing());
			yourGuesses = input.nextInt();
			if((easyDifficulty == yourGuesses)||(mediumDifficulty == yourGuesses)||(hardDifficulty == yourGuesses)) {
				youWon = true;
				break;
			}
			else if((easyDifficulty != yourGuesses)||(mediumDifficulty != yourGuesses)||(hardDifficulty != yourGuesses)) {
				System.out.println(System.lineSeparator() + condolences());
			}
		}
		if(youWon == false) {
			System.out.println(System.lineSeparator() + youLose());
		}
		else if(youWon == true) {
			System.out.println(System.lineSeparator() + congratulations());
		}
		System.out.println(System.lineSeparator() + playAgain());
	}
	
	public static String greetings() {
		String welcome = "Welcome to Talspelet!" + System.lineSeparator() + "This game is all about guessing numbers!";
		return welcome;
	}
	
	public static String instructions() {
		String instructions = "Instructions" + System.lineSeparator() + "First off you are going to choose a difficulty. There are three different settings to choose from, ranging from easy to hard." + System.lineSeparator() + "After that comes the guessing part! Simply write one number from inside the difficulties range. If you write the wrong one you have to guess again." + System.lineSeparator() + "In order to win you just have to guess the right number, easy right? But watch out! You only have three tries before you run out of guesses and lose!";
		return instructions;
	}
	
	public static String difficultyInformation() {
		String difficultyInformation = "Difficulty Information" + System.lineSeparator() + "The Easy Difficulty setting is the easiest with numbers ranging from 0 to 5." + System.lineSeparator() + "The Medium Difficulty setting has numbers ranging from 0 to 10." + System.lineSeparator() + "The Hard Difficulty setting is the hardest with numbers ranging from 0 to 20.";
		return difficultyInformation;
	}
	
	public static String chooseDifficulty() {
		String chooseDifficulty = "Choose Difficulty" + System.lineSeparator() + "(1) To choose the Easy Difficulty" + System.lineSeparator() + "(2) To choose the Medium Difficulty" + System.lineSeparator() + "(3) To choose the Hard Difficulty";
		return chooseDifficulty;
	}
	
	public static int easyDifficulty() {
		Random rand = new Random();
		if(whatDifficulty==1) {
			easyDifficulty = rand.nextInt(5+1);
			return easyDifficulty;
		}
		return 0;
	}
	
	public static int mediumDifficulty() {
		Random rand = new Random();
		if(whatDifficulty==2) {
			mediumDifficulty = rand.nextInt(10+1);
			return mediumDifficulty;
		}
		return 0;
	}
	
	public static int hardDifficulty() {
		Random rand = new Random();
		if(whatDifficulty==3) {
			hardDifficulty = rand.nextInt(20+1);
			return hardDifficulty;
		}
		return 0;
	}
	
	public static String startGuessing() {
		String startGuessing = "Your Guess:";
		return startGuessing;
	}
	
	public static String congratulations() {
		String congratulations = "Ding! Ding! Ding! Congratulations! You have guessed the right number!";
		return congratulations;
	}
	
	public static String condolences() {
		String condolences = "That is not right... Try again!";
		return condolences;
	}
	
	public static String youLose() {
		String youLose = "Oh no... It seems you have run out of guesses and lost!";
		return youLose;
	}
	
	public static String playAgain() {
		String playAgain = "Do want to play again?" + System.lineSeparator() + "(1) Yes" + System.lineSeparator() + "(2) No";
		return playAgain;
	}
	
	/*
	public static int numberOfGuesses() {
		
	}
	
	
	public static void errorMessage() {
		
	}
	
	public static int numberOfGuesses() {
		
	}
	
	public static String congratulations() {
		
	}
	
	public static String condolences() {
		
	}
	
	public static int doYouWantToQuit() {
		
	}
	
	public static int doYouWantToGoAgain() {
		
	}*/
}
