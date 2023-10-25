package game;

import support.LinkedList;

import java.util.Arrays;

import support.Card;

public class test {

	public static void main(String[] args) {
		LinkedList<Card> deck = new LinkedList<Card>();
		int[] vals = {3, 11, 5, 5, 4, 6, 8, 12, 5, 2, 1, 2, 4, 7};
		for (int i : vals) {
			deck.add(new Card(i));
		}
		LinkedList<Card> p1 = new LinkedList<Card>();
		LinkedList<Card> p2 = new LinkedList<Card>();
		for (int i = 0; i < deck.size(); i+=2) {
			p1.add(deck.get(i));
			p2.add(deck.get(i+1));
		}
		LinkedList<Card> S =new LinkedList<Card>();
		System.out.println("Welcome to War!\n" + "\n" + "Splitting deck...\n"
				+ "Player1: " + p1.size()+" cards, Player2: "+p2.size() +" cards\n\n" + "Game Starts");
		while (p1.size() > 0 && p2.size() > 0) {
			Card d1 = p1.remove(0);
			Card d2 = p2.remove(0);
			if (Compare(d1, d2)==1) {
				p1.add(d1);
				p1.add(d2);
				System.out.print("Player1 plays " + d1.CardName() + " and Player2 plays " + d2.CardName() + " \n"
						+ "Player1 wins the battle!\n Player1: " + p1.size() + " cards, Player2: " + p2.size() + " cards\n"
						+ "Next turn...\n ------------\n");
			} else if (Compare(d1, d2)==-1) {
				p2.add(d1);
				p2.add(d2);
				System.out.print("Player1 plays " + d1.CardName() + " and Player2 plays " + d2.CardName() + " \n"
						+ "Player2 wins the battle!\n Player1: " + p1.size() + " cards, Player2: " + p2.size() + " cards\n"
						+ "Next turn...\n ------------\n");
			} else {
				System.out.println("Player1 plays " + d1.CardName() + " and Player2 plays " + d2.CardName() + " \n"+"War Starts!!!");
				System.out.println(War(p1, p2, S, d1, d2));
			}
			
		}
		if(p1.size()<=0) {
			System.out.println( "Player2 wins the Game. Congraduation!");
		}
		else {
			System.out.println( "Player1 wins the Game. Congraduation!");
		}
			
	}

	public static void shuffle(LinkedList deck) {
		for (int i = 0; i < 28; i++) {
			int cardval = (int) (Math.random() * 13 + 2);
			Card c = new Card(cardval);
			deck.add(c);
		}
	}

	public static int Compare(Card card1, Card card2) {
		if (card1.getVal() > card2.getVal()) {
			return 1;
		} else if (card1.getVal() < card2.getVal()) {
			return -1;
		} else {
			return 0;
		}
	}
	public static String War(LinkedList p1, LinkedList p2, LinkedList S, Card d1, Card d2) {
		if(p1.size()>=4 && p2.size()>=4) {
			S.add(d1);
			S.add(d2);
			for (int i = 0; i < 3; i++) {
				S.add((Card) p1.remove(0));
				S.add((Card) p2.remove(0));
			}
		Card war1 = (Card) p1.remove(0);
		Card war2 = (Card) p2.remove(0);
		int w1=war1.getVal();
		int w2=war2.getVal();
		if (w1>w2) {
			for(int i=0;i<8;i++) {
				p1.add(S.get(i));
			}
			p1.add(war1);
			p1.add(war2);
			S.clear();
			return "Player1 plays " + war1.CardName()+ " and Player2 plays " +war2.CardName()+ "\n Player1 wins the battle and the war!\n Next turn...\n------------\n";
		}
		else if(w2>w1) {
			for(int i=0;i<8;i++) {
				p2.add(S.get(i));
			}
			p2.add(war1);
			p2.add(war2);
			S.clear();
			return "Player1 plays " + war1.CardName()+ " and Player2 plays " +war2.CardName()+ "\n Player2 wins the battle and the war!\n Next turn...\n------------\n";	
		}
		else {
			System.out.println( "Player1 plays " + war1.CardName()+ " and Player2 plays " +war2.CardName());
			War(p1, p2, S, d1, d2);
			return"Another War!";
				
		}
		}
		else if(p1.size()<4) {
			p1.clear();
			return "Player1 does not have enough cards to play the war";
		}
		else {
			p2.clear();
			return "Player2 does not have enough cards to play the war";
		}
	}

}
