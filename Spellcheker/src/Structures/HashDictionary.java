package Structures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HashDictionary {
	private HashTable dict;
	
	public HashDictionary(String filename) throws NumberFormatException, IOException {
		loadFile(filename);
	}
	public void loadFile(String filename) throws NumberFormatException,IOException{
		File f=new File("src/Main/" +filename);
		BufferedReader in=new BufferedReader(new FileReader(f));
		int size=Integer.parseInt(in.readLine());
		dict=new HashTable(size);
		String s;
		while((s=in.readLine())!=null) {
			dict.add(s);
		}
	}
	public boolean Check(String word) {
		return dict.lookup(word);
	}
	
	
}
