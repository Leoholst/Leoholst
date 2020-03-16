import java.util.Scanner;

public class Bijele {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int king = input.nextInt();
		int queen = input.nextInt();
		int rooks = input.nextInt();
		int bishops = input.nextInt();
		int knights = input.nextInt();
		int pawns = input.nextInt();
		
		int pKing = 1;
		int pQueen = 1;
		int pRooks = 2;
		int pBishops = 2;
		int pKnights = 2;
		int pPawns = 8;
		
		for(int i=0; i<10; i++) {
			if(king==1) {
				break;
			}
			else if(king<1){
				king+=pKing;
			}
			else {
				king-=pKing;
			}
		}
		
		for(int i=0; i<10; i++) {
			if(queen==1) {
				break;
			}
			else if(queen<1){
				queen++;
			}
			else {
				queen--;
			}
		}
		
		for(int i=0; i<10; i++) {
			if(rooks==2) {
				break;
			}
			else if(rooks<2){
				rooks++;
			}
			else {
				rooks--;
			}
		}
		
		for(int i=0; i<10; i++) {
			if(bishops==2) {
				break;
			}
			else if(bishops<2){
				bishops++;
			}
			else {
				bishops--;
			}
		}
		
		for(int i=0; i<10; i++) {
			if(knights==2) {
				break;
			}
			else if(knights<2){
				knights++;
			}
			else {
				knights--;
			}
		}
		
		for(int i=0; i<10; i++) {
			if(pawns==8) {
				break;
			}
			else if(pawns<8){
				pawns++;
			}
			else {
				pawns--;
			}
		}
		
		System.out.println(king+" "+queen+" "+rooks+" "+bishops+" "+knights+" "+pawns);
	}
}