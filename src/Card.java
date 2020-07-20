public class Card implements Comparable<Card> {
	private final int rank;
    private final int suit;
  
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
    @Override
	public int compareTo(Card anotherCard) {
    	//Compares the rank of two cards 
		if (this.getRank()<anotherCard.getRank()) return -1;
		else if (this.getRank()>anotherCard.getRank()) return 1;
		else return 0;
	}
	
	@Override
	public boolean equals(Object o){
		//Returns True if card ranks are equal
		
		Card anotherCard = (Card) o;
		return this.getRank() == anotherCard.getRank();
	}

}
