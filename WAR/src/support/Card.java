package support;

public class Card {
	private int val;
	private String name;
	
	public Card(int y) {
		val=y;
	}
	public int getVal() {
		return val;
	}
	
	public String CardName() {
		if (val<=10) {
			return String.valueOf(val);
		}
		else if(val==11) {
			return "Jack";
		}
		else if(val==12) {
			return "Queen";
		}
		else if(val==13) {
			return "King";
		}
		else {
			return "Ace";
		}
		
	}
}

