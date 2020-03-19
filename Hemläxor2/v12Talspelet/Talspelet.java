import java.util.Scanner;
import java.util.Random;

public class Talspelet {

	public static void main(String[] args) {
		System.out.println(greetings());
		System.out.println(System.lineSeparator() + instructions());
		System.out.println(System.lineSeparator() + chooseDifficulty);
	}
	
	public static String greetings() {
		String welcome = "Welcome to Talspelet!" + System.lineSeparator() + "This game is all about guessing numbers!";
		return welcome;
	}
	
	public static String instructions() {
		String instructions = "Instructions" + System.lineSeparator() + "First off you are going to choose a difficulty, there are three different to choose from ranging from easy to hard." + System.lineSeparator() + "After that comes the guessing part! Simply write one number from inside the difficulties range. If you write the wrong one you have to guess again." + System.lineSeparator() + "In order to win you just have to guess the right number, easy right? But watch out! You only have three tries before you run out of guesses and lose!";
		return instructions;
	}
	
	public static Random chooseDifficulty() {
		Scanner input = new Scanner(System.in);
		int choose = input.nextInt();
		int easy = 1;
		int medium = 2;
		int hard = 3;
		if(choose==easy) {
			Random difficult = (Random) new Random().ints(easy, hard + 1).iterator();
			return difficult;
		}
		if(choose==medium) {
			
		}
		if(choose==hard) {
			
		}
	}
	/*
	public static void errorMessage() {
		
	}
	
	public static int numberGenerator() {
		
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
