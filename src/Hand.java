import java.util.Arrays;


public class Hand{
		public static enum handRank{
			HIGHCARD, PAIR, TWOPAIR, THREEOFAKIND, STRAIGHT, FLUSH,
			FULLHOUSE, FOUROFAKIND, STRAIGHTFLUSH
		}
		
		private Card[] hand;
		private String name;
		
		public Hand(){
			hand = null;
			name = "";
		}
		
		public Hand(String handString, String name){
			String[] cards = handString.split(" ");
			hand = new Card[cards.length];
			Translate tl = new Translate();
			for (int i=0;i<hand.length;i++){
				hand[i] = tl.formCard(cards[i]);
			}
			Arrays.sort(hand); //Sorting Hand for Logic to Evaluate Hands
			this.name = name; 
		}
		
		public Card[] getHand(){
			return this.hand;
		}
		
		public String getName(){
			return this.name;
		}
		
		private static boolean isPair(Card[] hand){
			// Checks for pairs in a sorted hand
			// Checks if a card is the same as the card next to it
			// And not the same as a card two spaces away 
			
			return ((hand[0].getRank() == hand[1].getRank() && hand[1].getRank() != hand[2].getRank()) ||
					(hand[1].getRank() == hand[2].getRank() && hand[2].getRank() != hand[3].getRank() && hand[1].getRank() != hand[0].getRank()) ||
					(hand[2].getRank() == hand[3].getRank() && hand[3].getRank() != hand[4].getRank() && hand[2].getRank() != hand[1].getRank()) ||
					(hand[3].getRank() == hand[4].getRank() && hand[3].getRank() != hand[2].getRank()));
		}
		
		private static boolean isTwoPair(Card[] hand){
			// Checks for two pair in a sorted hand
			// Checks the three cases there is a two pair
	
			return ((hand[0].getRank() == hand[1].getRank() && hand[2].getRank() == hand[3].getRank() && hand[1].getRank()!=hand[2].getRank() && hand[3].getRank() != hand[4].getRank()) ||
					(hand[0].getRank() != hand[1].getRank() && hand[1].getRank() == hand[2].getRank() && hand[2].getRank() != hand[3].getRank() && hand[3].getRank() == hand[4].getRank()) ||
					(hand[0].getRank() == hand[1].getRank() && hand[3].getRank() == hand[4].getRank() && hand[1].getRank()!=hand[2].getRank() && hand[2].getRank() != hand[3].getRank())
					);
		}
		
		private static boolean isThreeOfAKind(Card[] hand){
			//Checks the three cases a sorted hand can have a three of a kind
			//Either the first three cards are the same, the last three are the same,
			//Or the middle three are the same
			
			return (hand[0].getRank() == hand[2].getRank() ||
					hand[1].getRank() == hand[3].getRank() ||
					hand[2].getRank() == hand[4].getRank());
		}
		
		private static boolean isStraight(Card[] hand){
			//Checks if there is a straight in a sorted hand
			//There can only be a straight iff the first and last card
			// have a difference in rank of 4 (I.e first card ace last 5)
		
			return hand[4].getRank() - hand[0].getRank() == 4;
		}
		
		private static boolean isFlush(Card[] hand){
			//Checks if all suits are the same by looping through hand
			
			for (int i=0;i<hand.length-1;i++){
				if (hand[i+1].getSuit() != hand[i].getSuit()) return false;
			}
			
			return true;
		}
		
		private static boolean isFullHouse(Card[] hand){
			//Checks the two cases a sorted hand can have a full house
			//Either the first three cards are the same and the last two are the same
			//Or the first two are the same and the last three are
			
			return ((hand[0].getRank() == hand[1].getRank() && hand[1].getRank() != hand[2].getRank() && hand[2].getRank() == hand[4].getRank()) ||
					(hand[0].getRank() == hand[2].getRank() && hand[2].getRank() != hand[3].getRank() && hand[3].getRank() == hand[4].getRank()));
		}
		
		private static boolean isFourOfAKind(Card[] hand){
			//Checks the two cases four of a kind can occur in a sorted hand
			//Either the first four or the last four are the same
			
			return (hand[0].getRank() == hand[3].getRank() ||
					hand[1].getRank() == hand[4].getRank());
		}
		
		private static boolean isStraightFlush(Card[] hand){
			//Checks if there is a straight and a flush
			
			return isStraight(hand) && isFlush(hand);
		}
		
		private handRank getHandRank(){
			//Sets enumeration handRank
			
			Card[] tempHand = this.getHand();
			if (isStraightFlush(tempHand)) return handRank.STRAIGHTFLUSH;
			else if (isFourOfAKind(tempHand)) return handRank.FOUROFAKIND;
			else if (isFullHouse(tempHand)) return handRank.FULLHOUSE;
			else if (isFlush(tempHand)) return handRank.FLUSH;
			else if (isStraight(tempHand)) return handRank.STRAIGHT;
			else if (isThreeOfAKind(tempHand)) return handRank.THREEOFAKIND;
			else if (isTwoPair(tempHand)) return handRank.TWOPAIR;
			else if (isPair(tempHand)) return handRank.PAIR;
			else return handRank.HIGHCARD;
		}
		public String showHandRank(){
			// Returns a String of the handRank
			
			if (this.getHandRank() == handRank.STRAIGHTFLUSH) return "Straight Flush";
			else if (this.getHandRank() == handRank.FOUROFAKIND) return "Four Of A Kind";
			else if (this.getHandRank() == handRank.FULLHOUSE) return "Fullhouse";
			else if (this.getHandRank() == handRank.FLUSH) return "Flush";
			else if (this.getHandRank() == handRank.STRAIGHT) return "Straight";
			else if (this.getHandRank() == handRank.THREEOFAKIND) return "Three Of A Kind";
			else if (this.getHandRank() == handRank.TWOPAIR) return "Two Pair";
			else if (this.getHandRank() == handRank.PAIR) return "Pair";
			else return "High Card";
			
		}
		
	
		public String getWinner(Hand hand1, Hand hand2){
			//Returns the winner of two hands
			
			handRank hand1Rank = hand1.getHandRank();
			handRank hand2Rank = hand2.getHandRank();
			int win = hand1Rank.compareTo(hand2Rank);
			if (win>0) return hand1.getName(); //If the two hands have different rank, better rank wins 
			else if (win<0) return hand2.getName();
			else return "Tie.";
		}
	}