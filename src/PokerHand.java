/*Author: Zachary Francis
This program is designed to compare pairs of poker hands
and to indicate which, if either, has a higher rank.
user input should be given as follows: 
Black: 2H 3D 5S 9C KD  White: 2C 3H 4S 8C AH 
*/

import java.util.*;

public class PokerHand{ 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  
	    System.out.println("Enter Poker Hands");
	    String input = sc.nextLine();  
		Hand blackHand = new Hand(formatBlack(input),"Black");
		Hand whiteHand = new Hand(formatWhite(input),"White");
		String result = new Hand().getWinner(blackHand, whiteHand);
		if (result.equals("Tie.")) System.out.println(result);
		else if (result.equals("Black")) System.out.println(result + " Wins. - " + blackHand.showHandRank()) ;
		else System.out.println(result + " Wins. - " + whiteHand.showHandRank());
		sc.close();
	}
		
	public static String formatBlack(String s) {
		//Method to format input 
		
		String[] hands = s.split("  ");
		String[] black = hands[0].split(":");
		return black[1].substring(1);
	} 
	public static String formatWhite(String s) {
		//Method to format input
		
		String[] hands = s.split("  ");
		String[] white = hands[1].split(":");
		return white[1].substring(1);
	} 
	
	} 






