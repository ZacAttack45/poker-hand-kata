import java.util.*;
public class Translate {
	{ 
		
	}
	
	public int showRank(String i) {
		// HashMap to translate ranks into there corresponding numerical rank
		
		HashMap<String, Integer> ranks = new HashMap<String, Integer>();
		ranks.put("2", 1); 
		ranks.put("3", 2); 
		ranks.put("4", 3); 
		ranks.put("5", 4); 
		ranks.put("6", 5); 
		ranks.put("7", 6); 
		ranks.put("8", 7); 
		ranks.put("9", 8); 
		ranks.put("J", 9); 
		ranks.put("Q", 10); 
		ranks.put("K", 11); 
		ranks.put("A", 12); 
		
		return ranks.get(i) ;
	}
	public int showSuit(String i) {
		// HashMap to translate suits into there corresponding numerical rank
		
		HashMap<String, Integer> suits = new HashMap<String, Integer>();
		suits.put("D", 1);
		suits.put("S", 2);
		suits.put("H", 3);
		suits.put("C", 4);
		
		return suits.get(i);
	}
	public Card formCard(String i) {
		//Takes string of card and makes corresponding card object
		
		String[] change = i.split("");
		
		return new Card(showRank(change[0]), showSuit(change[1]));
}
}

