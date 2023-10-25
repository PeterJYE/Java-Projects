package Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Structures.HashTable;
import Structures.HashDictionary;

public class SpellChecker {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a word to check spelling: ");
		String str = sc.nextLine();
		if (wordInDictionary(str)) {
			System.out.print("Correct Spelling!");
		} else {
			System.out.println("The word doesn't exist in dictionary!");
			ArrayList<String> s = Suggestion1(str);
			ArrayList<String> s2 = Suggestion2(str);
			ArrayList<String> s3 = Suggestion3(str);
			ArrayList<String> s4 = Suggestion4(str);
			System.out.println("Suggestion:" + s.toString() + s2.toString() + s3.toString()+s4.toString());
		}
	}

	public static boolean wordInDictionary(String word) throws NumberFormatException, IOException {
		HashDictionary dict = new HashDictionary("words.txt");
		return dict.Check(word);
	}

	public static ArrayList<String> Suggestion1(String word) throws NumberFormatException, IOException {
		ArrayList<String> r = new ArrayList<String>();
		int x = 0;
		while (x < word.length() - 1) {
			char[] wl = word.toCharArray();
			char[] neww = word.toCharArray();
			int y = x + 1;
			char j = wl[x];
			char k = wl[y];
			neww[y] = j;
			neww[x] = k;
			String str = new String(neww);
			if (wordInDictionary(str)) {
				r.add(str);
			}
			x++;
		}
		return r;
	}

	public static ArrayList<String> Suggestion2(String word) throws NumberFormatException, IOException {
		ArrayList<String> r = new ArrayList<String>();
		char[] AZ = new char[26];
		AZ[0] = 'a';
		AZ[1] = 'b';
		AZ[2] = 'c';
		AZ[3] = 'd';
		AZ[4] = 'e';
		AZ[5] = 'f';
		AZ[6] = 'g';
		AZ[7] = 'h';
		AZ[8] = 'i';
		AZ[9] = 'j';
		AZ[10] = 'k';
		AZ[11] = 'l';
		AZ[12] = 'm';
		AZ[13] = 'n';
		AZ[14] = 'o';
		AZ[15] = 'p';
		AZ[16] = 'q';
		AZ[17] = 'r';
		AZ[18] = 's';
		AZ[19] = 't';
		AZ[20] = 'u';
		AZ[21] = 'v';
		AZ[22] = 'w';
		AZ[23] = 'x';
		AZ[24] = 'y';
		AZ[25] = 'z';
		for (int j = 0; j < word.length(); j++) {
			for (int i = 0; i < 26; i++) {
				String neww=word.substring(0,j)+AZ[i]+word.substring(j+1);
				if (wordInDictionary(neww)) {
					r.add(neww);
				}
		}
		}
		return r;
	}
	public static ArrayList<String> Suggestion3(String word) throws NumberFormatException, IOException{
		ArrayList<String> r = new ArrayList<String>();
		for(int i=0;i<word.length();i++) {
			String neww=word.substring(0,i)+word.substring(i+1);
			if (wordInDictionary(neww)) {
				r.add(neww);
			}
		}
		return r;
	}
	public static ArrayList<String> Suggestion4(String word) throws NumberFormatException, IOException{
		ArrayList<String> r = new ArrayList<String>();
		char[] AZ = new char[26];
		AZ[0] = 'a';
		AZ[1] = 'b';
		AZ[2] = 'c';
		AZ[3] = 'd';
		AZ[4] = 'e';
		AZ[5] = 'f';
		AZ[6] = 'g';
		AZ[7] = 'h';
		AZ[8] = 'i';
		AZ[9] = 'j';
		AZ[10] = 'k';
		AZ[11] = 'l';
		AZ[12] = 'm';
		AZ[13] = 'n';
		AZ[14] = 'o';
		AZ[15] = 'p';
		AZ[16] = 'q';
		AZ[17] = 'r';
		AZ[18] = 's';
		AZ[19] = 't';
		AZ[20] = 'u';
		AZ[21] = 'v';
		AZ[22] = 'w';
		AZ[23] = 'x';
		AZ[24] = 'y';
		AZ[25] = 'z';
		for(int i=0;i<word.length();i++) {
			for(int j=0;j<26;j++) {
		if(i==0) {
			String newww=AZ[j]+word;
			if (wordInDictionary(newww)) {
				r.add(newww);
			}
		}
		else {
			String neww=word.substring(0,i+1)+AZ[j]+word.substring(i+1);
			if (wordInDictionary(neww)) {
				r.add(neww);
			}
			}
			}
		}
		return r;
	}
	
}
